package TicTacToe.models;

import TicTacToe.controllers.GameController;
import TicTacToe.exceptions.InvalidPlayersInputException;

import java.util.List;
import java.util.Scanner;

public class Player {
    private String name;
    private int id;
    private Symbol symbol;
    private PlayerType playerType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public static Builder builder(){
        return new Builder();
    }

    public Move makeMove(Board board) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(this.getName() +"'s turn : ");
        //board.display();
        System.out.print("Please select row : ");
        int row = scanner.nextInt();
        System.out.print("Please select column : ");
        int col = scanner.nextInt();

        Cell cell = board.getCells().get(row).get(col);
        if(cell == null || !cell.isValidForMove()){
            System.out.println("Invalid cell selected for move, kindly retry!");
            this.makeMove(board);
        }

        cell.setPlayer(this);
        cell.setCellState(CellState.FILLED);
        return new Move(cell, this);
    }

    public void undo(Game game) {
        System.out.println("Do you want to undo last Move : Yes/No ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        if(input.equalsIgnoreCase("yes")) {
            Move lastMove = game.getMoves().get(game.getMoves().size() - 1);
            int lastPlayerIndex = game.getPlayers().indexOf(lastMove.getPlayer());
            lastMove.getCell().undoCell();
            game.getWinningStrategy().undo(lastMove, game.getBoard());
            game.setNextMovePlayerIndex(lastPlayerIndex);
        }
    }

    public static class Builder{
        private String name;
        private int id;
        private Symbol symbol;
        private PlayerType playerType;

        public String getName() {
            return name;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public int getId() {
            return id;
        }

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Symbol getSymbol() {
            return symbol;
        }

        public Builder setSymbol(Symbol symbol) {
            this.symbol = symbol;
            return this;
        }

        public PlayerType getPlayerType() {
            return playerType;
        }

        public Builder setPlayerType(PlayerType playerType) {
            this.playerType = playerType;
            return this;
        }

        public Player build() throws InvalidPlayersInputException {
            if(this.getSymbol() == null || this.getPlayerType() == null){
                throw new InvalidPlayersInputException("Inputs for players are not valid!");
            }

            Player player = new Player();
            player.setId(this.getId());
            player.setPlayerType(this.getPlayerType());
            player.setSymbol(this.getSymbol());
            player.setName(this.getName());
            return player;
        }
    }
}
