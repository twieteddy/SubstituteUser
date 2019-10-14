package io.github.twieteddy.substituteuser;

import io.github.twieteddy.substituteuser.commands.SuCommand;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings({"WeakerAccess", "unused"})
public class SubstituteUser extends JavaPlugin {

  @Override
  public void onEnable() {
    PluginConfig config = new PluginConfig(this);
    getCommand("su").setExecutor(new SuCommand(config));
  }
}
