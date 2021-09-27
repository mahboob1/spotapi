package com.mhcl.spotapi.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mhcl.spotapi.dto.RateDto;
import com.mhcl.spotapi.dto.RateListDto;

@Configuration
public class SpotConfiguration {
	@Bean
	RateListDto rateListDto() {
		RateListDto rateListDto = new RateListDto();
		List<RateDto> rates = new ArrayList<>();
		rateListDto.setRates(rates);
		return rateListDto;
	}

}
