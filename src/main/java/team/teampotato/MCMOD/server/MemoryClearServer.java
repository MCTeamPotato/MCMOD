package team.teampotato.MCMOD.server;

import net.fabricmc.api.DedicatedServerModInitializer;
import team.teampotato.MCMOD.MCMOD;
import team.teampotato.MCMOD.common.config;

import java.util.Timer;
import java.util.TimerTask;

public class MemoryClearServer implements DedicatedServerModInitializer {
    @Override
    public void onInitializeServer() {
     Time();
    }
    public static void Time() {
        long DELAY = 0;// 延迟时间，设置为0表示立即执行
        long PERIOD = config.clearTime * 60 * 1000;//60是1分钟 1000是1秒 (尼玛的怎么是毫秒) 重复执行间隔
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.gc();
                MCMOD.LOGGER.info("[Memory Clearer Miss-not Ore Dict] Memory cleaning completed!");
            }
        };
        // 启动定时器，在延迟时间后开始执行任务，然后每隔指定时间间隔重复执行
        timer.schedule(task, DELAY, PERIOD);
    }
}
