import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class HackerTyper {

	private String code;

	public HackerTyper() {
		code = getCode();
	}

	private String getCode() {
		try {
			code = new String(Files.readAllBytes(Paths.get("./code.txt")));
			return code;
		} catch (IOException ex) {
			System.err.println("Could not read code.txt.");
			throw new RuntimeException(ex);
		}
	}

	public void type() {
		printDelayed(code);
	}

	private void printDelayed(String code) {
		try {
			for (int i = 0; i < code.length(); i++) {
				System.out.print(code.charAt(i));
			
				Thread.sleep(200);
			}
		} catch (InterruptedException ex) {
			System.err.println("Error while tried to print delayed.");
			throw new RuntimeException(ex);
		}
	}

	public static void main(String[] args) throws Exception {
		HackerTyper hackerTyper = new HackerTyper();
		hackerTyper.type();
	}
}
