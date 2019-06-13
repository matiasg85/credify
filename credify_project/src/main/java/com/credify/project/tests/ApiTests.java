package com.credify.project.tests;

import com.credify.project.api_objects.states;
import com.credify.project.utils.Helper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.ArrayList;
import java.util.List;
import net.sf.json.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ApiTests {

    Helper helper;

    @Test
    public void test1() {
        RestAssured.baseURI = "https://credapi.credify.tech/api/loanapp/v1";
        RequestSpecification request = RestAssured.given();
        Response response = request.get("/states");
        JSONObject json = new JSONObject();
        states[] states = response.jsonPath().getObject("states", states[].class);
        Assert.assertEquals(states.length,48);
        helper = new Helper();
        Assert.assertTrue(helper.stateValidator(states));

    }

    @Test
    public void test2() {
        RestAssured.baseURI = "https://credapi.credify.tech/api/loanapp/v1";
        RequestSpecification request = RestAssured.given();
        Response response = request.get("/states");
        JSONObject json = new JSONObject();
        states[] state = response.jsonPath().getObject("states", states[].class);

        helper = new Helper();
        List<String> matchingSates = new ArrayList<String>();
        matchingSates = helper.returnStatesByMinAge(state, 19);
        Assert.assertTrue(matchingSates.size() == 1);
        Reporter.log("Only 1 state has a minAge of 19 and it is: "+ matchingSates.get(0));
        //System.out.print("Only 1 state has a minAge of 19 and it is: "+ matchingSates.get(0));

    }

    @Test
    public void test3() {
        RestAssured.baseURI = "https://credapi.credify.tech/api/loanapp/v1";
        RequestSpecification request = RestAssured.given();
        Response response = request.get("/states");
        JSONObject json = new JSONObject();
        states[] state = response.jsonPath().getObject("states", states[].class);

        helper = new Helper();
        List<String> matchingSates = new ArrayList<String>();
        matchingSates = helper.returnStatesByMinLoanAmount(state, 3005);
        Assert.assertTrue(matchingSates.size() == 1);
        Reporter.log("Only 1 state has a minLoanAmount of 3,005 and it is: "+ matchingSates.get(0));
        //System.out.print("Only 1 state has a minLoanAmount of 3,005 and it is: "+ matchingSates.get(0));

    }
}


