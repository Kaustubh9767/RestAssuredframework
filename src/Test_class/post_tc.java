package Test_class;

import java.io.IOException;
import java.time.LocalDate;
import org.testng.Assert;
import org.testng.annotations.Test;

import Common_method.Common_method_Utilities;
import Common_method.Common_method_api;

import io.restassured.path.json.JsonPath;
import Request_repository.Post_request_repository;

public class post_tc {
	@Test
	public static void orchestrator() throws IOException {
		String responsebody = "";
		int responsestatuscode = 0;
		String baseuri = Post_request_repository.baseuri();
		String resource = Post_request_repository.resource();
		String requestbody = Post_request_repository.post_request_tc1();
		for (int i = 0; i < 5; i++) {
			responsestatuscode = Common_method_api.responsestatuscodeextractor(baseuri, resource, requestbody);
			if (responsestatuscode == 201) {
				responsebody = Common_method_api.responsebodyextractor(baseuri, resource, requestbody);
				responsebodyvalidator(responsebody);
				break;
			} else {
				System.out.println("Correct status code not found in iteration: " + i);
			}
		}
		Common_method_Utilities.evidence_file_creator("post_tc1", requestbody, responsebody);
		Assert.assertEquals(responsestatuscode, 201);

	}

	private static void responsebodyvalidator(String responsebody) {
		// create jsonPath object to extract responsebody parameters
		JsonPath jsp = new JsonPath(responsebody);

		// extract responsebody parameters
		String res_name = jsp.getString("name");
		String res_job = jsp.getString("job");
		String res_id = jsp.getString("id");
		String res_createdAt = jsp.getString("createdAt");

//				System.out.println("name : " + res_name + "\njob : " + res_job + "\nid : " + res_id + "\ncreatedAt : " + res_createdAt);

		// validate responsebody parameter
		Assert.assertEquals(res_name, "morpheous");
		Assert.assertEquals(res_job, "leader");
		Assert.assertNotNull(res_id, "assertion error , id parameter is null");

		// extract date from createdAt parameter
		String actual_date = res_createdAt.substring(0, 10);
		String current_date = LocalDate.now().toString(); // Create a date object
		Assert.assertEquals(actual_date, current_date);
		// System.out.println("Actual DATE : " + actual_date + "\nCURRENT DATE : " +
		// current_date);

	}

}
