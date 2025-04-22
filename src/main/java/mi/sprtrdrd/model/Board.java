package mi.sprtrdrd.model;

import java.util.HashMap;

public class Board {

    private final HashMap<Integer, Game> gameBoard = new HashMap<>();

    public HashMap<Integer, Game> readGameBoard() {
        return new HashMap<>(gameBoard);
    }

    public Game addGame(Game game) {
        if (gameBoard.containsValue(game)) {
            throw new IllegalArgumentException("Illegal argument creating a game. Game " + game + " is already on the board");
        }
        gameBoard.put(game.hashCode(), game);
        return game;
    }

    public Game removeGame(Game game) {
        if (!gameBoard.containsKey(game.hashCode())) {
            throw new IllegalArgumentException("Illegal argument removing a game. Requested game does not exist: "+ game);
        }
        return gameBoard.remove(game.hashCode());
    }
}
