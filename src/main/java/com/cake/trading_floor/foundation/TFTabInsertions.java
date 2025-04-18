package com.cake.trading_floor.foundation;

import com.cake.trading_floor.registry.TFRegistry;
import com.simibubi.create.AllBlocks;
import com.tterrag.registrate.util.entry.ItemProviderEntry;
import net.minecraft.world.item.Item;

import java.util.HashMap;
import java.util.Map;

public class TFTabInsertions {
    private static Map<Item, Item> INSERTS_AFTER = null;
    
    public static final Map<ItemProviderEntry<?, ?>, ItemProviderEntry<?, ?>> REGISTRY_INSERTS_AFTER = Map.of(
        AllBlocks.DEPOT, TFRegistry.TRADING_DEPOT
    );
    
    public static Map<Item, Item> getAllInsertsAfter() {
        if (INSERTS_AFTER != null) {
            return INSERTS_AFTER;
        }
        
        INSERTS_AFTER = new HashMap<>();
        for (Map.Entry<ItemProviderEntry<?, ?>, ItemProviderEntry<?, ?>> entry : REGISTRY_INSERTS_AFTER.entrySet()) {
            INSERTS_AFTER.put(entry.getKey().asItem(), entry.getValue().asItem());
        }
        return INSERTS_AFTER;
    }
}
