
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestBase {

    
    @BeforeAll
    static void  setUp() {
        RestAssured.baseURI = "https://reqres.in/api";
    }
}