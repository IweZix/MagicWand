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

/**
 * Item give a jump effect for 30 seconds
 */
public class StickOfGodItem extends Item {

  /**
   * Constructor
   *
   * @param p_41383_ Properties
   */
  public StickOfGodItem(Properties p_41383_) {
    super(p_41383_);
  }

  /**
   * Use the item with left click
   *
   * @param level           Level
   * @param player          Player who use the item
   * @param interactionHand InteractionHand
   * @return InteractionResultHolder<ItemStack>
   */
  public InteractionResultHolder<ItemStack> use(Level level, Player player,
      InteractionHand interactionHand) {
    if (player.getCooldowns().isOnCooldown(this)) {
      player.sendSystemMessage(Component.literal(
          ChatFormatting.RED + "Vous ne pouvez pas utilser cette item il est cooldown")
      );
    }

    player.addEffect(
        new MobEffectInstance(MobEffects.REGENERATION, 600, 2)
    );
    player.addEffect(
        new MobEffectInstance(MobEffects.ABSORPTION, 600, 2)
    );
    player.addEffect(
        new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 2)
    );
    player.addEffect(
        new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 600, 2)
    );
    player.addEffect(
        new MobEffectInstance(MobEffects.INVISIBILITY, 100, 2)
    );
    player.addEffect(
        new MobEffectInstance(MobEffects.JUMP, 600, 2)
    );

    player.getCooldowns().addCooldown(this, 6000);
    return super.use(level, player, interactionHand);
  }
}
