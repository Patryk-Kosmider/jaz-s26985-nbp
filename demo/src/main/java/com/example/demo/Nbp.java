package com.example.demo;

import java.util.List;

public class Nbp {
    private String table;

    private String currency;

    private String code;
    private List<Rate> rates;

    public Nbp(){}

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<Rate> getRate_list() {
        return rates;
    }

    public void setRate_list(List<Rate> rate_list) {
        this.rates = rate_list;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }
}
