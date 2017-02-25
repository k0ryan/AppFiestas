package com.fiestas.k0re.fiestas;

import java.net.URLEncoder;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.fiestas.k0re.fiestas.HttpRequest;

public class MainActivity extends Activity {
	
	final String myTag = "DocsUpload";
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calendario);
		Log.i(myTag, "OnCreate()");
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				postData();
				
			}
		});
		t.start();
	}

	

	public void postData() {

		String fullUrl = "https://docs.google.com/forms/d/e/1FAIpQLScpPmIQ9W_Y1AGngC1aOMVoH6XKKYxCOSAF_KEG6KMvD-ddJg/formResponse";
		HttpRequest mReq = new HttpRequest();
		String col1 = "col1";
		String col2 = "col2";
		String col3 = "col3";
        String col4 = "col4";
		
		String data = "entry.1138757144=" + URLEncoder.encode(col1) + "&" +
					  "entry.1353392484=" + URLEncoder.encode(col2) + "&" +
				      "entry.1547412774=" + URLEncoder.encode(col3) + "&" +
				      "entry.369429584=" + URLEncoder.encode(col4);
		String response = mReq.sendPost(fullUrl, data);
		Log.i(myTag, response);
	} 

}
