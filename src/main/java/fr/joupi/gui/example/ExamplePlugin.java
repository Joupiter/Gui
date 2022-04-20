package fr.joupi.gui.example;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class ExamplePlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {

        if (event.getMessage().equalsIgnoreCase("!menu")) {
            Player player = event.getPlayer();

            new ExampleGui(this).onOpen(player);
        }

        if (event.getMessage().equalsIgnoreCase("!paginated menu")) {
            Player player = event.getPlayer();

            new ExamplePaginatedGui(this).onOpen(player);
        }

    }

}
