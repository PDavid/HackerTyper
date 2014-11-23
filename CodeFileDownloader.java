import java.net.URL;
import java.net.URLConnection;
import java.net.Proxy;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class CodeFileDownloader {
	private static final String PROXY_HOST = "proxy.adnovum.hu";
	private static final int PROXY_PORT = 3128;

	private static final String URL = "http://hackertyper.com/code.txt";

	public CodeFileDownloader() {

	}

	public String downloadCode() {
		try {
			URL url = new URL(URL);
			Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(PROXY_HOST, PROXY_PORT));
			URLConnection connection = url.openConnection(proxy);
			BufferedReader in = new BufferedReader(new InputStreamReader(
						connection.getInputStream()));
		
			StringBuilder sb = new StringBuilder();
			String inputLine;
		
			while ((inputLine = in.readLine()) != null) {
				sb.append(inputLine).append("\n");
			}
		
			in.close();
		
			return sb.toString();

		} catch (IOException ex) {
			throw new RuntimeException("Exception while tring to download the code file from url: " + URL, ex);
		}
	}
}
