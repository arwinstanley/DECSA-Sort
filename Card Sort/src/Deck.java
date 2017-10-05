//
//Get rid of all literal constants :(
public class Deck {
   private int numSuits = 4;
   private int numCardsPerSuit = 13;
   private Card [] cards = new Card[numSuits*numCardsPerSuit];
   private int topCard = (numSuits*numCardsPerSuit)-1 ;


  public Deck() {
	  for (int i = 0; i<numSuits; i++) {
		  for(int j = 0; j < numCardsPerSuit;j++) {
			  cards[(j+(i*numCardsPerSuit))] = new Card(j+1,i);
		  }
	  }
  }
  public Deck(boolean sort) {
	  if(sort) {
		  for (int i = 0; i<numSuits; i++) {
			  for(int j = 0; j < numCardsPerSuit;j++) {
				  cards[(j+(i*numCardsPerSuit))] = new Card(j+1,i);
			  }
		  }
	  }
	  else if (sort == false)
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
  public Deck(int cph) {

	  }
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
  public void shuffle() {
	    for ( int i = cards.length-1; i > 0; i-- ) {
            int rand = (int)(Math.random()*(i+1));
            Card temp = cards[i];
            cards[i] = cards[rand];
            cards[rand] = temp;
        }
  }
  public int getNumSuits() {
	  return numSuits;
  }
  public int getNumCardsPerSuit() {
	  return numCardsPerSuit;
  }
  public Card[] getCards() {
	  return cards;
  }
  public int getTopCard() {
	  return topCard;
  }
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
  public Deck[] deal(int hands, int cph) {
	  Deck[] out = new Deck[hands];
	  if(hands*cph>cards.length)
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
  public Card pick() {
	  int x = 0;
	  Card out = null;
	  do {
		  x = (int)(Math.random()*(cards.length)+1);
	     out = cards[x];
	  }while(out == null);
	  cards[x]= null;
	  for(int i = x; i<cards.length-1; i++) {
		  cards[i] = cards[i+1];
		  cards[i+1]= null;
	  }
	  return out;
  }
  public void selectSort(){
      
      for (int i = 0; i < cards.length - 1; i++) {
          int index = i;
          for (int j = i + 1; j < cards.length; j++) {
              if (cards[j].compareTo(cards[index]) == -1) 
                  index = j;
          }
          Card lowCard = cards[index];  
          cards[index] = cards[i];
          cards[i] = lowCard;
      }
  }

  private void merge(Card arr[], int l, int m, int r)
  {
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
      while (i < n1 && j < n2)
      {
          if (L[i].compareTo(R[j]) != 1)
          {
              arr[k] = L[i];
              i++;
          }
          else
          {
              arr[k] = R[j];
              j++;
          }
          k++;
      }

      /* Copy remaining elements of L[] if any */
      while (i < n1)
      {
          arr[k] = L[i];
          i++;
          k++;
      }

      /* Copy remaining elements of R[] if any */
      while (j < n2)
      {
          arr[k] = R[j];
          j++;
          k++;
      }
  }

  private void mergeSort(Card arr[], int l, int r)
  {
      if (l < r)
      {
          // Find the middle point
          int m = (l+r)/2;

          // Sort first and second halves
          mergeSort(arr, l, m);
          mergeSort(arr , m+1, r);

          // Merge the sorted halves
          merge(arr, l, m, r);
      }
  }
  //I want it to look better from the main
  public void mergeSort() {
	  mergeSort(cards, 0, cards.length-1);
  }
}