import org.junit.jupiter.api.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static io.restassured.http.ContentType.JSON;

public class ReqTest extends TestBase {
    @Test
    void loginTest() {
        String body = "{ \"email\": \"eve.holt@reqres.in\", " +
                "\"password\": \"cityslicka\" }";

        given()
                .log().uri()
                .log().body()
                .body(body)
                .contentType(JSON)
                .when()
                .post("/login")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("token", is("QpwL5tke4Pnpja7X4"));
    }
    @Test
    void missingPasswordLoginTest() {
        String body = "{ \"email\": \"eve.holt@reqres.in\"}";

        given()
                .log().uri()
                .log().body()
                .body(body)
                .contentType(JSON)
                .when()
                .post("/login")
                .then()
                .log().status()
                .log().body()
                .statusCode(400)
                .body("error", is("Missing password"));
    }
    @Test
    void nameTest() {
        String name = "{\"name\": \"TestUser\"}";
        given()
                .log().uri()
                .body(name)
                .contentType(JSON)
                .when()
                .post("/users/2")
                .then()
                .log().body()
                .statusCode(201)
                .body("name", is("TestUser"));
    }
    @Test
    void emailTest() {
        String email = "{\"email\": \"janet.weaver@reqres.in\"}";
        given()
                .log().uri()
                .body(email)
                .contentType(JSON)
                .when()
                .post("/users/2")
                .then()
                .log().body()
                .statusCode(201)
                .body("email", is("janet.weaver@reqres.in"));
    }
    @Test
    void nameAndJobTest() {
        String nameAndJob = "{ \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"}";
        given()
                .log().uri()
                .body(nameAndJob)
                .contentType(ContentType.JSON)
                .when()
                .post("/users")
                .then()
                .log().body()
                .statusCode(201)
                .body("name", is("morpheus"))
                .body("job", is("leader"));
    }

}
