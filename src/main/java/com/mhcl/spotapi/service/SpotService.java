package com.mhcl.spotapi.service;

import java.util.List;

import com.mhcl.spotapi.dto.RateDto;

public interface SpotService {
	public List<RateDto> getRates();
}
