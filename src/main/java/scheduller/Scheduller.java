package com.phincon.bootcamp.iwan.scheduller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;
import com.phincon.bootcamp.iwan.repository.AccountRepository;
@RestController
public class Scheduler {
    Logger logger = LoggerFactory.getLogger(Scheduler.class);
    @Autowired     AccountRepository accountRepository;
    @Scheduled(cron = "/5 * * * ?")
    public void cronJobSch() {
        logger.info("jalan");
        accountRepository.getAccountById("1");     }  }