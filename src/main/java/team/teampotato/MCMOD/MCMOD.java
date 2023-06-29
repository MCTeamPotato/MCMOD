package team.teampotato.MCMOD;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.ModInitializer;
import team.teampotato.MCMOD.common.config;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MCMOD implements ModInitializer {
	public static final String MOD_NAME = "Memory Clearer Miss-not Ore Dict";
	public static final String MOD_ID = "memoryclearermissnotoredict";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		config.Registry();
		if (FabricLoader.getInstance().getEnvironmentType() == EnvType.SERVER) {
			LOGGER.info(MOD_NAME + " Running on server");
			// 在服务器端执行的逻辑
			//MemoryClearServer.Registry();
			//CommandServer.command();
			//这傻逼为什么在IDEA运行没问题啊，单独客户端出问题了
		} else {
			LOGGER.info(MOD_NAME + " Running on client");
			// 在客户端执行的逻辑
			//MemoryClearClient.Registry();
			//CommandClient.command();
			/*
			[MCMOD]
             青春内存清理不会梦到矿物词典学姐
             Memory Clearer miss-not ore dict
			 */
		}
	}
}

