package ru.szhernovy.jobvacancy.controller;/**
 * Created by szhernovoy on 14.11.2016.
 */

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import ru.szhernovy.jobvacancy.model.Vacancy;

import java.io.IOException;
import java.util.Set;


public class HTMLParser {
    private final String REGEX = "\\[0-9]";
    //private final Set<Vacancy> storage;
    private static Logger log = LoggerFactory.getLogger(HTMLParser.class);

    private String url = "http://www.sql.ru/forum/job-offers";

    //public HTMLParser(Set<Vacancy> storage) {
       // this.storage = storage;

    //}

    public Document getHtmlpage(String url) {

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
        Elements elementsRow = elements.select("tr");
        return  elementsRow;
    }


    public static void main(String[] args) {

        HTMLParser parser = new HTMLParser();
        Document document = parser.getHtmlpage("http://www.sql.ru/forum/job-offers/9");

        Elements rows = parser.getRowTable(parser.getTableHtml(document));
        for(Element element : rows){
            Elements cols = element.select("td");
            System.out.println("-------------------------------------------------------");

            int currentCol = 0;
            for(Element col : cols){
                System.out.println(col);
                if(currentCol == 5) {
                    currentCol =0;
                }


                if(currentCol == 1) {
                     col.attributes();
                }
                currentCol++;
            }


        }
        /*
        for (int i = 0; i < rows.size(); i++) {
            Element row = rows.get(i);
            Elements cols = row.select("td");

            for (Element e: cols){
                System.out.println(e.text());
            }
        }*/




    }


}
