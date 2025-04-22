package mi.sprtrdrd.model;

import java.util.LinkedHashMap;

public class Board {

    private final LinkedHashMap<Integer, Game> gameBoard = new LinkedHashMap<>();

    public LinkedHashMap<Integer, Game> readGameBoard() {
        return new LinkedHashMap<>(gameBoard);
    }

    public Game addGame(Game game) {
        synchronized (this) {
            if (gameBoard.containsValue(game)) {
                throw new IllegalArgumentException("Illegal argument creating a game. Game " + game + " is already on the board");
            }
            gameBoard.put(game.hashCode(), game);
            return game;
        }
    }

    public Game removeGame(Game game) {
        synchronized (this) {
            if (!gameBoard.containsKey(game.hashCode())) {
                throw new IllegalArgumentException("Illegal argument removing a game. Requested game does not exist: " + game);
            }
            return gameBoard.remove(game.hashCode());
        }
    }
}
