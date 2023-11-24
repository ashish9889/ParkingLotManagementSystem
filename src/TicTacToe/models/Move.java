package TicTacToe.models;

import TicTacToe.exceptions.CellStateNotValidException;

public class Move {
    private Cell cell;
    private Player player;

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public boolean isValid()  {
        if(this.getCell() == null || !this.getCell().getCellState().equals(CellState.EMPTY)){
            return false;
        }
        return true;
    }
}
