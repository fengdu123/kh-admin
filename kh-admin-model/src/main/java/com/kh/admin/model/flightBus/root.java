package com.kh.admin.model.flightBus;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * 所在的包名: com.kh.admin.model.flightBus
 * 所在的项目名：kh-admin
 *
 * @Author:wangyp
 * @Description:
 * @Date: Created in 14:35 2017/6/9
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="root")
@XmlType(name = "root", propOrder = { "header", "parameters", "response", "row" })
public class root {


    @XmlElement(name = "header")
    private Header header ;

    @XmlElement(name = "parameters")
    private Parameters parameters;

    @XmlElement(name = "reponse")
    private Response response;

    @XmlElementWrapper(name = "data")
    @XmlElement(name = "row")
    private List<Row> row ;

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public Parameters getParameters() {
        return parameters;
    }

    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public List<Row> getRow() {
        return row;
    }

    public void setRow(List<Row> row) {
        this.row = row;
    }

    @Override
    public String toString() {
        return "root{" +
                "header=" + header +
                ", parameters=" + parameters +
                ", response=" + response +
                ", row=" + row +
                '}';
    }
}
