package net.incoder.industrial.datagen;

import net.incoder.industrial.Industrial;
import net.incoder.industrial.block.ModBlock;
import net.incoder.industrial.item.ModItem;
import net.incoder.industrial.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, Industrial.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItem.BRONZE_INGOT.get());

        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlock.HEVEA_LOG.get().asItem())
                .add(ModBlock.HEVEA_WOOD.get().asItem())
                .add(ModBlock.STRIPPED_HEVEA_LOG.get().asItem())
                .add(ModBlock.STRIPPED_HEVEA_WOOD.get().asItem());

        this.tag(ItemTags.PLANKS)
                .add(ModBlock.HEVEA_PLANKS.asItem());

    }
}
