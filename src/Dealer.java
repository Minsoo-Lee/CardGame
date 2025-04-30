public class Dealer {
    Deck deck;

    public Dealer() {
        deck = new Deck();
        deck.shuffle();
    }

    public Card dealing() {
        return deck.pick();
    }
}
