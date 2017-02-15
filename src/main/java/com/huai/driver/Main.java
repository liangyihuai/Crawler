package com.huai.driver;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by liangyh on 2/14/2017.
 */
public class Main {

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            public void run() {
                new NovelOfDomination().doBusiness();
                new DragonNovelDriver().doBusiness();
            }
        };

        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(runnable, 1, 900, TimeUnit.SECONDS);
    }
}
