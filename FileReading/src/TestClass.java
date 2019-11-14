import java.util.*;
import java.io.*;
import javax.swing.*;
/**
 * @author Franceska
 *
 */
public class TestClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File test1 = new File(args[0]);
		File test2 = new File(args[2]);
		File invalidTest = null;
		File output = null;
		
		for(String x: args)
			if(x.equals("output.txt"))
				output = new File(x);
		
		//tests if given enough arguments
		bracesBalanced(invalidTest);
		fileIdentical(invalidTest, test1);
		

		//tests if CantOpenFile works
		
		//Tests Empty Files
		
		//Tests if prints Blank lines in output
		
		//Tests if Braces are Balanced
	}

}
