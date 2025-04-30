import data.Grade;

public class Player {

    public static final int CARD_NUM = 5;

    private String nickname;
    private Card[] cards;
    private int win;
    private int money;
    private int grade;

    public Player(String nickname) {
        this.nickname = nickname;
        cards = new Card[CARD_NUM];
        win = 0;
        money = 10000;
    }

    public void getCard(int index, Card card) {
        cards[index] = card;
    }

    public Card[] getCards() {
        return cards;
    }

    public void clearCards() {
        for (int i = 0; i < CARD_NUM; i++) {
            cards[i] = null;
        }
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }

    public void showCards() {
        for (int i = 0; i < CARD_NUM; i++) {
            System.out.println(cards[i]);
        }
    }
}
