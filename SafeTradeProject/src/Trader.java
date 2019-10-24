import java.util.*;

public class Trader implements java.lang.Comparable<Trader>
{
   private Brokerage brokerage;
   private String name;
   private String password;
   private TraderWindow myWindow;
   private Queue<String> messages;
   
   public Trader(Brokerage b, String n, String pswd)
   {
      brokerage = b;
      name = n;
      password = pswd;
      messages = new LinkedList<String>();
   }
   
   public int compareTo(Trader other)
   {
      return name.compareToIgnoreCase(other.getName());
   }
   
   public boolean equals(Object other)
   {
      if(other instanceof Trader)
         return name.equalsIgnoreCase(((Trader)other).getName());
      else
         return false;
   }
   
   public String getName()
   {
      return name;
   }
   
   public String getPassword()
   {
      return password;
   }
   
   public void getQuote(String symbol)
   {
      brokerage.getQuote(symbol, this);
   }
   
   public boolean hasMessages()
   {
      return messages.size() > 0;
   }
   
   public void openWindow()
   {
      myWindow = new TraderWindow(this);
      for(String msg: messages)
         myWindow.showMessage(msg);
      while(messages.size() != 0)
         messages.remove(0);
   }
   
   public void placeOrder(TradeOrder order)
   {
      brokerage.placeOrder(order);
   }
   
   public void quit()
   {
      brokerage.logout(this);
      myWindow = null;
   }
   
   public void receiveMessage(String msg)
   {
      messages.add(msg);
      if(myWindow != null)
      {
         for(String msgInMail : messages)
            myWindow.showMessage(msg);
         while(messages.size() > 0)
            messages.remove(0);
      }
   }
}