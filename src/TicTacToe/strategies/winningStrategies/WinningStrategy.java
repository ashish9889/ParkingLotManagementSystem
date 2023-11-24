package TicTacToe.strategies.winningStrategies;

import TicTacToe.models.GameState;

public interface WinningStrategy {
    GameState checkWin();
}
