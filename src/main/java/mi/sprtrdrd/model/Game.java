package mi.sprtrdrd.model;

import lombok.Getter;

@Getter
public class Game {

    private TeamScore teamHome;
    private TeamScore teamGuest;

    public Game(Team teamHome, Team teamGuest) {
    }

    public void updateScore(Team team, Integer score) {
    }
}
