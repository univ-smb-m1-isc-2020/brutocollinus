package fr.univ_smb.isc.m1.brutocollinus.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class TourBattleScheduler {
    private static final Logger log = LoggerFactory.getLogger(TourBattleScheduler.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    public TourBattleScheduler() {
        log.info("Start");
    }

    @Scheduled(fixedDelay = 5000)
    public void currentTime() {
        log.info("Current Time      = {}", dateFormat.format(new Date()));
    }
}
