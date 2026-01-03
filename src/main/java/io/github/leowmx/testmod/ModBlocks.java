package io.github.leowmx.testmod;

import net.fabricmc.fabric.api.block.v1.FabricBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.AbstractBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    private static void registerBlocks(String modid, String block_name) {
        final Block NEWBLOCK;
        Identifier blockId = Identifier.of(modid, block_name);
        RegistryKey<Block> blockKey = RegistryKey.of(Registries.BLOCK.getKey(), blockId);
        RegistryKey<Item> itemKey = RegistryKey.of(Registries.ITEM.getKey(), blockId);
        NEWBLOCK = new LaptopBlock(Block.Settings.copy(Blocks.IRON_BLOCK).registryKey(blockKey));
        Registry.register(Registries.BLOCK, blockKey, NEWBLOCK);
        Registry.register(Registries.ITEM, itemKey, new BlockItem(NEWBLOCK, new Item.Settings().registryKey(itemKey)));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(content ->{
            content.add(NEWBLOCK);
        });
    }

    public static void initialize() {
        registerBlocks("testmod", "laptop");
        System.out.println("[testmod] ModBlocks is loaded.");
    }

}