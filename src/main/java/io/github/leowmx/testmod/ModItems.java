package io.github.leowmx.testmod;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;


public class ModItems {
    // 声明物品对象
    private static void Registry_Item(String modid,String item_name){
        final Item NEWITEM;
        Identifier itemId = Identifier.of(modid,item_name);
        RegistryKey<Item> itemKey = RegistryKey.of(Registries.ITEM.getKey(), itemId);
        Item.Settings settings = new Item.Settings().registryKey(itemKey);
        NEWITEM = new Item(settings);
        Registry.register(Registries.ITEM, itemKey, NEWITEM);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
			content.add(NEWITEM);
		});

    }

    // 初始化方法（供主类调用以触发类加载）
    public static void initialize() {
        Registry_Item("testmod","phone");
        System.out.println("[testmod] ModItems is loaded.");
    }
}