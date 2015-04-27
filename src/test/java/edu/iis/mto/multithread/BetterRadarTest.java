package edu.iis.mto.multithread;

import org.junit.Rule;
import org.junit.Test;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class BetterRadarTest {

    @Rule
    public RepeatRule repeatRule = new RepeatRule();

    @Test
    @Repeat(times = 10000)
    public void launchPatriot10TimesWhenNoticesAScudMissle() {
        Executor executor = new Executor() {
            @Override
            public void execute(Runnable command) {
                command.run();
            }
        };

        PatriotBattery batteryMock = mock(PatriotBattery.class);
        ReactTask reactTask = new ReactTask(batteryMock);

        BetterRadar radar = new BetterRadar(executor, reactTask);
        radar.notice(new Scud());
        verify(batteryMock, times(10)).launchPatriot();
    }
}
