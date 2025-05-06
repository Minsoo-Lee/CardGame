import card.Dealer;
import card.Player;

import java.util.Arrays;

public class DeckTest {
    public static void main(String[] args) {
        int playerNum = 5;
        Dealer dealer = new Dealer();
        Player[] players = new Player[playerNum];

        // player 생성
        for (int i = 0; i < playerNum; i++) {
            players[i] = new Player("" + (i + 1));
        }

        // 플레이어에게 카드 배부
        for (int i = 0; i < playerNum; i++) {
            for (int j = 0; j < Player.CARD_NUM; j++) {
                players[i].setCard(j, dealer.dealing());
            }
        }

        for (int i = 1; i < playerNum; i++) {
            System.out.println("============== player " + i + " ==============");
            players[i].showCards();
            System.out.println();
        }

        System.out.println("============== After sort ============");
        for (int i = 1; i < playerNum; i++) {
            System.out.println("============== player " + i + " ==============");
            Arrays.sort(players[i].getCards());
            players[i].showCards();
            players[i].setRank();
            players[i].showRank();

            dealer.setCardBoard(players[i], players[i].getRank().getHighCard(), i - 1);
            System.out.println();
        }

        dealer.showCardBoard();
        Player winner = dealer.getWinner();

        for (int i = 1; i < playerNum; i++) {
            if (winner != players[i]) {
                players[i].setWin();
                players[i].setMoney();
            } else {
                players[i].setLose();
            }
        }

        System.out.println();
        System.out.println("=================================================");
        for (int i = 1; i < playerNum; i++) {
            System.out.println("Player[" + i + "] Win = " + players[i].getWin() + ", Lose = " + players[i].getLose() + ", Money = " + players[i].getMoney());
        }
    }
}
