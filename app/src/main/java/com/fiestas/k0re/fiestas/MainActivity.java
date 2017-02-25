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
				postData("Solana Vera", "Antonio", "Bachillerato", "2");
				
			}
		});
		t.start();
	}

	

	public void postData(String apellidos, String nombre, String bloque, String curso) {

		String fullUrl = "https://docs.google.com/forms/d/e/1FAIpQLScpPmIQ9W_Y1AGngC1aOMVoH6XKKYxCOSAF_KEG6KMvD-ddJg/formResponse";
		HttpRequest mReq = new HttpRequest();
		
		String data = "entry.1138757144=" + URLEncoder.encode(apellidos) + "&" +
					  "entry.1353392484=" + URLEncoder.encode(nombre) + "&" +
				      "entry.1547412774=" + URLEncoder.encode(bloque) + "&" +
				      "entry.369429584=" + URLEncoder.encode(curso);
		String response = mReq.sendPost(fullUrl, data);
		Log.i(myTag, response);
	} 

}
