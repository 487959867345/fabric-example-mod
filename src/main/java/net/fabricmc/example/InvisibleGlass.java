package net.fabricmc.example;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;

public class InvisibleGlass extends Item {
    public InvisibleGlass(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (world.isClient) {
            user.playSound(SoundEvents.BLOCK_GLASS_BREAK, 1.0F, 1.0F);
        }
        return stack.EMPTY;
    }
}
