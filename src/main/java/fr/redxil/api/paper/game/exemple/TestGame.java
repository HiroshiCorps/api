package fr.redxil.api.paper.game.exemple;

import fr.redxil.api.common.API;
import fr.redxil.api.common.game.error.GameInitError;
import fr.redxil.api.common.server.PlayerState;
import fr.redxil.api.common.time.TimerSystem;
import fr.redxil.api.paper.game.GameBuilder;
import fr.redxil.api.common.game.Game;
import fr.redxil.api.common.game.utils.GameState;
import fr.redxil.api.common.group.team.Team;
import fr.xilitra.hiroshisav.enums.TypeGame;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class TestGame extends GameBuilder {

    TimerSystem timerSystem = new TimerSystem();

    public TestGame(JavaPlugin plugin) throws GameInitError {
        super(plugin, TypeGame.UHC6P);
    }

    @Override
    public void onPlayerJoin(Player player) {
        player.setGameMode(GameMode.SPECTATOR);
        player.sendMessage("Partie rejoins en tant que joueur");
        start();
    }

    @Override
    public void onPlayerLeave(Player player) {

        Optional<Game> gameOptional = API.getInstance().getGameManager().getGameByServerID(API.getInstance().getServerID());
        gameOptional.ifPresent(game -> {
            if (game.getGameState() == GameState.START)
                stopStart();
        });

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
        Optional<Game> gameOptional = API.getInstance().getGameManager().getGameByServerID(API.getInstance().getServerID());
        if (gameOptional.isEmpty())
            return false;
        Game game = gameOptional.get();
        if (game.getPlayerList(PlayerState.CONNECTED, PlayerState.INCONNECT).size() < game.getMinPlayer() || game.getPlayerList(PlayerState.INCONNECT).isEmpty())
            return false;
        game.setGameState(GameState.START);
        timerSystem.setPeriod(1, TimeUnit.SECONDS);
        timerSystem.setValue(10, TimeUnit.SECONDS);
        return timerSystem.startTimer(new StartTimerListener(this));
    }

    @Override
    public boolean forceStart() {
        return start();
    }

    @Override
    public boolean stopStart() {
        Optional<Game> gameOptional = API.getInstance().getGameManager().getGameByServerID(API.getInstance().getServerID());
        if (gameOptional.isEmpty())
            return false;
        Game game = gameOptional.get();
        if (game.getGameState() != GameState.START)
            return false;
        timerSystem.stopTimer();
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
        Optional<Game> gameOptional = API.getInstance().getGameManager().getGameByServerID(API.getInstance().getServerID());
        gameOptional.ifPresent(game -> game.setGameState(GameState.GAME));
        timerSystem.setValue(10, TimeUnit.MINUTES);
        /*
            Here you can teleport player to their spawn point,
            Change their gamemode to survival
         */
    }

}
