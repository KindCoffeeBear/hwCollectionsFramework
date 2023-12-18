import java.util.ArrayList;
import java.util.Arrays;

public class Game {
    ArrayList<Player> players = new ArrayList<>(); // зарегистрированные игроки

    /**
     * Метод регистрации игрока в турнире
     *
     * @param player Добавляемый игрок
     */
    public void register(Player player) {
        players.add(player);
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = new Player();
        Player player2 = new Player();

        for (Player player : players) {
            if (player.getName().equals(playerName1)) {
                player1 = player;
            } else if (player.getName().equals(playerName2)) {
                player2 = player;
            }
        }

        if (player1.getName().isEmpty() || player2.getName().isEmpty()) {
            throw new NotRegisteredException(
                    "Игрок(и) не зарегистрирован(ы)"
            );
        } else {
            if (player1.getStrength() > player2.getStrength()) {
                return 1;
            } else if (player1.getStrength() < player2.getStrength()) {
                return 2;
            } else {
                return 0;
            }
        }
    }
}
