package card;

public class Player {

    public static final int CARD_NUM = 5;

    private String nickname;
    private final Card[] cards;
    private int win = 0;
    private int lose = 0;
    private int money;
    private Rank rank;

    public Player(String nickname) {
        this.nickname = nickname;
        cards = new Card[CARD_NUM];
        win = 0;
        money = 10000;
        rank = new Rank();
    }

    public void setCard(int index, Card card) {
        cards[index] = card;
    }

    public Card[] getCards() {
        return cards;
    }

    public void setRank() {
        rank.setGrade(this.cards);
    }

    public Rank getRank() {
        return rank;
    }

    public void setWin() {
        this.win++;
    }

    public int getWin() {
        return this.win;
    }

    public void setLose() {
        this.lose++;
    }

    public int getLose() {
        return this.lose;
    }

    public void setMoney() {
        this.money++;
    }

    public int getMoney() {
        return this.money;
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

    public void showRank() {
        System.out.println("Rank = " + this.rank.getGrade() + " / HighCard = " + this.rank.getHighCard());
    }
}
