package TicTacToe.strategies.botplayingstrategy;

import TicTacToe.models.Game;
import TicTacToe.models.Move;
import TicTacToe.models.Player;

public interface BotPlayingStrategy {

    Move makeMove(Game game, Player player);
}
