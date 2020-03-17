/**
 * @author Franceska
 *
 */
import java.lang.reflect.Field;
import java.security.Key;
import java.util.*;
import java.io.*;

public class TicTacToeMyHashMap {

	/**
	 * fields
	 * hashMap - the hashmap storing all the keyValue pairs
	 * thisSize - number of keyValue pairs in hashmap
	 */
	HashMap<TTTString, Boolean> hashMap;
	int thisSize;

	/**
	 * constructor: constructs a new TicTacToeMyHashMap
	 */
   TicTacToeMyHashMap() {
	  hashMap = new HashMap<TTTString, Boolean>();
   }

   /**
    * hashes the given string and places the boolean representing whether its a win or not in the hashmap
    * @param s tictactoe string
    * @param b the boolean that says whether this string is a win or not according to the AllCombinations.txt text file
    */
   public void put(TTTString s, boolean b)
   {
	   hashMap.put(s, b);
   }
   
   /**
    * gets the value of this string key s
    * @param s the key tictactoe string
    * @return whether this is a winning string or not
    */
   public boolean get(TTTString s)
   {
	   return hashMap.get(s);
   }

   //capacity is how much space is left
   /**
    * returns how large the hashmap table is
    * @return the length fo the hashmap table
    * @throws NoSuchFieldException
    * @throws IllegalAccessException
    */
   private int capacity() throws NoSuchFieldException, IllegalAccessException {
      Field tableField = HashMap.class.getDeclaredField("table"); //this gets the field table, i replaced table with hashmap, was i supposed to do so?
      tableField.setAccessible(true); //this makes the field table accessible
      Object[] table = (Object[]) tableField.get(hashMap);
      return table == null ? 0 : table.length;   
   }
   
   /**
    * evaluates the size and load factor of this hashmap
    * @return the string representation of this hashmap's loadfactor and size
    * @throws NoSuchFieldException
    * @throws IllegalAccessException
    */
   private String evaluate() throws NoSuchFieldException, IllegalAccessException {
	   int size;
	   float loadFactor;
	   
	   Field sizeField = HashMap.class.getDeclaredField("size"); 
	   sizeField.setAccessible(true); 
	   size = (Integer)sizeField.getInt(hashMap);
	   thisSize = size;
	   
	   Field loadFactorField = HashMap.class.getDeclaredField("loadFactor");
	   loadFactorField.setAccessible(true);
	   
	   loadFactor = loadFactorField.getFloat(hashMap);
	   String formatLF = String.format("%.2f", loadFactor);
	   
	   return "Size: " + size + ", Load Factor: " + formatLF;
   }
   
   /**
    * evaluates the number of entries in each quarter, in each tenth, and counts the length of the chains
    * @return string including the number of entries and counts
    * @throws NoSuchFieldException
    * @throws IllegalAccessException
    */
   public String evaluate2() throws NoSuchFieldException, IllegalAccessException
   {
	   int pos = 0;
	   int[] numInEachQuarter = new int[4];
	   int[] numInEachTenth = new int[10];
	   int numChains = 0;
	   ArrayList<Integer> chainLengths = new ArrayList<Integer>();
	   int maxChainLength = 0;
	   
	   Field tableField = HashMap.class.getDeclaredField("table"); //this gets the field table, i replaced table with hashmap, was i supposed to do so?
	   tableField.setAccessible(true); //this makes the field table accessible
	   Object[] table = (Object[]) tableField.get(hashMap);
	   
	   for(Object obj: table)
	   {
		   
		   if(obj != null)
		   {
			   int chainLength = 0;
			   Field nextField = obj.getClass().getDeclaredField("next");
			   nextField.setAccessible(true);
			   Object next = (Object) nextField.get(obj);
			   boolean first = true;
			   
			   while(next != null)
			   {
				   
				   if(first) {numChains++; first = false;}
				   chainLength++;
				   Field nextField2 = next.getClass().getDeclaredField("next");
				   nextField2.setAccessible(true);
				   next = (Object) nextField2.get(next);
			   }
			   if(chainLength > 0)
				   chainLengths.add(chainLength);
			   if(chainLength > maxChainLength)
				   maxChainLength = chainLength;
			   
			   numInEachQuarter[pos / 456]++;
			   numInEachTenth[pos / 183]++;
			   pos++;
		   }
	   }
	   
	   String inEachQuarter = "";
	   for(int x: numInEachQuarter)
		   inEachQuarter += x + ", ";
	   
	   String inEachTenth = "";
	   for(int x: numInEachTenth)
		   inEachTenth += x + ", ";
	   
	   
	   int sum = 0;
	   for(int x: chainLengths)
		   sum += x;
	   
	   String avgChainLength = "";
	   if(numChains > 0)
		   avgChainLength = String.format("%.2f",((double)sum / numChains));
	   
	   return "Entries in Each Quarter: " + inEachQuarter + "\nIn Each Tenth: " + inEachTenth +
			   "\nAverage Chain Length: " + avgChainLength + ", Max Chain Length: " + maxChainLength;
   }
   
   public static void main(String[] args) throws java.io.FileNotFoundException,
                                              NoSuchFieldException, 
                                              IllegalAccessException {

      TicTacToeMyHashMap m = new TicTacToeMyHashMap();

      Scanner scanner = new Scanner(new File("AllCombinations.txt"));
      TTTString tictactoeString;
      String temp;
      boolean tttBoolean;
      
      while(scanner.hasNextLine())
      {
    	  temp = scanner.nextLine();
    	  tictactoeString = new TTTString(temp.substring(0, temp.lastIndexOf(' ')));
    	  tttBoolean = Boolean.parseBoolean(temp.substring(temp.lastIndexOf(' ') + 1));
    	  m.put(tictactoeString, tttBoolean);
    	  
      }
      scanner.close();
  
      System.out.println("Capacity: " + m.capacity());
  
      System.out.println(m.evaluate());
      System.out.println(m.evaluate2());
   }

}

