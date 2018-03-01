package com.studyjar.xmloxm.convert;

import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.stereotype.Component;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Created by mj on 2017/12/29.
 *
 */
public class XmlProcessor {

    private Marshaller marshaller;

    private Unmarshaller unmarshaller;

    public void setMarshaller(Marshaller marshaller) {
        this.marshaller = marshaller;
    }

    public void setUnmarshaller(Unmarshaller unmarshaller) {
        this.unmarshaller = unmarshaller;
    }

    // Converts Object to XML
    public String objectToXML(Object graph) throws IOException {
        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(graph, new StreamResult(stringWriter));
        return stringWriter.toString();
    }

    // Converts XML to Java Object
    public Object xmlToObject(String xmlData) throws IOException {
        if(xmlData == null){
            throw new NullPointerException("xmlData is null");
        }
        StringReader stringReader = new StringReader(xmlData);
        return unmarshaller.unmarshal(new StreamSource(stringReader));
    }

}
