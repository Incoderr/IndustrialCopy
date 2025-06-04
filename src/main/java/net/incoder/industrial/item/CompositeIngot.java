package net.incoder.industrial.item;

import net.incoder.industrial.Industrial;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CompositeIngot {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Industrial.MODID);

    public static final DeferredItem<Item> COMPOSITE_INGOT = ITEMS.register("composite_ingot",
            () -> new Item(new Item.Properties()));

    public static void  register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
