package net.incoder.industrial.worldgen.tree;

import net.incoder.industrial.Industrial;
import net.incoder.industrial.worldgen.ModConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class ModTreeGrows {
    public static final TreeGrower HEVEA = new TreeGrower(Industrial.MODID + ":hevea",
            Optional.empty(), Optional.of(ModConfiguredFeatures.HEVEA_KEY), Optional.empty());
}
