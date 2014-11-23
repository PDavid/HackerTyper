import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class HackerTyper {

	private String code;

	public HackerTyper() {
		code = getCode();
	}

	public void type() {
		printDelayed(code);
	}

	private String getCode() {

		try {
			code = new String(Files.readAllBytes(Paths.get("./code.txt")));
		} catch (IOException ex) {
			CodeFileDownloader codeFileDownloader = new CodeFileDownloader();
			code = codeFileDownloader.downloadCode();
		}
		return code;
	}

	private void printDelayed(String code) {

		try {
			for (int i = 0; i < code.length(); i++) {
				System.out.print(code.charAt(i));
			
				Thread.sleep(200);
			}
		} catch (InterruptedException ex) {
			throw new RuntimeException(ex);
		}
	}

	public static void main(String[] args) throws Exception {
		HackerTyper hackerTyper = new HackerTyper();
		hackerTyper.type();
	}
}
