package Test_class;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common_method.Common_method_get;
import Common_method.Common_method_Utilities;
import io.restassured.path.json.JsonPath;
import Request_repository.get_request_respository;

public class get_tc1 {
	@Test
	public static void orchestrator() throws IOException {

		String responsebody = "";
		int responseStatuscode = 0;
		String baseuri = get_request_respository.baseuri();
		String resource = get_request_respository.resource();

		for (int i = 0; i < 5; i++) {
			responseStatuscode = Common_method_get.responsestatuscodeextractor(baseuri, resource);
			if (responseStatuscode == 200) {
				responsebody = Common_method_get.responsebodyextractor(baseuri, resource);
				responseBodyValidator(responsebody);
				break;
			} else {
				System.out.println("Correct status code is not found in the iteration: " + i);
			}
		}

		Common_method_Utilities.evidence_file_creator("get_tc1", null, responsebody);
		Assert.assertEquals(responseStatuscode, 200);

	}

	private static void responseBodyValidator(String responsebody) {
		// Create object
		JsonPath jsp = new JsonPath(responsebody);

		// Array lenght
		int dataarraylength = jsp.getInt("data.size()");
//			System.out.println("Length of Data Array is : " +dataarraylength);

		// Array values declaration
		int id[] = { 7, 8, 9, 10, 11, 12 };
		String email[] = { "michael.lawson@reqres.in", "lindsay.ferguson@reqres.in", "tobias.funke@reqres.in",
				"byron.fields@reqres.in", "george.edwards@reqres.in", "rachel.howell@reqres.in" };
		String first_name[] = { "Michael", "Lindsay", "Tobias", "Byron", "George", "Rachel" };
		String last_name[] = { "Lawson", "Ferguson", "Funke", "Fields", "Edwards", "Howell" };
		String avatar[] = { "https://reqres.in/img/faces/7-image.jpg", "https://reqres.in/img/faces/8-image.jpg",
				"https://reqres.in/img/faces/9-image.jpg", "https://reqres.in/img/faces/10-image.jpg",
				"https://reqres.in/img/faces/11-image.jpg", "https://reqres.in/img/faces/12-image.jpg" };
		// System.out.println("Data Array");

		for (int i = 0; i < dataarraylength; i++) {
			// Extract response body parameters
			int res_id = jsp.getInt("data [" + i + "].id");
			String res_email = jsp.getString("data [" + i + "].email");
			String res_fname = jsp.getString("data [" + i + "].first_name");
			String res_lname = jsp.getString("data [" + i + "].last_name");
			String res_avatar = jsp.getString("data [" + i + "].avatar");

//				System.out.println(res_id);
//				System.out.println(res_email);
//				System.out.println(res_fname);
//				System.out.println(res_lname);
//				System.out.println(res_avatar);

			// validate response body parameters
			Assert.assertEquals(res_id, id[i]);
			Assert.assertEquals(res_email, email[i]);
			Assert.assertEquals(res_fname, first_name[i]);
			Assert.assertEquals(res_lname, last_name[i]);
			Assert.assertEquals(res_avatar, avatar[i]);
		}
	}

}
