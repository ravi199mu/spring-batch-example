package com.ravi.batch.config;



import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.extensions.excel.RowMapper;
import org.springframework.batch.extensions.excel.mapping.BeanWrapperRowMapper;
import org.springframework.batch.extensions.excel.poi.PoiItemReader;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.json.JacksonJsonObjectMarshaller;
import org.springframework.batch.item.json.JsonFileItemWriter;
import org.springframework.batch.item.json.builder.JsonFileItemWriterBuilder;
import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.oxm.xstream.XStreamMarshaller;

import com.ravi.batch.model.Userxls;

@Configuration
public class ApplicationConfig {
	
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	

	@Bean(destroyMethod="")
	public ItemReader<Userxls> excelItemReader() {
		PoiItemReader<Userxls> reader = new PoiItemReader<>();
		reader.setLinesToSkip(1);
		reader.setResource(new ClassPathResource("user.xlsx"));
		reader.setRowMapper(excelRowMapper());
		return reader;
	}

	@Bean
	public RowMapper<Userxls> excelRowMapper() {
		BeanWrapperRowMapper<Userxls> rowMapper = new BeanWrapperRowMapper<>();
		rowMapper.setTargetType(Userxls.class);
		return rowMapper;
	}

	@Bean
	public StaxEventItemWriter<Userxls> writter() {
		StaxEventItemWriter<Userxls> writter = new StaxEventItemWriter<Userxls>();
		writter.setRootTagName("users");
		writter.setResource(new FileSystemResource("xml/users.xml"));
		writter.setMarshaller(marshaller());
		return writter;
	}

	private XStreamMarshaller marshaller() {
		XStreamMarshaller marshaller = new XStreamMarshaller();
		Map<String, Class> map = new HashMap<>();
		map.put("user", Userxls.class);
		marshaller.setAliases(map);
		return marshaller;
	}
	
	
	@Bean
	public JsonFileItemWriter<Userxls> jsonFileItemWriter() {
	   return new JsonFileItemWriterBuilder<Userxls>()
	                 .jsonObjectMarshaller(new JacksonJsonObjectMarshaller<>())
	                 //.resource(new ClassPathResource("users.json"))
	                 .resource(new FileSystemResource("xml/users.json"))
	                 .name("JsonFileItemWriter")
	                 .build();
	}

	@Bean
	public Step step1() {
		return stepBuilderFactory.get("step1").<Userxls, Userxls>chunk(10).reader(excelItemReader()).processor(process())
				.writer(jsonFileItemWriter()).build();
	}

	@Bean
	public Job runJob() {
		return jobBuilderFactory.get("report generation").flow(step1()).end().build();
	}

	public ItemProcessor<Userxls, Userxls> process() {

		ItemProcessor<Userxls, Userxls> process = new ItemProcessor<Userxls, Userxls>() {

			@Override
			public Userxls process(Userxls userxls) throws Exception {
				
				//logic to call doc service and send payload.
				return userxls;
			}

		};
		return process;

	}

}
