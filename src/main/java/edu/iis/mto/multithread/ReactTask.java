package edu.iis.mto.multithread;

public class ReactTask implements Runnable {

    private PatriotBattery battery;

    public ReactTask(PatriotBattery battery) {
        this.battery = battery;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            battery.launchPatriot();
        }
    }
}
