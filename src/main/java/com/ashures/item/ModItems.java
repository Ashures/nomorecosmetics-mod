package com.ashures.item;

import com.ashures.NoMoreCosmetics;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item DEVIL_HORNS = registerItem("devil_horns", new ArmorItem(ArmorMaterials.CHAIN, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item ANGEL_HALO = registerItem("angel_halo", new ArmorItem(ArmorMaterials.CHAIN, ArmorItem.Type.HELMET, new FabricItemSettings()));

    // To add a different type of item (for example, Ingredient) create a new method for that new type.
    private static void addItemsToCombatItemGroup(FabricItemGroupEntries entries) {
        entries.add(DEVIL_HORNS);
        entries.add(ANGEL_HALO);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(NoMoreCosmetics.MOD_ID, name), item);
    }

    public static void registerModItems() {
        NoMoreCosmetics.LOGGER.info("Registering Mod Items for " + NoMoreCosmetics.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemsToCombatItemGroup);
    }
}
