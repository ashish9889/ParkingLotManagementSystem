package TicTacToe.models;

import TicTacToe.exceptions.InvalidPlayersInputException;

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
