package Board;

public class TimerThread extends Thread{
    private final long startTime;
    private final long runningTime;
    private long lastTime;
    public TimerThread(long runningTime) {
        startTime = System.currentTimeMillis();
        this.runningTime = runningTime * 60 * 1000;
        lastTime = startTime;
    }
    @Override
    public void run() {
        while (true) {
            if (startTime + runningTime < System.currentTimeMillis()) {
                System.out.println("Time ran out, no one wins!");
                System.exit(0);
            }
            if (System.currentTimeMillis() / 1000 - lastTime / 1000 >= 30){
                System.out.println("This game has been running for " + ((System.currentTimeMillis() - startTime) / 1000 + 1) + " seconds");
                lastTime = System.currentTimeMillis();
            }
        }
    }
}
