/*
 * This class is the tester for the assignment Card Sorting
 *  
 * @author WinstanleyA
 * @Date 10/4/17
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CSMain {
	/* 
	 *  returns a PrintWriter to write the out to a text file
	 *  
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
	 * main method to test my classes 
	 * 
	 * @param args is the names of all the files you want to use in this program
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Deck d1 = new Deck(false);
        PrintWriter out = readerW(args[0]);
        System.out.print(d1);

		File file = new File("output.txt");

		try {	
			out = new PrintWriter(file);	
		} catch (FileNotFoundException ex) {}
		  
		Card tComp1 = new Card(0, 2);
		Card tComp2 = new Card(2, 3);
		
		CardComp compy = new CardComp();
		
		out.println("=============Comparator test=============");
		out.println(tComp1);
		out.println("Should be greater than:");
		out.println(tComp2);
		out.println("The results");
		out.println(compy.compare(tComp1, tComp2));
		out.println();
		out.println("key: 1 = 1st greater than 2nd");
		out.println("     0 = they equal");
		out.println("    -1 = 1st less than 2nd");
		
		
		
		
             
		out.close();
        out.close();
        
	}

}
