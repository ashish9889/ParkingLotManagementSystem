package TicTacToe;

import TicTacToe.controllers.GameController;
import TicTacToe.exceptions.BotCountException;
import TicTacToe.exceptions.InvalidPlayersInputException;
import TicTacToe.exceptions.PlayerCountDimensionMismatchException;
import TicTacToe.exceptions.SymbolCountException;
import TicTacToe.models.*;
import TicTacToe.strategies.winningStrategies.OrderOneWinningStrategy;
import TicTacToe.strategies.winningStrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws BotCountException, SymbolCountException, PlayerCountDimensionMismatchException, InvalidPlayersInputException {
        GameController gameController = new GameController();

        Player ashish = Player.builder().setId(1).setPlayerType(PlayerType.HUMAN).setName("Ashish").setSymbol(new Symbol('#')).build();
        Player bot = Player.builder().setId(2).setPlayerType(PlayerType.BOT).setName("Pluto").setSymbol(new Symbol('O')).build();

        Game game = gameController.startGame(3 , Arrays.asList(ashish, bot), new OrderOneWinningStrategy(3));
        System.out.println("Game is Starting");
//        Game game = new Game();
        while(gameController.checkState(game).equals(GameState.IN_PROGRESS)){
            gameController.displayBoard(game);
            gameController.makeMove(game);
            // do undo
            gameController.undo(game);
        }

        if(gameController.checkState(game).equals(GameState.SUCCESS)){
            System.out.println("Winner is "+game.getWinner());
        } else if (gameController.checkState(game).equals(GameState.DRAW)){
            System.out.println("Game is Drawn");
        }

    }

    private static Cell getInputCell(Scanner scanner) {
        System.out.println("Provide row number");
        int row = scanner.nextInt();
        System.out.println("Provide column number");
        int column = scanner.nextInt();
        return new Cell(row, column);
    }
}
