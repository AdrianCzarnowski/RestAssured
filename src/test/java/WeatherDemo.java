



import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import static java.lang.System.*;
import static org.testng.Assert.assertEquals;



public class WeatherDemo extends TestBase {


    @Test
    public void weatherInLondon() {
        given(getRequestSpecificationWeather()).
                when()
                .get(getWeatherUrlAndEndpoint()).
                then()
                .spec(getResponseSpecificationWeather());
    }

    @Test
    public void weatherInLondonPartResponseAssertion() {
        String bodyPart = given(getRequestSpecificationWeather()).
        when()
                .get(getWeatherUrlAndEndpoint()).
        then()
                .spec(getResponseSpecificationWeather())
                .extract()
                .path(getProperty("body_part_to_test"));
        assertEquals(getProperty("country"), bodyPart);
    }
}



