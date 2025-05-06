import card.Dealer;
import card.Player;

import java.util.Arrays;
import java.util.Scanner;

public class DeckTest {
    public static void main(String[] args) {
        int playerNum = 4;
        Dealer dealer = new Dealer();
        Player[] players = new Player[playerNum];

        // player 생성
        for (int i = 0; i < playerNum; i++) {
            while (true) {
                Scanner scanner = new Scanner(System.in);
                String nickname = scanner.nextLine();
                if (nickname.length() <= 20) {
                    players[i] = new Player(nickname);
                    System.out.println(i + 1 + "의 닉네임: " + players[i].getNickname());
                    break;
                }
                else {
                    System.out.println("닉네임은 20자를 넘지 말아야 합니다.");
                }
            }
        }

        for (int x = 0; x < 100; x++) {

            System.out.println("플레이어들에게 카드를 배부합니다.");
            // 플레이어에게 카드 배부
            for (int i = 0; i < playerNum; i++) {
                for (int j = 0; j < Player.CARD_NUM; j++) {
                    players[i].setCard(j, dealer.dealing());
                }
            }

            // 플레이어 카드 보여주기
            System.out.println("============== After sort ============");
            for (int i = 0; i < playerNum; i++) {
                System.out.println("==============" + players[i].getNickname() + " ==============");
                Arrays.sort(players[i].getCards());
                players[i].showCards();
                players[i].setRank();
                players[i].showRank();

                dealer.setCardBoard(players[i], players[i].getRank().getHighCard(), i);
                System.out.println();
            }

            dealer.showCardBoard();
            Player winner = dealer.getWinner();

            for (int i = 0; i < playerNum; i++) {
                if (winner != players[i]) {
                    players[i].setLose();
                } else {
                    players[i].setWin();
                    players[i].setMoney();
                    System.out.println("승자는 " + players[i].getNickname() + " 입니다.");
                }
            }

            // 승자 출력
            System.out.println();
            System.out.println("======================== 현재 상황 =========================");
            for (int i = 0; i < playerNum; i++) {
                System.out.println("Player[" + i + "] Win = " + players[i].getWin() + ", Lose = " + players[i].getLose() + ", Money = " + players[i].getMoney());
            }

            // 한 판씩 끝날때마다 카드 초기화
            dealer.initCards();
            System.out.println();

            // 게임이 끝날 때마다 5초씩 대기
            try {
                Thread.sleep(50000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Arrays.sort(players);
        System.out.println("======================== 경기 결과 =========================");
        for (Player player : players) {
            System.out.println("Player[" + player.getNickname() + "] | Win = " + player.getWin() + ", Lose = " + player.getLose() + ", Money = " + player.getMoney());
        }
    }
}
