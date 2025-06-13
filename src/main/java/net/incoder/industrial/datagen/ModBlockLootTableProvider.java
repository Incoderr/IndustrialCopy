package net.incoder.industrial.datagen;

import net.incoder.industrial.block.ModBlock;
import net.incoder.industrial.item.ModItem;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.neoforged.fml.common.Mod;


import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {

    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlock.BRONZE_BLOCK.get());
        dropSelf(ModBlock.TIN_BLOCK.get());
        dropSelf(ModBlock.LEAD_BLOCK.get());
        dropSelf(ModBlock.SILVER_BLOCK.get());
        dropSelf(ModBlock.STEEL_BLOCK.get());

        add(ModBlock.TIN_ORE.get(), block -> createTinOreDrop(ModBlock.TIN_ORE.get(), ModItem.RAW_TIN.get()));
        add(ModBlock.LEAD_ORE.get(), block -> createTinOreDrop(ModBlock.LEAD_ORE.get(), ModItem.RAW_LEAD.get()));
        add(ModBlock.SILVER_ORE.get(), block -> createTinOreDrop(ModBlock.SILVER_ORE.get(), ModItem.RAW_SILVER.get()));

        this.dropSelf(ModBlock.HEVEA_LOG.get());
        this.dropSelf(ModBlock.HEVEA_WOOD.get());
        this.dropSelf(ModBlock.STRIPPED_HEVEA_LOG.get());
        this.dropSelf(ModBlock.STRIPPED_HEVEA_WOOD.get());
        this.dropSelf(ModBlock.HEVEA_PLANKS.get());
        this.dropSelf(ModBlock.HEVEA_SAPLING.get());

        this.add(ModBlock.HEVEA_LEAVES.get(), block ->
           createLeavesDrops(block, ModBlock.HEVEA_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
    }

    protected LootTable.Builder createTinOreDrop(Block block, Item item) {
        HolderLookup.RegistryLookup<Enchantment> registryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return createSilkTouchDispatchTable(block,
                this.applyExplosionDecay(block,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))) // Без удачи — 1 единица
                                .apply(ApplyBonusCount.addOreBonusCount(registryLookup.getOrThrow(Enchantments.FORTUNE))) // Увеличение с удачей
                )
        );
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlock.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
