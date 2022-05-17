import config.App;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    private static App app;

    @BeforeMethod
    public void setUp(){
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        app = new App();
    }
}

