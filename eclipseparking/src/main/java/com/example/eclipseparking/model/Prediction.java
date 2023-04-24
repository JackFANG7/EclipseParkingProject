package com.example.eclipseparking.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="prediction")
public class Prediction implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Integer id;
    private Double lat;
    private Double lon;
    private Double t0000;
    private Double t0030;
    private Double t0100;
    private Double t0130;
    private Double t0200;
    private Double t0230;
    private Double t0300;
    private Double t0330;
    private Double t0400;
    private Double t0430;
    private Double t0500;
    private Double t0530;
    private Double t0600;
    private Double t0630;
    private Double t0700;
    private Double t0730;
    private Double t0800;
    private Double t0830;
    private Double t0900;
    private Double t0930;
    private Double t1000;
    private Double t1030;
    private Double t1100;
    private Double t1130;
    private Double t1200;
    private Double t1230;
    private Double t1300;
    private Double t1330;
    private Double t1400;
    private Double t1430;
    private Double t1500;
    private Double t1530;
    private Double t1600;
    private Double t1630;
    private Double t1700;
    private Double t1730;
    private Double t1800;
    private Double t1830;
    private Double t1900;
    private Double t1930;
    private Double t2000;
    private Double t2030;
    private Double t2100;
    private Double t2130;
    private Double t2200;
    private Double t2230;
    private Double t2300;
    private Double t2330;

    public Integer getId() {
        return id;
    }

    public Prediction setId(Integer id) {
        this.id = id;
        return this;
    }

    public Double getLat() {
        return lat;
    }

    public Prediction setLat(Double lat) {
        this.lat = lat;
        return this;
    }

    public Double getLon() {
        return lon;
    }

    public Prediction setLon(Double lon) {
        this.lon = lon;
        return this;
    }

    public Double getT0000() {
        return t0000;
    }

    public Prediction setT0000(Double t0000) {
        this.t0000 = t0000;
        return this;
    }

    public Double getT0030() {
        return t0030;
    }

    public Prediction setT0030(Double t0030) {
        this.t0030 = t0030;
        return this;
    }

    public Double getT0100() {
        return t0100;
    }

    public Prediction setT0100(Double t0100) {
        this.t0100 = t0100;
        return this;
    }

    public Double getT0130() {
        return t0130;
    }

    public Prediction setT0130(Double t0130) {
        this.t0130 = t0130;
        return this;
    }

    public Double getT0200() {
        return t0200;
    }

    public Prediction setT0200(Double t0200) {
        this.t0200 = t0200;
        return this;
    }

    public Double getT0230() {
        return t0230;
    }

    public Prediction setT0230(Double t0230) {
        this.t0230 = t0230;
        return this;
    }

    public Double getT0300() {
        return t0300;
    }

    public Prediction setT0300(Double t0300) {
        this.t0300 = t0300;
        return this;
    }

    public Double getT0330() {
        return t0330;
    }

    public Prediction setT0330(Double t0330) {
        this.t0330 = t0330;
        return this;
    }

    public Double getT0400() {
        return t0400;
    }

    public Prediction setT0400(Double t0400) {
        this.t0400 = t0400;
        return this;
    }

    public Double getT0430() {
        return t0430;
    }

    public Prediction setT0430(Double t0430) {
        this.t0430 = t0430;
        return this;
    }

    public Double getT0500() {
        return t0500;
    }

    public Prediction setT0500(Double t0500) {
        this.t0500 = t0500;
        return this;
    }

    public Double getT0530() {
        return t0530;
    }

    public Prediction setT0530(Double t0530) {
        this.t0530 = t0530;
        return this;
    }

    public Double getT0600() {
        return t0600;
    }

    public Prediction setT0600(Double t0600) {
        this.t0600 = t0600;
        return this;
    }

    public Double getT0630() {
        return t0630;
    }

    public Prediction setT0630(Double t0630) {
        this.t0630 = t0630;
        return this;
    }

    public Double getT0700() {
        return t0700;
    }

    public Prediction setT0700(Double t0700) {
        this.t0700 = t0700;
        return this;
    }

    public Double getT0730() {
        return t0730;
    }

    public Prediction setT0730(Double t0730) {
        this.t0730 = t0730;
        return this;
    }

    public Double getT0800() {
        return t0800;
    }

    public Prediction setT0800(Double t0800) {
        this.t0800 = t0800;
        return this;
    }

    public Double getT0830() {
        return t0830;
    }

    public Prediction setT0830(Double t0830) {
        this.t0830 = t0830;
        return this;
    }

    public Double getT0900() {
        return t0900;
    }

    public Prediction setT0900(Double t0900) {
        this.t0900 = t0900;
        return this;
    }

    public Double getT0930() {
        return t0930;
    }

    public Prediction setT0930(Double t0930) {
        this.t0930 = t0930;
        return this;
    }

    public Double getT1000() {
        return t1000;
    }

    public Prediction setT1000(Double t1000) {
        this.t1000 = t1000;
        return this;
    }

    public Double getT1030() {
        return t1030;
    }

    public Prediction setT1030(Double t1030) {
        this.t1030 = t1030;
        return this;
    }

    public Double getT1100() {
        return t1100;
    }

    public Prediction setT1100(Double t1100) {
        this.t1100 = t1100;
        return this;
    }

    public Double getT1130() {
        return t1130;
    }

    public Prediction setT1130(Double t1130) {
        this.t1130 = t1130;
        return this;
    }

    public Double getT1200() {
        return t1200;
    }

    public Prediction setT1200(Double t1200) {
        this.t1200 = t1200;
        return this;
    }

    public Double getT1230() {
        return t1230;
    }

    public Prediction setT1230(Double t1230) {
        this.t1230 = t1230;
        return this;
    }

    public Double getT1300() {
        return t1300;
    }

    public Prediction setT1300(Double t1300) {
        this.t1300 = t1300;
        return this;
    }

    public Double getT1330() {
        return t1330;
    }

    public Prediction setT1330(Double t1330) {
        this.t1330 = t1330;
        return this;
    }

    public Double getT1400() {
        return t1400;
    }

    public Prediction setT1400(Double t1400) {
        this.t1400 = t1400;
        return this;
    }

    public Double getT1430() {
        return t1430;
    }

    public Prediction setT1430(Double t1430) {
        this.t1430 = t1430;
        return this;
    }

    public Double getT1500() {
        return t1500;
    }

    public Prediction setT1500(Double t1500) {
        this.t1500 = t1500;
        return this;
    }

    public Double getT1530() {
        return t1530;
    }

    public Prediction setT1530(Double t1530) {
        this.t1530 = t1530;
        return this;
    }

    public Double getT1600() {
        return t1600;
    }

    public Prediction setT1600(Double t1600) {
        this.t1600 = t1600;
        return this;
    }

    public Double getT1630() {
        return t1630;
    }

    public Prediction setT1630(Double t1630) {
        this.t1630 = t1630;
        return this;
    }

    public Double getT1700() {
        return t1700;
    }

    public Prediction setT1700(Double t1700) {
        this.t1700 = t1700;
        return this;
    }

    public Double getT1730() {
        return t1730;
    }

    public Prediction setT1730(Double t1730) {
        this.t1730 = t1730;
        return this;
    }

    public Double getT1800() {
        return t1800;
    }

    public Prediction setT1800(Double t1800) {
        this.t1800 = t1800;
        return this;
    }

    public Double getT1830() {
        return t1830;
    }

    public Prediction setT1830(Double t1830) {
        this.t1830 = t1830;
        return this;
    }

    public Double getT1900() {
        return t1900;
    }

    public Prediction setT1900(Double t1900) {
        this.t1900 = t1900;
        return this;
    }

    public Double getT1930() {
        return t1930;
    }

    public Prediction setT1930(Double t1930) {
        this.t1930 = t1930;
        return this;
    }

    public Double getT2000() {
        return t2000;
    }

    public Prediction setT2000(Double t2000) {
        this.t2000 = t2000;
        return this;
    }

    public Double getT2030() {
        return t2030;
    }

    public Prediction setT2030(Double t2030) {
        this.t2030 = t2030;
        return this;
    }

    public Double getT2100() {
        return t2100;
    }

    public Prediction setT2100(Double t2100) {
        this.t2100 = t2100;
        return this;
    }

    public Double getT2130() {
        return t2130;
    }

    public Prediction setT2130(Double t2130) {
        this.t2130 = t2130;
        return this;
    }

    public Double getT2200() {
        return t2200;
    }

    public Prediction setT2200(Double t2200) {
        this.t2200 = t2200;
        return this;
    }

    public Double getT2230() {
        return t2230;
    }

    public Prediction setT2230(Double t2230) {
        this.t2230 = t2230;
        return this;
    }

    public Double getT2300() {
        return t2300;
    }

    public Prediction setT2300(Double t2300) {
        this.t2300 = t2300;
        return this;
    }

    public Double getT2330() {
        return t2330;
    }

    public Prediction setT2330(Double t2330) {
        this.t2330 = t2330;
        return this;
    }

    public Double[] array(){
        Double[] array=new Double[]{t0000,t0030,t0100,t0130,t0200,t0230,t0300,t0330,t0400,t0430,t0500,t0530,t0600,t0630,t0700,t0730,t0800,t0830,t0900,t0930,t1000,t1030,t1100,t1130,t1200,t1230,t1300,t1330,t1400,t1430,t1500,t1530,t1600,t1630,t1700,t1730,t1800,t1830,t1900,t1930,t2000,t2030,t2100,t2130,t2200,t2230,t2300,t2330};
        return array;
    }
}
