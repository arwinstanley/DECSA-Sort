import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CSMain {
	public static PrintWriter readerW(String fNme) {
		File scannable = new File( fNme );
		PrintWriter input = null;
		try {
			input = new PrintWriter(scannable);
		} catch (FileNotFoundException ex) {
			System.out.println("Cant open file: " + fNme);
			return null;
		}
		return input;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
