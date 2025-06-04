package net.incoder.industrial;

import net.incoder.industrial.block.BronzeBlock;
import net.incoder.industrial.item.*;
import net.incoder.industrial.tool.ToolHammer;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class CreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Industrial.MODID);

    public static final Supplier<CreativeModeTab> BRONZE_TAB = CREATIVE_MODE_TAB.register("bronze_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItem.BRONZE_INGOT.get()))
                    .title(Component.translatable("creativetab.industrial.bronze_ingot"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItem.BRONZE_INGOT);
                        output.accept(ModItem.SILVER_INGOT);
                        output.accept(ModItem.TIN_INGOT);
                        output.accept(ModItem.COMPOSITE_INGOT);
                        output.accept(ModItem.TIN_PLATE);
                        output.accept(ModItem.COPPER_PLATE);
                        output.accept(ModItem.IRON_PLATE);
                        output.accept(ModItem.BRONZE_PLATE);
                        output.accept(ModItem.HAMMER_TOOL);
                        output.accept(ModItem.CUTTER_TOOL);

                        output.accept(BronzeBlock.BRONZE_BLOCK);
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
