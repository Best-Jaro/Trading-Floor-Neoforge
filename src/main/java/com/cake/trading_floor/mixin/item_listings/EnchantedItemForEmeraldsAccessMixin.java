package com.cake.trading_floor.mixin.item_listings;

import com.cake.trading_floor.compat.jei.virtual_recipes.potential_villager_trade.PotentialMerchantOfferInfo;
import com.cake.trading_floor.foundation.access.ResolvableItemListing;
import net.minecraft.core.RegistryAccess;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import javax.annotation.Nullable;

@Mixin(targets = "net.minecraft.world.entity.npc.VillagerTrades$EnchantedItemForEmeralds")
public class EnchantedItemForEmeraldsAccessMixin implements ResolvableItemListing {
    
    @Shadow @Final private int baseEmeraldCost;
    
    @Shadow @Final private ItemStack itemStack;
    
    @Override
    public @Nullable PotentialMerchantOfferInfo create_trading_floor$resolve(RegistryAccess provider) {
        return new PotentialMerchantOfferInfo(
            Items.EMERALD.getDefaultInstance().copyWithCount(baseEmeraldCost),
            ItemStack.EMPTY,
            itemStack
        ).withImpliedEnchantVariants();
    }
    
}
