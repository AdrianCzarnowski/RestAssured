import org.testng.annotations.Test;


import static io.restassured.RestAssured.*;
import static java.lang.System.getProperty;

public class WeatherDemo extends TestBase {

    @Test
    public void weather() {
        given(getRequestSpecificationWeather()).
                when()
                .get(getProperty("BASE_URL") + getProperty("endpoint")).
                then()
                .spec(getResponseSpecificationWeather());
    }
}



