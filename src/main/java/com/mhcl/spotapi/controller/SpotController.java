package com.mhcl.spotapi.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mhcl.spotapi.dto.RateDto;
import com.mhcl.spotapi.dto.RateListDto;
import com.mhcl.spotapi.service.SpotServiceImpl;

@RestController
@RequestMapping("/spot/")
public class SpotController {
	private static final Logger logger 
	  = LoggerFactory.getLogger(SpotController.class);
	
	@Autowired
	SpotServiceImpl spotService;
	
	@GetMapping("getRates")
	public List<RateDto> getRates() {
		return spotService.getRates();
	}
		
	@PutMapping("putRates")
	public void updateRates(@RequestBody RateListDto rateListDto) {
		this.spotService.updateRates(rateListDto);
	}
	
	//usage: getPrice?start=2015-07-01T07:00:00-05:00&end=2015-07-01T12:00:00-05:00
	@GetMapping("getPrice")
	public String getPrice(@RequestParam String start, @RequestParam String end) {
		String price = this.spotService.getPrice(start, end);
		return price;
	}
}
