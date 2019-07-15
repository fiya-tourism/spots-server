package com.fy.spotsserver.entity;

import java.util.Date;

public class Spots {
    private Integer spotsId;

    private Integer staffId;

    private String spotsName;

    private Integer spotsType;

    private String spotsIntroduceId;

    private String spotsAddress;

    private Double spotsPrice;

    private String spotsPhone;

    private Date spotsOpenTime;

    private Integer spotsRepertory;

    private String spotsActivity;

    private String spotsVenue;

    private Date spotsGotime;

    private Date spotsRelease;

    private Date spotsCreate;

    private Date spotsUpdate;

    private Integer spotsYn;

    public Integer getSpotsId() {
        return spotsId;
    }

    public void setSpotsId(Integer spotsId) {
        this.spotsId = spotsId;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getSpotsName() {
        return spotsName;
    }

    public void setSpotsName(String spotsName) {
        this.spotsName = spotsName == null ? null : spotsName.trim();
    }

    public Integer getSpotsType() {
        return spotsType;
    }

    public void setSpotsType(Integer spotsType) {
        this.spotsType = spotsType;
    }

    public String getSpotsIntroduceId() {
        return spotsIntroduceId;
    }

    public void setSpotsIntroduceId(String spotsIntroduceId) {
        this.spotsIntroduceId = spotsIntroduceId == null ? null : spotsIntroduceId.trim();
    }

    public String getSpotsAddress() {
        return spotsAddress;
    }

    public void setSpotsAddress(String spotsAddress) {
        this.spotsAddress = spotsAddress == null ? null : spotsAddress.trim();
    }

    public Double getSpotsPrice() {
        return spotsPrice;
    }

    public void setSpotsPrice(Double spotsPrice) {
        this.spotsPrice = spotsPrice;
    }

    public String getSpotsPhone() {
        return spotsPhone;
    }

    public void setSpotsPhone(String spotsPhone) {
        this.spotsPhone = spotsPhone == null ? null : spotsPhone.trim();
    }

    public Date getSpotsOpenTime() {
        return spotsOpenTime;
    }

    public void setSpotsOpenTime(Date spotsOpenTime) {
        this.spotsOpenTime = spotsOpenTime;
    }

    public Integer getSpotsRepertory() {
        return spotsRepertory;
    }

    public void setSpotsRepertory(Integer spotsRepertory) {
        this.spotsRepertory = spotsRepertory;
    }

    public String getSpotsActivity() {
        return spotsActivity;
    }

    public void setSpotsActivity(String spotsActivity) {
        this.spotsActivity = spotsActivity == null ? null : spotsActivity.trim();
    }

    public String getSpotsVenue() {
        return spotsVenue;
    }

    public void setSpotsVenue(String spotsVenue) {
        this.spotsVenue = spotsVenue == null ? null : spotsVenue.trim();
    }

    public Date getSpotsGotime() {
        return spotsGotime;
    }

    public void setSpotsGotime(Date spotsGotime) {
        this.spotsGotime = spotsGotime;
    }

    public Date getSpotsRelease() {
        return spotsRelease;
    }

    public void setSpotsRelease(Date spotsRelease) {
        this.spotsRelease = spotsRelease;
    }

    public Date getSpotsCreate() {
        return spotsCreate;
    }

    public void setSpotsCreate(Date spotsCreate) {
        this.spotsCreate = spotsCreate;
    }

    public Date getSpotsUpdate() {
        return spotsUpdate;
    }

    public void setSpotsUpdate(Date spotsUpdate) {
        this.spotsUpdate = spotsUpdate;
    }

    public Integer getSpotsYn() {
        return spotsYn;
    }

    public void setSpotsYn(Integer spotsYn) {
        this.spotsYn = spotsYn;
    }
}