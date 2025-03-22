package com.cake.trading_floor.mixin;

import com.cake.trading_floor.foundation.TFTabInsertions;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;
import java.util.function.Function;

@Mixin(remap = false, targets = "com.simibubi.create.AllCreativeModeTabs$RegistrateDisplayItemsGenerator")
public class CreateCreativeModeTabMixin {

    @Inject(method = "makeVisibilityFunc", order = 600, at = @At(value = "RETURN"), cancellable = true)
    private static void outputAll(CallbackInfoReturnable<Function<Item, CreativeModeTab.TabVisibility>> cir) {
        Function<Item, CreativeModeTab.TabVisibility> wrappedFunc = cir.getReturnValue();
        cir.setReturnValue((item) -> {
            if (TFTabInsertions.getAllInsertsAfter().values().contains(item)) {
                return CreativeModeTab.TabVisibility.PARENT_TAB_ONLY;
            }
            return wrappedFunc.apply(item);
        });
    }

    @Inject(method = "applyOrderings", order = 600, at = @At(value = "TAIL"))
    private static void outputAll(List<Item> items, List<?> orderings, CallbackInfo ci) {
        for (int i = 0; i < items.size(); i++) {
            if (TFTabInsertions.getAllInsertsAfter().containsKey(items.get(i))) {
                items.add(i, TFTabInsertions.getAllInsertsAfter().get(items.get(i)));
                i++;
            }
        }
    }
    
}

