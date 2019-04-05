package com.sc.rai.raischeduler.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sc.rai.raischeduler.model.WalletRequest;
import com.sc.rai.raischeduler.model.WalletResponse;
import com.sc.rai.raischeduler.utils.RESTUtil;

@Service
public class BlockChainService {
//	@Value("${host.blockchain.url}")
//	  protected String blockchainUrlAddress;
//
//	  @Value("${chain.channel}")
//	  protected String channel;
//	  @Value("${chain.code}")
//	  protected String chainCode;
//	  @Value("${chain.code.version}")
//	  protected String chainCodeVer;
//
//	  @Value("${chain.create.business.date.method}")
//	  protected String createBusinessDateMethod;
//	  @Value("${chain.get.business.date.method}")
//	  protected String getBusinessDateMethod;
//	  @Value("${chain.update.business.date.method}")
//	  protected String updateBusinessDateMethod;
//
//
//	  @Value("${chain.code.username}")
//	  protected String chainUsername;
//	  @Value("${chain.code.password}")
//	  protected String chainPassword;
//
//	  public WalletResponse getBusinessDate() throws JsonParseException, JsonMappingException, IOException {
//		    return makeRequest(Collections.EMPTY_LIST, createBusinessDateMethod);
//	  }
//
//	  public WalletResponse createBusinessDate(LocalDate newBusinessDate) throws JsonParseException, JsonMappingException, IOException {
//	    return makeRequest(List.of(newBusinessDate.toString()), createBusinessDateMethod);
//	  }
//
//	  public WalletResponse updateBusinessDate(LocalDate newBusinessDate) throws JsonParseException, JsonMappingException, IOException {
//	    return makeRequest(List.of(newBusinessDate.toString()), updateBusinessDateMethod);
//	  }
//
//	  @SuppressWarnings("unchecked")
//	  private WalletResponse makeRequest(List<String> args, String method) throws JsonParseException, JsonMappingException, IOException {
//
//			    WalletRequest request = new WalletRequest(args, channel, chainCode, chainCodeVer, method);
//			    ObjectMapper mapper = new ObjectMapper();
//
//			    ResponseEntity<Object> response = RESTUtil
//				        .postData(chainUsername, chainPassword, blockchainUrlAddress, request, String.class);
//
//			    WalletResponse walletResponse = mapper.readValue(response.getBody().toString(), WalletResponse.class);
//			    return walletResponse;
//	  }
}
