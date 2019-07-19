package com.fy.spotsserver.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author 彭志新
 */
@Document(collection = "Spots")
@Data
public class Spots{

    //旅游主键
    private Integer spotsId;
    //员工外键
    private Integer staffId;
    //景点名称
    private String spotsName;
    //园区类型
    private Integer spotsType;
    //景点介绍 存 mongodb
    private String spotsIntroduceId;
    //景点简介（短介绍）  后加
    private String easintroduce;
    //景点具体介绍  后加
    private String conentisert;
    //景点地址
    private String spotsAddress;
    //门票价格
    private Double spotsPrice;
    //资讯电话
    private String spotsPhone;
    //开放时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:dd" ,timezone = "GTM")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:dd")
    private Date spotsOpenTime;
    //景点门票库存
    private Integer spotsRepertory;
    //景点活动
    private String spotsActivity;
    //集合地点
    private String spotsVenue;
    //出发时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:dd" ,timezone = "GTM")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:dd")
    private Date spotsGotime;
    //发布时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:dd" ,timezone = "GTM")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:dd")
    private Date spotsRelease;
    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:dd" ,timezone = "GTM")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:dd")
    private Date spotsCreate;
    //修改时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:dd" ,timezone = "GTM")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:dd")
    private Date spotsUpdate;
    //状态
    private Integer spotsYn;





}