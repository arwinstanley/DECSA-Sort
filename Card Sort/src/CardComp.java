
import java.util.Comparator;
public class CardComp implements Comparator<Card>{
   public int  compare(Card c1, Card c2){
      if (c1.rank()<c2.rank())
         return -1;
      if(equals(c1, c2))
         return 0;
      return 1;
   }
   public boolean equals(Object obj1, Object obj2) {
	   if (((Card)obj1).rank()==((Card)obj2).rank()&&((Card)obj1).suit().equals(((Card)obj2).suit())) {
		   return true;
	   }
	   return false;
   }
}