package net.incoder.industrial.datagen;

import net.incoder.industrial.Industrial;
import net.incoder.industrial.block.ModBlock;
import net.incoder.industrial.block.custom.ModFlammableRotatedPillarBlock;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.minecraft.core.Direction;

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
        blockWithItem(ModBlock.URAN_ORE);

        blockWithItem(ModBlock.DEEPSLATE_TIN_ORE);
        blockWithItem(ModBlock.DEEPSLATE_LEAD_ORE);
        blockWithItem(ModBlock.DEEPSLATE_SILVER_ORE);
        blockWithItem(ModBlock.DEEPSLATE_URAN_ORE);

        blockWithItem(ModBlock.IRON_FURNACE);

        blockItem(ModBlock.HEVEA_LOG, "_rubber_false");
        blockItem(ModBlock.HEVEA_WOOD);
        blockItem(ModBlock.STRIPPED_HEVEA_LOG);
        blockItem(ModBlock.STRIPPED_HEVEA_WOOD);

        blockWithItem(ModBlock.HEVEA_PLANKS);

        logBlockWithRubber(ModBlock.HEVEA_LOG);
        axisBlock(((RotatedPillarBlock) ModBlock.HEVEA_WOOD.get()),
                ResourceLocation.fromNamespaceAndPath(Industrial.MODID, "block/hevea_wood"));

        logBlock(((RotatedPillarBlock) ModBlock.STRIPPED_HEVEA_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlock.STRIPPED_HEVEA_WOOD.get()), blockTexture(ModBlock.STRIPPED_HEVEA_LOG.get()), blockTexture(ModBlock.STRIPPED_HEVEA_LOG.get()));

        leavesBlock(ModBlock.HEVEA_LEAVES);
        saplingBlock(ModBlock.HEVEA_SAPLING);

        blockWithItem(ModBlock.MACHINE_BODY);
        blockWithItem(ModBlock.IMPROVED_MACHINE_BODY);

        blockWithItem(ModBlock.REINFORCED_GLASS);

        blockWithItem(ModBlock.COPPER_WIRE);

    }

    private void logBlockWithRubber(DeferredBlock<Block> blockRegistryObject) {
        Block block = blockRegistryObject.get();
        String path = BuiltInRegistries.BLOCK.getKey(block).getPath();

        ResourceLocation sideTexture = ResourceLocation.fromNamespaceAndPath(Industrial.MODID, "block/" + path);
        ResourceLocation endTexture = ResourceLocation.fromNamespaceAndPath(Industrial.MODID, "block/" + path + "_top");
        ResourceLocation rubberTexture = ResourceLocation.fromNamespaceAndPath(Industrial.MODID, "block/" + path + "_rubber");


        ModelFile noRubberModel = models().withExistingParent(path + "_rubber_false", "minecraft:block/cube_column")
                .texture("end", endTexture)
                .texture("side", sideTexture)
                .renderType("cutout");


        ModelFile[] rubberModels = new ModelFile[4];
        for (int i = 0; i < 4; i++) {
            rubberModels[i] = models().withExistingParent(path + "_rubber_true_side_" + i, "minecraft:block/orientable")
                    .texture("top", endTexture)
                    .texture("bottom", endTexture)
                    .texture("side", sideTexture)
                    .texture("front", rubberTexture)
                    .renderType("cutout");
        }

        getVariantBuilder(block).forAllStates(state -> {
            boolean hasRubber = state.getValue(ModFlammableRotatedPillarBlock.RUBBER);
            int rubberSide = state.getValue(ModFlammableRotatedPillarBlock.RUBBER_SIDE);
            Direction.Axis axis = state.getValue(RotatedPillarBlock.AXIS);

            ModelFile model;
            int rotationX = 0;
            int rotationY = 0;

            if (hasRubber) {
                model = rubberModels[rubberSide];


                switch (axis) {
                    case Y:
                        rotationX = 0;
                        rotationY = rubberSide * 90;
                        break;
                    case X:
                        rotationX = 90;
                        rotationY = 90 + rubberSide * 90;
                        break;
                    case Z:
                        rotationX = 90;
                        rotationY = rubberSide * 90;
                        break;
                }
            } else {
                model = noRubberModel;


                switch (axis) {
                    case Y:
                        rotationX = 0;
                        rotationY = 0;
                        break;
                    case X:
                        rotationX = 90;
                        rotationY = 90;
                        break;
                    case Z:
                        rotationX = 90;
                        rotationY = 0;
                        break;
                }
            }

            return ConfiguredModel.builder()
                    .modelFile(model)
                    .rotationX(rotationX)
                    .rotationY(rotationY)
                    .build();
        });
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
