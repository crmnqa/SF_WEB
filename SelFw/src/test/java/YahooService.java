import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
	
	public class YahooService{
		public static void main(String args[]) throws IOException{

		//String request = "http://api.search.yahoo.com/WebSearchService/V1/webSearch?appid=YahooDemo&query=umbrella&results=10";
		String request = "https://api.betfair.com/global/v3/BFGlobalService.wsdl";
		//String request = "http://mail.yahoo.com";
		HttpClient client = new HttpClient();
		GetMethod method = new GetMethod(request);
		
		
			int statusCode = client.executeMethod(method);
			
			System.out.println(statusCode);
		 
		
		

InputStream rstream = null;

rstream = method.getResponseBodyAsStream();

BufferedReader br = new BufferedReader(new InputStreamReader(rstream));

String line;

while ((line = br.readLine()) != null) {

//System.out.println(line);

}

br.close();


	}


		
		
		
		
	
	}

	

/*








// Send GET request




}  */