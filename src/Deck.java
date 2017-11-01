import java.util.*;
/**
 * Class to hold values and perform functions like a real deck of cards
 * 
 * @author WinstanleyA
 * @Date 10/4/17
 */
public class Deck {
   private int numSuits = 4;
   private int numCardsPerSuit = 13;
   private Card [] cards = new Card[numSuits*numCardsPerSuit];
   private int topCard = (cards.length)-1 ;
   boolean hand = false;

	/**
	 * Default constructor to make a full sorted deck
	 * 
	 * @param none
	 */
  public Deck() {
	  for (int i = 0; i<numSuits; i++) {
		  for(int j = 0; j < numCardsPerSuit;j++) {
			  cards[(j+(i*numCardsPerSuit))] = new Card(i,j+1);
		  }
	  }
  }
	/**
	 * creates a deck with either sorted or unsorted contents
	 * @param sort is a boolean true if you want a sorted deck false otherwise
	 */
  public Deck(boolean sort) {
       fill(sort);
	   }
	/**
	 * returns a "deck" that represents a hand of cards with limited functionality 
	 * 
	 * @param cph is the cards per hand
	 */
  public Deck(int cph) {
	  if (cph <= 0)
		  return;
	  cards = new Card[cph];
	  hand = true;
	  }
	/**
	 * this method fills an otherwise empty deck either sorted or unsorted based on the parameter
	 *
	 * @param sort is a boolean true if you want a sorted deck false otherwise
	 */
  public void fill(boolean sort) {
	  if (hand)
		  return;
	  if(sort) {
		  for (int i = 0; i<numSuits; i++) {
			  for(int j = 0; j < numCardsPerSuit;j++) {
				  cards[(j+(i*numCardsPerSuit))] = new Card(i,j+1);
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
				  cards[x] = new Card(i,j+1);
			  }
		  }
	  }
  }
	/**
	 * Shuffles all the Cards in cards
	 */
  public void shuffle() {
	  if(cards[0] == null)
		  return;
	  if (hand)
		  return;
	    for ( int i = topCard; i > 0; i-- ) {
            int rand = (int)(Math.random()*(i+1));
            Card temp = cards[i];
            cards[i] = cards[rand];
            cards[rand] = temp;
        }
  }
	/**
	 * returns the field numSuits
	 * 
	 * @return numSuits is the number of Suits field
	 */
  public int getNumSuits() {
	  return numSuits;
  }
	/**
	 * returns the field numCardsPerSuit
	 * 
	 * @return numCardsPerSuit is the number of cards in every suit
	 */
  public int getNumCardsPerSuit() {
	  return numCardsPerSuit;
  }
	/**
	 * returns the field array cards
	 * 
	 * @return cards is the main part of the class and holds all the Cards
	 */
  public Card[] getCards() {
	  return cards;
  }
	/**
	 * returns the field topCard
	 * 
	 * @return topCard is the index of the top card
	 */
  public int getTopCard() {
	  return topCard;
  }
	/**
	 * returns a string representation on the object
	 * 
	 * @return output a String to replace the default String representation of an object
	 */
  public String toString() {
	  if(cards[0] == null)
		  return null;
	  String out = "";
	  if (hand) {
		  for(int i = 0 ; i < topCard; i++ ) {
			  out += "" + cards[i] + "\n";
		  }
		return out;
	  }
	  for (int i = 0; i < numCardsPerSuit; i++) {
		  for(int j =0; j < numSuits; j++) {
			  out += "" + cards[(j*numCardsPerSuit)+i] + "\t";
		  }
		  out += "\n" ;
	  }
	  return out;
  }
	/**
	 * returns a boolean to show whether or not decks match
	 * 
     * @param other is the other Deck you want to compare
	 * @return boolean true if the decks match false otherwise
	 */
  public boolean equals(Deck other) {
	  if(cards[0] == null)
		  return false;
	  if(topCard != other.getTopCard())
		  return false;
	  for (int i = 0; i<= topCard;i++) {
		  if(!(cards[i].equals(other.getCards()[i]))){
			  return false;
		  }
	  }
	  return true;
  }
	/**
	 * Deals cards out to hands with the right number of cards in each hand
	 * 
     * @param hands is the number of hands to deal
     * @param cph is the cards per hand
	 * @return out an array of decks all containing the same number of Cards
	 */
  public Deck[] deal(int hands, int cph) {
	  if(cards[0] == null)
		  return null;
	  if (hand)
		  return null;
	  if(hands <= 0 || cph <= 0)
		  return null;
	  Deck[] out = new Deck[hands];
	  if(hands*cph>topCard+1)
		  return null;
	  for(int i = 0; i < hands; i ++)
		  out[i] = new Deck(cph);
		  
	  for(int i= 0; i < cph; i++) {
		  for( int j = 0; j < hands; j++) {
			  out[j].getCards()[i] = cards[topCard];
			  cards[topCard] = null;
			  topCard--;
			  if(topCard<0);
			  return null;		  
		  }
	  }
	  return out;
  }
	/**
	 * returns a card randomly picked from the deck
	 * 
	 * @return out a Card that was randomly chosen and removed from the Deck
	 */
  public Card pick() {
	  if(cards[0] == null)
		  return null;
	  int x = 0;
	  Card out = null;
	  x = (int)(Math.random()*(topCard));
	  cards[x]= null;
	  for(int i = x; i<topCard-1; i++) {
		  cards[i] = cards[i+1];
		  cards[i+1]= null;
	  }
	  return out;
  }
	/**
	 * Sorts the deck based on the selection sort algorithm
	 */
  public void selectSort(){
	  if(cards[0] == null)
		  return;
	  if (hand)
		  return;
      
      for (int i = 0; i < topCard ; i++) {
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
	/**
	 * merges the two sides of the mergeSort
	 * 
     * @param arr is the array of Cards
     * @param l is the left index
     * @param m is the middle index
     * @param r is the right index
     * 
	 * All the comments inside this code I copied from stack overflow to help give me a
	 * better idea of what was happening when I threw an error
	 */
  private void merge(Card arr[], int l, int m, int r) {
      // Find sizes of two subarrays to be merged
      int n1 = m - l + 1;
      int n2 = r - m;
      /* Create temp arrays */
      ArrayList<Card> L = new ArrayList<Card>(n1);
      ArrayList<Card> R = new ArrayList<Card>(n2);
      /*Copy data to temp arrays*/
      for (int i=0; i<n1; ++i)
          L.add(i, arr[l + i] );
      for (int j=0; j<n2; ++j)
          R.add(j, arr[m + 1+ j]);
      /* Merge the temp arrays */
      // Initial indexes of first and second subarrays
      int i = 0, j = 0;
      // Initial index of merged subarry array
      int k = l;
      while (i < n1 && j < n2){
          if (L.get(i).compareTo(R.get(j)) != 1) {
              arr[k] = L.get(i);
              i++;
          }
          else {
              arr[k] = R.get(j);
              j++;
          }
          k++;
      }
      /* Copy remaining elements of L[] if any */
      while (i < n1) {
          arr[k] = L.get(i);
          i++;
          k++;
      }
      /* Copy remaining elements of R[] if any */
      while (j < n2){
          arr[k] = R.get(j);
          j++;
          k++;
      }
  }
	/**
	 * recursively sorts deck using the mergeSort algorithm
	 * 
     * @param arr is the array of Cards
     * @param l is the left index
     * @param r is the right index
     * 
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
  /**
   * 
   * I want it to look better from the main so I made the other methods private
   * and this one without parameters and public, for purely aesthetic reasons
   * 
   */
  public void mergeSort() {
	  if(cards[0] == null)
		  return;
	  if (hand)
		  return;
	  mergeSort(cards, 0, topCard);
  }
}