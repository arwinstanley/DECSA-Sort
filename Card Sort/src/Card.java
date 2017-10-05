
public class Card implements Comparable<Card> {
	
	private String suit;
	private int rank;
	
    public Card() {
    	suit = "spades";
    	rank = 1;
    }
	public Card(int cardRank, String cardSuit) {
		rank = cardRank;
		suit = cardSuit;
	}
    public Card(int cardRank, int cardSuit) {
    	   String s ="";
    	switch(cardSuit){
    		case 0: s = "clubs";
    				break;
    		case 1: s = "diamonds";
					break;
    		case 2: s = "hearts";
					break;
    		case 3: s = "spades";
					break;
			default: s ="invalid suit pick a number between 0 and 3";
					break;
    	}	
	    	suit = s;
	    	rank = cardRank;
	}
    public Card(String cardRank, String cardSuit) {
	    	suit = cardSuit;
	    	rank = Integer.valueOf(cardRank);
	    	
	}
	public Card(String cardRank, int cardSuit) {
	 	   String s ="";
	    	switch(cardSuit){
	    		case 0: s = "clubs";
	    				break;
	    		case 1: s = "diamonds";
						break;
	    		case 2: s = "hearts";
						break;
	    		case 3: s = "spades";
						break;
				default: s ="invalid suit pick a number between 0 and 3";
						break;
	    	}	
		    	suit = s;
		    	rank = Integer.valueOf(cardRank);
	}
	public String suit() {
		return suit;
	}
	public int rank() {
		return rank;
	}
	public String getRankStr() {
		String output = "";
		switch(rank){
		case 1: output = "Ace";
				break;
		case 2: output = "Two";
				break;
		case 3: output = "Three";
				break;
		case 4: output = "Four";
				break;
		case 5: output = "Five";
				break;
		case 6: output = "Six";
				break;
		case 7: output = "Seven";
				break;
		case 8: output = "Eight";
				break;
		case 9: output = "Nine";
				break;
		case 10: output = "Ten";
				break;
		case 11: output = "Jack";
				break;
		case 12: output = "Queen";
				break;
		case 13: output = "King";
				break;
		default: output = "IDK";
				break;
		}
		return output;
	}
	public int getSuitInt() {
		int s = 0;
		switch(suit){
		case "clubs": s = 0;
				break;
		case "diamonds": s = 1;
				break;
		case "hearts": s = 2;
				break;
		case "spades": s = 3;
				break;
		default: s =-20;
				break;
	}	
		return s;
	}
	public boolean matches(Card otherCard) {
		return otherCard.suit().equals(this.suit())
			&& otherCard.rank()==(this.rank());
	}
	@Override 
	public String toString() {
		String output = "";
	 	switch(rank){
		case 1: output = "Ace";
				break;
		case 2: output = "Two";
				break;
		case 3: output = "Three";
				break;
		case 4: output = "Four";
				break;
		case 5: output = "Five";
				break;
		case 6: output = "Six";
				break;
		case 7: output = "Seven";
				break;
		case 8: output = "Eight";
				break;
		case 9: output = "Nine";
				break;
		case 10: output = "Ten";
				break;
		case 11: output = "Jack";
				break;
		case 12: output = "Queen";
				break;
		case 13: output = "King";
				break;
		default: output = "IDK";
				break;
	}	
		return output + " of " + suit;
	}
	@Override
	public int compareTo(Card other) {
		  if (getSuitInt()>other.getSuitInt())
		         return 1;
		      if(getSuitInt()==other.getSuitInt()) {
				  if (rank>other.rank())
				         return 1;
				      if(this.matches(other))
				         return 0;
				      return -1;
		      }
		      return -1;
		}

}