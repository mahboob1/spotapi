package com.mhcl.spotapi;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mhcl.spotapi.controller.SpotController;
import com.mhcl.spotapi.dto.RateDto;
import com.mhcl.spotapi.dto.RateListDto;

@SpringBootApplication
public class SpotapiApplication implements CommandLineRunner {
	private static final Logger logger 
	  = LoggerFactory.getLogger(SpotapiApplication.class);
	@Autowired
	RateListDto rateListDto;
	@Value("${json.path}") 
	private String fileLoc;

	public static void main(String[] args) {
		SpringApplication.run(SpotapiApplication.class, args);
	}

	public void run(String... args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();       
        RateListDto rateList = objectMapper.readValue(new File(fileLoc), 
                new TypeReference<RateListDto>(){});

        rateList.getRates().forEach(x -> logger.info(x.toString()));
        rateList.getRates().forEach(x -> rateListDto.getRates().add(x));
	}
}
