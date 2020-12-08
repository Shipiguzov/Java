package com.ifmo.jjd.lesson9;

import java.util.Objects;

public class ColouringBook extends Book{

    private int picsCount;

    public ColouringBook(String title, int pageCount, int picsCount) {
        super(title, pageCount);
        this.picsCount = picsCount;
    }

    public int getPicsCount() {
        return picsCount;
    }

    @Override
    protected ColouringBook clone() {
        ColouringBook that = new ColouringBook(this.getTitle(), this.getPageCount(), this.picsCount);
        //that.setAuthor(this.getAuthor()); ссылка на author
        that.setAuthor(new Author( // создание нового экземпляра Author
                this.getAuthor().getName(),
                this.getAuthor().getSurname()
                ));
        return that;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ColouringBook)) return false;

        ColouringBook that = (ColouringBook) o;
        if (getTitle() == that.getTitle() && getPageCount() == that.getPageCount() && getPicsCount() == that.getPicsCount() || getAuthor().equals(that.getAuthor())) return true;
        return false;
    }

    @Override
    public int hashCode() {
        int result1 = getTitle() != null ? getTitle().hashCode() : 0;
        int result2 =  getPageCount() != 0 ? getPageCount() : 0;
        int result3 = getPicsCount() != 0 ? picsCount : 0;
        int result4 = getAuthor() != null ? getAuthor().hashCode() : 0;
        return 31 * result1 + result2 + result3 + result4;
    }

    @Override
    public String toString() {
        return "ColouringBook{" + '\'' +
                "picsCount=" + picsCount + '\'' +
                "pageCount=" + getPicsCount() + '\'' +
                "title=" + getTitle() + '\'' +
                "author=" + getAuthor() + '\'' +
        '}';
    }
}