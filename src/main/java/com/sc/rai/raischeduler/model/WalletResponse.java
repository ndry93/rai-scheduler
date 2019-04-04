package com.sc.rai.raischeduler.model;

public class WalletResponse {
	private String returnCode;
	private WalletResponseResult result;
	private String txid;
	private WalletResponseInfo info;
	public String getReturnCode() {
		return returnCode;
	}
	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}
	public WalletResponseResult getResult() {
		return result;
	}
	public void setResult(WalletResponseResult result) {
		this.result = result;
	}
	public String getTxid() {
		return txid;
	}
	public void setTxid(String txid) {
		this.txid = txid;
	}
	public WalletResponseInfo getInfo() {
		return info;
	}
	public void setInfo(WalletResponseInfo info) {
		this.info = info;
	}


}


