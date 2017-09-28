
import java.util.Comparator;
public class CardComp implements Comparator<Card>{
   public int  compare(Card c1, Card c2){
      if (c2.pointValue()>c1.pointValue())
         return 1;
      if(c1.equals(c2))
         return 0;
      return -1;
   }


}