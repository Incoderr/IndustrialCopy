package net.incoder.industrial.item;

import net.incoder.industrial.Industrial;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ArmorMaterial {


    public static final Holder<net.minecraft.world.item.ArmorMaterial> BRONZE_ARMOR = register("bronze", Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
        map.put(ArmorItem.Type.BOOTS, 2);
        map.put(ArmorItem.Type.LEGGINGS, 5);
        map.put(ArmorItem.Type.CHESTPLATE, 6);
        map.put(ArmorItem.Type.HELMET, 2);
        map.put(ArmorItem.Type.BODY, 6);
    }), () -> ModItem.BRONZE_INGOT.get());


    private static Holder<net.minecraft.world.item.ArmorMaterial> register(String name, EnumMap<ArmorItem.Type, Integer> typeProtection, Supplier<Item> ingredientItem) {

        ResourceLocation location = ResourceLocation.fromNamespaceAndPath(Industrial.MODID, name);
        Holder<SoundEvent> equipSound = SoundEvents.ARMOR_EQUIP_NETHERITE;
        Supplier<Ingredient> ingredient = () -> Ingredient.of(ingredientItem.get());
        List<net.minecraft.world.item.ArmorMaterial.Layer> layers = List.of(new net.minecraft.world.item.ArmorMaterial.Layer(location));


        EnumMap<ArmorItem.Type, Integer> typeMap = new EnumMap<>(ArmorItem.Type.class);
        for (ArmorItem.Type type : ArmorItem.Type.values()) {
            typeMap.put(type, typeProtection.getOrDefault(type, 0));
        }


        net.minecraft.world.item.ArmorMaterial armorMaterial = new net.minecraft.world.item.ArmorMaterial(typeMap,           // Защита для каждого типа
                0,
                equipSound,
                ingredient,
                layers,
                0.0f,
                0.0f
        );

        return Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL, location, armorMaterial);
    }
}