package fr.joupi.gui.example;

import com.google.common.collect.Lists;
import fr.joupi.gui.GuiButton;
import fr.joupi.gui.ItemBuilder;
import fr.joupi.gui.PageableGui;
import lombok.Getter;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class ExamplePaginatedGui extends PageableGui<ExamplePlugin, ItemStack> {

    @Getter private final List<ItemStack> list;

    protected ExamplePaginatedGui(ExamplePlugin plugin) {
        super(plugin, "&eMenu", 3, 9);
        this.list = Lists.newLinkedList();

        for (int i = 0; i < 64; i++)
            list.add(new ItemBuilder(Material.ENDER_PEARL).setAmount(i).build());

        list.forEach(this::addItem);
    }

    @Override
    public void setup() {
        setHorizontalLine(18, 27, new ItemBuilder(Material.STAINED_GLASS_PANE).setDyeColor(DyeColor.BLUE).build());

        for (int i = 0; i < getPage().countElements(); i++)
            setItem(i, new GuiButton(getPage().getElements().get(i)));

        setItem(21, previousPageButton());

        setItem(23, nextPageButton());
    }

    private void addItem(ItemStack itemStack) {
        getPagination().addElement(itemStack);
    }

    @Override
    public GuiButton nextPageButton() {
        return new GuiButton(new ItemBuilder(Material.ARROW).setName("&aSuivant").build(), event -> {
            if (!getPagination().hasNext(getPage())) return;

            updatePage(getPagination().getNext(getPage()));
        });
    }

    @Override
    public GuiButton previousPageButton() {
        return new GuiButton(new ItemBuilder(Material.ARROW).setName("&cRetour").build(), event -> {
            if (!getPagination().hasPrevious(getPage())) return;

            updatePage(getPagination().getPrevious(getPage()));
        });
    }

}
