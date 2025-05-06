package sort;

import card.Card;

import java.util.Comparator;

public class SortByKind implements Comparator<Card> {

    @Override
    public int compare(Card c1, Card c2) {
        if (c1.getKind() == c2.getKind())
            return c2.getNumber() - c1.getNumber();
        else return c2.getKind() - c1.getKind();
    }
}
