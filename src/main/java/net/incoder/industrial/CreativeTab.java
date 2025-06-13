package net.incoder.industrial;


import net.incoder.industrial.block.ModBlock;
import net.incoder.industrial.item.*;
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
                        //INGOT
                        output.accept(ModItem.BRONZE_INGOT);
                        output.accept(ModItem.SILVER_INGOT);
                        output.accept(ModItem.TIN_INGOT);
                        output.accept(ModItem.COMPOSITE_INGOT);
                        output.accept(ModItem.LEAD_INGOT);
                        output.accept(ModItem.STEEL_INGOT);
                        //PLATE
                        output.accept(ModItem.TIN_PLATE);
                        output.accept(ModItem.COPPER_PLATE);
                        output.accept(ModItem.IRON_PLATE);
                        output.accept(ModItem.BRONZE_PLATE);
                        output.accept(ModItem.LEAD_PLATE);
                        output.accept(ModItem.GOLD_PLATE);
                        //CASING
                        output.accept(ModItem.TIN_CASING);
                        output.accept(ModItem.IRON_CASING);
                        output.accept(ModItem.BRONZE_CASING);
                        output.accept(ModItem.COPPER_CASING);
                        output.accept(ModItem.GOLD_CASING);
                        output.accept(ModItem.LEAD_CASING);
                        //RAW
                        output.accept(ModItem.RAW_TIN);
                        output.accept(ModItem.RAW_LEAD);
                        output.accept(ModItem.RAW_SILVER);
                        //TOOL
                        output.accept(ModItem.BRONZE_PICKAXE);
                        output.accept(ModItem.BRONZE_AXE);
                        output.accept(ModItem.BRONZE_HOE);
                        output.accept(ModItem.BRONZE_SHOVEL);
                        output.accept(ModItem.BRONZE_SWORD);
                        //
                        output.accept(ModItem.HAMMER_TOOL);
                        output.accept(ModItem.CUTTER_TOOL);
                        output.accept(ModItem.TREETAP);
                        output.accept(ModItem.RUBBER);
                        //
                        //ARMOR
                        output.accept(ModItem.BRONZE_HELMET);
                        output.accept(ModItem.BRONZE_CHESTPLATE);
                        output.accept(ModItem.BRONZE_LEGGINGS);
                        output.accept(ModItem.BRONZE_BOOTS);
                        //BLOCK
                        output.accept(ModBlock.BRONZE_BLOCK);
                        output.accept(ModBlock.TIN_BLOCK);
                        output.accept(ModBlock.LEAD_BLOCK);
                        output.accept(ModBlock.STEEL_BLOCK);
                        output.accept(ModBlock.SILVER_BLOCK);
                        //ORE
                        output.accept(ModBlock.TIN_ORE);
                        output.accept(ModBlock.LEAD_ORE);
                        output.accept(ModBlock.SILVER_ORE);
                        //WOODS
                        output.accept(ModBlock.HEVEA_LOG);
                        output.accept(ModBlock.HEVEA_WOOD);
                        output.accept(ModBlock.STRIPPED_HEVEA_LOG);
                        output.accept(ModBlock.STRIPPED_HEVEA_WOOD);
                        output.accept(ModBlock.HEVEA_PLANKS);
                        output.accept(ModBlock.HEVEA_LEAVES);
                        output.accept(ModBlock.HEVEA_SAPLING);
                        //
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
