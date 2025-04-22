package mi.sprtrdrd.model;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List gameBoard = new ArrayList();

    public List readGameBoard() {
        return new ArrayList(gameBoard);
    }

    public Game addGame(Game game) {
        return null;
    }

    public Game removeGame(Game game) {
        return null;
    }
}
