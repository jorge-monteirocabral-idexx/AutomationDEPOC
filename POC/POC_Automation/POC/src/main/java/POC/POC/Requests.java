package POC.POC;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Requests {

	public int request(String typeRequest, String httpSite, String request) throws IOException
	{
		int result=0; 
		URL url = new URL(httpSite);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			String loginPassword = "action:jackson";
			String encoded = new sun.misc.BASE64Encoder().encode(loginPassword.getBytes());
			connection.setRequestProperty("Authorization", "Basic " + encoded);
			connection.setRequestMethod(typeRequest);
			connection.setRequestProperty("Content-type", "text/json;charset=\"utf-8\"");
			connection.setReadTimeout(60000);
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.getOutputStream().write(request.getBytes());
			connection.connect();
			result = connection.getResponseCode();
		
			
		return result; 
	}
}
