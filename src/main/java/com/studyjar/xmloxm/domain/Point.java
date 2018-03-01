package com.studyjar.xmloxm.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * Created by mj on 2017/12/29.
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@Component
public class Point {

    private String lastName;

    private String firstName;

}
