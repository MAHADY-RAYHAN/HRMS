package Test;

import io.restassured.*;
import io.restassured.response.*;
import io.restassured.specification.*;
import static io.restassured.RestAssured.*;

public class HardCode {

	public static void main(String[] args) {
		/**
		 * BaseURI for all user
		 */
		RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api";
		
		/**
		 * JWT required for all calls - it expires every 12 hours
		 */
		String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1OTUwOTQ5NzEsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU5NTEzODE3MSwidXNlcklkIjoiMTA1NyJ9.3bdStuIxoyO0y9DbAu8Nc1_z9CpEA4VK5tFg_Sc5Uq8";
		/**
		 * preparing /get employee.php.request
		 */
		 RequestSpecification getOneEployeeRequest= given().header("Content-Type","application/json").header("Authorization",token).queryParam("employee_id","16490A");
		
		 Response getOneEmployeeResponse= getOneEployeeRequest.when().get("/getOneEmployee.php");
		 /**
		 * two ways to print response
		 *  
		 * pretty print () method convert object into string and prints - no need to SOP
		 */
		 getOneEmployeeResponse.prettyPrint();
		 
		  //String response=getOneEmployeeResponse.body().asString();
		 
		// System.out.println(getOneEmployeeResponse);
		 
		 /**
		 * verifying response status code is 200
		 */
		 getOneEmployeeResponse.then().assertThat().statusCode(200);
		 
	}
	
}
