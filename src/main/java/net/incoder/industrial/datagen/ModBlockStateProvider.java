package net.incoder.industrial.datagen;

import net.incoder.industrial.Industrial;
import net.incoder.industrial.block.ModBlock;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Industrial.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlock.BRONZE_BLOCK);
        blockWithItem(ModBlock.SILVER_BLOCK);
        blockWithItem(ModBlock.STEEL_BLOCK);
        blockWithItem(ModBlock.TIN_BLOCK);
        blockWithItem(ModBlock.LEAD_BLOCK);

        blockWithItem(ModBlock.TIN_ORE);
        blockWithItem(ModBlock.LEAD_ORE);
        blockWithItem(ModBlock.SILVER_ORE);


        blockItem(ModBlock.HEVEA_LOG);
        blockItem(ModBlock.HEVEA_WOOD);
        blockItem(ModBlock.STRIPPED_HEVEA_LOG);
        blockItem(ModBlock.STRIPPED_HEVEA_WOOD);

        blockWithItem(ModBlock.HEVEA_PLANKS);

        logBlock(((RotatedPillarBlock) ModBlock.HEVEA_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlock.HEVEA_WOOD.get()), blockTexture(ModBlock.HEVEA_LOG.get()));

        logBlock(((RotatedPillarBlock) ModBlock.STRIPPED_HEVEA_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlock.STRIPPED_HEVEA_WOOD.get()), blockTexture(ModBlock.STRIPPED_HEVEA_LOG.get()), blockTexture(ModBlock.STRIPPED_HEVEA_LOG.get()));

        leavesBlock(ModBlock.HEVEA_LEAVES);
        saplingBlock(ModBlock.HEVEA_SAPLING);
    }

    private void saplingBlock(DeferredBlock<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void leavesBlock(DeferredBlock<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(), ResourceLocation.parse("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("industrial:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("industrial:block/" + deferredBlock.getId().getPath() + appendix));
    }
}
