import java.util.*;

public class Brokerage implements Login
{
   private StockExchange exchange;
   private Map<String, Trader> registeredTraders;
   private Set<Trader> loggedInTraders;
   
   public Brokerage(StockExchange e)
   {
      exchange = e;
      registeredTraders = new TreeMap<String, Trader>();
      loggedInTraders = new TreeSet<Trader>();
   }
   
   public int addUser(String name, String password)
   {
      if(name.length() < 4 || name.length() > 10)
         return -1;
      else if(password.length() < 2 || password.length() > 10)
         return -2;
      else if(!registeredTraders.containsKey(name))
         return -3;
      else
      {
         Trader adding = new Trader(this, name, password);
         registeredTraders.put(name, adding);
         return 0;
      }
   }
   
   public void getQuote(String symbol, Trader trader)
   {
      trader.receiveMessage(exchange.getQuote(symbol));
   }
   
   public int login(String name, String password)
   {
      Trader given = registeredTraders.get(name);
      if(given == null)
         {return -1;}
      else if(!given.getPassword().equals(password))
         {return -2;}
      else if (loggedInTraders.contains(given))
         {return -3;}
      else
      {
         loggedInTraders.add(given);
         if(!given.hasMessages())
            given.receiveMessage("Welcome to SafeTrade!");
         given.openWindow();
         return 0;
      }
   }
   
   public void logout(Trader trader)
   {
      loggedInTraders.remove(trader);
   }
   
   public void placeOrder(TradeOrder order)
   {
      exchange.placeOrder(order);
   }
}
