package TicTacToe;

import TicTacToe.controllers.GameController;
import TicTacToe.exceptions.BotCountException;
import TicTacToe.exceptions.PlayerCountDimensionMismatchException;
import TicTacToe.exceptions.SymbolCountException;
import TicTacToe.models.Cell;
import TicTacToe.models.Game;
import TicTacToe.models.GameState;
import TicTacToe.models.Move;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws BotCountException, SymbolCountException, PlayerCountDimensionMismatchException {
        GameController gameController = new GameController();
        Game game = gameController.startGame(3 , new ArrayList<>(), new ArrayList<>());
        System.out.println("Game is Starting");
//        Game game = new Game();
        Move move = null;
        Cell cell = null;
        Scanner scanner = new Scanner(System.in);
        while(gameController.checkState(game).equals(GameState.IN_PROGRESS)){
            gameController.displayBoard(game);
            move = new Move();
            move.setPlayer(game.getPlayers().get(game.getNextMovePlayerIndex()));
            move.setCell(getInputCell(scanner));
            gameController.makeMove(game, move);
            // do undo
        }

        if(gameController.checkState(game).equals(GameState.SUCCESS)){
            System.out.println("Winner is some player");
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
