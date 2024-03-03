package fr.iwezix.mymod.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/**
 * Item to teleport the player to the spawn point
 */
public class TeleportationStickItem extends Item {

  /**
   * NBT tag to store the spawn point
   */
  private static final String NBT_SPAWN_X = "SpawnX";
  private static final String NBT_SPAWN_Y = "SpawnY";
  private static final String NBT_SPAWN_Z = "SpawnZ";

  /**
   * Constructor
   *
   * @param p_41383_ Properties
   */
  public TeleportationStickItem(Properties p_41383_) {
    super(p_41383_);
  }

  /**
   * Teleport the player to the spawn point
   *
   * @param level           world where the player is located
   * @param player          player who use the item
   * @param interactionHand hand used
   * @return InteractionResultHolder<ItemStack>
   */
  @Override
  public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, Player player,
      @NotNull InteractionHand interactionHand) {

    if (player.isCrouching()) {
      Vec3 spawnPoint = player.position();
      player.getPersistentData().putInt(NBT_SPAWN_X, (int) spawnPoint.x);
      player.getPersistentData().putInt(NBT_SPAWN_Y, (int) spawnPoint.y);
      player.getPersistentData().putInt(NBT_SPAWN_Z, (int) spawnPoint.z);
      player.sendSystemMessage(Component.literal(
          ChatFormatting.GREEN + "Point de spawn enregistré en " + spawnPoint.x + " " + spawnPoint.y
              + " " + spawnPoint.z));
    } else {
      if (player.getCooldowns().isOnCooldown(this)) {
        player.sendSystemMessage(Component.literal(
            ChatFormatting.RED + "Vous ne pouvez pas utiliser cet item, il est en cooldown"));
      } else if (!player.getPersistentData().contains(NBT_SPAWN_X)) {
        // Handle the case where the spawn point is not set
      } else {
        teleportPlayer(player);
        player.getCooldowns().addCooldown(this, 1200);
      }
    }
    return super.use(level, player, interactionHand);
  }



  /**
   * Teleport the player to the spawn point
   *
   * @param player player who use the item
   */
  private void teleportPlayer(Player player) {
    Vec3 teleportPoint = new Vec3(
        player.getPersistentData().getInt(NBT_SPAWN_X),
        player.getPersistentData().getInt(NBT_SPAWN_Y),
        player.getPersistentData().getInt(NBT_SPAWN_Z)
    );

    player.teleportTo(teleportPoint.x, teleportPoint.y, teleportPoint.z);
  }
}
