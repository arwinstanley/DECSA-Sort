//Get rid of all literal constants :(
public class Deck {

   private Card [] cards = new Card[numSuits*numCardsPerSuit];
   private int topCard;
   private static int numSuits = 4;
   private static int numCardsPerSuit = 13;
   

  public Deck() {
	  for (int i = 0; i<numSuits; i++) {
		  for(int j = 1; j<=numCardsPerSuit;j++) {
			  cards[j*(i+1)] = new Card(j,i);
		  }
		
	  }
  }
  public Deck(boolean sort) {
	  if(sort) {
	  for (int i = 0; i<numSuits; i++) {
		  for(int j = 1; j<=numCardsPerSuit;j++) {
			  cards[j*(i+1)] = new Card(j,i);
		  }
	    }
	  }
	  else {
		  for (int i = 0; i<numSuits; i++) {
			  for(int j = 1; j<=numCardsPerSuit;j++) {
				  int x = 0;
				 do {
					x = (int)(Math.random()*52+1);
				 } while(cards[x]== null);
				  cards[x] = new Card(j,i);
		    }
		  }
	  }
  }
  public void shuffle() {
	  cards = (new Deck(false)).getCards();
  }
  public static void setNumSuits(int n) {
	  numSuits = n;
  }
  public static void setNumCardsPerSuit(int n) {
	  numCardsPerSuit = n;
  }
  public static int getNumSuits() {
	  return numSuits;
  }
  public static int getNumCardsPerSuit() {
	  return numCardsPerSuit;
  }
  public Card[] getCards() {
	  return cards;
  }
  public String toString() {
	  String out = "";
	  for (int i = 0; i < numCardsPerSuit; i++) {
		  for(int j =0; j < numSuits; j++) {
			  out += "" + cards[(i+1)*(j+1)] + "\t";
		  }
		  out += "\n" ;
	  }
	  return out;
  }
  public boolean equals(Deck other) {
	  if(cards.length != other.getCards().length)
		  return false;
	  for (int i = 0; i<cards.length;i++) {
		  if(!(cards[i].matches(other.getCards()[i]))){
			  return false;
		  }
	  }
	  return true;
  }
  