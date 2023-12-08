package fr.iwezix.mymod.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class StickOfGodItem extends Item {

    public StickOfGodItem(Properties p_41383_) {
        super(p_41383_);
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        // donne un effet de regen
        player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 600, 2));
        player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 600, 2));
        player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 2));
        player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 600, 2));
        player.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 100, 2));
        player.addEffect(new MobEffectInstance(MobEffects.JUMP, 600, 2));
        // ajout du cooldown
        player.getCooldowns().addCooldown(this, 6000);
        // si cooldown pas encore terminer
        return super.use(level, player, interactionHand);
    }
}
