package com.mehmetcanwt.seamlesscursor.mixin;

import com.mehmetcanwt.seamlesscursor.CursorPosition;
import net.minecraft.client.Minecraft;
import net.minecraft.client.MouseHandler;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MouseHandler.class)
public class MouseHandlerMixin {
	@Shadow
	@Final
	private Minecraft minecraft;

	@Shadow
	private double xpos;

	@Shadow
	private double ypos;

	@Shadow
	private boolean mouseGrabbed;

	@Inject(method = "grabMouse", at = @At("HEAD"))
	private void noCursorReset$saveOnGrab(CallbackInfo ci) {
		if (!this.mouseGrabbed) {
			CursorPosition.save(this.xpos, this.ypos);
		}
	}

	@ModifyArg(
		method = "releaseMouse",
		at = @At(
			value = "INVOKE",
			target = "Lcom/mojang/blaze3d/platform/InputConstants;grabOrReleaseMouse(Lcom/mojang/blaze3d/platform/Window;IDD)V"
		),
		index = 2
	)
	private double noCursorReset$keepX(double x) {
		return CursorPosition.restoreX(x, windowWidth());
	}

	@ModifyArg(
		method = "releaseMouse",
		at = @At(
			value = "INVOKE",
			target = "Lcom/mojang/blaze3d/platform/InputConstants;grabOrReleaseMouse(Lcom/mojang/blaze3d/platform/Window;IDD)V"
		),
		index = 3
	)
	private double noCursorReset$keepY(double y) {
		return CursorPosition.restoreY(y, windowHeight());
	}

	@Inject(method = "releaseMouse", at = @At("TAIL"))
	private void noCursorReset$restoreFields(CallbackInfo ci) {
		if (!CursorPosition.has()) {
			return;
		}
		this.xpos = CursorPosition.restoreX(this.xpos, windowWidth());
		this.ypos = CursorPosition.restoreY(this.ypos, windowHeight());
	}

	@Unique
	private int windowWidth() {
		return this.minecraft.getWindow().getScreenWidth();
	}

	@Unique
	private int windowHeight() {
		return this.minecraft.getWindow().getScreenHeight();
	}
}
