package fr.iwezix.mymod.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class HealStickItem extends Item {

    public HealStickItem(Properties p_41383_) {
        super(p_41383_);
    }

    // Clique droit
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        // donne un effet de regen
        player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 600));
        // ajout du cooldown
        player.getCooldowns().addCooldown(this, 1200);
        // si cooldown pas encore terminer
        if (player.getCooldowns().isOnCooldown(this))
            // envoie un message
            player.sendSystemMessage(Component.literal(ChatFormatting.RED + "Vous ne pouvez pas utilser cette item il est cooldown"));
        return super.use(level, player, interactionHand);
    }
}
