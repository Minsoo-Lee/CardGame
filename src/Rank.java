import data.Grade;

public class Rank {
    private Card highCard;
    private int grade;

    // [1 2 2] [2 1 2] [2 2 1]
    // 양 쪽 끝에서 비교
    private boolean isTowPairs(Card[] cards) {
        int[] pointers = new int[3];
        if (pointers[2] == 4) {
            if (pointers[1] == 2 && (pointers[0] == 0 || pointers[1] == 1)) {
                this.highCard = cards[4];
                return true;
            }
            if (pointers[0] == 1 && pointers[1] == 3) {
                this.highCard = cards[3];
                return true;
            }
        }
        return false;
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

    // 포인터를 3개 써야 할 때는 p3 = 5, p2 < 5
    //      ex. twopair, triple
    // 포인터를 2개 써야 할 때는 p2 = 5
    //      ex. flush, fullhouse
    private void getPoint(int[] cards, int[] pointers, int start, int count) {
        if (count == 3) return ;
        for (int i = start; i < 4; i++) {
            if (cards[i] != cards[i + 1]) {
                pointers[count] = i;
                getPoint(cards, pointers, i + 1, count + 1);
                return ;
            }
        }
        pointers[count] = 5;
        getPoint(cards, pointers, 5, count + 1);
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
