package com.sc.rai.raischeduler.tasks;

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
public class PendingPaymentTask {
    private static final Logger log = LoggerFactory.getLogger(MaturedDepositTask.class);

    @Value("${host.java.url}")
    protected String javaHostUrl;

    @Value("${tasks.scheduled.hourly}")
    protected String cronHourly;

    @Scheduled(cron = "${tasks.scheduled.pending.payments}")
//@Scheduled(fixedRate = 5000)
    public void creditPendingPaymentsToExternalBankAccounts() {
        try {
            ObjectMapper mapper = new ObjectMapper();

            ResponseEntity<Object> response = RESTUtil
                    .postData(javaHostUrl + "/payments/external", null, String.class);
            log.info("==== " + response.getBody().toString());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}