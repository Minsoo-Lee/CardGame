package card;

import java.util.Arrays;

public class Dealer {
    Deck deck;
    CardBoard[] cardBoard;

    public Dealer() {
        deck = new Deck();
        deck.shuffle();
        cardBoard = new CardBoard[Player.CARD_NUM];
    }

    public void initCards() {
        this.deck.init();
    }

    public Card dealing() {
        return deck.pick();
    }

    public void setCardBoard(Player player, Card card, int index) {
        cardBoard[index] = new CardBoard(player, card);
    }

    public void showCardBoard() {
        System.out.println();
        for (int i = 0; i < cardBoard.length; i++) {
            System.out.println("index = " + i + ", " + cardBoard[i].getPlayer().getWin());
        }
        System.out.println();
    }

    public Player getWinner() {
        Arrays.sort(cardBoard);

        return cardBoard[0].getPlayer();
    }
}
