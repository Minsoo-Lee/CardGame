package card;

// 각 플레이어의 highCard를 여기에 수집
// 딜러가 이 클래스를 포함하여 누가 이겼는지 공지
public class CardBoard implements Comparable<CardBoard> {
    private final Player player;
    private final Card highCard;

    CardBoard(Player player, Card card) {
        this.player = player;
        this.highCard = card;
    }

    public Player getPlayer() {
        return this.player;
    }

    @Override
    public int compareTo(CardBoard cb) {
        if (this.highCard.getNumber() == cb.highCard.getNumber()) {
            return cb.highCard.getKind() - this.highCard.getKind();
        } else {
            return cb.highCard.getNumber() - this.highCard.getNumber();
        }
    }
}
