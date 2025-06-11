package net.incoder.industrial.tool;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class HammerTool extends Item {
    public HammerTool(Properties properties) {
        super(properties.durability(64));
    }
    @Override
    public ItemStack getCraftingRemainingItem(ItemStack itemStack) {

        ItemStack damagedHammer = itemStack.copy();
        damagedHammer.setDamageValue(damagedHammer.getDamageValue() + 1);

        if (damagedHammer.getDamageValue() >= damagedHammer.getMaxDamage()) {
            return ItemStack.EMPTY;
        }

        return damagedHammer;
    }

    @Override
    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return true;
    }
}
