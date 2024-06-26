package net.landen.mccourse;

import net.fabricmc.api.ModInitializer;

import net.landen.mccourse.block.ModBlocks;
import net.landen.mccourse.item.ModItemGroup;
import net.landen.mccourse.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MCCourseMod implements ModInitializer {
	public static final String MOD_ID = "mccourse";
    public static final Logger LOGGER = LoggerFactory.getLogger("mccourse");

	@Override
	public void onInitialize() {
		ModItemGroup.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

	}
}