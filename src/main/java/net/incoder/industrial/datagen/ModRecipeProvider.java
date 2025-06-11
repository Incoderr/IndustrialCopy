package net.incoder.industrial.datagen;

import net.incoder.industrial.Industrial;
import net.incoder.industrial.block.ModBlock;
import net.incoder.industrial.item.ModItem;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
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
        List<ItemLike> TIN_SMELTABLES = List.of(ModItem.RAW_TIN,
                ModBlock.TIN_ORE);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlock.BRONZE_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItem.BRONZE_INGOT.get())
                .unlockedBy("has_bronze_ingot", has(ModItem.BRONZE_INGOT)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItem.BRONZE_INGOT.get(), 9)
                .requires(ModBlock.BRONZE_BLOCK)
                .unlockedBy("has_bronze_block", has(ModBlock.BRONZE_BLOCK)).save(recipeOutput);

        oreSmelting(recipeOutput, TIN_SMELTABLES, RecipeCategory.MISC, ModItem.TIN_INGOT.get(), 0.25f, 200, "tin_ingot");
        oreBlasting(recipeOutput, TIN_SMELTABLES, RecipeCategory.MISC, ModItem.TIN_INGOT.get(), 0.25f, 100, "tin_ingot");
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