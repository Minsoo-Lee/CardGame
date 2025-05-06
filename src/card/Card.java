package card;

public class Card implements Comparable<Card> {

        static final int KIND_MAX = 4;
        static final int NUM_MAX = 13;

        static final int SPADE = 4;
        static final int DIAMOND = 3;
        static final int HEART = 2;
        static final int CLOVER = 1;

        int kind;
        int number;

        Card() {
            this(SPADE, 1);
        }

        Card(int kind, int number) {
            this.kind = kind;
            this.number = number;
        }

        public String toString() {
            String[] kinds = {"CLOVER", "HEART", "DIAMOND", "SPADE"};
            String[] numbers = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
            return "kind : " + kinds[this.kind] + ", number : " + numbers[this.number];
        }

        public int getNumber() {
            return this.number;
        }

        public int getKind() { return this.kind; }

        @Override
        public int compareTo(Card c) {
            if (this.number == c.number) {
                return c.kind - this.kind;
            } else {
                return c.number - this.number;
            }
        }
    }
