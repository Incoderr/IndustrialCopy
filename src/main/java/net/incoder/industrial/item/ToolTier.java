package net.incoder.industrial.item;

import net.incoder.industrial.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;


public class ToolTier {
    public static final Tier BRONZE = new SimpleTier(

            ModTags.Blocks.INCORRECT_FOR_BRONZE_TOOL,

            200,

            5f,

            1.5f,

            20,

            () -> Ingredient.of(ModItem.BRONZE_INGOT.get())
    );
}
