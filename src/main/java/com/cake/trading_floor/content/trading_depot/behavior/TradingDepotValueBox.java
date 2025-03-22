package com.cake.trading_floor.content.trading_depot.behavior;

import com.simibubi.create.foundation.blockEntity.behaviour.ValueBoxTransform;
import net.createmod.catnip.math.VecHelper;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import static net.minecraft.world.level.block.HorizontalDirectionalBlock.FACING;

public class TradingDepotValueBox extends ValueBoxTransform.Sided {
    
    @Override
    protected boolean isSideActive(BlockState state, Direction direction) {
        if (direction == state.getValue(FACING).getOpposite()) return false;
        return direction.getAxis().isHorizontal();
    }
    
    @Override
    protected Vec3 getSouthLocation() {
        return VecHelper.voxelSpace(8, 4, 16.05);
    }
    
}
