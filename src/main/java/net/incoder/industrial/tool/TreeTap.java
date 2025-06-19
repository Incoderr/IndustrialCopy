package net.incoder.industrial.tool;

import net.incoder.industrial.item.ModItem;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.core.BlockPos;
import net.incoder.industrial.block.ModBlock;
import net.incoder.industrial.block.custom.ModFlammableRotatedPillarBlock;

public class TreeTap extends Item {
    public TreeTap(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState state = level.getBlockState(pos);
        Player player = context.getPlayer();
        InteractionHand hand = context.getHand();
        ItemStack stack = context.getItemInHand();

        if (state.getBlock() == ModBlock.HEVEA_LOG.get() && state.getValue(ModFlammableRotatedPillarBlock.RUBBER)) {
            if (!level.isClientSide) {

                level.setBlock(pos, state.setValue(ModFlammableRotatedPillarBlock.RUBBER, false)
                        .setValue(ModFlammableRotatedPillarBlock.RUBBER_SIDE, 0), 3);


                int rubberSide = state.getValue(ModFlammableRotatedPillarBlock.RUBBER_SIDE);
                Direction.Axis axis = state.getValue(ModFlammableRotatedPillarBlock.AXIS);
                Direction rubberDirection = ModFlammableRotatedPillarBlock.getSideDirection(rubberSide, axis);


                double offsetX = 0.5;
                double offsetY = 0.7;
                double offsetZ = 0.5;

                switch (rubberDirection) {
                    case NORTH:
                        offsetZ -= 0.3;
                        break;
                    case SOUTH:
                        offsetZ += 0.3;
                        break;
                    case WEST:
                        offsetX -= 0.3;
                        break;
                    case EAST:
                        offsetX += 0.3;
                        break;
                    case UP:
                        offsetY += 0.3;
                        break;
                    case DOWN:
                        offsetY -= 0.3;
                        break;
                }

                int amount = level.random.nextInt(3) + 1;
                ItemStack rubber = new ItemStack(ModItem.RAW_RUBBER.get(), amount);
                net.minecraft.world.entity.item.ItemEntity itemEntity = new net.minecraft.world.entity.item.ItemEntity(
                        level,
                        pos.getX() + offsetX + (level.random.nextDouble() - 0.5) * 0.2,
                        pos.getY() + offsetY,
                        pos.getZ() + offsetZ + (level.random.nextDouble() - 0.5) * 0.2,
                        rubber
                );


                double velocityX = rubberDirection.getStepX() * 0.1;
                double velocityY = Math.max(0.1, rubberDirection.getStepY() * 0.1);
                double velocityZ = rubberDirection.getStepZ() * 0.1;

                itemEntity.setDeltaMovement(velocityX, velocityY, velocityZ);
                level.addFreshEntity(itemEntity);

                stack.hurtAndBreak(1, player, player.getEquipmentSlotForItem(stack));

                return InteractionResult.SUCCESS;
            }
            return InteractionResult.CONSUME;
        }

        return InteractionResult.PASS;
    }
}
