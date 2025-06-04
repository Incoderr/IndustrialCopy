package net.incoder.industrial.item;

import net.incoder.industrial.Industrial;
import net.incoder.industrial.tool.ToolHammer;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItem {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Industrial.MODID);
    //
    public static final DeferredItem<Item> BRONZE_INGOT = ITEMS.register("bronze_ingot",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> TIN_INGOT = ITEMS.register("tin_ingot",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SILVER_INGOT = ITEMS.register("silver_ingot",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> TIN_PLATE = ITEMS.register("tin_plate",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> IRON_PLATE = ITEMS.register("iron_plate",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> COPPER_PLATE = ITEMS.register("copper_plate",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> BRONZE_PLATE = ITEMS.register("bronze_plate",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> COMPOSITE_INGOT = ITEMS.register("composite_ingot",
            () -> new Item(new Item.Properties()));
    //Tool

    public static final DeferredItem<Item> HAMMER_TOOL = ITEMS.register("hammer_tool",
            () -> new ToolHammer(new Item.Properties().durability(64)));

    public static final DeferredItem<Item> CUTTER_TOOL = ITEMS.register("cutter_tool",
            () -> new ToolHammer(new Item.Properties().durability(64)));
    //
    public static void  register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
