public class Card {
  int r;
  int s;
  
  Card (int rank, int suit) {
    r = rank;
    s = suit;
  }
  
  public int getRank() {
    return r;
  }
  
  public int getSuit() {
    return s;
  }
  
  public String toString() {
    return r + " of " + s;
  }
  
  }