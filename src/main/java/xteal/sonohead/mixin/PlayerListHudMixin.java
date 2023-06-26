package xteal.sonohead.mixin;

import net.minecraft.client.gui.hud.PlayerListHud;
import net.minecraft.network.ClientConnection;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(PlayerListHud.class)
public class PlayerListHudMixin {
    @Redirect(
            method = "render",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/network/ClientConnection;isEncrypted()Z"
            )
    )
    public boolean isEncrypted(ClientConnection instance) {
        return true;
    }
}
