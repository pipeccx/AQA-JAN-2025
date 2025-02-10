package org.prog.rest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.devtools.v130.fetch.model.AuthChallengeResponse;
import org.testng.annotations.Test;

public class MyApiTest {
    @Test
    public void MyTest() {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://randomuser.me/");
        requestSpecification.basePath("/api");
        requestSpecification.queryParam("inc", "gender,name,nat,location");
        requestSpecification.queryParam("noinfo");
        requestSpecification.queryParam("results", "3");

        Response response = requestSpecification.get();
        response.prettyPrint();

        Results results = response.as(Results.class);
        if (results.getResults().get(0).getLocation() == null) {
            System.out.println("NO LOCATION!");
        } else {
            System.out.println("Location: " + results.getResults().get(0).getLocation().getCity() + ", " + results.getResults().get(0).getLocation().getCountry());
        }
        System.out.println(results.getResults().get(0).getName().getFirst());
    }
}

