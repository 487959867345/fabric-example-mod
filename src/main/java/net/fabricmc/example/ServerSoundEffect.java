package net.fabricmc.example;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class ServerSoundEffect implements UseItemCallback {
    @Override
    public TypedActionResult<ItemStack> interact(PlayerEntity player, World world, Hand hand) {
        if (world.isClient) {
            player.playSound(SoundEvents.BLOCK_GLASS_BREAK, 1, 1);
            return TypedActionResult.pass(player.getMainHandStack());
        }
        if (player.getMainHandStack().getItem().equals(SuperGlass.InvisGlass) && !player.getStatusEffects().contains(SuperGlass.BleedEffect)) {
            player.addStatusEffect(new StatusEffectInstance(SuperGlass.BleedEffect, 20 * 5, 1));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 20 * 20, 1));
            System.out.println("Adding Effect");
            player.getMainHandStack().setCount(0);
            return TypedActionResult.consume(player.getMainHandStack());
        }
        return TypedActionResult.pass(player.getMainHandStack());

    }
}
