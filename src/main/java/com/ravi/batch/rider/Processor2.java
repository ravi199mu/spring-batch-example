package com.ravi.batch.rider;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.ravi.batch.model.User;
import com.ravi.batch.model.Userxls;

@Component
public class Processor2 implements ItemProcessor<Userxls, Userxls> {
	
	public static List<Userxls> allUsers = new ArrayList<>();

	@Override
	public Userxls process(Userxls item) throws Exception {
		allUsers.add(item);
		return item;
	}

	
	
	
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
	
}
