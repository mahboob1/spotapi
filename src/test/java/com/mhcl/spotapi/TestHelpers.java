package com.mhcl.spotapi;

import java.util.List;
import java.util.ArrayList;

import com.mhcl.spotapi.dto.RateDto;

public class TestHelpers {
	public static String start = "2015-07-01T07:00:00-05:00";
	public static String end = "2015-07-01T12:00:00-05:00";
	public static List<RateDto> getRates() {
		return new ArrayList<RateDto>() {{
            add(new RateDto() {{
                setDays("mon,tues");
                setTimes("0900-2100");
                setTz("America/Chicago");
                setPrice("1500");
            }});
            add(new RateDto() {{
                setDays("fri,sat,sun");
                setTimes("0900-2100");
                setTz("America/Chicago");
                setPrice("2000");
            }});
        }};
	}

}
