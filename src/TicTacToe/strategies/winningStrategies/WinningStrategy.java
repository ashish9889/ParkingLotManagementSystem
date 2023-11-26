package TicTacToe.strategies.winningStrategies;

import TicTacToe.models.Board;
import TicTacToe.models.GameState;
import TicTacToe.models.Move;

public interface WinningStrategy {

    public boolean checkWin(Move move, Board board);

    void undo(Move move, Board board);
}
