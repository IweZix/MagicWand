package fr.iwezix.mymod.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.List;
import org.jetbrains.annotations.NotNull;

/**
 * Item give a fire effect for 10 seconds to entities around the player
 */
public class FireStickItem extends Item {

  /**
   * Constructor
   *
   * @param properties Properties
   */
  public FireStickItem(Properties properties) {
    super(properties);
  }

  /**
   * Burn mod around the player
   *
   * @param level           level where the player is located
   * @param player          player who use the item
   * @param interactionHand interactionHand used
   * @return InteractionResultHolder<ItemStack>
   */
  @Override
  public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level,
      @NotNull Player player, @NotNull InteractionHand interactionHand) {
    if (player.getCooldowns().isOnCooldown(this)) {
      player.sendSystemMessage(Component.literal(
          ChatFormatting.RED + "Vous ne pouvez pas utiliser cet item, il est en cooldown"));
    } else {
      applyFireEffectToEntitiesAroundPlayer(level, player);

      player.getCooldowns().addCooldown(this, 1200);
    }

    return super.use(level, player, interactionHand);
  }

  /**
   * Apply fire effect to entities around the player
   *
   * @param level  level
   * @param player player who use the item
   */
  private void applyFireEffectToEntitiesAroundPlayer(Level level, Player player) {
    double radius = 5.0;

    List<Entity> entities = level.getEntities(player, player.getBoundingBox().inflate(radius),
        entity -> entity instanceof LivingEntity);

    for (Entity entity : entities) {
      if (entity instanceof LivingEntity) {
        LivingEntity livingEntity = (LivingEntity) entity;
        livingEntity.setSecondsOnFire(10);
      }
    }
  }
}
