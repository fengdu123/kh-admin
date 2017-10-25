package com.kh.admin.model.flightBus;


import javax.xml.bind.annotation.*;
import java.util.Date;

/**
 * 所在的包名: com.kh.admin.model.flightBus
 * 所在的项目名：kh-admin
 *
 * @Author:wangyp
 * @Description:
 * @Date: Created in 14:50 2017/6/9
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "row")
@XmlType( propOrder = { "NDStation", "NDOpTime", "NDShortcut", "NDDistrict","NDNotes","NDCity","Sort","NDEName","NDProvince","NDCode","NDName","NDNamePY" })
public class Row {

    @XmlAttribute(name = "NDStation")
    private String NDStation; //发车站编码              长度为20

    @XmlAttribute(name = "NDOpTime")
    private Date NDOpTime ;//更新时间
    @XmlAttribute(name = "NDShortcut")
    private String NDShortcut ;//助记码                长度为10
    @XmlAttribute(name = "NDDistrict")
    private String NDDistrict ;//区，中文名称           长度为20
    @XmlAttribute(name = "NDNotes")
    private String NDNotes ;  //备注                   长度255
    @XmlAttribute(name = "NDCity")
    private String NDCity; //市 ，中文名称              长度为20
    @XmlAttribute(name = "Sort")
    private int Sort ;   //排序
    @XmlAttribute(name = "NDEName")
    private String NDEName ;//站点英文名称                长度为50
    @XmlAttribute(name = "NDProvince")
    private String NDProvince; //省，中文名称           长度为20
    @XmlAttribute(name = "NDCode")
    private String NDCode ;//站点编码  唯一             长度为20
    @XmlAttribute(name = "NDName")
    private String NDName ; //站点名称                 长度为50
    @XmlAttribute(name = "NDNamePY")
    private String NDNamePY;

    public
    String getNDStation() {
        return NDStation;
    }

    public
    void setNDStation(String NDStation) {
        this.NDStation = NDStation;
    }

    public
    Date getNDOpTime() {
        return NDOpTime;
    }

    public
    void setNDOpTime(Date NDOpTime) {
        this.NDOpTime = NDOpTime;
    }

    public
    String getNDShortcut() {
        return NDShortcut;
    }

    public
    void setNDShortcut(String NDShortcut) {
        this.NDShortcut = NDShortcut;
    }

    public
    String getNDDistrict() {
        return NDDistrict;
    }

    public
    void setNDDistrict(String NDDistrict) {
        this.NDDistrict = NDDistrict;
    }

    public
    String getNDNotes() {
        return NDNotes;
    }

    public
    void setNDNotes(String NDNotes) {
        this.NDNotes = NDNotes;
    }

    public
    String getNDCity() {
        return NDCity;
    }

    public
    void setNDCity(String NDCity) {
        this.NDCity = NDCity;
    }

    public
    int getSort() {
        return Sort;
    }

    public
    void setSort(int sort) {
        Sort = sort;
    }

    public
    String getNDEName() {
        return NDEName;
    }

    public
    void setNDEName(String NDEName) {
        this.NDEName = NDEName;
    }

    public
    String getNDProvince() {
        return NDProvince;
    }

    public
    void setNDProvince(String NDProvince) {
        this.NDProvince = NDProvince;
    }

    public
    String getNDCode() {
        return NDCode;
    }

    public
    void setNDCode(String NDCode) {
        this.NDCode = NDCode;
    }

    public
    String getNDName() {
        return NDName;
    }

    public
    void setNDName(String NDName) {
        this.NDName = NDName;
    }

    public
    String getNDNamePY() {
        return NDNamePY;
    }

    public
    void setNDNamePY(String NDNamePY) {
        this.NDNamePY = NDNamePY;
    }

    @Override
    public
    String toString() {
        return "flightbusInfoBrq{" +
                "NDStation='" + NDStation + '\'' +
                ", NDOpTime=" + NDOpTime +
                ", NDShortcut='" + NDShortcut + '\'' +
                ", NDDistrict='" + NDDistrict + '\'' +
                ", NDNotes='" + NDNotes + '\'' +
                ", NDCity='" + NDCity + '\'' +
                ", Sort=" + Sort +
                ", NDEName=" + NDEName +
                ", NDProvince='" + NDProvince + '\'' +
                ", NDCode='" + NDCode + '\'' +
                ", NDName='" + NDName + '\'' +
                ", NDNamePY='" + NDNamePY + '\'' +
                '}';
    }

}
