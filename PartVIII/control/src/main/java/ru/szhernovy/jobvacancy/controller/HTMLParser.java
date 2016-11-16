package ru.szhernovy.jobvacancy.controller;/**
 * Created by szhernovoy on 14.11.2016.
 */

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class HTMLParser {

    private final DBManager storage;
    private static Logger log = LoggerFactory.getLogger(HTMLParser.class);
    private long startDate;
    private boolean firstLoad;

    private static final String REGEX = "(\\$\\{)(\\w+)(\\})";
    private static Pattern pattern = Pattern.compile(REGEX);

    private String url = "http://www.sql.ru/forum/job-offers/";

    public HTMLParser(DBManager storage) {
        this.storage = storage;
    }

    //public HTMLParser(Set<Vacancy> storage) {
       // this.storage = storage;

    //}

    public Document getHtmlPage(String url) {

        Document doc = null;
        try{
            doc = Jsoup.connect(url)
                    .data("query", "Java")
                    .userAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.21 (KHTML, like Gecko) Chrome/19.0.1042.0 Safari/535.21")
                    .cookie("auth", "token")
                    .timeout(3000)
                    .post();
        } catch (IOException e) {
            log.error(e.getMessage(),e);
        }
        return doc;
    }


    public Elements getTableHtml(Document document){
        Elements elements = document.select("table.forumTable");
        return  elements;
    }

    public Elements getRowTable(Elements elements){
        Elements elementsRow = elements.select("tr:has(.postslisttopic)");
        return  elementsRow;
    }

    public void init(){
        this.startDate = storage.getFirstLoad();
        this.firstLoad =  startDate == 0 ? true : false;
    }

    public boolean checkVacancy(String textVacancy){
        Matcher m = Pattern.compile(REGEX).matcher(textVacancy);
        return m.find();
    }



    public long mainLoop(){

        boolean next  = true;
        int numberPage = 1;
        Document document = getHtmlPage(String.format("%s/%d",this.url,numberPage++));
        Elements rows = getRowTable(getTableHtml(document));
        Elements oldRows = rows;
        while(next){
            for(Element element : rows){
                Elements cols = element.select("td:not(.icon_cell)");
                Elements sp = cols.select("span.closedTopic");
                Elements refs = cols.select("a[href]");
                if(sp.isEmpty()){
                   if(checkVacancy(cols.get(0).text())){

                           String linkVacancy = cols.get(0).select("a").attr("href");
                           String nameVacancy = cols.get(0).text();
                           String author      = cols.get(1).text();
                           String linkAuthor  = cols.get(1).select("a").attr("href");
                           int ask   = Integer.valueOf(cols.get(2).text());
                           int view = Integer.valueOf(cols.get(3).text());
                           long timeUpdate = convertation(Long.valueOf(cols.get(4).text()));


                        }



                }



                System.out.println(refs.attr("href"));



                if(firstLoad){



                }
              document = getHtmlPage(String.format("%s/%d",this.url,numberPage++));
              rows = getRowTable(getTableHtml(document));
              if(rows.equals(oldRows)){
                 next = false;
              }
              else{
                  oldRows = rows;
              }
        }



    public static void main(String[] args) {
        DBManager storage = new DBManager();
        HTMLParser parser = new HTMLParser(storage);
        Document document = parser.getHtmlPage("http://www.sql.ru/forum/job-offers/1");

     boolean firstLoad = true;
        Elements rows =  parser.getRowTable(parser.getTableHtml(document));
        for (Element row : rows){
            Elements cols = row.select("td:not(.icon_cell)");
            Elements sp = cols.select("span.closedTopic");
            Elements refs = cols.select("a");
            if(sp.isEmpty()){
                for(int index =0; index < cols.size(); index++){
                    switch (index){
                        case 0:
                            System.out.println(cols.get(index).text());
                            System.out.println(refs.attr("href"));
                            break;
                        case 1:
                            System.out.println(cols.get(index).text());
                            System.out.println(cols.get(index).select("a").attr("href"));
                            break;
                        case 2:
                            System.out.println(cols.get(index));
                            break;
                        case 3:
                            System.out.println(cols.get(index));
                            break;
                        case 4:
                            System.out.println(cols.get(index));
                            break;
                        default: throw new UnknownError();
                    }
                }

                System.out.println("----------------------");
            }
            }


    }


}

    private long convertation(Long aLong) {
    }