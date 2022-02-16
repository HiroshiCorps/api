package fr.redxil.api.paper.game.exemple;

import fr.redxil.api.common.API;
import fr.redxil.api.common.game.Game;
import fr.redxil.api.common.game.error.GameInitError;
import fr.redxil.api.common.game.utils.GameEnum;
import fr.redxil.api.common.game.utils.GameState;
import fr.redxil.api.common.group.team.Team;
import fr.redxil.api.paper.game.GameBuilder;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.concurrent.TimeUnit;

public class TestGame extends GameBuilder {
    public TestGame(JavaPlugin plugin) throws GameInitError {
        super(plugin, GameEnum.TEST);
    }

    @Override
    public void onPlayerJoin(Player player) {
        player.setGameMode(GameMode.SPECTATOR);
        player.sendMessage("Partie rejoins en tant que joueur");
        start();
    }

    @Override
    public void onPlayerLeave(Player player) {

        Game game = API.getInstance().getGame();
        if (game.getGameState() == GameState.START)
            stopStart();

    }

    @Override
    public void onSpectatorJoin(Player player) {
        player.setGameMode(GameMode.SPECTATOR);
        player.sendMessage("Partie rejoins en tant que spectateur");
    }

    @Override
    public void onSpectatorLeave(Player player) {
        /*
        Je sais pas quoi comme exemple
         */
    }

    @Override
    public boolean start() {
        Game game = API.getInstance().getGame();
        if (game.getPlayers().size() < game.getMinPlayer() || !game.getInConnectPlayer().isEmpty())
            return false;
        game.setGameState(GameState.START);
        getTimerGest().setPeriod(1, TimeUnit.SECONDS);
        getTimerGest().setValue(10, TimeUnit.SECONDS);
        return getTimerGest().startTimer(new StartTimerListener(this));
    }

    @Override
    public boolean forceStart() {
        return start();
    }

    @Override
    public boolean stopStart() {
        Game game = API.getInstance().getGame();
        if (game.getGameState() != GameState.START)
            return false;
        getTimerGest().stopTimer();
        game.setGameState(GameState.WAITING);
        return true;
    }

    @Override
    public void onWin(Team team) {
        Bukkit.getOnlinePlayers().forEach((player) -> {
            player.setGameMode(GameMode.SPECTATOR);
            player.sendMessage("Partie gagné par l'équipe: " + team.getTeamName());
        });
    }

    @Override
    public void onWin(Player winner) {
        Bukkit.getOnlinePlayers().forEach((player) -> {
            player.setGameMode(GameMode.SPECTATOR);
            player.sendMessage("Partie gagné par l'équipe: " + winner.getDisplayName());
        });
    }

    @Override
    public void forceEnd(String reason) {
        Bukkit.getOnlinePlayers().forEach((player) -> {
            player.setGameMode(GameMode.SPECTATOR);
            player.sendMessage("Partie arrété: " + reason);
        });
    }

    @Override
    public void forceWin(Team team, String reason) {
        Bukkit.getOnlinePlayers().forEach((player) -> {
            player.setGameMode(GameMode.SPECTATOR);
            player.sendMessage("Partie gagné de force par l'équipe: " + team.getTeamName());
        });
    }

    @Override
    public void forceWin(Player winner, String reason) {
        Bukkit.getOnlinePlayers().forEach((player) -> {
            player.setGameMode(GameMode.SPECTATOR);
            player.sendMessage("Partie gagné de force par l'équipe: " + winner.getDisplayName());
        });
    }

    public void startTimerFinish() {
        Game game = API.getInstance().getGame();
        game.setGameState(GameState.GAME);
        getTimerGest().setValue(10, TimeUnit.MINUTES);
        /*
            Here you can teleport player to their spawn point,
            Change their gamemode to survival
         */
    }

}
