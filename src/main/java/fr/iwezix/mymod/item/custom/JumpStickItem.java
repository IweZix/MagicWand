package fr.iwezix.mymod.item.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class JumpStickItem extends Item {

    public JumpStickItem(Properties p_41383_) {
        super(p_41383_);
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        // 600/20 = 30s
        player.addEffect(new MobEffectInstance(MobEffects.JUMP, 600));
        // 1200/20 = 60s
        player.getCooldowns().addCooldown(this, 1200);
        return super.use(level, player, interactionHand);
    }
}
