
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public class RestJsonHttpClient {

	  
	public static void main(String[] args) throws ClientProtocolException, IOException {
		// 

		DefaultHttpClient httpClient = new DefaultHttpClient();	
	 
	 
		
 
		
		HttpPost postRequest = new HttpPost("https://acs-uat.newsint.co.uk/profile/getUserProfile");
		

		StringEntity input = new StringEntity("{\"tenantId\":\"TNL\",\"username\":\"two2@two.com\",\"timestamp\":\"2012-01-31T16:30:00Z\"}");
	

	input.setContentType("application/json");
		

	postRequest.setEntity(input);
		
		HttpResponse response = httpClient.execute(postRequest);
		/*		 

		if (response.getStatusLine().getStatusCode() != 201) {
			throw new RuntimeException("Failed : HTTP error code :"+ response.getStatusLine().getStatusCode());
		}
		
		
		BufferedReader br = new BufferedReader(
                new InputStreamReader((response.getEntity().getContent())));

		
		
		String output;
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}
 
		httpClient.getConnectionManager().shutdown();
 */
	  }  
		
		
		
		
	}


