import java.util.*;

public class StockExchange
{
   private Map<String, Stock> map;
   
   public StockExchange()
   {
      map = new HashMap<String, Stock>();
   }
   
   public String getQuote(String symbol)
   {
      Stock temp = map.get(symbol);
      return temp.getQuote();
   }
   
   public void listStock(String symbol, String name, double price)
   {
      Stock adding = new Stock(symbol, name, price);
      map.put(symbol, adding);
   }
   
   public void placeOrder(TradeOrder order)
   {
      String temp = order.getSymbol();
      Stock stock = map.get(temp);
      
      if(temp != null)
         stock.placeOrder(order);
      else
         order.getTrader().receiveMessage("Invalid symbol");
   }
   
}
