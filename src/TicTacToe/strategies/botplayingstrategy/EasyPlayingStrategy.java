package TicTacToe.strategies.botplayingstrategy;

import TicTacToe.models.*;

import java.util.List;

public class EasyPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Move makeMove(Game game, Player player ) {
        int size = game.getBoard().getSize();
        List<List<Cell>> cells = game.getBoard().getCells();

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(cells.get(i).get(j).getCellState().equals(CellState.EMPTY)){
                    return new Move(new Cell(i, j), player);
                }
            }
        }
        return null;
    }
}
