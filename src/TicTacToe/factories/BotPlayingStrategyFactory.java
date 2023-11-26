package TicTacToe.factories;

import TicTacToe.models.BotDifficultyLevel;
import TicTacToe.strategies.HardPlayingStrategy;
import TicTacToe.strategies.MediumPlayingStrategy;
import TicTacToe.strategies.botplayingstrategy.BotPlayingStrategy;
import TicTacToe.strategies.botplayingstrategy.EasyPlayingStrategy;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategy(BotDifficultyLevel botDifficultyLevel){
        if(BotDifficultyLevel.EASY.equals(botDifficultyLevel)){
            return new EasyPlayingStrategy();
        }else if(BotDifficultyLevel.MEDIUM.equals(botDifficultyLevel)){
            return new MediumPlayingStrategy();
        }else if(BotDifficultyLevel.HARD.equals(botDifficultyLevel)){
            return new HardPlayingStrategy();
        }
        return new EasyPlayingStrategy();
    }
}
