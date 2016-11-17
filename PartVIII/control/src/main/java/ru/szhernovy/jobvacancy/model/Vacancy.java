package ru.szhernovy.jobvacancy.model;/**
 * Created by szhernovoy on 14.11.2016.
 */


public class Vacancy {

    private String title;
    private String author;
    private String urlVacancy;
    private String urlAuthor;
    private int answer;
    private int view;
    private long updateDate;

    public Vacancy(String title, String author, String urlVacancy, String urlAuthor, int answer, int view, long updateDate) {
        this.title = title;
        this.author = author;
        this.urlVacancy = urlVacancy;
        this.urlAuthor = urlAuthor;
        this.answer = answer;
        this.view = view;
        this.updateDate = updateDate;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getUrlVacancy() {
        return urlVacancy;
    }

    public String getUrlAuthor() {
        return urlAuthor;
    }

    public int getAnswer() {
        return answer;
    }

    public int getView() {
        return view;
    }

    public long getUpdateDate() {
        return updateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vacancy vacancy = (Vacancy) o;

        if (!title.equals(vacancy.title)) return false;
        return urlAuthor.equals(vacancy.urlAuthor);

    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + urlAuthor.hashCode();
        return result;
    }
}
