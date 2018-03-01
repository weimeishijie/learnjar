//package com.studyjar.xmloxm.domain;
//
//import lombok.Data;
//
//import javax.xml.bind.annotation.XmlAccessType;
//import javax.xml.bind.annotation.XmlAccessorType;
//import javax.xml.bind.annotation.XmlAttribute;
//import javax.xml.bind.annotation.XmlType;
//import java.io.Serializable;
//
///**
// * Created by mj on 2018/1/9.
// */
//@Data
//@XmlType(propOrder = {"locationName", "operation", "state"})
//@XmlAccessorType(XmlAccessType.NONE)
//public class Destination implements Serializable {
//
//    @XmlAttribute(name = "locationName", required = true)
//    private Location locationName;
//
//    @XmlAttribute(name = "operation", required = true)
//    private TcsOperation operation;
//
//    @XmlAttribute(name = "state", required = false)
//    private DestinationState state;
//
//    public Destination() {}
//
//    public Destination(TcsOperation operation) {
//        this.operation = operation;
//    }
//
//
//}
