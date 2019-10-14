package io.github.twieteddy.substituteuser.commands;

import io.github.twieteddy.substituteuser.PluginConfig;
import java.util.Arrays;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.jetbrains.annotations.NotNull;

public class SuCommand implements CommandExecutor {
  private final PluginConfig config;

  @SuppressWarnings("unused")
  public SuCommand(PluginConfig config) {
    this.config = config;
  }

  @EventHandler
  public boolean onCommand(
      CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
    if (!sender.isOp()) {
      sender.sendMessage(config.getNoPermissionMessage());
      return false;
    }

    if (args.length < 2) {
      sender.sendMessage(config.getNotEnoughArgumentsMessage());
      return false;
    }

    List<String> argsList = Arrays.asList(args);
    String targetName = argsList.get(0);
    String command = String.join(" ", argsList.subList(1, argsList.size()));
    Player targetPlayer = Bukkit.getPlayerExact(targetName);

    if (targetPlayer == null) {
      sender.sendMessage(config.getPlayerNotOnlineMessage());
      return false;
    }

    targetPlayer.chat(command);
    return true;
  }
}
