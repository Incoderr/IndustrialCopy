package net.incoder.industrial.entity;

import net.incoder.industrial.Industrial;
import net.incoder.industrial.block.ModBlock;
import net.incoder.industrial.block.entity.IronFurnaceEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, Industrial.MODID);
    //
    public static final Supplier<BlockEntityType<IronFurnaceEntity>> IRON_FURNACE_BE =
            BLOCK_ENTITIES.register("iron_furnace_be", () -> BlockEntityType.Builder.of(
                    IronFurnaceEntity::new, ModBlock.IRON_FURNACE.get()).build(null));
    //
    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
