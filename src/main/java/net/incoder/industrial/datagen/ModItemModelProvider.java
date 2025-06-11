package net.incoder.industrial.datagen;

import net.incoder.industrial.Industrial;
import net.incoder.industrial.item.ModItem;
import net.minecraft.data.PackOutput;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

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

        basicItem(ModItem.HAMMER_TOOL.get());
        basicItem(ModItem.CUTTER_TOOL.get());
    }
}
