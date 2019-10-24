import java.util.*;

public class PriceComparator implements Comparator<TradeOrder>
{
   private boolean ascending;
   
   public PriceComparator()
   {
      ascending = true;
   }
   
   public PriceComparator(boolean a)
   {
      ascending = a;
   }
   
   public int compare(TradeOrder x, TradeOrder y)
   {
      if(x.isMarket() && y.isMarket())
         return 0;
      else if(!x.isMarket() && y.isMarket())
         return 1;
      else if(x.isMarket() && !y.isMarket())
         return -1;
      else
      {
         if(ascending)
            return (int)((x.getPrice() * 100) - (y.getPrice() * 10));
         else
            return (int)((y.getPrice() * 100) - (x.getPrice() * 100));
      }
      
   }
}