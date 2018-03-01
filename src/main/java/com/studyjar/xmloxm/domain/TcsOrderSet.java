package com.studyjar.xmloxm.domain;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mj on 2018/1/9.
 *
 * "<tcsOrderSet>" +
 "<sceneName>xin14-3</sceneName>" +
 "<order xsi:type=\"transport\" deadline=\"2017-05-06 08:30:37\" intendedVehicle=\"Vehicle-0001\" vehicleTypeAvailable=\"false\" id=\"66\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">"+
 "</order>" +
 "</tcsOrderSet>";
 *
 */
@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class TcsOrderSet implements Serializable {

    @XmlElement(name = "sceneName", required = true)
    private String sceneName;

    @XmlElement(name = "order", required = true)
    private List<TcsOrder> orders = new ArrayList<>();

}
