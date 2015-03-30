package API;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.*;
import org.json.*;

public class APIResponse {

	private int ResponseCode;
	private String Response; 
	private HttpURLConnection connection;
        private JSONObject json;
	
	APIResponse(){
		;
	}
	
	public APIResponse(HttpURLConnection conn) throws Exception{ 
            connection = conn;
            ResponseCode = connection.getResponseCode();
            Response = bufferResponse();
            json = new JSONObject(Response);
            //System.out.println(json.getJSONObject("newsPages").getJSONObject("minor").getJSONObject("3").getJSONObject("CustomFields").getString("author"));
	}
	
        public JSONObject getJson(){
            return json;
        }
        
	public String getResponse(){
            return (String)Response;
	}
	
	private String bufferResponse() throws Exception{
            BufferedReader rd;
            if(ResponseCode == 200){
                rd = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            } else {
                     rd = new BufferedReader(
                    new InputStreamReader(connection.getErrorStream()));
            }
            String res = "";
            String line;
            while ((line = rd.readLine()) != null) {
	        res = res + line;
	    }
	    return res;
	    
	}
	
	public boolean isSuccess(){
            if(ResponseCode != 200){
                return false;
            } else {
                return true;
            }
	}
        
        public String getError() throws Exception{
            
            if(json.has("Error")){
                return json.getString("Error");
            }
            return connection.getResponseMessage();
            
        }
	
	
}
