package net.incoder.industrial.screen.custom;

import com.mojang.blaze3d.systems.RenderSystem;
import net.incoder.industrial.Industrial;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class IronFurnaceScreen extends AbstractContainerScreen<IronFurnaceMenu> {
    private static final ResourceLocation GUI_TEXTURE =
            ResourceLocation.fromNamespaceAndPath(Industrial.MODID, "textures/gui/iron_furnace/iron_furnace_gui.png");
    private static final ResourceLocation FIRE_TEXTURE =
            ResourceLocation.fromNamespaceAndPath(Industrial.MODID, "textures/gui/fire_progress.png");
    private static final ResourceLocation ARROW_TEXTURE =
            ResourceLocation.fromNamespaceAndPath(Industrial.MODID, "textures/gui/arrow_progress.png");

    public IronFurnaceScreen(IronFurnaceMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
    }

    @Override
    protected void init() {
        super.init();

        this.titleLabelY = 6;
        this.inventoryLabelY = this.imageHeight - 94;
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;


        guiGraphics.blit(GUI_TEXTURE, x, y, 0, 0, imageWidth, imageHeight);


        renderFireProgress(guiGraphics, x, y);


        renderProgressArrow(guiGraphics, x, y);
    }

    private void renderFireProgress(GuiGraphics guiGraphics, int x, int y) {
        if (menu.isLit()) {
            int fireHeight = menu.getScaledBurnProgress();

            guiGraphics.blit(FIRE_TEXTURE,
                    x + 56, y + 36 + 12 - fireHeight,
                    0, 12 - fireHeight,
                    14, fireHeight + 1,
                    14, 14);
        }
    }

    private void renderProgressArrow(GuiGraphics guiGraphics, int x, int y) {
        if (menu.isCrafting()) {
            int arrowProgress = menu.getScaledArrowProgress();
            guiGraphics.blit(ARROW_TEXTURE,
                    x + 79, y + 35,
                    0, 0,
                    arrowProgress, 16,
                    24, 16);
        }
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {

        guiGraphics.drawString(this.font, this.title, this.titleLabelX, this.titleLabelY, 4210752, false);

        guiGraphics.drawString(this.font, this.playerInventoryTitle, this.inventoryLabelX, this.inventoryLabelY, 4210752, false);
    }
}
