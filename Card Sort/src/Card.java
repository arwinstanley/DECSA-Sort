
public class Card {
	
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
	public Card(int cardRank, int cardSuit) {
	    	suit = "spades";
	    	rank = 1;
	}
	public String suit() {
		return suit;
	}
	public int rank() {
		return rank;
	}
	public boolean matches(Card otherCard) {
		return otherCard.suit().equals(this.suit())
			&& otherCard.rank()==(this.rank());
	}
	@Override 
	public String toString() {
		return rank + " of " + suit;
	}
}