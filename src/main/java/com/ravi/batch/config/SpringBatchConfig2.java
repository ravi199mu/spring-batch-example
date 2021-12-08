//package com.ravi.batch.config;
//
//import java.util.Collections;
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.batch.extensions.excel.RowMapper;
//import org.springframework.batch.extensions.excel.mapping.BeanWrapperRowMapper;
//import org.springframework.batch.extensions.excel.poi.PoiItemReader;
//import org.springframework.batch.item.ItemProcessor;
//import org.springframework.batch.item.ItemReader;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.batch.item.xml.builder.StaxEventItemWriterBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.FileSystemResource;
//import org.springframework.core.io.Resource;
//import org.springframework.oxm.xstream.XStreamMarshaller;
//
//import com.ravi.batch.model.Userxls;
//
//@Configuration
//@EnableBatchProcessing
//public class SpringBatchConfig2 {
//
//	@Bean
//	public Job job(JobBuilderFactory builder, StepBuilderFactory stepBuilder, ItemReader<Userxls> reader,
//			ItemProcessor<Userxls, Userxls> processor, ItemWriter<Userxls> writer) {
//
//		Step step = stepBuilder.get("ETL-File-Load").<Userxls, Userxls>chunk(100).reader(reader).processor(processor)
//				.writer(writer).build();
//
//		return builder.get("ETL-Load").incrementer(new RunIdIncrementer()).start(step).build();
//	}
//
//	//@Bean
//	@Bean(destroyMethod="")
//	public ItemReader<Userxls> itemReaderr() {
//		PoiItemReader<Userxls> reader = new PoiItemReader<>();
//		reader.setLinesToSkip(1);
//		reader.setResource(new ClassPathResource("user.xlsx"));
//		reader.setRowMapper(excelRowMapper());
//		return reader;
//	}
//
////	@Bean
////    ItemStreamReader<> reader() {
////        PoiItemReader reader = new PoiItemReader();
////        reader.setResource(new ClassPathResource("input.xlsx"));
////        reader.setRowMapper(new RowMapperImpl());
////        reader.setLinesToSkip(1);
////
////        return reader;
////    }
//
//	@Bean
//	public RowMapper<Userxls> excelRowMapper() {
//		BeanWrapperRowMapper<Userxls> rowMapper = new BeanWrapperRowMapper<>();
//		rowMapper.setTargetType(Userxls.class);
//		return rowMapper;
//	}
//
//	@Bean
//	public ItemWriter<Userxls> itemWriterXml(Environment environment) {
//		String exportFilePath = environment.getRequiredProperty("batch.job.export.file.path");
//
//		Resource exportFileResource = new FileSystemResource(exportFilePath);
//
//		XStreamMarshaller userMarshaller = new XStreamMarshaller();
//		userMarshaller.setAliases(Collections.singletonMap("user", Userxls.class));
//
//		return new StaxEventItemWriterBuilder<Userxls>().name("userWriter").resource(exportFileResource)
//				.marshaller(userMarshaller).rootTagName("users").build();
//	}
//	
//	@Bean
//	public ItemWriter<Userxls> itemWriterJson(Environment environment) {
//		String exportFilePath = environment.getRequiredProperty("batch.job.export.file.path");
//
//		Resource exportFileResource = new FileSystemResource(exportFilePath);
//
//		XStreamMarshaller userMarshaller = new XStreamMarshaller();
//		userMarshaller.setAliases(Collections.singletonMap("user", Userxls.class));
//
//		return new StaxEventItemWriterBuilder<Userxls>().name("userWriter").resource(exportFileResource)
//				.marshaller(userMarshaller).rootTagName("users").build();
//	}
//}
