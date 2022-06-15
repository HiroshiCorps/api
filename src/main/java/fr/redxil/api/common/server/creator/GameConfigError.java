package fr.redxil.api.common.server.creator;

public class GameConfigError extends Exception {
    String errorMessage;
    public GameConfigError(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage(){
        return errorMessage;
    }

}
