package net.incoder.industrial.datagen;

import net.incoder.industrial.Industrial;
import net.incoder.industrial.block.ModBlock;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Industrial.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlock.BRONZE_BLOCK.get())
                .add(ModBlock.TIN_BLOCK.get())
                .add(ModBlock.LEAD_BLOCK.get())
                .add(ModBlock.STEEL_BLOCK.get())
                .add(ModBlock.SILVER_BLOCK.get())

                .add(ModBlock.TIN_ORE.get())
                .add(ModBlock.LEAD_ORE.get())
                .add(ModBlock.SILVER_ORE.get());

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlock.HEVEA_LOG.get())
                .add(ModBlock.HEVEA_WOOD.get())
                .add(ModBlock.STRIPPED_HEVEA_LOG.get())
                .add(ModBlock.STRIPPED_HEVEA_WOOD.get());
    }
}
