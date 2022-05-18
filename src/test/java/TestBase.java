import config.App;
import helpers.Specification;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

import org.testng.annotations.BeforeMethod;



public class TestBase extends Specification {

    private static App app;

    @BeforeMethod
    public void setUp(){
//        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        app = new App();
    }


}

