package net.incoder.industrial.item;

import net.incoder.industrial.Industrial;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class TinPlate {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Industrial.MODID);

    public static final DeferredItem<Item> TIN_PLATE = ITEMS.register("tin_plate",
            () -> new Item(new Item.Properties()));

    public static void  register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
