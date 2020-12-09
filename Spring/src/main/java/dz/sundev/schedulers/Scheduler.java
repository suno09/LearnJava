package dz.sundev.schedulers;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Scheduler {
    /** executing a task on every second from the application startup
     * @Scheduled(fixedRate = 1000) */
    /** execute the task every minute starting at 9:00 AM and ending at 9:59 AM, every day
    @Scheduled(cron = "0 40 15 * * ?") */
    /** after every 3 seconds, the fixed delay scheduler task has executed on every second
     * @Scheduled(fixedDelay = 1000, initialDelay = 3000) */
    @Scheduled(fixedRate = 5000)
    public void cronJobSch() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date now = new Date();
        String strDate = sdf.format(now);
        System.out.println("Java cron job expression:: " + strDate);
    }
}
