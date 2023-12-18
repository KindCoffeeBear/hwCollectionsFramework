import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    Game game = new Game();
    Player player1 = new Player(231, "Ваня", 45);
    Player player2 = new Player(432, "Аня", 54);
    Player player3 = new Player(5, "Женя", 34);
    Player player4 = new Player(42, "Костя", 45);

    @Test
    public void testRound() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        int expected1 = 1;
        int actual1 = game.round("Ваня", "Женя");

        int expected2 = 2;
        int actual2 = game.round("Ваня", "Аня");

        int expected3 = 0;
        int actual3 = game.round("Ваня", "Костя");

        Assertions.assertEquals(expected1, actual1);
        Assertions.assertEquals(expected2, actual2);
        Assertions.assertEquals(expected3, actual3);
    }

    @Test
    public void testNotRegisteredException() {
        game.register(player1);
        game.register(player2);
        game.register(player3);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Ваня", "Костя");
        });

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Костя", "Ваня");
        });
    }

    @Test
    public void testGetId() {
        int expected = 231;
        int actual = player1.getId();

        Assertions.assertEquals(expected, actual);
    }
}
