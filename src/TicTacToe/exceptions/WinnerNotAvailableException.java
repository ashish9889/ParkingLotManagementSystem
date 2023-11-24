package TicTacToe.exceptions;

public class WinnerNotAvailableException extends Exception{
    public WinnerNotAvailableException(String msg){
        super(msg);
    }
}
