
import org.testng.annotations.Test;


import static io.restassured.RestAssured.*;


public class WeatherDemo extends TestBase {

    @Test
    public void weather() {
        given(getRequestSpecificationWeather()).
        when()
                .get(getWeatherUrlAndEndpoint()).
        then()
                .spec(getResponseSpecificationWeather());
    }
}



