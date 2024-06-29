package com.example.demo;

import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;
import java.time.LocalTime;
@Entity
@Table(name="`nbp`")
@Schema(description = "Class for logging info of API average rate currency fetching")
public class DatabaseLog {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Schema(description = "ID number of record")
    private int id;
    @Schema(description = "Currency name")
    private String waluta;
    @Schema(description = "Start date")
    private LocalDate date_start;
    @Schema(description = "End date")
    private LocalDate date_end;
    @Schema(description = "Average value of currency between 'Start date' and 'End date'")
    private double kurs;
    @Schema(description = "Date of calculating the value")
    private LocalDate date_now;
    @Schema(description = "Time of calculating the value")
    private LocalTime time;

    public DatabaseLog(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWaluta() {
        return waluta;
    }

    public void setWaluta(String waluta) {
        this.waluta = waluta;
    }

    public LocalDate getDate_start() {
        return date_start;
    }

    public void setDate_start(LocalDate date_start) {
        this.date_start = date_start;
    }

    public LocalDate getDate_end() {
        return date_end;
    }

    public void setDate_end(LocalDate date_end) {
        this.date_end = date_end;
    }

    public double getKurs() {
        return kurs;
    }

    public void setKurs(double kurs) {
        this.kurs = kurs;
    }

    public LocalDate getDate_now() {
        return date_now;
    }

    public void setDate_now(LocalDate date_now) {
        this.date_now = date_now;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
