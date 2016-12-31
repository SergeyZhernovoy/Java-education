package ru.szhernovoy.jobvacancy.controller;/**
 * Created by szhernovoy on 14.11.2016.
 */

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import ru.szhernovoy.jobvacancy.model.Vacancy;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class HTMLParser {

    /**main provider write vacancies into data base */
    private final DBManager storage;
    /**logger */
    private static Logger log = LoggerFactory.getLogger(HTMLParser.class);
    /**last update in data base */
    private long startDate;
    /**check first load into data base */
    private boolean firstLoad;
    /**string regex fort find correct title */
    private final String REGEX = "(?i)java(?!script|\\W+script)";
       /**utility class for regex*/
    private Pattern pattern = Pattern.compile(REGEX);
    /**start pointer for parsing */
    private final String url = "http://www.sql.ru/forum/job-offers/";

    /**
     * Constructor
     * @param storage
     */
    public HTMLParser(DBManager storage) {
        this.storage = storage;
        this.startDate = storage.getLastLoad();
        this.firstLoad =  startDate == 0 ? true : false;
    }

    /**
     * Getter for receive html document from site
     * @param url
     * @return
     */
    public Document getHtmlPage(String url) {

        Document doc = null;
        try{
            doc = Jsoup.connect(url)
                    .data("query", "Java")
                    .userAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.21 (KHTML, like Gecko) Chrome/19.0.1042.0 Safari/535.21")
                    .cookie("auth", "token")
                    .timeout(3000)
                    .post();
            log.info("load html from site in document", doc);
        } catch (IOException e) {
            log.error(e.getMessage(),e);
        }
        return doc;
    }

    /**
     * Getter for receive main table with vacancies
     * @param document
     * @return
     */
    public Elements getTableHtml(Document document){
        Elements elements = document.select("table.forumTable");
        return  elements;
    }

    /**
     * Getter for receive row with references only
     * @param elements
     * @return
     */
    public Elements getRowTable(Elements elements){
        Elements elementsRow = elements.select("tr:has(.postslisttopic)");
        return  elementsRow;
    }

    /**
     * Regex utility method
     * @param textVacancy
     * @return
     */
    public boolean checkVacancy(String textVacancy){
        this.pattern = Pattern.compile(this.REGEX);
        Matcher m = this.pattern.matcher(textVacancy);
        return m.find();
    }

    /**
     * Add vacancies in data base across manager BD
     * @param linkVacancy
     * @param nameVacancy
     * @param author
     * @param linkAuthor
     * @param ask
     * @param view
     * @param timeUpdate
     */
    public void addVacancy(String linkVacancy, String nameVacancy, String author, String linkAuthor, int ask, int view, long timeUpdate) {
        boolean needAdd = false;
        if(this.firstLoad){
           needAdd = true;
        }
        else{
            if(this.startDate < timeUpdate){
               needAdd = true;
            }
        }
        if(needAdd){
            Vacancy vacancy = new Vacancy(nameVacancy,author,linkVacancy,linkAuthor,ask,view,timeUpdate);
            log.info("add vacancy in data base", vacancy);
            this.storage.add(vacancy);
        }
    }

    /**
     * Convertation text field in long (data + time)
     * @param time
     * @return
     */
    public long convertation(String time) {
        long result = 0L;
        if (time.contains("сегодня")) {
            time = time.replace("сегодня","");
            result = System.currentTimeMillis();

        } else if (time.contains("вчера")) {
            time = time.replace("вчера","");
            result = System.currentTimeMillis() - 24 * 60 * 60 * 1000;
        }
        try {
            result = new SimpleDateFormat("dd MMM yy, HH:mm").parse(time).getTime();
        }  catch (ParseException e) {
            log.error(e.getMessage(),e);
        }
        return result;
    }

    public String cleanNameVacancy(String name) {
        return name.replace("[new]","").trim();
    }

    /**
     * Generate object Vacancy
     * @param column
     * @return
     */
    public long parseElementToVacancy(Elements column){
        long result = 0;
        if (checkVacancy(column.get(0).text())) {
            String linkVacancy = column.get(0).select("a").attr("href");
            String nameVacancy = cleanNameVacancy(column.get(0).text());
            String author = column.get(1).text();
            String linkAuthor = column.get(1).select("a").attr("href");
            int ask  = Integer.valueOf(column.get(2).text());
            int view = Integer.valueOf(column.get(3).text());
            result = convertation(column.get(4).text());
            addVacancy(linkVacancy, nameVacancy, author, linkAuthor, ask, view, result);
        }
        return  result;
    }

    /**
     * Main loop load all pages from site
     * @return
     */
    public long mainLoop(){

        long result         = this.startDate;
        long timeDate       = 0;
        boolean next        = true;
        int numberPage      = 1;
        Document document   = null;
        Elements rows       = null;
        Elements oldRows    = null;
        do{
            document = getHtmlPage(String.format("%s/%d",this.url,numberPage++));
            rows = getRowTable(getTableHtml(document));
            for (Element element : rows) {
                Elements cols = element.select("td:not(.icon_cell)");
                Elements sp = cols.select("span.closedTopic");
                if (sp.isEmpty()) {
                    timeDate = parseElementToVacancy(cols);
                    if (result < timeDate) {
                        result = timeDate;
                    }
                }
            }
            if(!this.firstLoad && result > this.startDate ||rows != null && ((rows.size() == 3) && (oldRows.size() ==3))) {
                next = false;
            }else {
                oldRows = rows;
            }
        }while (next);
        return result;
    }
}

