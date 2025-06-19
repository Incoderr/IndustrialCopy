package net.incoder.industrial.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class WireBlock extends Block {
    public static final BooleanProperty NORTH = BooleanProperty.create("north");
    public static final BooleanProperty EAST = BooleanProperty.create("east");
    public static final BooleanProperty SOUTH = BooleanProperty.create("south");
    public static final BooleanProperty WEST = BooleanProperty.create("west");
    public static final BooleanProperty UP = BooleanProperty.create("up");
    public static final BooleanProperty DOWN = BooleanProperty.create("down");

    private static final VoxelShape SHAPE_CENTER = Block.box(5.0, 5.0, 5.0, 11.0, 11.0, 11.0);
    private static final VoxelShape SHAPE_NORTH = Block.box(5.0, 5.0, 0.0, 11.0, 11.0, 5.0);
    private static final VoxelShape SHAPE_EAST = Block.box(11.0, 5.0, 5.0, 16.0, 11.0, 11.0);
    private static final VoxelShape SHAPE_SOUTH = Block.box(5.0, 5.0, 11.0, 11.0, 11.0, 16.0);
    private static final VoxelShape SHAPE_WEST = Block.box(0.0, 5.0, 5.0, 5.0, 11.0, 11.0);
    private static final VoxelShape SHAPE_UP = Block.box(5.0, 11.0, 5.0, 11.0, 16.0, 11.0);
    private static final VoxelShape SHAPE_DOWN = Block.box(5.0, 0.0, 5.0, 11.0, 5.0, 11.0);

    public WireBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(NORTH, false)
                .setValue(EAST, false)
                .setValue(SOUTH, false)
                .setValue(WEST, false)
                .setValue(UP, false)
                .setValue(DOWN, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(NORTH, EAST, SOUTH, WEST, UP, DOWN);
    }


    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {

        boolean connect = neighborState.getBlock() instanceof WireBlock;

        Property<Boolean> property = getPropertyForDirection(direction);
        if (property != null) {
            return state.setValue(property, connect);
        }
        return state;
    }

    private static Property<Boolean> getPropertyForDirection(Direction direction) {
        switch (direction) {
            case NORTH: return NORTH;
            case EAST: return EAST;
            case SOUTH: return SOUTH;
            case WEST: return WEST;
            case UP: return UP;
            case DOWN: return DOWN;
            default: throw new IllegalArgumentException("Invalid direction: " + direction);
        }
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        VoxelShape shape = SHAPE_CENTER;

        if (state.getValue(NORTH)) {
            shape = Shapes.or(shape, SHAPE_NORTH);
        }
        if (state.getValue(EAST)) {
            shape = Shapes.or(shape, SHAPE_EAST);
        }
        if (state.getValue(SOUTH)) {
            shape = Shapes.or(shape, SHAPE_SOUTH);
        }
        if (state.getValue(WEST)) {
            shape = Shapes.or(shape, SHAPE_WEST);
        }
        if (state.getValue(UP)) {
            shape = Shapes.or(shape, SHAPE_UP);
        }
        if (state.getValue(DOWN)) {
            shape = Shapes.or(shape, SHAPE_DOWN);
        }

        return shape;
    }

    @Override
    public float getShadeBrightness(BlockState state, BlockGetter level, BlockPos pos) {
        return 1.0F;
    }

    @Override
    public boolean propagatesSkylightDown(BlockState state, BlockGetter level, BlockPos pos) {
        return true;
    }

    @Override
    public boolean isCollisionShapeFullBlock(BlockState state, BlockGetter world, BlockPos pos) {
        return false;
    }
}
