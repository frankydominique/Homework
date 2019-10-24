public class TradeOrder
{
   private Trader trader;
   private String symbol;
   private boolean buyOrder;
   private boolean marketOrder;
   private int numShares;
   private double price;
   
   public TradeOrder(Trader t, String s, boolean b, boolean m, int n, double p)
   {
      trader = t;
      symbol = s;
      buyOrder = b;
      marketOrder = m;
      numShares = n;
      price = p;
   }
   
   public double getPrice()
   {
      return price;
   }
   
   public int getShares()
   {
      return numShares;
   }
   
   public String getSymbol()
   {
      return symbol;
   }
   
   public Trader getTrader()
   {
      return trader;
   }
   
   public boolean isBuy()
   {
      return buyOrder;
   }
   
   public boolean isSell()
   {
      return !buyOrder;
   }
   
   public boolean isMarket()
   {
      return marketOrder;
   }
   
   public boolean isLimit()
   {
      return !marketOrder;
   }
   
   public void subtractShares(int shares)
   {
      numShares -= shares;
   }
}
