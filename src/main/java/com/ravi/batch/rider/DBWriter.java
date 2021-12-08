//package com.ravi.batch.rider;
//
//import java.util.List;
//
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.ravi.batch.model.User;
//import com.ravi.batch.repository.UserRepository;
//
//@Component
//public class DBWriter implements ItemWriter<User> {
//	
//	@Autowired
//	private UserRepository userRepository;
//	
//	@Override
//	public void write(List<? extends User> users) throws Exception {
//		System.out.println("data saved for users "+users);
//		userRepository.saveAll(users);
//	}
//
//}
