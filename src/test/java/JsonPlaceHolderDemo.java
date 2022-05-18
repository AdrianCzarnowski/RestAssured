import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.*;
import static java.lang.System.getProperty;

public class JsonPlaceHolderDemo extends TestBase {

    @Test
    public void weather2() {
        given(getRequestSpecificationWeather()).
                when()
                .get(getProperty("BASE_URL") + getProperty("endpoint")).
                then()
                .spec(getResponseSpecificationWeather());
    }
}



