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
 * Item give a regen effect for 30 seconds
 */
public class HealStickItem extends Item {

  /**
   * Constructor
   *
   * @param p_41383_ Properties
   */
  public HealStickItem(Properties p_41383_) {
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
    // si cooldown pas encore terminer
    if (player.getCooldowns().isOnCooldown(HealStickItem.this)) {
      // envoie un message
      player.sendSystemMessage(Component.literal(
          ChatFormatting.RED + "Vous ne pouvez pas utilser cette item il est cooldown"));
    }

    // donne un effet de regen de 30 secondes
    player.addEffect(
        new MobEffectInstance(MobEffects.REGENERATION, 600)
    );

    // ajout du cooldown de 60 secondes
    player.getCooldowns().addCooldown(this, 1200);
    return super.use(level, player, interactionHand);
  }
}
