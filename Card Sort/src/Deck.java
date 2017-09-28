import java.util.List;
import java.util.ArrayList;

public class Deck {

	private List<Card> cards;
   private List<Card> discards;
	private int size;

	public Deck(String[] ranks, String[] suits, int[] values) {
      for(String s: suits){
       for(int i=0; i<values.length;i++){
         cards.add(new Card(ranks[i], s, values[i]));
         }
         shuffle();
	}
   }

	public boolean isEmpty() {
      if(cards.size() == 0)
      return true;
      return false;
	}

	public int size() {
      return cards.size();
	}

	public void shuffle() {
      	for (int i = cards.size() - 1; i > 0; i--) {
			int howMany = i + 1;
			int start = 0;
			int randPos = (int) (Math.random() * howMany) + start;
			Card temp = cards.get(i);
			cards.set(i, cards.get(randPos));
			cards.set(randPos, temp);
		}
		size = cards.size();
	}

	public Card deal() {

      Card out = cards.get(cards.size()-1);
      cards.remove(cards.size()-1);
      discards.add(out);
      return out ;
      }

	@Override
	public String toString() {
		String rtn = "size = " + size + "\nUndealt cards: \n";

		for (int k = size - 1; k >= 0; k--) {
			rtn = rtn + cards.get(k);
			if (k != 0) {
				rtn = rtn + ", ";
			}
			if ((size - k) % 2 == 0) {
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\nDealt cards: \n";
		for (int k = cards.size() - 1; k >= size; k--) {
			rtn = rtn + cards.get(k);
			if (k != size) {
				rtn = rtn + ", ";
			}
			if ((k - cards.size()) % 2 == 0) {
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\n";
		return rtn;
	}
}
