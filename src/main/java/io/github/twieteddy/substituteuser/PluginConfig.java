package io.github.twieteddy.substituteuser;

import java.io.File;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;

@SuppressWarnings("unused")
public class PluginConfig {
  private final String noPermission;
  private final String notEnoughArguments;
  private final String playerNotOnline;

  public PluginConfig(SubstituteUser plugin) {
    File file = new File(plugin.getDataFolder(), "config.yml");
    if (!file.exists()) {
      plugin.saveResource("config.yml", true);
    }

    YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
    noPermission = colorize(config.getString("no_permission"));
    notEnoughArguments = colorize(config.getString("not_enough_arguments"));
    playerNotOnline = colorize(config.getString("player_not_online"));
  }

  private String colorize(String text) {
    return text == null ? "" : ChatColor.translateAlternateColorCodes('&', text);
  }

  public final String getNoPermissionMessage() {
    return noPermission;
  }

  public final String getNotEnoughArgumentsMessage() {
    return notEnoughArguments;
  }

  public final String getPlayerNotOnlineMessage() {
    return playerNotOnline;
  }
}
