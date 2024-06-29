package com.example.jaz_s26963_nbp.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Exchange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "t")
    private String table;
    private String currency;
    private String code;
    @OneToMany
    @Cascade(CascadeType.ALL)
    private List<Rate> rates;
    private Double mean;
    private LocalDateTime queryDate = LocalDateTime.now();

    public Exchange() {
    }

    public Exchange(Long id, String table, String currency, String code, List<Rate> rates, Double mean) {
        this.id = id;
        this.table = table;
        this.currency = currency;
        this.code = code;
        this.rates = rates;
        this.mean = mean;
    }

    public Double getMean() {
        return mean;
    }

    public void setMean(Double mean) {
        this.mean = mean;
    }

    public LocalDateTime getQueryDate() {
        return queryDate;
    }

    public void setQueryDate(LocalDateTime queryDate) {
        this.queryDate = queryDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
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

    public void setRate(List<Rate> rates) {
        this.rates = rates;
    }
}
