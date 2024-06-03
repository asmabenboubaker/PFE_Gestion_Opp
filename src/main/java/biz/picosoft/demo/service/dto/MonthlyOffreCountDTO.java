package biz.picosoft.demo.service.dto;

public class MonthlyOffreCountDTO {
    private int year;
    private int month;
    private long count;

    public MonthlyOffreCountDTO(int year, int month, long count) {
        this.year = year;
        this.month = month;
        this.count = count;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
