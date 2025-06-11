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

    // Регистрация материала брони
    public static final Holder<net.minecraft.world.item.ArmorMaterial> BRONZE_ARMOR = register("bronze", Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
        map.put(ArmorItem.Type.BOOTS, 2);      // Защита ботинок
        map.put(ArmorItem.Type.LEGGINGS, 5);   // Защита поножей
        map.put(ArmorItem.Type.CHESTPLATE, 6); // Защита нагрудника
        map.put(ArmorItem.Type.HELMET, 2);     // Защита шлема
        map.put(ArmorItem.Type.BODY, 6);       // Защита тела (для лошадей)
    }), () -> ModItem.BRONZE_INGOT.get());

    // Метод для регистрации материала брони
    private static Holder<net.minecraft.world.item.ArmorMaterial> register(String name, EnumMap<ArmorItem.Type, Integer> typeProtection, Supplier<Item> ingredientItem) {

        ResourceLocation location = ResourceLocation.fromNamespaceAndPath(Industrial.MODID, name);
        Holder<SoundEvent> equipSound = SoundEvents.ARMOR_EQUIP_NETHERITE; // Звук надевания брони
        Supplier<Ingredient> ingredient = () -> Ingredient.of(ingredientItem.get());
        List<net.minecraft.world.item.ArmorMaterial.Layer> layers = List.of(new net.minecraft.world.item.ArmorMaterial.Layer(location));

        // Создаем новый EnumMap для защиты
        EnumMap<ArmorItem.Type, Integer> typeMap = new EnumMap<>(ArmorItem.Type.class);
        for (ArmorItem.Type type : ArmorItem.Type.values()) {
            typeMap.put(type, typeProtection.getOrDefault(type, 0));
        }

        // Создаем и регистрируем материал брони
        net.minecraft.world.item.ArmorMaterial armorMaterial = new net.minecraft.world.item.ArmorMaterial(typeMap,           // Защита для каждого типа
                0,    // Зачаровываемость
                equipSound,        // Звук надевания
                ingredient,        // Ингредиент для ремонта
                layers,           // Слои текстур
                0.0f,        // Прочность
                0.0f // Сопротивление отбрасыванию
        );

        return Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL, location, armorMaterial);
    }
}