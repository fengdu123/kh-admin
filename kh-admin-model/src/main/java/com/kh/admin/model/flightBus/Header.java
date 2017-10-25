package com.kh.admin.model.flightBus;

import javax.xml.bind.annotation.*;

/**
 * 所在的包名: com.kh.admin.model.flightBus
 * 所在的项目名：kh-admin
 *
 * @Author:wangyp
 * @Description:
 * @Date: Created in 14:42 2017/6/9
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "header")
@XmlType(propOrder = {"srcserver","needtrans","tagserver","service","transid"})
public class Header {

    @XmlElement(name = "srcserver")
    private String srcserver;

    @XmlElement(name = "needtrans")
    private String needtrans;

    @XmlElement(name = "tagserver")
    private String tagserver;

    @XmlElement(name = "service")
    private String service;

    @XmlElement(name = "transid")
    private String transid;

    public String getSrcserver() {
        return srcserver;
    }

    public void setSrcserver(String srcserver) {
        this.srcserver = srcserver;
    }

    public String getNeedtrans() {
        return needtrans;
    }

    public void setNeedtrans(String needtrans) {
        this.needtrans = needtrans;
    }

    public String getTagserver() {
        return tagserver;
    }

    public void setTagserver(String tagserver) {
        this.tagserver = tagserver;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getTransid() {
        return transid;
    }

    public void setTransid(String transid) {
        this.transid = transid;
    }

    @Override
    public String toString() {
        return "Header{" +
                "srcserver='" + srcserver + '\'' +
                ", needtrans='" + needtrans + '\'' +
                ", tagserver='" + tagserver + '\'' +
                ", service='" + service + '\'' +
                ", transid='" + transid + '\'' +
                '}';
    }
}
