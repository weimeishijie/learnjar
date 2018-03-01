package com.studyjar.xmloxm.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * Created by mj on 2018/1/9.
 *
 */
@Data
@XmlType(propOrder = {"id"})
@XmlAccessorType(XmlAccessType.NONE)
@JsonDeserialize(as = Transport.class)
public class TcsOrder implements Serializable {

    @XmlAttribute(name = "id", required = true)
    protected Long id;


}
