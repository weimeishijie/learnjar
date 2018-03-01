package com.studyjar.xmloxm.domain;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mj on 2018/1/9.
 *
 */
@Data
@XmlType(propOrder = {"deadline", "vehicleTypeAvailable"})
@XmlAccessorType(XmlAccessType.NONE)
public class Transport extends TcsOrder implements Serializable {

    @XmlAttribute(name = "deadline", required = false)
    private String deadline;

    @XmlAttribute(name = "vehicleTypeAvailable", required = false)
    private Boolean vehicleTypeAvailable = true;

//    @XmlElement(name = "destination", required = true)
//    private List<Destination> destinations = new ArrayList<>();

}
