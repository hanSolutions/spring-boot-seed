package ca.hansolutions.services;

import ca.hansolutions.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private static final Logger logger = LoggerFactory.getLogger(ScheduleService.class);
    private final BookRepository bookRepository;

    @Scheduled(fixedRate = 500000)
    public void printLog(){

        logger.info("Current time is {}", new DateTime());
//        logger.info("get book 123 {}", bookRepository.getBookById("123"));
//        logger.info("get book abc {}", bookRepository.getBookById("abc"));
//        logger.info("get book 123 {}", bookRepository.getBookById("123"));
//        logger.info("get book abc {}", bookRepository.getBookById("abc"));
//        logger.info("get book 123 {}", bookRepository.getBookById("123"));
//        logger.info("get book abc {}", bookRepository.getBookById("abc"));
//        logger.info("get book 123 {}", bookRepository.getBookById("123"));
//        logger.info("get book abc {}", bookRepository.getBookById("abc"));
//        logger.info("get book 123 {}", bookRepository.getBookById("123"));
//        logger.info("get book abc {}", bookRepository.getBookById("abc"));
//        logger.info("get book 123 {}", bookRepository.getBookById("123"));
//        logger.info("get book abc {}", bookRepository.getBookById("abc"));

    }
}
