package com.example.jaz_s26963_nbp.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(name = "Rates ID", example = "1", nullable = false)
    private Long id;
    @Schema(name = "Unique NO identifier from NBP API", example = "125/A/NBP/2024", nullable = false)
    private String no;
    @Schema(name = "Effective date from NBP API (date of the currency value)", example = "2024-06-28", nullable = false)
    private String effectiveDate;
    @Schema(name = "Value of the currency", example = "4.13", nullable = false)
    private Double mid;

    public Rate() {
    }

    public Rate(Long id, String no, String effectiveDate, Double mid) {
        this.id = id;
        this.no = no;
        this.effectiveDate = effectiveDate;
        this.mid = mid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Double getMid() {
        return mid;
    }

    public void setMid(Double mid) {
        this.mid = mid;
    }
}
