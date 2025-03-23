package br.com.fmarc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;


//MapperConfig criado, para caso seja necessário não retornar algum dado no JSON de Response,
//Adicionar @JsonFilter.
@Configuration
public class ObjectMapperConfig {

	@Bean
	public ObjectMapper ObjectMapper() {
		ObjectMapper mapper = new ObjectMapper();

		SimpleFilterProvider filters = new SimpleFilterProvider().addFilter("PersonFilter",
				SimpleBeanPropertyFilter.serializeAllExcept("sensitiveData"));
		mapper.setFilterProvider(filters);
		return mapper;
	}
}
