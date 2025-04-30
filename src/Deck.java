import java.util.ArrayList;
import java.util.List;

public class Deck {
    final static int CARD_NUM = 52;
//    Card cards[] = new Card[CARD_NUM];

    // 중복 방지를 위해 ArrayList로 셋업
    private ArrayList<Card> cards = new ArrayList<>();

    Deck() {
        int i = 0;

        for(int k = 0; k < Card.KIND_MAX; k++)
            for(int n = 0; n < Card.NUM_MAX; n++)
                cards.add(new Card(k, n));
    }

    public void init() {
        cards.clear();
        for(int k = 0; k < Card.KIND_MAX; k++)
            for(int n = 0; n < Card.NUM_MAX; n++)
                cards.add(new Card(k, n));
    }

    // 나눠주고 나면 Deck에서 제거 - 중복 딜링 방지
    Card pick(int index) {
        Card card = cards.get(index);
        cards.remove(index);
        return card;
    }

    Card pick() {
        int index = (int) (Math.random() * cards.size());
        return pick(index);
    }

    public void shuffle() {
        for(int i = 0; i < cards.size(); i++) {
            int r = (int)(Math.random() * cards.size());

            Card temp = cards.get(i);
            cards.set(i, cards.get(r));
            cards.set(r, temp);
        }
    }

    public ArrayList<Card> getCards() {
        return this.cards;
    }
}
