package com.sean.weather.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;
import java.io.StringReader;

/**
 * Created by Administrator on 2019/6/12.
 */

public class XmlBuilder {

    public static Object xmlStrToObject(Class<?> clazz,String xmlStr) throws Exception
    {
        Object xmlObject = null;
        Reader reader = null;
        JAXBContext context = JAXBContext.newInstance(clazz);

        Unmarshaller unmarshaller =  context.createUnmarshaller();
        reader = new StringReader(xmlStr);
        xmlObject =   unmarshaller.unmarshal(reader);

        if(reader != null)
        {
            reader.close();
        }
        return  xmlObject;
    }
}
