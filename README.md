Unzip and from project root directory run : mvn spring-boot:run
This will start the rest service in localhost at 5000 and can be accesses by swagger ui or postman.

At startup the application reads the rates json file in command line runner to a singleton java class.

1. Swagger UI provided:
http://localhost:5000/swagger-ui.html
http://localhost:5000/v2/api-docs

2, Docker file included

3. Spring boot actuator is provided:
http://localhost:5000/actuator/prometheus
http://localhost:5000/actuator/health
http://localhost:5000/actuator/env
http://localhost:5000/actuator/beans

pojo level validation is not included and so no validator used for logging.

Following get command will return all rates
---------------------------
http://localhost:5000/getRates

Following get command will return price for a start and end date time
---------------------------
http://localhost:5000/getPrice?start=2015-07-01T07:00:00-05:00
&end=2015-07-01T12:00:00-05:00

Following post command in postman will update the rates json.
------------------------------
http://localhost:5000/putRates    with post body:
{
"rates": [
{
"days": "mon,tues,thurs",
"times": "0900-2100",
"tz": "America/Chicago",
"price": 1501
},
{
"days": "fri,sat,sun",
"times": "0900-2100",
"tz": "America/Chicago",
"price": 2002
},
{
"days": "wed",
"times": "0600-1800",
"tz": "America/Chicago",
"price": 1753
},
{
"days": "mon,wed,sat",
"times": "0100-0500",
"tz": "America/Chicago",
"price": 1004
},
{
"days": "sun,tues",
"times": "0100-0700",
"tz": "America/Chicago",
"price": 930
}
]
}
-----------------------


