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
        if (isOnePair(cards)) this.grade = 2;
        else {
            this.highCard = cards[0];
            this.grade = 1;
        }
    }

    @Override
    public String toString() {
        return "HighCard = " + this.highCard + "\ngrade = " + this.grade;
    }
}
