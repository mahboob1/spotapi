package com.mhcl.spotapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RateDto {
	@JsonProperty("days")
	private String days;
	@JsonProperty("times")
	private String times;
	@JsonProperty("tz")
	private String tz;
	@JsonProperty("price")
	private String price;
}