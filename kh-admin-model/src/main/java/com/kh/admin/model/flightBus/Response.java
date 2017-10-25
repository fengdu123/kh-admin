package com.kh.admin.model.flightBus;

import javax.xml.bind.annotation.*;

/**
 * 所在的包名: com.kh.admin.model.flightBus
 * 所在的项目名：kh-admin
 *
 * @Author:wangyp
 * @Description:
 * @Date: Created in 14:48 2017/6/9
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "response")
@XmlType( propOrder = {"errcode","errmsg"})
public class Response {

    @XmlElement(name = "errcode")
    private String errcode;
    @XmlElement(name = "errmsg")
    private String errmsg;

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    @Override
    public String toString() {
        return "Response{" +
                "errcode='" + errcode + '\'' +
                ", errmsg='" + errmsg + '\'' +
                '}';
    }
}
