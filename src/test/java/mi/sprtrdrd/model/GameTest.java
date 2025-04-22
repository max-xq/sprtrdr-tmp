package mi.sprtrdrd.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    @Test
    public void testCreateGame__created_successfully() {
        final var teamA = new Team("teamA");
        final var teamB = new Team("teamB");
        final var game = new Game(teamA, teamB);
        assertEquals(teamA, game.getTeamHome().getTeam());
        assertEquals(teamB, game.getTeamGuest().getTeam());
    }

    @Test
    public void testCreateGame__failed() {
        final var teamA = new Team("teamA");
        final var teamB = new Team("teamA");
        assertThrows(Exception.class, () -> new Game(teamA, teamB));
    }

    @Test
    public void testUpdateScore__updated_normally() {
        final var teamHome = new Team("teamA");
        final var teamGuest = new Team("teamB");
        final var game = new Game(teamHome, teamGuest);
        game.updateScore(teamHome, 1);
        assertEquals(1, game.getTeamHome().getScore());
        assertEquals(0, game.getTeamGuest().getScore());
    }

    @Test
    public void testUpdateScore__failed_to_update() {
        final var teamA = new Team("teamA");
        final var teamB = new Team("teamB");
        final var game1 = new Game(teamA, teamB);
        final var teamC = new Team("teamC");
        assertThrows(Exception.class, () -> game1.updateScore(teamC, 1));
    }
}