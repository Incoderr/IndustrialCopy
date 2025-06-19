package net.incoder.industrial.block.custom;

import net.incoder.industrial.block.ModBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.neoforged.neoforge.common.ItemAbility;
import org.jetbrains.annotations.Nullable;


public class ModFlammableRotatedPillarBlock extends RotatedPillarBlock {
    public static final BooleanProperty RUBBER = BooleanProperty.create("rubber");

    public static final IntegerProperty RUBBER_SIDE = IntegerProperty.create("rubber_side", 0, 3);

    private static final int RUBBER_GROWTH_TIME_SECONDS = 40;


    public ModFlammableRotatedPillarBlock(Properties properties) {
        super(properties);

        this.registerDefaultState(this.stateDefinition.any()
                .setValue(RUBBER, false)
                .setValue(RUBBER_SIDE, 0)
                .setValue(AXIS, Direction.Axis.Y));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(RUBBER, RUBBER_SIDE);
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context,
                                                     ItemAbility itemAbility, boolean simulate) {
        if (context.getItemInHand().getItem() instanceof AxeItem) {
            if (state.is(ModBlock.HEVEA_LOG)) {
                return ModBlock.STRIPPED_HEVEA_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }

            if (state.is(ModBlock.HEVEA_WOOD)) {
                return ModBlock.STRIPPED_HEVEA_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
        }

        return super.getToolModifiedState(state, context, itemAbility, simulate);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!level.isClientSide && state.getBlock() == ModBlock.HEVEA_LOG.get()) {
            if (!state.getValue(RUBBER) && random.nextFloat() < RUBBER_GROWTH_TIME_SECONDS) {
                int randomSide = random.nextInt(4);
                level.setBlock(pos, state.setValue(RUBBER, true).setValue(RUBBER_SIDE, randomSide), 3);
            }
        }
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return state.getBlock() == ModBlock.HEVEA_LOG.get() && !state.getValue(RUBBER);
    }


    public static Direction getSideDirection(int side, Direction.Axis axis) {
        switch (axis) {
            case Y:
                switch (side) {
                    case 0: return Direction.NORTH;
                    case 1: return Direction.EAST;
                    case 2: return Direction.SOUTH;
                    case 3: return Direction.WEST;
                }
                break;
            case X:
                switch (side) {
                    case 0: return Direction.UP;
                    case 1: return Direction.NORTH;
                    case 2: return Direction.DOWN;
                    case 3: return Direction.SOUTH;
                }
                break;
            case Z:
                switch (side) {
                    case 0: return Direction.UP;
                    case 1: return Direction.WEST;
                    case 2: return Direction.DOWN;
                    case 3: return Direction.EAST;
                }
                break;
        }
        return Direction.NORTH;
    }
}
