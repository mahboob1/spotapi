package com.mhcl.spotapi.service;

import java.io.File;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mhcl.spotapi.SpotapiApplication;
import com.mhcl.spotapi.dto.RateDto;
import com.mhcl.spotapi.dto.RateListDto;

@Service("spotService")
public class SpotServiceImpl implements SpotService {
	private static final Logger logger 
	  = LoggerFactory.getLogger(SpotServiceImpl.class);
	public static final String UNAVAILABLE = "unavailable";
	@Autowired
	RateListDto rateListDto;
	
	@Value("${json.path}") 
	private String fileLoc;
	
	public List<RateDto> getRates() {
		return rateListDto.getRates();
	}
		
	public void updateRates(RateListDto rateListDto) {
		this.rateListDto = rateListDto;
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			objectMapper.writeValue(new File(fileLoc), rateListDto);
		} catch(Exception e) {
			logger.info("Error write object", e);
		}
	}
		
	public String getPrice(String start, String end) {
		ZonedDateTime startDt = ZonedDateTime.parse(start);
		ZonedDateTime endDt = ZonedDateTime.parse(end);
		String startDOfWk = startDt.getDayOfWeek().toString();
		String endDOfWk = endDt.getDayOfWeek().toString();
		if(!startDOfWk.equals(endDOfWk) || startDt.isAfter(endDt)) {
			return UNAVAILABLE;
		}
		for(RateDto rtDto: rateListDto.getRates()) {
			String[] dOfWks = rtDto.getDays().split(",");
			for(String dOfWk: dOfWks) {
				if(startDOfWk.startsWith(dOfWk.toUpperCase())) {
					ZoneId destZoneId = ZoneId.of(rtDto.getTz());
					ZonedDateTime destStartDt = startDt.withZoneSameInstant(destZoneId);
					ZonedDateTime destEndDt = endDt.withZoneSameInstant(destZoneId);
					String destStartHr = String.valueOf(destStartDt.getHour());
					if(destStartHr.length() == 1) {
						destStartHr = "0" + destStartHr;
					}
					String destStartMn = String.valueOf(destStartDt.getMinute());
					if(destStartMn.length() == 1) {
						destStartMn = "0" + destStartMn;
					}
					String destStartHrMn = destStartHr + destStartMn;
					
					String destEndHr = String.valueOf(destEndDt.getHour());
					if(destEndHr.length() == 1) {
						destEndHr = "0" + destEndHr;
					}
					String destEndMn = String.valueOf(destEndDt.getMinute());
					if(destEndMn.length() == 1) {
						destEndMn = "0" + destEndMn;
					}
					String destEndHrMn = destEndHr + destEndMn;
					
					String[] timeArray = rtDto.getTimes().split("-");
					if(Integer.parseInt(timeArray[0]) <= Integer.parseInt(destStartHrMn) && 
							Integer.parseInt(timeArray[1]) >= Integer.parseInt(destEndHrMn)) {
						return rtDto.getPrice();
					}
				}
			}
		}
		return UNAVAILABLE;
	}
}
