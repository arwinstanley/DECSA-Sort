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
}
