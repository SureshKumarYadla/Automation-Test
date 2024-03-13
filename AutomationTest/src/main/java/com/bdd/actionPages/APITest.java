package com.bdd.actionPages;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class APITest  {
    @Test
    public  void Test_API() {
        String url= "https://api.citybik.es/v2/networks";
        Response response= RestAssured.given().when().get(url).then().extract().response();
        System.out.println("logging response: \n " + response.asPrettyString());
        JsonPath path =response.jsonPath();
        String country = path.getString("networks.location[0].country");
        String latitude = path.getString("networks.location[0].latitude");
        String longitude = path.getString("networks.location[0].longitude");
        System.out.println("Country: "+country +"\nLatitude: "+ latitude +"\nLongitude:"+ longitude);

    }

}


