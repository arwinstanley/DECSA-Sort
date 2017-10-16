//
//Get rid of all literal constants :(
/*
 * @author WinstanleyA
 * @Date 10/4/17
 * This class is the real deal, the biggest fish, the main event, the coupe de gras
 */
public class Deck {
   private int numSuits = 4;
   private int numCardsPerSuit = 13;
   private Card [] cards = new Card[numSuits*numCardsPerSuit];
   private int topCard = (cards.length)-1 ;
   boolean hand = false;

	/*
	 * @author WinstanleyA
     * @Date 10/4/17
	 * @param none
	 * just the plain old default constructor
	 */
  public Deck() {
	  for (int i = 0; i<numSuits; i++) {
		  for(int j = 0; j < numCardsPerSuit;j++) {
			  cards[(j+(i*numCardsPerSuit))] = new Card(j+1,i);
		  }
	  }
  }
	/*
	 * @author WinstanleyA
     * @Date 10/4/17
	 * @param sort is a boolean true if you want a sorted deck false otherwise
	 */
  public Deck(boolean sort) {
       fill(sort);
	   }
	/*
	 * @author WinstanleyA
     * @Date 10/4/17
	 * @param cph is the cards per hand
	 * ||||||||UPDATE||||||||
	 * @Date 10/5/17
	 * This is the way I was going to get around the error I throw when I deal out new hands
	 * I didn't remember to write it but at least I was thinking ahead :/
	 */
  public Deck(int cph) {
	  cards = new Card[cph];
	  hand = true;
	  }
	/*
	 * @author WinstanleyA
     * @Date 10/4/17
	 * @param sort is a boolean true if you want a sorted deck false otherwise
	 * this method just fills an otherwise empty deck. not really sure what I was going to
	 * use this one for
	 */
  public void fill(boolean sort) {
	  if(sort) {
		  for (int i = 0; i<numSuits; i++) {
			  for(int j = 0; j < numCardsPerSuit;j++) {
				  cards[(j+(i*numCardsPerSuit))] = new Card(j+1,i);
			  }
		  }
	  }
	  else {
		  for (int i = 0; i<numSuits; i++) {
			  for(int j = 0; j < numCardsPerSuit;j++) {
				  int x = 0;
					 do {
							x = (int)(Math.random()*(numSuits*numCardsPerSuit));
						 } while(cards[x]== null);
				  cards[x] = new Card(j+1,i);
			  }
		  }
	  }
  }
	/*
	 * @author WinstanleyA
     * @Date 10/4/17
	 * Shuffles all the Cards in cards
	 */
  public void shuffle() {
	    for ( int i = topCard; i > 0; i-- ) {
            int rand = (int)(Math.random()*(i+1));
            Card temp = cards[i];
            cards[i] = cards[rand];
            cards[rand] = temp;
        }
  }
	/*
	 * @author WinstanleyA
     * @Date 10/4/17
	 * @return numSuits is the number of Suits field
	 */
  public int getNumSuits() {
	  return numSuits;
  }
	/*
	 * @author WinstanleyA
     * @Date 10/4/17
	 * @return numCardsPerSuit is the number of cards in every suit
	 */
  public int getNumCardsPerSuit() {
	  return numCardsPerSuit;
  }
	/*
	 * @author WinstanleyA
     * @Date 10/4/17
	 * @return cards is the main part of the class and holds all the Cards
	 */
  public Card[] getCards() {
	  return cards;
  }
	/*
	 * @author WinstanleyA
     * @Date 10/4/17
	 * @return topCard is the index of the top card
	 */
  public int getTopCard() {
	  return topCard;
  }
	/*
	 * @author WinstanleyA
     * @Date 10/4/17
	 * @return output a String to replace the default String representation of an object
	 */
  public String toString() {
	  String out = "";
	  for (int i = 0; i < numCardsPerSuit; i++) {
		  for(int j =0; j < numSuits; j++) {
			  out += "" + cards[(j*numCardsPerSuit)+i] + "\t";
		  }
		  out += "\n" ;
	  }
	  return out;
  }
	/*
	 * @author WinstanleyA
     * @Date 10/4/17
     * @param other is the other Deck you want to compare
	 * @return boolean true if the decks match false otherwise
	 */
  public boolean equals(Deck other) {
	  if(topCard != other.getTopCard())
		  return false;
	  for (int i = 0; i<= topCard;i++) {
		  if(!(cards[i].matches(other.getCards()[i]))){
			  return false;
		  }
	  }
	  return true;
  }
	/*
	 * @author WinstanleyA
     * @Date 10/4/17
     * @param hands is the number of hands to deal
     * @param cph is the cards per hand
	 * @return out an array of decks all containing the same number of Cards
	 */
  public Deck[] deal(int hands, int cph) {
	  Deck[] out = new Deck[hands];
	  if(hands*cph>topCard+1)
		  return null;
	  for(int i= 0; i < hands; i++) {
		  Deck holder = new Deck(cph);
		  for(int j = 0;j < cph;j++) {
		  holder.getCards()[j] = cards[topCard];
		  cards[topCard] = null;
		  topCard--;
		  }
		  out[i] = holder;
	  }
	  return out;
  }
	/*
	 * @author WinstanleyA
     * @Date 10/4/17
	 * @return out a Card that was randomly chosen and removed from the Deck
	 */
  public Card pick() {
	  int x = 0;
	  Card out = null;
	  do {
		  x = (int)(Math.random()*(topCard));
	     out = cards[x];
	  }while(out == null);
	  cards[x]= null;
	  for(int i = x; i<topCard-1; i++) {
		  cards[i] = cards[i+1];
		  cards[i+1]= null;
	  }
	  return out;
  }
	/*
	 * @author WinstanleyA
	 * Sorts the deck based on the selection sort algorithm
	 */
  public void selectSort(){
      
      for (int i = 0; i < topCardb ; i++) {
          int index = i;
          for (int j = i + 1; j < topCard; j++) {
              if (cards[j].compareTo(cards[index]) == -1) 
                  index = j;
          }
          Card lowCard = cards[index];  
          cards[index] = cards[i];
          cards[i] = lowCard;
      }
  }
	/*
	 * @author WinstanleyA
     * @Date 10/4/17
     * @param arr is the array of Cards
     * @param l is the left index
     * @param m is the middle index
     * @param r is the right index
	 * All the comments inside this code I copied from stack overflow to help give me a
	 * better idea of what was happening when I threw an error
	 */
  private void merge(Card arr[], int l, int m, int r) {
      // Find sizes of two subarrays to be merged
      int n1 = m - l + 1;
      int n2 = r - m;
      /* Create temp arrays */
      Card L[] = new Card [n1];
      Card R[] = new Card [n2];
      /*Copy data to temp arrays*/
      for (int i=0; i<n1; ++i)
          L[i] = arr[l + i];
      for (int j=0; j<n2; ++j)
          R[j] = arr[m + 1+ j];
      /* Merge the temp arrays */
      // Initial indexes of first and second subarrays
      int i = 0, j = 0;
      // Initial index of merged subarry array
      int k = l;
      while (i < n1 && j < n2){
          if (L[i].compareTo(R[j]) != 1) {
              arr[k] = L[i];
              i++;
          }
          else {
              arr[k] = R[j];
              j++;
          }
          k++;
      }
      /* Copy remaining elements of L[] if any */
      while (i < n1) {
          arr[k] = L[i];
          i++;
          k++;
      }
      /* Copy remaining elements of R[] if any */
      while (j < n2){
          arr[k] = R[j];
          j++;
          k++;
      }
  }
	/*
	 * @author WinstanleyA
     * @Date 10/4/17
     * @param arr is the array of Cards
     * @param l is the left index
     * @param r is the right index
	 * All the comments inside this code I copied from stack overflow to help give me a
	 * better idea of what was happening when I threw an error
	 */
  private void mergeSort(Card arr[], int l, int r){
      if (l < r){
          // Find the middle point
          int m = (l+r)/2;
          // Sort first and second halves
          mergeSort(arr, l, m);
          mergeSort(arr , m+1, r);
          // Merge the sorted halves
          merge(arr, l, m, r);
      }
  }	
  /*
   * @author WinstanleyA
   * @Date 10/4/17
   * I want it to look better from the main so I made the other methods private
   * and this one without parameters and public
   */
  public void mergeSort() {
	  mergeSort(cards, 0, topCard);
  }
}