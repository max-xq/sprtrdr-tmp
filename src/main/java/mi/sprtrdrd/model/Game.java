package mi.sprtrdrd.model;

import lombok.Getter;

@Getter
public class Game {
    private final TeamScore teamHome;
    private final TeamScore teamGuest;

    public Game(final Team teamHome, final Team teamGuest) {
        if (teamHome.equals(teamGuest)) {
            throw new IllegalArgumentException(
                    "Illegal argument creating a game. Home and guest teams are the same: " + teamHome + " " + teamGuest);
        }
        this.teamHome = new TeamScore(teamHome);
        this.teamGuest = new TeamScore(teamGuest);
    }

    public void updateScore(Team team, Integer score) {
        if (team.equals(teamHome.getTeam())) {
            teamHome.setScore(score);
        } else if (team.equals(teamGuest.getTeam())) {
            teamGuest.setScore(score);
        } else {
            throw new IllegalArgumentException("Team "+team+" does not play in game " + this);
        }
    }
}
