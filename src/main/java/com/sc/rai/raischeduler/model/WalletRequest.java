package com.sc.rai.raischeduler.model;

import java.util.ArrayList;
import java.util.List;

public class WalletRequest {
  private List<String> args = new ArrayList<>();
  private String channel;
  private String chaincode;
  private String chaincodeVer;
  private String method;
public WalletRequest(List<String> args, String channel, String chaincode, String chaincodeVer, String method) {
	super();
	this.args = args;
	this.channel = channel;
	this.chaincode = chaincode;
	this.chaincodeVer = chaincodeVer;
	this.method = method;
}
public List<String> getArgs() {
	return args;
}
public void setArgs(List<String> args) {
	this.args = args;
}
public String getChannel() {
	return channel;
}
public void setChannel(String channel) {
	this.channel = channel;
}
public String getChaincode() {
	return chaincode;
}
public void setChaincode(String chaincode) {
	this.chaincode = chaincode;
}
public String getChaincodeVer() {
	return chaincodeVer;
}
public void setChaincodeVer(String chaincodeVer) {
	this.chaincodeVer = chaincodeVer;
}
public String getMethod() {
	return method;
}
public void setMethod(String method) {
	this.method = method;
}
}
