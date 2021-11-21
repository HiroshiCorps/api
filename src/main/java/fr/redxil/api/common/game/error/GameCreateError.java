package fr.redxil.api.common.game.error;

public class GameCreateError extends Throwable {

    String errorMessage;

    public GameCreateError(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
