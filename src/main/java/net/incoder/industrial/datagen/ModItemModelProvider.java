package net.incoder.industrial.datagen;

import net.incoder.industrial.Industrial;
import net.incoder.industrial.block.ModBlock;
import net.incoder.industrial.item.ModItem;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Industrial.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItem.BRONZE_INGOT.get());
        basicItem(ModItem.TIN_INGOT.get());
        basicItem(ModItem.LEAD_INGOT.get());
        basicItem(ModItem.COMPOSITE_INGOT.get());
        basicItem(ModItem.SILVER_INGOT.get());
        basicItem(ModItem.STEEL_INGOT.get());

        basicItem(ModItem.BRONZE_BOOTS.get());
        basicItem(ModItem.BRONZE_HELMET.get());
        basicItem(ModItem.BRONZE_CHESTPLATE.get());
        basicItem(ModItem.BRONZE_LEGGINGS.get());

        basicItem(ModItem.BRONZE_AXE.get());
        basicItem(ModItem.BRONZE_HOE.get());
        basicItem(ModItem.BRONZE_SHOVEL.get());
        basicItem(ModItem.BRONZE_PICKAXE.get());
        basicItem(ModItem.BRONZE_SWORD.get());

        basicItem(ModItem.BRONZE_PLATE.get());
        basicItem(ModItem.TIN_PLATE.get());
        basicItem(ModItem.LEAD_PLATE.get());
        basicItem(ModItem.GOLD_PLATE.get());
        basicItem(ModItem.IRON_PLATE.get());
        basicItem(ModItem.COPPER_PLATE.get());

        basicItem(ModItem.TIN_CASING.get());
        basicItem(ModItem.LEAD_CASING.get());
        basicItem(ModItem.GOLD_CASING.get());
        basicItem(ModItem.COPPER_CASING.get());
        basicItem(ModItem.IRON_CASING.get());
        basicItem(ModItem.BRONZE_CASING.get());

        basicItem(ModItem.RAW_TIN.get());
        basicItem(ModItem.RAW_LEAD.get());
        basicItem(ModItem.RAW_SILVER.get());

        basicItem(ModItem.HAMMER_TOOL.get());
        basicItem(ModItem.CUTTER_TOOL.get());

        saplingItem(ModBlock.HEVEA_SAPLING);

        basicItem(ModItem.TREETAP.get());
        basicItem(ModItem.RUBBER.get());
    }
    private ItemModelBuilder saplingItem(DeferredBlock<Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(Industrial.MODID,"block/" + item.getId().getPath()));
    }
}
