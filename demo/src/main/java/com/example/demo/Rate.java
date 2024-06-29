package com.example.demo;

import java.time.LocalDate;

public class Rate {

    private String no;
    private LocalDate effective_date;
    private double mid;

    public Rate(String no, LocalDate effective_date, double mid) {
        this.no = no;
        this.effective_date = effective_date;
        this.mid = mid;
    }

    public String getNo() {
        return no;
    }

    public LocalDate getEffective_date() {
        return effective_date;
    }

    public double getMid() {
        return mid;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public void setEffective_date(LocalDate effective_date) {
        this.effective_date = effective_date;
    }

    public void setMid(double mid) {
        this.mid = mid;
    }
}
