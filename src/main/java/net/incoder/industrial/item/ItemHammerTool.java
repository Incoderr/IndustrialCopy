package net.incoder.industrial.item;

import net.incoder.industrial.Industrial;
import net.incoder.industrial.tool.ToolHammer;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemHammerTool {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Industrial.MODID);

    public static final DeferredItem<Item> HAMMER_TOOL = ITEMS.register("hammer_tool",
            () -> new ToolHammer(new Item.Properties().durability(64)));

    public static void  register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
