package MyExperiments;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public class HttpClientPost {

	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws IOException{
		// 
		 
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost postRequest = new HttpPost("https://acs-uat.newsint.co.uk/profile/getUserProfile");
		StringEntity input = new StringEntity("{\"tenantId\":\"TNL\",\"username\":\"three2@three.com\"}");
		input.setContentType("application/json");
		postRequest.addHeader("X-NI-signatureType", "2");
		postRequest.addHeader("X-NI-apiVersion","1");
		postRequest.addHeader("X-NI-signatureHash", "dummy");
		postRequest.addHeader("X-NI-apiKey", "a3a0a84318e06c048a8bdb56c966f060");
		postRequest.setEntity(input);
		
		
		HttpResponse response = httpClient.execute(postRequest);
	 
	System.out.println(response.getStatusLine().getStatusCode());
		 
	}

	}
		  
 


