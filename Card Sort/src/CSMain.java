/*
 * @author WinstanleyA
 * @Date 10/4/17
 * This class is the tester for the assingment
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CSMain {
	/* 
	 * @author WinstanleyA
	 * @Date 10/4/17
	 * @param fNme the name of the file your writing to
	 * @return input a PrintWriter which will be able to write to the file given in fNme
	 */
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
	/* 
	 * @author WinstanleyA
	 * @Date 10/4/17
	 * @param args is the names of all the files you want to use in this program
	 * just showing all of my methods working
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Deck d1 = new Deck(false);
        PrintWriter out = readerW(args[0]);
        System.out.print(d1);
        out.close();
        
	}

}
