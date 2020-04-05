package com.jonathan.monagm.client.models;

import javax.annotation.Nonnull;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.LivingEntity;

public class GauntletModel extends BipedModel<LivingEntity> {

  public GauntletModel() {

    this.textureWidth = 32;
    this.textureHeight = 16;
    this.bipedRightArm = new RendererModel(this, 0, 0);
    this.bipedRightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
    this.bipedRightArm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.5F);
    this.bipedLeftArm.mirror = true;
    this.bipedLeftArm = new RendererModel(this, 16, 0);
    this.bipedLeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
    this.bipedLeftArm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.5F);
  }

  @Override
  public void render(@Nonnull LivingEntity entityIn, float limbSwing, float limbSwingAmount,
      float ageInTicks, float netHeadYaw, float headPitch, float scale) {
    this.bipedRightArm.render(scale);
    this.bipedLeftArm.render(scale);
  }
}
