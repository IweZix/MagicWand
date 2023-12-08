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

public class MyBlockBlock extends Block {

    public MyBlockBlock(Properties p_49795_) {
        super(p_49795_);
    }

    // Cette méthode est appelée quand le joueur clique sur le block
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player,
                                 InteractionHand interactionHand, BlockHitResult blockHitResult) {
        // Affiche un message dans le chat du joueur qui a cliqué sur le block
        player.sendSystemMessage(Component.literal("Tu as fais clique droit sur le bitcoin !"));
        // Ajoute l'effet de vision nocturne de niveau 1au joueur qui a cliqué sur le block pendant 5 secondes (100 ticks)
        player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 100, 1));
        return super.use(blockState, level, blockPos, player, interactionHand, blockHitResult);
    }

    // Cette méthode est appelée quand un joueur marche sur le block
    public void stepOn(Level level, BlockPos blockPos, BlockState blockState, Entity entity) {
        super.stepOn(level, blockPos, blockState, entity);
        // si l'entité sur le block est un joueur
        if (entity instanceof Player player)
            player.sendSystemMessage(Component.literal("Tu viens de marcher sur le bitcoin !"));
    }
}
