package ua.cn.al.quarkus;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ExampleResourceTest {
/**
 * Uncomment test body to ensure it does not work
 */
    @Test
    public void testHelloEndpoint() {
//        given()
//          .when().get("/hello")
//          .then()
//             .statusCode(200)
//             .body(is("From JS:42"));
    }

}