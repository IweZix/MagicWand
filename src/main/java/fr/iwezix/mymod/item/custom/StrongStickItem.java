package fr.iwezix.mymod.item.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class StrongStickItem extends Item {

    public StrongStickItem(Properties p_41383_) {
        super(p_41383_);
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        // donne un effet de speed
        player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 600));
        // ajout du cooldown
        player.getCooldowns().addCooldown(this, 1200);
        return super.use(level, player, interactionHand);
    }
}
