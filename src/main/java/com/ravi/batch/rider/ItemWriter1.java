//package com.ravi.batch.rider;
//
//import java.util.List;
//
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.ravi.batch.model.User;
//import com.ravi.batch.model.Userxls;
//import com.ravi.batch.repository.UserRepository;
//import com.ravi.batch.util.ObjectToXmlConvertor;
//
//@Component
//public class ItemWriter1 implements ItemWriter<Userxls> {
//	
//	@Autowired
//	ObjectToXmlConvertor convertor;
//
//	@Override
//	public void write(List<? extends Userxls> items) throws Exception {
//		convertor.createXMLFile(items);
//	}
//}
