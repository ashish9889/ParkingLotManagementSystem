package TicTacToe.controllers;

import TicTacToe.exceptions.*;
import TicTacToe.models.*;
import TicTacToe.strategies.winningStrategies.WinningStrategy;

import java.util.HashMap;
import java.util.List;

public class GameController {
    public static Game startGame(int dimension,
                          List<Player> players,
                          List<WinningStrategy> winningStrategies) throws BotCountException, SymbolCountException, PlayerCountDimensionMismatchException {
        // we will create the game
        // we need to validate
//        game.getbuilder().setplayers(...).setWinning(...);
//        game.addplayer().addplayer().addwinningstrategt();

        return Game.getBuilder()
                .setDimension(dimension)
                .setPlayers(players)
                .setWinningStrategies(winningStrategies)
                .build();
    }

    public static boolean makeMove(Game game, Move move){
        if(move.isValid()){
           game.getBoard().getCells().get(move.getCell().getRow()).get(move.getCell().getCol()).setPlayer(move.getPlayer());
           checkState(game);
        }else{
            System.out.println("Entered cell is not valid for move, kindly select another cell!");
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws BotCountException, SymbolCountException, PlayerCountDimensionMismatchException, InvalidPlayersInputException {
        Player player1 = Player.builder().setPlayerType(PlayerType.HUMAN).setSymbol(new Symbol('#')).setName("Ashish").setId(1).build();
        Player player2 = Player.builder().setPlayerType(PlayerType.HUMAN).setSymbol(new Symbol('+')).setName("Manish").setId(2).build();
        List<Player> players = List.of(player2, player1);
        List<WinningStrategy> winningStrategies = null;
        Game game = GameController.startGame(3, players, winningStrategies);
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
        return game.checkCurrentState();

    }

    public void undo(Game game){

    }

}
