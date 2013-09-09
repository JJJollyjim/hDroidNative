package com.hdubapp.hdub;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.os.AsyncTask;

public class APIManager {

	class HTTPRequestTask extends AsyncTask<URL, Void, String> {

		@Override
		protected String doInBackground(URL... urls) {
			URL url = urls[0];

			HttpURLConnection connection = null;

			try {
				connection = (HttpURLConnection) url.openConnection();
				connection.setRequestMethod("POST");
				connection.connect();

				return readStream(connection.getInputStream());
			} catch (Exception e) {
				return null;
			} finally {
				connection.disconnect();
			}
		}

		protected void onPostExecute(String result) {

		}

		private String readStream(InputStream in) throws IOException {
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));

			StringBuilder builder = new StringBuilder();
			String line;

			while ((line = reader.readLine()) != null) {
				builder.append(line + "\n");
			}

			return builder.toString();
		}
	}
}
