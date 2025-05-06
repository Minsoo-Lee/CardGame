package card;

import data.Grade;
import sort.SortByKind;

import java.util.Arrays;

public class Rank {
    private Card highCard;
    private int grade;

    private boolean isStraightFlush(Card[] cards) {
        return isStraight(cards) && isFlush(cards);
    }

    private boolean isFourCard(Card[] cards) {
        int p1;
        for (p1 = 0; p1 < 2; p1++) {
            int p2;
            for (p2 = p1; p2 < cards.length; p2++) {
                if (cards[p2].getNumber() != cards[p1].getNumber()) break;
            }
            if (p2 - p1 == 3) {
                this.highCard = cards[p1];
                return true;
            }
        }
        return false;
    }

    private boolean isFullHouse(Card[] cards) {
        Card[] cardTmp = cloneCards(cards);

        for (int i = 0; i < cardTmp.length - 3; i++) {
            if (cardTmp[i].getNumber() == cardTmp[i + 1].getNumber()
                    && cardTmp[i + 1].getNumber() == cardTmp[i + 2].getNumber()) {
                if (i == 0) {
                    this.highCard = cardTmp[0];
                }
                cardTmp[i] = null;
                cardTmp[i + 1] = null;
                cardTmp[i + 2] = null;
            } else return false;
        }

        for (int i = 0; i < cardTmp.length - 1; i++) {
            if (cardTmp[i] == null && cardTmp[i + 1] == null) continue;
            if (cardTmp[i].getNumber() == cardTmp[i + 1].getNumber()) {
                if (i == 0) {
                    this.highCard = cardTmp[0];
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isFlush(Card[] cards) {
        Card[] cardTmp = cloneCards(cards);

        for (int i = 0; i < 2; i++) {
            if (cardTmp[i].getKind() == cardTmp[i + 1].getKind()
                    && cardTmp[i + 1].getKind() == cardTmp[i + 2].getKind()
                    && cardTmp[i + 2].getKind() == cardTmp[i + 3].getKind()) {
                this.highCard = cardTmp[i];
                return true;
            }
        }
        return false;
    }

    private boolean isStraight (Card[] cards) {
        // A ~ 2로 이어지는 스트레이트일 경우
        // 큰 순서대로이기 때문에 0 인덱스가 제일 큼
        if (cards[cards.length - 1].getNumber() == 0 && cards[0].getNumber() == Card.NUM_MAX - 1) {
            int p1, p2;

            for (p1 = 0; p1 < Player.CARD_NUM - 1; p1++) {
                if (cards[p1].getNumber() != cards[p1 + 1].getNumber() + 1)
                    break;
            }
            for (p2 = Player.CARD_NUM - 1; p2 > 0; p2--) {
                if (cards[p2].getNumber() != cards[p2 - 1].getNumber() - 1)
                    break;
            }
            if (p2 - p1 == 1){
                this.highCard = cards[0];
                return true;
            }
            return false;
        }

        // 위의 경우가 아니면
        for (int i = 0; i < cards.length - 1; i++) {
            if (cards[i].getNumber() != cards[i + 1].getNumber() + 1)
                return false;
        }
        this.highCard = cards[0];
        return true;
    }

    // 인덱스 0부터 연속된 숫자 3개 파악
    private boolean isTriple (Card[] cards) {
        for (int i = 0; i < cards.length - 3; i++) {
            if (cards[i].getNumber() == cards[i + 1].getNumber()
                    && cards[i + 1].getNumber() == cards[i + 2].getNumber()) {
                this.highCard = cards[i];
                return true;
            }
        }
        return false;
    }

    // 양 쪽 끝에서 포인터를 조여오며 짝 찾기
    // 풀하우스도 같이 판별되긴 하지만, 위에서 이미 풀하우스는 거르고 들어옴
    private boolean isTowPairs(Card[] cards) {
        int p1, p2;
        int count = 0;

        for (p1 = 1; p1 < Player.CARD_NUM; p1++) {
            if (cards[p1].getNumber() == cards[p1 - 1].getNumber()) {
                count++;
                break;
            }
        }
        for (p2 = Player.CARD_NUM - 2; p2 >= 0; p2--) {
            if (cards[p2].getNumber() == cards[p2 + 1].getNumber()) {
                count++;
                break;
            }
        }

        // Grade, Boolean 반환
        if (p1 < p2 && count == 2) {
            this.highCard = cards[p1 - 1];
            return true;
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

    public void setGrade(Card[] cards) {
        if (isStraightFlush(cards)) this.grade = Grade.sFlush;
        else if (isFourCard(cards)) this.grade = Grade.fourCards;
        else if (isFullHouse(cards)) this.grade = Grade.fullHouse;
        else if (isFlush(cards)) this.grade = Grade.flush;
        else if (isStraight(cards)) this.grade = Grade.straight;
        else if (isTriple(cards)) this.grade = Grade.triple;
        else if (isTowPairs(cards)) this.grade = Grade.twopair;
        else if (isOnePair(cards)) this.grade = Grade.onepair;
        else {
            this.highCard = cards[0];
            this.grade = Grade.high;
        }
    }

    public Card getHighCard() {
        return this.highCard;
    }

    public int getGrade() {
        return this.grade;
    }

    public Card[] cloneCards(Card[] cards) {
        Card[] cardTmp = new Card[Player.CARD_NUM];

        for (int i = 0; i < cards.length; i++) {
            cardTmp[i] = new Card(cards[i].getNumber(), cards[i].getKind());
        }
        Arrays.sort(cardTmp, new SortByKind());

        return cardTmp;
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
