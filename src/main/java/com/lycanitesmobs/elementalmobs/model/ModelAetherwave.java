package com.lycanitesmobs.elementalmobs.model;

import com.lycanitesmobs.core.model.ModelObj;
import com.lycanitesmobs.core.renderer.LayerBase;
import com.lycanitesmobs.elementalmobs.ElementalMobs;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.vecmath.Vector4f;

@SideOnly(Side.CLIENT)
public class ModelAetherwave extends ModelObj {

	// ==================================================
  	//                    Constructors
  	// ==================================================
    public ModelAetherwave() {
        this(1.0F);
    }

    public ModelAetherwave(float shadowSize) {

		// Load Model:
		this.initModel("aetherwave", ElementalMobs.instance.group, "projectile/aetherwave");
    }


	// ==================================================
	//                 Animate Part
	// ==================================================
	@Override
	public void animatePart(String partName, EntityLiving entity, float time, float distance, float loop, float lookY, float lookX, float scale) {
		super.animatePart(partName, entity, time, distance, loop, lookY, lookX, scale);
	}


	// ==================================================
	//                Get Part Color
	// ==================================================
	/** Returns the coloring to be used for this part and layer. **/
	public Vector4f getPartColor(String partName, Entity entity, LayerBase layer, boolean trophy, float loop) {
		float glowSpeed = 40;
		float glow = loop * glowSpeed % 360;
		float color = ((float)Math.cos(Math.toRadians(glow)) * 0.1f) + 0.9f;
		return new Vector4f(color, color, color, 1);
	}


	// ==================================================
	//                      Visuals
	// ==================================================
	@Override
	public void onRenderStart(LayerBase layer, Entity entity, boolean renderAsTrophy) {
		super.onRenderStart(layer, entity, renderAsTrophy);
		int i = 15728880;
		int j = i % 65536;
		int k = i / 65536;
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float) j, (float) k);
	}

	@Override
	public void onRenderFinish(LayerBase layer, Entity entity, boolean renderAsTrophy) {
		super.onRenderFinish(layer, entity, renderAsTrophy);
		int i = entity.getBrightnessForRender();
		int j = i % 65536;
		int k = i / 65536;
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float) j, (float) k);
	}
}
