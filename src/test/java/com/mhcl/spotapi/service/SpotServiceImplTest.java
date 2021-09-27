package com.mhcl.spotapi.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.mhcl.spotapi.TestHelpers;
import com.mhcl.spotapi.dto.RateDto;
import com.mhcl.spotapi.dto.RateListDto;

@RunWith(MockitoJUnitRunner.class)
public class SpotServiceImplTest {
	@InjectMocks
	SpotServiceImpl spotService;
	
	@Mock
	RateListDto rateListDto;
	
	private List<RateDto> rates;
	
	@Before
	public void init() {
		rates = TestHelpers.getRates();
	}

	@Test
	public void testGetRates() {
		when(rateListDto.getRates()).thenReturn(rates);
		spotService.getRates();
		assertEquals(rates.size(),spotService.getRates().size());
	}

	@Test
	public void testUpdateRates() throws Exception {
		spotService.updateRates(rateListDto);
	}

	@Test
	public void testGetPrice() {
		when(rateListDto.getRates()).thenReturn(rates);
		spotService.getPrice(TestHelpers.start, TestHelpers.end); 
	}

}
