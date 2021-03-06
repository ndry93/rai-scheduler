package com.sc.rai.raischeduler.tasks;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.sc.rai.raischeduler.service.BlockChainService;
import com.sc.rai.raischeduler.utils.RESTUtil;

@Component
public class ScheduledTasks {
	private static Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
	
	@Value("${host.java.url}")
    protected String javaHostUrl;
	
	@Autowired
	private BlockChainService blockChainService;
	
	
	@SuppressWarnings("unchecked")
	@Scheduled(cron = "${tasks.scheduled.bussinessdate}",zone = "${tasks.scheduled.zone}") /* every day at 12am */
	public void scheduledDaily() {
	  try {
		  ResponseEntity<Object> response = RESTUtil
                  .postData( javaHostUrl+"/bussinessdate/invoke/update", null, String.class);
		  log.info("====updateBussinessDate : "+response.getBody().toString());
	  } catch (Exception e){
	    log.error("Scheduled task failed: {}", e.getMessage());
	  }
	}
	@SuppressWarnings("unchecked")
	@Scheduled(cron = "${tasks.scheduled.sync.early.exit.request}",zone = "${tasks.scheduled.zone}") /* every day at 12am */
	public void syncEarlyExitRequest() {
	  try {
		  ResponseEntity<Object> response = RESTUtil
                  .postData( javaHostUrl+"/sync/exit/early/request", null, String.class);
		  log.info("====syncEarlyExitRequest : "+response.getBody().toString());
	  } catch (Exception e){
	    log.error("Scheduled task failed: {}", e.getMessage());
	  }
	}
	@SuppressWarnings("unchecked")
	@Scheduled(cron = "${tasks.scheduled.update.all.active.early.exit.request}",zone = "${tasks.scheduled.zone}") /* every day at 12am */
	public void updateAllActiveEarlyExitRequest() {
	  try {
		  ResponseEntity<Object> response = RESTUtil
                  .postData( javaHostUrl+"/update/active/request/blendedrate", null, String.class);
		  log.info("====updateAllActiveEarlyExitRequest : "+response.getBody().toString());
	  } catch (Exception e){
	    log.error("Scheduled task failed: {}", e.getMessage());
	  }
	}
	@SuppressWarnings("unchecked")
	@Scheduled(cron = "${tasks.scheduled.redeem.term.deposit}",zone = "${tasks.scheduled.zone}") /* every day at 12am */
	public void redeemTermDeposit() {
	  try {
		  ResponseEntity<Object> response = RESTUtil
                  .postData( javaHostUrl+"/process/expired/exitEarlyRequest", null, String.class);
		  log.info("====redeemTermDeposit : "+response.getBody().toString());
	  } catch (Exception e){
	    log.error("Scheduled task failed: {}", e.getMessage());
	  }
	}
	
//	@SuppressWarnings("unused")
//	private void updateBusinessDate() throws JsonParseException, JsonMappingException, IOException {
//	  LocalDate today = LocalDate.now();
//	  log.debug("Updating business date to : {}", today.toString());
//	  blockChainService.updateBusinessDate(today);
//	}
//	public void updateBusinessDateInvoked(LocalDate date) throws JsonParseException, JsonMappingException, IOException {
//		  log.debug("Updating business date to : {}", date.toString());
//		  blockChainService.updateBusinessDate(date);
//		}
}
