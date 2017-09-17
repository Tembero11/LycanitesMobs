package com.lycanitesmobs.core.mobevent;

import com.lycanitesmobs.core.info.GroupInfo;
import net.minecraft.entity.EntityLiving;

public class MobEventRudolph extends MobEventYule {


    // ==================================================
    //                     Constructor
    // ==================================================
	public MobEventRudolph(String name, GroupInfo group) {
		super(name, group);
	}


    // ==================================================
    //                   Spawn Effects
    // ==================================================
    @Override
    public void onSpawn(EntityLiving entity, int rank) {
        super.onSpawn(entity, rank);
        entity.setCustomNameTag("Rudolph");
	}
}
