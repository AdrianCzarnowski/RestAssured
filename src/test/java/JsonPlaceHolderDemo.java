import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.*;

public class JsonPlaceHolderDemo extends TestBase {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private static final String USERS = "users";


    @Test
    public void shouldGetAllUsers() {
        when().
                get(BASE_URL).
                then()
                .statusCode(200);
    }

    //    @Test
//    public void shouldGetSpecifyName(){
//        Response response =
//                (Response) given()
//                        .contentType(ContentType.JSON)
//                        .queryParam("username", "Bret")
//                        .queryParam("email", "Sincere@april.biz").
//                when().
//                        get(BASE_URL+USERS).
//                then().
//                        statusCode(200).extract().response();
//        JsonPath extractor = response.jsonPath().get("name");
//        System.out.println(extractor);
//    }
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
//    @Test
//    public static void getSpecificName(){
//
//        ArrayList<String> names;
//        names = when().get(BASE_URL+USERS).then().extract().jsonPath().get();
//
//        String listName = "";
////            System.out.println("The name is "+ name);
//        listName=names.get(0);
//
//        System.out.println("Name is " + listName);
//    }

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

//        System.out.println(array.get(1));
    }

    @Test
    public static void getAllUserName() {
        Response response = RestAssured.given().when().get(BASE_URL + USERS);
        JSONArray array = new JSONArray(response.getBody().asPrettyString());
        for (int i = 0; i < array.length(); i++) {

            JSONObject obj = array.getJSONObject(i);
            System.out.println("><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println(obj.get("username"));

        }


    }
}