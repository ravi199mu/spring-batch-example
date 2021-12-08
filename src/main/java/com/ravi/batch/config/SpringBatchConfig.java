//package com.ravi.batch.config;
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.batch.item.ItemProcessor;
//import org.springframework.batch.item.ItemReader;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.batch.item.file.FlatFileItemReader;
//import org.springframework.batch.item.file.LineMapper;
//import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
//import org.springframework.batch.item.file.mapping.DefaultLineMapper;
//import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.Resource;
//
//import com.ravi.batch.model.User;
//
//@Configuration
//@EnableBatchProcessing
//public class SpringBatchConfig {
//
//	@Bean
//	public Job job(JobBuilderFactory builder,StepBuilderFactory stepBuilder
//				, ItemReader<User> reader,ItemProcessor<User, User> processor,ItemWriter<User> writer) {
//		
//		Step step = stepBuilder.get("ETL-File-Load")
//							.<User,User>chunk(100)
//							.reader(reader)
//							.processor(processor)
//							.writer(writer)
//							.build();
//		
//		
//		
//		return builder.get("ETL-Load")
//			.incrementer(new RunIdIncrementer())
//			.start(step).build();
//	}
//	
//	
//	@Bean
//	public FlatFileItemReader<User> reader(@Value("${input}") Resource resource){
//		
//		FlatFileItemReader<User> flatFileItemReader = new FlatFileItemReader<>();
//		
//		flatFileItemReader.setResource(resource);
//		
//		flatFileItemReader.setName("CSV-Reader");
//		flatFileItemReader.setLinesToSkip(1);
//		flatFileItemReader.setLineMapper(lineMapper());
//		return flatFileItemReader;
//	}
//
//
//	public LineMapper<User> lineMapper() {
//		
//		DefaultLineMapper<User> defaultLineMapper = new DefaultLineMapper<>();
//		
//		DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer();
//		delimitedLineTokenizer.setDelimiter(",");
//		delimitedLineTokenizer.setStrict(false);
//		delimitedLineTokenizer.setNames(new String[] {"id","name","dept","salary"});
//		
//		BeanWrapperFieldSetMapper<User> beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<>();
//		beanWrapperFieldSetMapper.setTargetType(User.class);
//		
//		defaultLineMapper.setLineTokenizer(delimitedLineTokenizer);
//		defaultLineMapper.setFieldSetMapper(beanWrapperFieldSetMapper);
//		
//		return defaultLineMapper;
//	}
//}
