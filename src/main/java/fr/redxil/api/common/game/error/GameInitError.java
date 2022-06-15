package fr.redxil.api.common.game.error;

public class GameInitError extends Throwable {

    String errorMessage;

    public GameInitError(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
