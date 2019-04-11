/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sc.rai.raischeduler.tasks;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.sc.rai.raischeduler.utils.RESTUtil;

/**
 *
 * @author hendryyu
 */
@Component
public class MaturedDepositTask {
    private static final Logger log = LoggerFactory.getLogger(MaturedDepositTask.class);

//    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Value("${host.java.url}")
    protected String javaHostUrl;

    @Scheduled(cron = "${tasks.scheduled.update.matured.active.deposit.status}")
    public void updateMaturedActiveDepositStatus() {
        try {
            ObjectMapper mapper = new ObjectMapper();

            ResponseEntity<Object> response = RESTUtil
                    .postData( javaHostUrl+"/deposits/mature", null, String.class);
            log.info("==== "+response.getBody().toString());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
