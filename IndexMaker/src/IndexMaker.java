/**
 * @author Franceska
 *
 */

import java.util.*;
import java.io.*;
import javax.swing.*;

public class IndexMaker {

	private static File input;
	private static File output;
	/**
	 * @param args[0] input file
	 * @param args[1] output file
	 * 
	 * if args[1] is not given, args[1] = new file named inputfilename + word index
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input = new File(args[0]);
		if(args[1] != null) output = new File(args[1]);
		else output = new File(args[0] + "WordIndex");
	}

}
