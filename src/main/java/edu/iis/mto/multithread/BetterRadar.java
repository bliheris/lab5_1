package edu.iis.mto.multithread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BetterRadar {

    private Executor executor;
    private ReactTask reactTask;

    public BetterRadar(Executor executor, ReactTask reactTask) {
        this.executor = executor;
        this.reactTask = reactTask;
    }

    public void notice(Scud enemyMissle) {
        executor.execute(reactTask);
    }
}
