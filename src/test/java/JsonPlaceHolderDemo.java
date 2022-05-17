import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;

public class JsonPlaceHolderDemo extends TestBase {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private static final String USERS = "users";


    @Test
    public void weather(){
        given()
                .log()
                .all()
                .header("name:", "Adrian")
                .header("age:", "29")
                .param("q","London,uk")
                .param("appid", "b1b15e88fa797225412429c1c50c122a1").
        when()
                .get("https://samples.openweathermap.org/data/2.5/weather").
        then()
                .log()
                .all()
                .statusCode(200);
    }
    @Test
    public void weather2(){
        RequestSpecification requestSpecification1 = given()
                .log()
                .all()
                .header("name:", "Adrian")
                .header("age:", "29")
                .param("q","London,uk")
                .param("appid", "b1b15e88fa797225412429c1c50c122a1");

        given(requestSpecification1).
        when()
                .get("https://samples.openweathermap.org/data/2.5/weather").
        then()
                .log()
                .all()
                .statusCode(200);
    }

    @Test
    public void weather3(){
        RequestSpecification requestSpecification = given()
                .log()
                .all()
                .header("name:", "Adrian")
                .header("age:", "29")
                .param("q","London,uk")
                .param("appid", "b1b15e88fa797225412429c1c50c122a1");

        ResponseSpecification responseSpecification = RestAssured.expect();
        responseSpecification.log().all();
        responseSpecification.time(Matchers.lessThan(5000L));
        responseSpecification.contentType(ContentType.JSON);
        responseSpecification.statusCode(200);

        given(requestSpecification).
        when()
                .get("https://samples.openweathermap.org/data/2.5/weather").
        then()
                .spec(responseSpecification);
    }
    @Test
    public void shouldGetAllUsers() {
        when().
                get(BASE_URL).
                then()
                .statusCode(200);
    }

    @Test
    public static void getSpecificPartOfResponseBody() {

        ArrayList<String> names;
        names = when().get(BASE_URL + USERS).then().extract().jsonPath().get("name");

        String listName = "";
        for (String name : names) {

            System.out.println("The name is " + name);
            listName = listName + " " + name;
        }
        System.out.println("List of names " + listName);
    }
    @Test
    public static void getOneUserFromArray() {
        Response response = RestAssured.given().when().get(BASE_URL + USERS);
        JSONArray array = new JSONArray(response.getBody().asPrettyString());
        System.out.println("><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println(array.get(0));
    }

    @Test
    public static void getOneUserName() {
        Response response = RestAssured.given().when().get(BASE_URL + USERS);
        JSONArray array = new JSONArray(response.getBody().asPrettyString());
        JSONObject obj = array.getJSONObject(0);
        System.out.println("><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println(obj.get("username"));
    }

    @Test
    public static void getAllUserName() {
        Response response = RestAssured.given().when().get(BASE_URL + USERS);
        JSONArray array = new JSONArray(response.getBody().asPrettyString());
        for (int i = 0; i < array.length(); i++) {
            JSONObject obj = array.getJSONObject(i);
            System.out.println("><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println(obj.get("name"));
            System.out.println(obj.get("username"));
            System.out.println(obj.get("address"));
            JSONObject obj1 = (JSONObject) obj.get("address");
            System.out.println("!!!!!!!!!!!!!!");
            System.out.println(obj1.get("city"));
//            List<Object> zips = JsonPath.from(String.valueOf(obj)).getList("address.flatten().zipcode");
//            System.out.println(zips);


//            System.out.println(obj.get("address"));
        }
    }

}