package net.incoder.industrial.block;

import net.incoder.industrial.Industrial;
import net.incoder.industrial.item.Bronze;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BronzeBlock {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(Industrial.MODID);

    public static final DeferredBlock<Block> BRONZE_BLOCK = registerBlock("bronze_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(5f).requiresCorrectToolForDrops()));

    private static <T extends Block> DeferredBlock <T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name,block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void  registerBlockItem(String name, DeferredBlock<T> block) {
        Bronze.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
