import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Game {
    HashMap<String, Player> players = new HashMap<>(); // зарегистрированные игроки

    /**
     * Метод регистрации игрока в турнире
     *
     * @param player Добавляемый игрок
     */
    public void register(String key, Player player) {
        players.put(key, player);
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = new Player();
        Player player2 = new Player();

        for (String key : players.keySet()) {
            if (players.get(key).getName().equals(playerName1)) {
                player1 = players.get(key);
            } else if (players.get(key).getName().equals(playerName2)) {
                player2 = players.get(key);
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
