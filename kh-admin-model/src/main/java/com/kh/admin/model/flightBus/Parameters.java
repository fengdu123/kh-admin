package com.kh.admin.model.flightBus;

import javax.xml.bind.annotation.*;

/**
 * 所在的包名: com.kh.admin.model.flightBus
 * 所在的项目名：kh-admin
 *
 * @Author:wangyp
 * @Description:
 * @Date: Created in 14:46 2017/6/9
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "parameters")
@XmlType(propOrder = {"OpStation","DstNode"})
public class Parameters {

    @XmlElement(name = "OpStation")
    private String OpStation;

    @XmlElement(name = "DstNode")
    private String DstNode;

    public String getOpStation() {
        return OpStation;
    }

    public void setOpStation(String opStation) {
        OpStation = opStation;
    }

    public String getDstNode() {
        return DstNode;
    }

    public void setDstNode(String dstNode) {
        DstNode = dstNode;
    }

    @Override
    public String toString() {
        return "Parameters{" +
                "OpStation='" + OpStation + '\'' +
                ", DstNode='" + DstNode + '\'' +
                '}';
    }
}
