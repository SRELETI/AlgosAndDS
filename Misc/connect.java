import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;


public class connect {
	public static boolean acceptAnySSL =true;
	public static void main(String args[]) throws IOException
	{
		String uri="https://castdata.tivlab.austin.ibm.com/cgi-bin/wdisplay.cgi?collections=taddm&coll=taddm&doc_url=https://rtp-rtc1.tivlab.raleigh.ibm.com:9443/jazz/resource/itemName/com.ibm.team.workitem.WorkItem/16816:::::16816&hl_color=yellow&search_arg=error";
		URL url = new URL(uri);
		HttpURLConnection urlcon = (HttpURLConnection) url.openConnection();
		if (urlcon instanceof HttpsURLConnection && acceptAnySSL) {
			// Accept "bad" certificates
			((HttpsURLConnection) urlcon).setSSLSocketFactory(getSSLContext()
					.getSocketFactory());
		}
		urlcon.setRequestProperty("User-Agent", 
		        "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");

		urlcon.connect();
		InputStream in = urlcon.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		StringBuilder sb = new StringBuilder(
				urlcon.getContentLength() + 256);
		String line = null;
		while ((line = reader.readLine()) != null) {
			sb.append(line);
			sb.append("\n");
		}
		System.out.println(sb);
	}
	private static SSLContext sc;

	private synchronized static SSLContext getSSLContext() {
		if (sc == null) {
			// Used to accept all certificates
			TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
				public java.security.cert.X509Certificate[] getAcceptedIssuers() {
					return null;
				}

				public void checkClientTrusted(
						java.security.cert.X509Certificate[] certs,
						String authType) {
				}

				public void checkServerTrusted(
						java.security.cert.X509Certificate[] certs,
						String authType) {
				}
			} };

			try {
				sc = SSLContext.getInstance("SSL");
				sc.init(null, trustAllCerts, new java.security.SecureRandom());
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
		return sc;
	}
}
