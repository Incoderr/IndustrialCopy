package net.incoder.industrial.item;

import net.incoder.industrial.Industrial;
import net.incoder.industrial.tool.CutterTool;
import net.incoder.industrial.tool.HammerTool;
import net.incoder.industrial.tool.TreeTap;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;


public class ModItem {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Industrial.MODID);
    //INGOT
    public static final DeferredItem<Item> BRONZE_INGOT = ITEMS.register("bronze_ingot",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> TIN_INGOT = ITEMS.register("tin_ingot",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SILVER_INGOT = ITEMS.register("silver_ingot",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> LEAD_INGOT = ITEMS.register("lead_ingot",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> STEEL_INGOT = ITEMS.register("steel_ingot",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> COMPOSITE_INGOT = ITEMS.register("composite_ingot",
            () -> new Item(new Item.Properties()));
    //PLATE
    public static final DeferredItem<Item> TIN_PLATE = ITEMS.register("tin_plate",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> IRON_PLATE = ITEMS.register("iron_plate",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> COPPER_PLATE = ITEMS.register("copper_plate",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> BRONZE_PLATE = ITEMS.register("bronze_plate",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> LEAD_PLATE = ITEMS.register("lead_plate",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> GOLD_PLATE = ITEMS.register("gold_plate",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> STEEL_PLATE = ITEMS.register("steel_plate",
            () -> new Item(new Item.Properties()));
    //CASING
    public static final DeferredItem<Item> IRON_CASING = ITEMS.register("iron_casing",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> TIN_CASING = ITEMS.register("tin_casing",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> COPPER_CASING = ITEMS.register("copper_casing",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> BRONZE_CASING = ITEMS.register("bronze_casing",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> LEAD_CASING = ITEMS.register("lead_casing",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> GOLD_CASING = ITEMS.register("gold_casing",
            () -> new Item(new Item.Properties()));

    //OTHER TOOL
    public static final DeferredItem<Item> HAMMER_TOOL = ITEMS.register("hammer_tool",
            () -> new HammerTool(new Item.Properties().durability(64)));

    public static final DeferredItem<Item> CUTTER_TOOL = ITEMS.register("cutter_tool",
            () -> new CutterTool(new Item.Properties().durability(64)));

    public static final DeferredItem<Item> TREETAP = ITEMS.register("treetap",
            () -> new TreeTap(new Item.Properties().durability(32)));
    //OTHER
    public static final DeferredItem<Item> RUBBER = ITEMS.register("rubber",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> COIL = ITEMS.register("coil",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ELECTRIC_DRIVE = ITEMS.register("electric_drive",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ELECTRICAL_DIAGRAM = ITEMS.register("electrical_diagram",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ELECTRIC_MOTOR = ITEMS.register("electric_motor",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> COMPOSITE = ITEMS.register("composite",
            () -> new Item(new Item.Properties()));
    //TOOL
    public static final DeferredItem<PickaxeItem> BRONZE_PICKAXE = ITEMS.register("bronze_pickaxe", () -> new PickaxeItem(
            ToolTier.BRONZE,
            new Item.Properties().attributes(
                    PickaxeItem.createAttributes(
                            ToolTier.BRONZE,
                            1,
                            -2.8f
                    )
            )
    ));

    public static final DeferredItem<SwordItem> BRONZE_SWORD = ITEMS.register("bronze_sword", () -> new SwordItem(
            ToolTier.BRONZE,
            new Item.Properties().attributes(
                    SwordItem.createAttributes(
                            ToolTier.BRONZE,
                            3,
                            -2.4f
                    )
            )
    ));

    public static final DeferredItem<AxeItem> BRONZE_AXE = ITEMS.register("bronze_axe", () -> new AxeItem(
            ToolTier.BRONZE,
            new Item.Properties().attributes(
                    AxeItem.createAttributes(
                            ToolTier.BRONZE,
                            6f,
                            -3.1f
                    )
            )
    ));

    public static final DeferredItem<ShovelItem> BRONZE_SHOVEL = ITEMS.register("bronze_shovel", () -> new ShovelItem(
            ToolTier.BRONZE,
            new Item.Properties().attributes(
                    ShovelItem.createAttributes(
                            ToolTier.BRONZE,
                            1.5f,
                            -3f
                    )
            )
    ));

    public static final DeferredItem<HoeItem> BRONZE_HOE = ITEMS.register("bronze_hoe", () -> new HoeItem(
            ToolTier.BRONZE,
            new Item.Properties().attributes(
                    HoeItem.createAttributes(
                            ToolTier.BRONZE,
                            -2,
                            -1f
                    )
            )
    ));
    //ARMOR
    public static final DeferredItem<ArmorItem> BRONZE_HELMET = ITEMS.register("bronze_helmet",
            () -> new ArmorItem(ArmorMaterial.BRONZE_ARMOR, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(15))));

    public static final DeferredItem<ArmorItem> BRONZE_CHESTPLATE = ITEMS.register("bronze_chestplate",
            () -> new ArmorItem(ArmorMaterial.BRONZE_ARMOR, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(15))));

    public static final DeferredItem<ArmorItem> BRONZE_LEGGINGS = ITEMS.register("bronze_leggings",
            () -> new ArmorItem(ArmorMaterial.BRONZE_ARMOR, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(15))));

    public static final DeferredItem<ArmorItem> BRONZE_BOOTS = ITEMS.register("bronze_boots",
            () -> new ArmorItem(ArmorMaterial.BRONZE_ARMOR, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(15))));
    //RAW
    public static final DeferredItem<Item> RAW_TIN = ITEMS.register("raw_tin",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RAW_LEAD = ITEMS.register("raw_lead",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RAW_SILVER = ITEMS.register("raw_silver",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RAW_RUBBER = ITEMS.register("raw_rubber",
            () -> new Item(new Item.Properties()));
    //
    public static void  register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
