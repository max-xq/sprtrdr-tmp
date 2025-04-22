package mi.sprtrdrd.model;

import org.junit.jupiter.api.BeforeEach;

public class BoardTest {
    private Board testBoard = new Board();

    @BeforeEach
    public void tearDown() {
        this.refreshTestBoard();
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