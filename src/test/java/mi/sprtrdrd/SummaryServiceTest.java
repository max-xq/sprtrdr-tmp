package mi.sprtrdrd;

import mi.sprtrdrd.model.Board;
import mi.sprtrdrd.model.Game;
import mi.sprtrdrd.model.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SummaryServiceTest {
    private Board testBoard = new Board();

    @BeforeEach
    void setup() {
        this.buildTestData();
    }

    @Test
    void parseSummary() {
        final var parsedBoard = SummaryService.parseSummary(this.testBoard);
        assertEquals(expectedResult(), parsedBoard);
    }

    private void buildTestData() {
        final var teamA1 = new Team("Uruguay");
        final var teamA2 = new Team("Italy");
        final var gameA = new Game(teamA1, teamA2);
        gameA.updateScore(teamA1, 6);
        gameA.updateScore(teamA2, 6);

        final var teamB1 = new Team("Spain");
        final var teamB2 = new Team("Brazil");
        final var gameB = new Game(teamB1, teamB2);
        gameB.updateScore(teamB1, 10);
        gameB.updateScore(teamB2, 2);

        final var teamC1 = new Team("Mexico");
        final var teamC2 = new Team("Canada");
        final var gameC = new Game(teamC1, teamC2);
        gameC.updateScore(teamC1, 0);
        gameC.updateScore(teamC2, 5);

        final var teamD1 = new Team("Argentina");
        final var teamD2 = new Team("Australia");
        final var gameD = new Game(teamD1, teamD2);
        gameD.updateScore(teamD1, 3);
        gameD.updateScore(teamD2, 1);

        final var teamE1 = new Team("Germany");
        final var teamE2 = new Team("France");
        final var gameE = new Game(teamE1, teamE2);
        gameE.updateScore(teamE1, 2);
        gameE.updateScore(teamE2, 2);

        this.testBoard.addGame(gameA);
        this.testBoard.addGame(gameB);
        this.testBoard.addGame(gameC);
        this.testBoard.addGame(gameD);
        this.testBoard.addGame(gameE);
    }

    private String expectedResult() {
        return
                """
                        1. Uruguay 6 - Italy 6
                        2. Spain 10 - Brazil 2
                        3. Mexico 0 - Canada 5
                        4. Argentina 3 - Australia 1
                        5. Germany 2 - France 2""";
    }
}