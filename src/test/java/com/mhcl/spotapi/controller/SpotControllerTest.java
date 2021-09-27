package com.mhcl.spotapi.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.mhcl.spotapi.SpotapiApplication;
import com.mhcl.spotapi.dto.RateListDto;
import com.mhcl.spotapi.service.SpotServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(SpotController.class)
@ContextConfiguration(classes = SpotapiApplication.class)
public class SpotControllerTest {
	
	@Autowired
    private MockMvc mvc;
	
	@MockBean
	SpotServiceImpl spotService;
	
	@MockBean
	RateListDto rateListDto;

	@Test
	public void testGetRates() throws Exception {
		mvc.perform(get("/getRates")
		          .contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	public void testUpdateRates() throws Exception {
		mvc.perform(put("/putRates")
		          .contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	public void testGetPrice() throws Exception {
		mvc.perform(get("/getPrice?start=2015-07-01T07:00:00-05:00&end=2015-07-01T12:00:00-05:00")
		          .contentType(MediaType.APPLICATION_JSON));
	}

}
