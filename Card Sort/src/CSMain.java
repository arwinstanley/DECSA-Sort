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
		//Card fh = new Card(4, 2);
		//Card ah = new Card(1, 2);
		//System.out.print(fh.compareTo(ah));
		// TODO Auto-generated method stub
        Deck d1 = new Deck();
        PrintWriter out = readerW(args[0]);
      //  System.out.print(d1);
        out.println(d1);
        out.println();
        out.println();
        d1.shuffle();
        out.println(d1);
        out.println();
        out.println();
        out.println();
        out.println();
         d1.mergeSort();
        out.println(d1);
        out.close();
        
	}

}
