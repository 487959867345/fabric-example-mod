package net.fabricmc.example;

import net.fabricmc.api.Environment;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class SuperGlass implements ModInitializer {
	public static Item InvisGlass = new InvisibleGlass(new FabricItemSettings().maxCount(1).food(new FoodComponent
			.Builder()
			.snack()
			.alwaysEdible()
			.build())
			.group(ItemGroup.FOOD));
	public static StatusEffect  BleedEffect = new BleedEffect();
	@Override
	public void onInitialize() {
		Registry.register(Registry.ITEM, new Identifier("superglass", "invis_glass"), InvisGlass);
		Registry.register(Registry.STATUS_EFFECT, new Identifier("superglass", "bleed_effect"), BleedEffect);

	}
}
