package team.teampotato.memorycleanermissnotoredict;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import team.teampotato.memorycleanermissnotoredict.config.ConfigUtil;

import java.util.Timer;
import java.util.TimerTask;

public class MCMODModClient {
    public static void initClient() {
        MCMODMod.LOGGER.info(MCMODMod.MOD_NAME + " Running on client");
        ConfigUtil.setConfigScreen();

        if (ConfigUtil.getConfig().autoCleanMemory) {
            autoCleanMemory();
        }
    }

    public static void autoCleanMemory() {
        long DELAY = 0;// 延迟时间，设置为0表示立即执行
        long PERIOD = MCMODMod.clearTime;//60是1分钟 1000是1秒 (尼玛的怎么是毫秒) 重复执行间隔
        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                memoryClean();
            }
        };

        // 启动定时器，在延迟时间后开始执行任务，然后每隔指定时间间隔重复执行
        timer.schedule(task, DELAY, PERIOD);
    }

    public static void memoryClean() {
        Runtime runtime = Runtime.getRuntime();
        System.gc();
        long usedMemory = runtime.totalMemory() - runtime.freeMemory();
        int memoryPercent = (int) (usedMemory * 100 / (double) runtime.maxMemory());
        String memory = memoryPercent+"%";

        // 计算进度条长度
        int progressBarLength = memoryPercent / 10;

        int remainingLength = 10 - progressBarLength;

        // 构建进度条字符串
        String progressBar = "[" + "■".repeat(Math.max(0, progressBarLength)) +
                "-".repeat(Math.max(0, remainingLength)) + "]";
        MinecraftClient.getInstance().execute(() -> {//
            if (MinecraftClient.getInstance().player != null) {
                MinecraftClient.getInstance().player.sendMessage(Text.translatable("memoryclearermissnotoredict.memoryclear",progressBar,memory).formatted(Formatting.GREEN),false);
            }
        });
    }
}
