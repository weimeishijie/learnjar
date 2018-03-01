package com.studyjar.xmloxm.convert;

import com.studyjar.xmloxm.domain.Boy;
import com.studyjar.xmloxm.domain.TcsOrder;
import com.studyjar.xmloxm.domain.TcsOrderSet;
import com.studyjar.xmloxm.domain.Transport;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

/**
 * Created by mj on 2018/1/2.
 *
 */
public class JAXBTest {

    public static void main(String[] args) throws JAXBException {
//        JAXBContext context = JAXBContext.newInstance(Boy.class);
//        Marshaller marshaller = context.createMarshaller();
//        Unmarshaller unmarshaller = context.createUnmarshaller();
//
//        Boy boy = new Boy();
//        marshaller.marshal(boy, System.out);
//        System.out.println();
        JAXBContext contexty = JAXBContext.newInstance(
                TcsOrderSet.class,
                TcsOrder.class,
                Transport.class);

        Unmarshaller unmarshaller = contexty.createUnmarshaller();

        String xml = "<tcsOrderSet> +\n" +
                " <sceneName>xin14-3</sceneName> +\n" +
                " <order xsi:type=\\\"transport\\\" deadline=\\\"2017-05-06 08:30:37\\\" intendedVehicle=\\\"Vehicle-0001\\\" vehicleTypeAvailable=\\\"false\\\" id=\\\"66\\\" >+\n" +
                " </order> +\n" +
                " </tcsOrderSet>";
        Object boy1 = unmarshaller.unmarshal(new StringReader(xml));
        System.out.println(boy1);
    }


}
