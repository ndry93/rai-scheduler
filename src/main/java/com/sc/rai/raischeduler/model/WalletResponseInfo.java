package com.sc.rai.raischeduler.model;

import java.util.ArrayList;

public class WalletResponseInfo {
	private String proxyError;
	ArrayList < WalletResponsePeerErrors > peerErrors = new ArrayList < WalletResponsePeerErrors > ();
	public String getProxyError() {
		return proxyError;
	}
	public void setProxyError(String proxyError) {
		this.proxyError = proxyError;
	}
	public ArrayList<WalletResponsePeerErrors> getPeerErrors() {
		return peerErrors;
	}
	public void setPeerErrors(ArrayList<WalletResponsePeerErrors> peerErrors) {
		this.peerErrors = peerErrors;
	}
}
