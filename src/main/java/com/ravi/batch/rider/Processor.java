//package com.ravi.batch.rider;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.springframework.batch.item.ItemProcessor;
//import org.springframework.stereotype.Component;
//
//import com.ravi.batch.model.User;
//
//@Component
//public class Processor implements ItemProcessor<User, User> {
//
//	private static final Map<String, String> DEPT_NAMES = new HashMap<String, String>();
//	
//	public Processor() {
//		DEPT_NAMES.put("001", "IT");
//		DEPT_NAMES.put("002", "CSE");
//	}
//	
//	@Override
//	public User process(User item) throws Exception {
//
//		String deptCode = item.getDept();
//		String dept = DEPT_NAMES.get(deptCode);
//		
//		item.setDept(dept);
//		item.setTimeStamp(new Date());
//		System.out.println(String.format("Converted from [%s] to [%s]", deptCode,dept));
//		
//		return item;
//	}
//	
//}
