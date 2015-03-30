package API;

import android.os.AsyncTask;
import android.os.StrictMode;

import java.lang.System;
import java.io.*;
import java.net.*;
import java.util.*;

public class APICall {

	private String baseURL = "http://82.165.177.134/GoFitYourself/api/v1/index.php";
	private String Method; 
	private String FullURL;
	private Map<String,Object> Params = new LinkedHashMap<>();
	private String Authentication = ""; 
	
	public APICall(String method, String URL ){

        StrictMode.ThreadPolicy tp = StrictMode.ThreadPolicy.LAX;
        StrictMode.setThreadPolicy(tp);


            Method = method; 
            FullURL = baseURL + URL;
	}

        public void SetUser(String UserHash){
            this.Authentication = UserHash;
        }
        
	public void addParameter(String key, String value){
            Params.put(key, value);
	}

	public APIResponse exec() throws Exception{
		
            URL thisurl;
            // Setup the URL
            try{ thisurl = new URL(FullURL);
            } catch (Exception e) {
                    return new APIResponse();
            }

            System.out.println(Method);
            System.out.println(FullURL);

            // Deal with Params
            String encodedParams = "";
            encodedParams = encodeParams();
            System.out.println(Params);

            //Setup Request
            byte[] postDataBytes = encodedParams.getBytes("UTF-8");
            HttpURLConnection conn = null;
            try {
                conn = (HttpURLConnection)thisurl.openConnection();
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
            conn.setRequestMethod(Method);
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("X-UserAuth", Authentication);

            if(Method!= "GET"){

            conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
            conn.setDoOutput(true);

            try( DataOutputStream wr = new DataOutputStream( conn.getOutputStream())) {
             wr.write( postDataBytes );
            }
            }

            APIResponse response = new APIResponse(conn);

            return response;
        
	}
	
	private String encodeParams() throws Exception {
            StringBuilder postData = new StringBuilder();
            for (Map.Entry<String,Object> param : Params.entrySet()) {
                if (postData.length() != 0) postData.append('&');
                postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postData.append('=');
                postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }
            return postData.toString();
	}
}
