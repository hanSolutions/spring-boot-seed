package ca.hansolutions.services;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    private static final Logger logger = LoggerFactory.getLogger(ScheduleService.class);

    @Scheduled(fixedRate = 5000)
    public void printLog(){

        logger.info("Current time is {}", new DateTime());
    }
}
