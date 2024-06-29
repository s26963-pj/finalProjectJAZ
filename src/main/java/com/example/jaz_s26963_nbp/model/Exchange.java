package com.example.jaz_s26963_nbp.model;

import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(name = "Exchange ID", example = "1", nullable = false)
    private Long id;
    @Column(name = "t")
    @Schema(name = "Table from NBP API", example = "a", nullable = false)
    private String table;
    @Schema(name = "Currency name from NBP API", example = "euro", nullable = false)
    private String currency;
    @Schema(name = "Currency code from NBP API", example = "eur", nullable = false)
    private String code;
    @OneToMany
    @Cascade(CascadeType.ALL)
    @Schema(name = "Rates from NBP API", nullable = false)
    private List<Rate> rates;
    @Schema(name = "Mean from the request", example = "4.134", nullable = true)
    private Double mean;
    @Schema(name = "Time and date of the query", example = "2024-06-29", nullable = true)
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
