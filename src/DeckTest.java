import data.Grade;
import data.Kind;

import java.util.Arrays;

public class DeckTest {
    public static void main(String[] args) {
        int playerNum = 5;
        Dealer dealer = new Dealer();
        Player[] players = new Player[playerNum];

        for (int i = 0; i < playerNum; i++) {
            players[i] = new Player("" + (i + 1));
        }

        for (int i = 0; i < playerNum; i++) {
            for (int j = 0; j < Player.CARD_NUM; j++) {
                players[i].getCard(j, dealer.dealing());
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
            System.out.println();
        }
    }
}
