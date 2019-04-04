package com.sc.rai.raischeduler.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WalletResponsePayload {
//	@JsonProperty("ObjectType")
//	private String objectType;
//	 private String walletId;
//	 private String status;
//	 private String kycStatus;
//	 private String walletType;
//	 private String issuerId;
//	 private String currency;
//	 private float quantity;
	 
	 private String accountId;
	 private String issuerId;
	 private String status;
	 private String kycStatus;
	 private String currency;
	 private float quantity;
	 private Integer timestamp;
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getIssuerId() {
		return issuerId;
	}
	public void setIssuerId(String issuerId) {
		this.issuerId = issuerId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getKycStatus() {
		return kycStatus;
	}
	public void setKycStatus(String kycStatus) {
		this.kycStatus = kycStatus;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public float getQuantity() {
		return quantity;
	}
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
	public Integer getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Integer timestamp) {
		this.timestamp = timestamp;
	}

}
