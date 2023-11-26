package TicTacToe.models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    private List<List<Cell>> cells;
    Board(int dimension){
        size = dimension;
        cells = new ArrayList<>(size);
        for(int i = 0; i < size; i++){
            cells.add(i, new ArrayList<>(size));
            for(int j = 0; j < size; j++){
                cells.get(i).add(new Cell(i, j));
            }
        }
    }
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<List<Cell>> getCells() {
        return cells;
    }

    public void display(){
        System.out.println("-- Current Board State -- ");
        for(int i = 0; i < this.getSize(); i++){
            for(int j = 0; j < this.getSize(); j++){
                if(this.getCells().get(i).get(j).getCellState().equals(CellState.EMPTY))
                    System.out.print(" - ");
                else
                    System.out.print(" "+this.getCells().get(i).get(j).getPlayer().getSymbol().getaChar()+" ");
                if(j < this.getSize() - 1)
                    System.out.print("|");
            }
            System.out.println();
        }
    }
    public void setCells(List<List<Cell>> board) {
        this.cells = board;
    }
}