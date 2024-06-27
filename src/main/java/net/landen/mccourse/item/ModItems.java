package net.landen.mccourse.item;

import net.fabricmc.fabric.api.item.v1.EquipmentSlotProvider;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.landen.mccourse.MCCourseMod;
import net.landen.mccourse.block.ModBlocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
    // "=" is initializing the object,
    public static final Item PINK_GARNET = registerItem("pink_garnet",
            new Item(new FabricItemSettings()));
    public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet",
            new Item(new FabricItemSettings()));
    public static final Item SUSPICIOUS_KEY = registerItem("suspicious_key",
            new Item(new FabricItemSettings()));

    // cleans up code through registering item more efficiently
    private static Item registerItem(String name, Item item) {
        // accessing register class with Registry, .register is accessing a method within the Registry class, () indicate parameters of register
        // .ITEM is a variable within the class Registries; it is all caps because it is a static final variable
        // new Identifier is creating a new "Identifier" object
        // Registry.register method takes in a Registry, identifier, and entry; returns type ITEM due to Registries.ITEM, Identifier gives its custom id in the game
        return Registry.register(Registries.ITEM, new Identifier(MCCourseMod.MOD_ID, name), item);
    }

    // adds objects to a list
    private static void itemGroupIngredients(FabricItemGroupEntries entries) {
        entries.add(PINK_GARNET);
        entries.add(RAW_PINK_GARNET);

        entries.add(ModBlocks.PINK_GARNET_BLOCK);
        entries.add(ModBlocks.RAW_PINK_GARNET_BLOCK);
    }

    // adds the list of entries in itemGroupIngredients to the creative tab ingredients
    public static void registerModItems() {
        MCCourseMod.LOGGER.info("Registering Mod Items for " + MCCourseMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::itemGroupIngredients);
    }
}
