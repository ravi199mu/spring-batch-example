package com.ravi.batch.util;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ravi.batch.model.Userxls;

@Component
public class ObjectToXmlConvertor {

	public void createXMLFile(Object user) {
		try {
			File file = new File("order.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Userxls.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.marshal(user, file);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	public void createJsonFile(Userxls user) {
		 // Creating Object of ObjectMapper define in Jackson API  
        ObjectMapper Obj = new ObjectMapper();  
        try {  
            // Converting the Java object into a JSON string  
            String jsonStr = Obj.writeValueAsString(user);  
            // Displaying Java object into a JSON string  
            System.out.println(jsonStr);  
            
            //refer -https://howtodoinjava.com/java/library/json-simple-read-write-json-examples/
        }  
        catch (IOException e) {  
            e.printStackTrace();  
        }  
	}

}
