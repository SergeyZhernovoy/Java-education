package ru.szhernovy.jobvacancy.controller;

import com.sun.org.apache.xml.internal.serializer.ElemDesc;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Assert;
import org.junit.Test;

import java.util.GregorianCalendar;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by szhernovoy on 17.11.2016.
 */
public class HTMLParserTest {


    @Test
    public void whenWeHaveJavaVacancyThatMatchItCorrect() throws Exception {
            HTMLParser parser = new HTMLParser(new DBManager(this.getClass().getClassLoader().getResource("vacancy.properties").getPath()));
            boolean result = parser.checkVacancy("Java developer");
            boolean result2 = parser.checkVacancy("Java-developer");
            boolean result3 = parser.checkVacancy("Java\\developer");
            boolean result4 = parser.checkVacancy("Developer Java");
            boolean result5 = parser.checkVacancy("Разработчик Java");
            boolean result6 = parser.checkVacancy("Senior Java");
            boolean result7 = parser.checkVacancy("\"Java-developer\"");
            boolean control = result && result2 && result3 && result4 & result5 && result6 && result7;
            Assert.assertThat(control, is(true));
    }

    @Test
    public void whenWeParsingURLShouldGetTable() throws Exception {
        HTMLParser parser = new HTMLParser(new DBManager(this.getClass().getClassLoader().getResource("vacancy.properties").getPath()));
        Document document = parser.getHtmlPage(String.format("%s/%d","http://www.sql.ru/forum/job-offers/",1));
        Elements rows = parser.getRowTable(parser.getTableHtml(document));
        boolean control = !rows.isEmpty();
        Assert.assertThat(control,is(true));
    }

    @Test
    public void checkDataConvertationFromStringHtml() throws Exception {
        HTMLParser parser = new HTMLParser(new DBManager(this.getClass().getClassLoader().getResource("vacancy.properties").getPath()));
        long time = parser.convertation("сегодня");
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTimeInMillis(time);
        int year = 2016;
        Assert.assertThat(year,is(cal.get(1)));
    }

    @Test
    public void checkDataYesterdayConvertationFromStringHtml() throws Exception {
        HTMLParser parser = new HTMLParser(new DBManager(this.getClass().getClassLoader().getResource("vacancy.properties").getPath()));
        long time = parser.convertation("вчера");
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTimeInMillis(time);
        int year = 2016;
        Assert.assertThat(year,is(cal.get(1)));
    }

    @Test
    public void checkDataAnyConvertationFromStringHtml() throws Exception {
        HTMLParser parser = new HTMLParser(new DBManager(this.getClass().getClassLoader().getResource("vacancy.properties").getPath()));
        long time = parser.convertation("15 ноя 16, 13:47");
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTimeInMillis(time);
        int year = 2016;
        Assert.assertThat(year,is(cal.get(1)));
    }



}