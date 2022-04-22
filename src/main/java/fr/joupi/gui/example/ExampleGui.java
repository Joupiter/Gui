package fr.joupi.gui.example;

import fr.joupi.gui.Gui;
import fr.joupi.gui.GuiButton;
import fr.joupi.gui.ItemBuilder;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ExampleGui extends Gui<ExamplePlugin> {

    protected ExampleGui(ExamplePlugin plugin) {
        super(plugin, "&6&lInventaire", 6);
    }

    @Override
    public void setup() {
        setItems(getBorders(), new GuiButton(new ItemBuilder(Material.STAINED_GLASS_PANE).setDyeColor(DyeColor.RED).build()));

        setItem(49, new GuiButton(new ItemStack(Material.BARRIER),
                event -> close((Player) event.getWhoClicked())));
    }
}
