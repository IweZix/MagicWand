package fr.iwezix.mymod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

/**
 * Class for the custom block BlockName + Block
 */
public class MyBlockBlock extends Block {

  /**
   * Constructor
   *
   * @param p_49795_ properties of the block
   */
  public MyBlockBlock(Properties p_49795_) {
    super(p_49795_);
  }

  /**
   * When the block is left clicked
   *
   * @param blockState      state of the block
   * @param level           world
   * @param blockPos        position of the block
   * @param player          player who clicked
   * @param interactionHand hand used to click
   * @param blockHitResult  result of the click
   * @return the result of the interaction
   */
  public @NotNull InteractionResult use(@NotNull BlockState blockState, @NotNull Level level,
      @NotNull BlockPos blockPos, Player player,
      @NotNull InteractionHand interactionHand, @NotNull BlockHitResult blockHitResult) {
    // send a message to the player
    player.sendSystemMessage(Component.literal("Tu as fais clique droit sur le bitcoin !"));
    // Add the night vision effect to the player who clicked on the block for 5 seconds (100 ticks)
    player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 100, 1));

    return super.use(blockState, level, blockPos, player, interactionHand, blockHitResult);
  }

  /**
   * When an entity step on the block
   *
   * @param level      world
   * @param blockPos   position of the block
   * @param blockState state of the block
   * @param entity     entity who step on the block
   */
  public void stepOn(@NotNull Level level, @NotNull BlockPos blockPos,
      @NotNull BlockState blockState, @NotNull Entity entity) {
    super.stepOn(level, blockPos, blockState, entity);
    // If the entity is a player, send a message to the player
    if (entity instanceof Player player) {
      player.sendSystemMessage(Component.literal("Tu viens de marcher sur le bitcoin !"));
    }
  }
}
