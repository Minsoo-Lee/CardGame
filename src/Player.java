public class Player {

    public static final int CARD_NUM = 5;

    private String nickname;
    private Card[] cards;
    private int win;
    private int money;
    private Rank rank;

    public Player(String nickname) {
        this.nickname = nickname;
        cards = new Card[CARD_NUM];
        win = 0;
        money = 10000;
        rank = new Rank();
    }

    public void getCard(int index, Card card) {
        cards[index] = card;
    }

    public Card[] getCards() {
        return cards;
    }

    public void setRank() {
        rank.getGrade(this.cards);
    }

    public Rank getRank() {
        return rank;
    }

    public void clearCards() {
        for (int i = 0; i < CARD_NUM; i++) {
            cards[i] = null;
        }
    }

    public void showCards() {
        for (int i = 0; i < CARD_NUM; i++) {
            System.out.println(cards[i]);
        }
    }
}
