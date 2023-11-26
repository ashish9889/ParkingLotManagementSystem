package TicTacToe.controllers;

import TicTacToe.exceptions.*;
import TicTacToe.models.*;
import TicTacToe.strategies.winningStrategies.WinningStrategy;
import java.util.List;

public class GameController {
    public static Game startGame(int dimension,
                          List<Player> players,
                          WinningStrategy winningStrategy) throws BotCountException, SymbolCountException, PlayerCountDimensionMismatchException {

        return Game.getBuilder()
                .setDimension(dimension)
                .setPlayers(players)
                .setWinningStrategy(winningStrategy)
                .build();
    }

    public static void makeMove(Game game){
        game.makeMove();

    }

    public static void main(String[] args) throws BotCountException, SymbolCountException, PlayerCountDimensionMismatchException, InvalidPlayersInputException {
        Player player1 = Player.builder().setPlayerType(PlayerType.HUMAN).setSymbol(new Symbol('#')).setName("Ashish").setId(1).build();
        Player player2 = Player.builder().setPlayerType(PlayerType.HUMAN).setSymbol(new Symbol('+')).setName("Manish").setId(2).build();
        List<Player> players = List.of(player2, player1);
        WinningStrategy winningStrategy = null;
        Game game = GameController.startGame(3, players, winningStrategy);

        displayBoard(game);
    }

    public static void displayBoard(Game game){
        game.getBoard().display();
    }

    public Player getWinner(Game game) throws WinnerNotAvailableException {
        if(!game.getGameState().equals(GameState.SUCCESS))
            throw new WinnerNotAvailableException("Game does not have winner!");

        return game.getWinner();
    }

    public static GameState checkState(Game game){
        return game.getGameState();
    }

    public void undo(Game game){
        game.undo();
    }

}
