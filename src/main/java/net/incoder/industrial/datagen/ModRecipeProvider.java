package net.incoder.industrial.datagen;

import net.incoder.industrial.Industrial;
import net.incoder.industrial.block.ModBlock;
import net.incoder.industrial.item.ModItem;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        //SMELTABLES
        List<ItemLike> TIN_SMELTABLES = List.of(ModItem.RAW_TIN,
                ModBlock.TIN_ORE);

        List<ItemLike> LEAD_SMELTABLES = List.of(ModItem.RAW_LEAD,
                ModBlock.LEAD_ORE);

        List<ItemLike> SILVER_SMELTABLES = List.of(ModItem.RAW_SILVER,
                ModBlock.SILVER_ORE);
        //PLATE
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItem.BRONZE_PLATE.get())
                .requires(ModItem.BRONZE_INGOT.get())
                .requires(ModItem.HAMMER_TOOL.get())
                .unlockedBy("has_bronze_ingot", has(ModItem.BRONZE_INGOT))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItem.TIN_PLATE.get())
                .requires(ModItem.TIN_INGOT.get())
                .requires(ModItem.HAMMER_TOOL.get())
                .unlockedBy("has_tin_ingot", has(ModItem.TIN_INGOT))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItem.COPPER_PLATE.get())
                .requires(Items.COPPER_INGOT)
                .requires(ModItem.HAMMER_TOOL.get())
                .unlockedBy("has_copper_ingot", has(Items.COPPER_INGOT))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItem.GOLD_PLATE.get())
                .requires(Items.GOLD_INGOT)
                .requires(ModItem.HAMMER_TOOL.get())
                .unlockedBy("has_gold_ingot", has(Items.GOLD_INGOT))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItem.LEAD_PLATE.get())
                .requires(ModItem.LEAD_INGOT.get())
                .requires(ModItem.HAMMER_TOOL.get())
                .unlockedBy("has_lead_ingot", has(ModItem.LEAD_INGOT))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItem.IRON_PLATE.get())
                .requires(Items.IRON_INGOT)
                .requires(ModItem.HAMMER_TOOL.get())
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .save(recipeOutput);
        //CASING
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItem.BRONZE_CASING.get(), 2)
                .requires(ModItem.BRONZE_PLATE.get())
                .requires(ModItem.HAMMER_TOOL.get())
                .unlockedBy("has_bronze_ingot", has(ModItem.BRONZE_INGOT))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItem.TIN_CASING.get(), 2)
                .requires(ModItem.TIN_PLATE.get())
                .requires(ModItem.HAMMER_TOOL.get())
                .unlockedBy("has_tin_ingot", has(ModItem.TIN_INGOT))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItem.COPPER_CASING.get(), 2)
                .requires(ModItem.COPPER_PLATE.get())
                .requires(ModItem.HAMMER_TOOL.get())
                .unlockedBy("has_copper_ingot", has(Items.COPPER_INGOT))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItem.GOLD_CASING.get(), 2)
                .requires(ModItem.GOLD_PLATE.get())
                .requires(ModItem.HAMMER_TOOL.get())
                .unlockedBy("has_gold_ingot", has(Items.GOLD_INGOT))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItem.LEAD_CASING.get(), 2)
                .requires(ModItem.LEAD_PLATE.get())
                .requires(ModItem.HAMMER_TOOL.get())
                .unlockedBy("has_lead_ingot", has(ModItem.LEAD_INGOT))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItem.IRON_CASING.get(), 2)
                .requires(ModItem.IRON_PLATE.get())
                .requires(ModItem.HAMMER_TOOL.get())
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .save(recipeOutput);
        //
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItem.COMPOSITE_INGOT.get(), 2)
                .pattern("111")
                .pattern("222")
                .pattern("333")
                .define('1', ModItem.IRON_PLATE.get())
                .define('2', ModItem.BRONZE_PLATE.get())
                .define('3', ModItem.TIN_PLATE.get())
                .unlockedBy("has_iron_plate", has(ModItem.IRON_PLATE))
                .unlockedBy("has_bronze_plate", has(ModItem.BRONZE_PLATE))
                .unlockedBy("has_tin_plate", has(ModItem.TIN_PLATE))
                .save(recipeOutput);
        //
        //BLOCK
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlock.BRONZE_BLOCK.get())
                .pattern("111")
                .pattern("111")
                .pattern("111")
                .define('1', ModItem.BRONZE_INGOT.get())
                .unlockedBy("has_bronze_ingot", has(ModItem.BRONZE_INGOT))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItem.BRONZE_INGOT.get(), 9)
                .requires(ModBlock.BRONZE_BLOCK)
                .unlockedBy("has_bronze_block", has(ModBlock.BRONZE_BLOCK))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlock.TIN_BLOCK.get())
                .pattern("111")
                .pattern("111")
                .pattern("111")
                .define('1', ModItem.TIN_INGOT.get())
                .unlockedBy("has_tin_ingot", has(ModItem.TIN_INGOT))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItem.TIN_INGOT.get(), 9)
                .requires(ModBlock.TIN_BLOCK)
                .unlockedBy("has_tin_block", has(ModBlock.TIN_BLOCK))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlock.STEEL_BLOCK.get())
                .pattern("111")
                .pattern("111")
                .pattern("111")
                .define('1', ModItem.STEEL_INGOT.get())
                .unlockedBy("has_steel_ingot", has(ModItem.STEEL_INGOT))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItem.STEEL_INGOT.get(), 9)
                .requires(ModBlock.STEEL_BLOCK)
                .unlockedBy("has_steel_block", has(ModBlock.STEEL_BLOCK))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlock.SILVER_BLOCK.get())
                .pattern("111")
                .pattern("111")
                .pattern("111")
                .define('1', ModItem.SILVER_INGOT.get())
                .unlockedBy("has_silver_ingot", has(ModItem.SILVER_INGOT))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItem.SILVER_INGOT.get(), 9)
                .requires(ModBlock.SILVER_BLOCK)
                .unlockedBy("has_silver_block", has(ModBlock.SILVER_BLOCK))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlock.LEAD_BLOCK.get())
                .pattern("111")
                .pattern("111")
                .pattern("111")
                .define('1', ModItem.LEAD_INGOT.get())
                .unlockedBy("has_lead_ingot", has(ModItem.LEAD_INGOT))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItem.LEAD_INGOT.get(), 9)
                .requires(ModBlock.LEAD_BLOCK)
                .unlockedBy("has_lead_block", has(ModBlock.LEAD_BLOCK))
                .save(recipeOutput);

        //TOOL
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItem.BRONZE_PICKAXE.get())
                .pattern("111")
                .pattern(" 2 ")
                .pattern(" 2 ")
                .define('1', ModItem.BRONZE_INGOT.get())
                .define('2', Items.STICK)
                .unlockedBy("has_bronze_ingot", has(ModItem.BRONZE_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItem.BRONZE_AXE.get())
                .pattern("11 ")
                .pattern("12 ")
                .pattern(" 2 ")
                .define('1', ModItem.BRONZE_INGOT.get())
                .define('2', Items.STICK)
                .unlockedBy("has_bronze_ingot", has(ModItem.BRONZE_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItem.BRONZE_SHOVEL.get())
                .pattern(" 1 ")
                .pattern(" 2 ")
                .pattern(" 2 ")
                .define('1', ModItem.BRONZE_INGOT.get())
                .define('2', Items.STICK)
                .unlockedBy("has_bronze_ingot", has(ModItem.BRONZE_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItem.BRONZE_SWORD.get())
                .pattern(" 1 ")
                .pattern(" 1 ")
                .pattern(" 2 ")
                .define('1', ModItem.BRONZE_INGOT.get())
                .define('2', Items.STICK)
                .unlockedBy("has_bronze_ingot", has(ModItem.BRONZE_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItem.BRONZE_HOE.get())
                .pattern("11 ")
                .pattern(" 2 ")
                .pattern(" 2 ")
                .define('1', ModItem.BRONZE_INGOT.get())
                .define('2', Items.STICK)
                .unlockedBy("has_bronze_ingot", has(ModItem.BRONZE_INGOT))
                .save(recipeOutput);
        //
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItem.HAMMER_TOOL.get())
                .pattern(" 22")
                .pattern("112")
                .pattern(" 22")
                .define('1', Items.STICK)
                .define('2', Items.IRON_INGOT)
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItem.CUTTER_TOOL.get())
                .pattern("1 1")
                .pattern(" 1 ")
                .pattern("2 2")
                .define('1', ModItem.IRON_PLATE.get())
                .define('2', Items.IRON_INGOT)
                .unlockedBy("has_bronze_ingot", has(ModItem.BRONZE_INGOT))
                .save(recipeOutput);
        //
        //ARMOR
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItem.BRONZE_HELMET.get())
                .pattern("111")
                .pattern("1 1")
                .pattern("   ")
                .define('1', ModItem.BRONZE_INGOT.get())
                .unlockedBy("has_bronze_ingot", has(ModItem.BRONZE_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItem.BRONZE_CHESTPLATE.get())
                .pattern("1 1")
                .pattern("111")
                .pattern("111")
                .define('1', ModItem.BRONZE_INGOT.get())
                .unlockedBy("has_bronze_ingot", has(ModItem.BRONZE_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItem.BRONZE_LEGGINGS.get())
                .pattern("111")
                .pattern("1 1")
                .pattern("1 1")
                .define('1', ModItem.BRONZE_INGOT.get())
                .unlockedBy("has_bronze_ingot", has(ModItem.BRONZE_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItem.BRONZE_BOOTS.get())
                .pattern("   ")
                .pattern("1 1")
                .pattern("1 1")
                .define('1', ModItem.BRONZE_INGOT.get())
                .unlockedBy("has_bronze_ingot", has(ModItem.BRONZE_INGOT))
                .save(recipeOutput);

        //

        oreSmelting(recipeOutput, TIN_SMELTABLES, RecipeCategory.MISC, ModItem.TIN_INGOT.get(), 0.25f, 200, "tin_ingot");
        oreBlasting(recipeOutput, TIN_SMELTABLES, RecipeCategory.MISC, ModItem.TIN_INGOT.get(), 0.25f, 100, "tin_ingot");

        oreSmelting(recipeOutput, LEAD_SMELTABLES, RecipeCategory.MISC, ModItem.LEAD_INGOT.get(), 0.25f, 200, "lead_ingot");
        oreBlasting(recipeOutput, LEAD_SMELTABLES, RecipeCategory.MISC, ModItem.LEAD_INGOT.get(), 0.25f, 100, "lead_ingot");

        oreSmelting(recipeOutput, SILVER_SMELTABLES, RecipeCategory.MISC, ModItem.SILVER_INGOT.get(), 0.25f, 200, "silver_ingot");
        oreBlasting(recipeOutput, SILVER_SMELTABLES, RecipeCategory.MISC, ModItem.SILVER_INGOT.get(), 0.25f, 100, "silver_ingot");
    }


    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> ingredients, RecipeCategory category, ItemLike result,
                                      float experience, int cookingTime, String group) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, ingredients, category, result,
                experience, cookingTime, group, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> ingredients, RecipeCategory category, ItemLike result,
                                      float experience, int cookingTime, String group) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, ingredients, category, result,
                experience, cookingTime, group, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> cookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> ingredients, RecipeCategory category, ItemLike result, float experience, int cookingTime, String group, String recipeName) {
        for (ItemLike itemlike : ingredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), category, result, experience, cookingTime, cookingSerializer, factory)
                    .group(group)
                    .unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, Industrial.MODID + ":" + getItemName(result) + recipeName + "_" + getItemName(itemlike));
        }
    }
}