package team.teampotato.memorycleanermissnotoredict;

import team.teampotato.memorycleanermissnotoredict.command.ServerCommand;

import java.util.Timer;
import java.util.TimerTask;

public class MCMODModServer {
    public static void initServer() {
        MCMODMod.LOGGER.info(MCMODMod.MOD_NAME + " Running on server");
        ServerCommand.registerServerCommand();
        timer();
    }

    public static void timer() {
        long DELAY = 0;// 延迟时间，设置为0表示立即执行
        long PERIOD = MCMODMod.clearTime;//60是1分钟 1000是1秒 (尼玛的怎么是毫秒) 重复执行间隔
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.gc();
                MCMODMod.LOGGER.info("[Memory Clearer Miss-not Ore Dict] Memory cleaning completed!");
            }
        };
        // 启动定时器，在延迟时间后开始执行任务，然后每隔指定时间间隔重复执行
        timer.schedule(task, DELAY, PERIOD);
    }
}
