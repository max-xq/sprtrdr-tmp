package mi.sprtrdrd.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BoardTest {
    private Board testBoard = new Board();

    @BeforeEach
    public void tearDown() {
        this.refreshTestBoard();
    }

    @Test
    public void testAddGame__game_added_normally() {
        final var teamA = new Team("teamA");
        final var teamB = new Team("teamB");
        final var game = new Game(teamA, teamB);
        assertEquals(5, this.testBoard.readGameBoard().size());
        assertEquals(game, this.testBoard.addGame(game));
        assertEquals(6, this.testBoard.readGameBoard().size());
    }

    @Test
    public void testAddGame__failed_game_is_already_added() {
        final var teamA = new Team("init_team1");
        final var teamB = new Team("init_team2");
        final var game = new Game(teamA, teamB);
        final var exception = assertThrows(
                IllegalArgumentException.class,
                () -> this.testBoard.addGame(game));
        assertEquals(
                "Illegal argument creating a game. Game " + game + " is already on the board",
                exception.getMessage());
    }

    @Test
    public void testRemoveGame__removed_normally() {
        final var teamA = new Team("init_team1");
        final var teamB = new Team("init_team2");
        final var game = new Game(teamA, teamB);
        final var removed = this.testBoard.removeGame(game);
        assertEquals(game, removed);
    }

    @Test
    public void testRemoveGame__failed_to_remove() {
        final var teamA = new Team("does_not_exist1");
        final var teamB = new Team("does_not_exist2");
        final var game = new Game(teamA, teamB);
        final var exception = assertThrows(
                IllegalArgumentException.class,
                () -> this.testBoard.removeGame(game));
        assertEquals("Illegal argument removing a game. Requested game does not exist: "+ game, exception.getMessage());
    }

    private void refreshTestBoard() {
        this.testBoard = new Board();
        for(var i = 0; i < 5; ++i) {
            final var team1 = new Team("init_team"+i);
            final var team2 = new Team("init_team"+(i+1));
            final var game = new Game(team1, team2);
            this.testBoard.addGame(game);
        }
    }
}