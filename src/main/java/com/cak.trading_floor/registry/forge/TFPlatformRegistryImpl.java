package com.cak.trading_floor.registry.forge;

import com.cak.trading_floor.content.trading_depot.CommonTradingDepotBlock;
import com.cak.trading_floor.content.trading_depot.CommonTradingDepotBlockEntity;
import com.cak.trading_floor.forge.content.depot.TradingDepotBlock;
import com.cak.trading_floor.forge.content.depot.TradingDepotBlockEntity;
import com.cak.trading_floor.registry.TFPlatformRegistry;
import com.tterrag.registrate.builders.BlockEntityBuilder;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class TFPlatformRegistryImpl implements TFPlatformRegistry.TFPlatformRegistryImplementor {

    public static void register() {
        TFPlatformRegistry.PLATFORM = new TFPlatformRegistryImpl();
    }

    public NonNullFunction<BlockBehaviour.Properties, CommonTradingDepotBlock> getTradingDepotBlock() {
        return TradingDepotBlock::new;
    }
    
    public BlockEntityBuilder.BlockEntityFactory<CommonTradingDepotBlockEntity> getTradingDepotBlockEntity() {
        return TradingDepotBlockEntity::new;
    }
    
}
