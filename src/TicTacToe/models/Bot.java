package TicTacToe.models;

import TicTacToe.factories.BotPlayingStrategyFactory;
import TicTacToe.strategies.botplayingstrategy.BotPlayingStrategy;

public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;

    private BotPlayingStrategy botPlayingStrategy;

    Bot(BotDifficultyLevel difficultyLevel){
        this.botDifficultyLevel = difficultyLevel;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategy(this.botDifficultyLevel);
    }
    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }

    public BotPlayingStrategy getBotPlayingStrategy() {
        return botPlayingStrategy;
    }

    public void setBotPlayingStrategy(BotPlayingStrategy botPlayingStrategy) {
        this.botPlayingStrategy = botPlayingStrategy;
    }
}
