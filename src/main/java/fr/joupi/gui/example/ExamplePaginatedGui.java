package fr.joupi.gui.example;

import fr.joupi.gui.GuiButton;
import fr.joupi.gui.PageableGui;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class ExamplePaginatedGui extends PageableGui<ExamplePlugin, Material> {

    protected ExamplePaginatedGui(ExamplePlugin plugin) {
        super(plugin, "&6&lMenu avec pages", 3, 9);

        Arrays.stream(Material.values()).forEach(this::addMaterial);
    }

    @Override
    public void setup() {
        for (int i = 0; i < getPage().countElements(); i++)
            setItem(i, new GuiButton(new ItemStack(getPage().getElements().get(i))));

        setItem(21, previousPageButton());

        setItem(23, nextPageButton());

    }

    private void addMaterial(Material material) {
        getPagination().addElement(material);
    }

    @Override
    public GuiButton nextPageButton() {
        return new GuiButton(new ItemStack(Material.ARROW), event -> {
            if (!getPagination().hasNext(getPage())) return;

            updatePage(getPagination().getNext(getPage()));
        });
    }

    @Override
    public GuiButton previousPageButton() {
        return new GuiButton(new ItemStack(Material.ARROW), event -> {
            if (!getPagination().hasPrevious(getPage())) return;

            updatePage(getPagination().getPrevious(getPage()));
        });
    }
}
