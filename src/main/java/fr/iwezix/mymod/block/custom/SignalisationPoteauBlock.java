package fr.iwezix.mymod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.stream.Stream;

public class SignalisationPoteauBlock extends HorizontalDirectionalBlock {

    public SignalisationPoteauBlock(Properties p_54120_) {
        super(p_54120_);
    }

    public static final VoxelShape SHAPE_N =
            Block.box(7, 0, 7, 9, 16, 9);

    public static final VoxelShape SHAPE_E =
            Block.box(7, 0, 7, 9, 16, 9);


    public static final VoxelShape SHAPE_S =
            Block.box(7, 0, 7, 9, 16, 9);


    public static final VoxelShape SHAPE_W =
            Block.box(7, 0, 7, 9, 16, 9);


    public VoxelShape getShape(BlockState p_54126_, BlockGetter p_54127_, BlockPos p_54128_, CollisionContext p_54129_) {
        switch (p_54126_.getValue(FACING)) {
            case SOUTH:
                return SHAPE_S;
            case WEST:
                return SHAPE_W;
            case EAST:
                return SHAPE_E;
            default:
                return SHAPE_N;
        }
    }

    protected void createBlockStateDefinition(StateDefinition.Builder p_54122_) {
        p_54122_.add(FACING);
    }

    public BlockState getStateForPlacement(BlockPlaceContext p_54124_) {
        return this.defaultBlockState().setValue(FACING, p_54124_.getHorizontalDirection().getOpposite());
    }
}
