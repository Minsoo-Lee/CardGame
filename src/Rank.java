import data.Grade;

public class Rank {
    private Card highCard;
    private int grade;

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
        if (isOnePair(cards)) this.grade = Grade.onepair;
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
