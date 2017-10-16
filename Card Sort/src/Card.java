/*
 * @author WinstanleyA
 * @Date 10/4/17
 * This class I made last year in one of our labs and I modified it to work for this assignment
 */
public class Card implements Comparable<Card> {
	
	private String suit;
	private int rank;
	/*
	 * @author WinstanleyA
     * @Date 10/4/17
	 * @param none
	 * just the plain old default constructor
	 */
    public Card() {
    	suit = "spades";
    	rank = 1;
    }
	/*
	 * @author WinstanleyA
     * @Date 10/4/17
	 * @param cardRank the rank in an int
	 * @param cardSuit the suit in a String
	 * Simple constructor for when the user already has the right data types
	 */
	public Card(String cardSuit, int cardRank) {
		rank = cardRank;
		suit = cardSuit;
	}
	/*
	 * @author WinstanleyA
     * @Date 10/4/17
	 * @param cardRank the rank in an int
	 * @param cardSuit the suit in an int
	 * constructor for inputing the suit as an int
	 */
    public Card(int cardSuit, int cardRank) {
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
	/*
	 * @author WinstanleyA
     * @Date 10/4/17
	 * @param cardRank the rank in a String
	 * @param cardSuit the suit in a String
	 * For user inputing the rank as a String
	 */
    public Card(String cardSuit, String cardRank) {
	    	suit = cardSuit;
	    	rank = Integer.valueOf(cardRank);
	    	
	}
	/*
	 * @author WinstanleyA
     * @Date 10/4/17
	 * @param cardRank the rank in a String
	 * @param cardSuit the suit in an int
	 * For the people who want to input the data in the opposite type
	 */
	public Card(int cardSuit, String cardRank) {
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
	/*
	 * @author WinstanleyA
     * @Date 10/4/17
	 * @return suit is the suit field
	 */
	public String suit() {
		return suit;
	}
	/*
	 * @author WinstanleyA
     * @Date 10/4/17
	 * @return rank is the rank field
	 */
	public int rank() {
		return rank;
	}
	/*
	 * @author WinstanleyA
     * @Date 10/4/17
	 * @return output is the rank in a String
	 */
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
	/*
	 * @author WinstanleyA
     * @Date 10/4/17
	 * @return s is the suit as an int
	 */
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
	/*
	 * @author WinstanleyA
     * @Date 10/4/17
     * @param otherCard is the other Card you want to compare
	 * @return boolean true if the cards match false otherwise
	 */
	public boolean matches(Card otherCard) {
		return otherCard.suit().equals(this.suit())
			&& otherCard.rank()==(this.rank());
	}
	/*
	 * @author WinstanleyA
     * @Date 10/4/17
	 * @return output a String to replace the default String representation of an object
	 */
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
	/*
	 * @author WinstanleyA
     * @Date 10/4/17
     * @param other is the Card you want to compare to this one
	 * @return int 1 if this is greater than other 0 if they are equal -1 if this is less than other
	 */
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