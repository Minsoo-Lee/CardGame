import data.Grade;

public class Rank {
    private Card highCard;
    private int grade;

    private boolean isTriple (Card[] cards) {
        for (int i = 0; i < cards.length - 1; i++) {
            if (cards[i].getNumber() == cards[i + 1].getNumber()) {
                this.highCard = cards[i];
                return true;
            }
        }
        return false;
    }

    // 양 쪽 끝에서 포인터를 조여오며 짝 찾기
    // 풀하우스도 같이 판별되긴 하지만, 위에서 이미 풀하우스는 거르고 들어옴
    private boolean isTowPairs(Card[] cards) {
        int p1 = 0, p2 = Player.CARD_NUM - 1;
        int count = 0;

        for (p1 = 1; p1 < Player.CARD_NUM; p1++) {
            if (cards[p1].getNumber() == cards[p1 - 1].getNumber())
                break;
        }
        for (p2 = Player.CARD_NUM - 2; p2 >= 0; p2--) {
            if (cards[p2].getNumber() == cards[p2 + 1].getNumber())
                break;
        }
        return p1 < p2 ? true : false;
    }

    private boolean isOnePair(Card[] cards) {
        for (int i = 0; i < cards.length - 1; i++) {
            if (cards[i].getNumber() == cards[i + 1].getNumber()) {
                this.highCard = cards[i];
                return true;
            }
        }
        return false;
    }

    public void getGrade(Card[] cards) {
        if (isTowPairs(cards)) this.grade = Grade.twopair;
        else if (isOnePair(cards)) this.grade = Grade.onepair;
        else {
            this.highCard = cards[0];
            this.grade = Grade.high;
        }
    }

    @Override
    public String toString() {
        String[] grades = {
                "high",
                "onepair",
                "twopair",
                "triple",
                "straight",
                "flush",
                "fullHouse",
                "fourCards",
                "sFlush"
        };
        return "HighCard = " + this.highCard + "\ngrade = " + grades[this.grade - 1];
    }
}
