package io.github.leowmx.testmod.mixin.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientWorld;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class ExampleClientMixin {
	@Inject(method = "setWorld", at = @At("TAIL"))
    private void onWorldSet(ClientWorld world, CallbackInfo ci) {
        // 客户端世界已切换
    }
}