import java.util.*;
import java.text.DecimalFormat;

public class Stock
{
   public static DecimalFormat money = new DecimalFormat("0.00");
   private String symbol;
   private String company;
   private double lowestPrice, highestPrice, originalPrice;
   private int volume;
   private PriorityQueue<TradeOrder> buy;
   private PriorityQueue<TradeOrder> sell;
   
   public Stock(String s, String c, double p)
   {
      symbol = s;
      company = c;
      originalPrice = p;
      lowestPrice = p;
      highestPrice = p;
      volume = 0;
      buy = new PriorityQueue<TradeOrder>(1, new PriceComparator(false));
      sell = new PriorityQueue<TradeOrder>(1, new PriceComparator());
   }
   
   public String getQuote()
   {
      String quote = company + " (" + symbol + ")\n";
    quote += "Price: " + money.format(originalPrice) + "  hi: " + money.format(highestPrice)
                   + "  lo: " + money.format(lowestPrice) + "  vol: " + volume + "\n";

    quote += "Ask: ";

    if (!sell.isEmpty())
    {
      TradeOrder order = sell.peek();
      if (order.isLimit())
        quote += money.format(order.getPrice());
      else
        quote += "market";
      quote += " size: " + order.getShares();
    }
    else
    {
      quote += "none";
    }

    quote += "  Bid: ";

    if (!buy.isEmpty())
    {
      TradeOrder order = buy.peek();
      if (order.isLimit())
        quote += money.format(order.getPrice());
      else
        quote += "market";
      quote += " size: " + order.getShares();
    }
    else
    {
      quote += "none";
    }

    return quote;
   }
   
   public void placeOrder(TradeOrder order)
   {
      String msg = "New order:  ";
    if (order.isSell())
      msg += "Sell ";
    else
      msg += "Buy ";

    msg += symbol + " ";
    if (!"".equals(company))
      msg += " (" + company + ")";
    msg += "\n";

    msg += order.getShares() + " shares";

    if (order.isMarket())
      msg += " at market ";
    else
      msg += " at  " + money.format(order.getPrice());

    Trader trader = order.getTrader();
    trader.receiveMessage(msg);

    if (order.isSell())
      sell.add(order);
    else
      buy.add(order);

    executeOrders();
   }
   
    protected void executeOrders()
  {
    while (!buy.isEmpty() && !sell.isEmpty())
    {
      TradeOrder selling = sell.peek();
      TradeOrder buying = buy.peek();
      if (selling.isLimit() && buying.isLimit() && selling.getPrice() > buying.getPrice())
        break;

      double price;

      if (selling.isMarket() && buying.isMarket())
        price = originalPrice;
      else if (selling.isMarket() && buying.isLimit())
        price = buying.getPrice();
      else if (selling.isLimit() && buying.isMarket())
        price = selling.getPrice();
      else // if (sell.isLimit() && buy.isLimit())
        price = selling.getPrice();

      int shares = Math.min(buying.getShares(), selling.getShares());

      selling.subtractShares(shares);
      buying.subtractShares(shares);

      String msg = shares + " " + symbol + " at " + money.format(price)
        + " amt " + money.format(price * shares);
      buying.getTrader().receiveMessage("You bought: " + msg);
      selling.getTrader().receiveMessage("You sold: " + msg);

      if (buying.getShares() == 0)
        buy.remove();

      if (selling.getShares() == 0)
        sell.remove();

      volume += shares;
      if (price < lowestPrice)
        lowestPrice = price;
      if (price > highestPrice)
        highestPrice = price;
      originalPrice = price;
    }
  }
}