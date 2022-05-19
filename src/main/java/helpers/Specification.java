package helpers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.Integer.getInteger;
import static org.hamcrest.Matchers.is;


import static io.restassured.RestAssured.given;
import static java.lang.Integer.parseInt;
import static java.lang.System.getProperty;

public class Specification {

    private static Logger logger = LoggerFactory.getLogger("Specification.class");
    public RequestSpecification getRequestSpecificationWeather() {
        RequestSpecification requestSpecification = given()
                .header(getProperty("header_name"), getProperty("name"))
                .header(getProperty("header_age"), getInteger("age"))
                .param(getProperty("param_city_tag"), getProperty("param_city_name"))
                .param(getProperty("param_id"), getProperty("param_token"));
        return requestSpecification;
    }

    public ResponseSpecification getResponseSpecificationWeather() {
        ResponseSpecification responseSpecification = RestAssured.expect();
        responseSpecification.time(Matchers.lessThan(5000L));
        responseSpecification.contentType(ContentType.JSON);
        responseSpecification.statusCode(getInteger("status_code"));
        logger.info("Api test completed");
        return responseSpecification;
    }
    public String getWeatherUrlAndEndpoint(){
        return getProperty("BASE_URL") + getProperty("endpoint");
    }
}
