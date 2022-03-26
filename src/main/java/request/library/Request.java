package request.library;

import java.io.Serializable;

public class Request implements Serializable{
	
	private boolean isWritten;
	private boolean isRead;
	
	private String senderName;
	private String requestType;
	private int requestID;
	private String inputString;
	private String targetModel;
	
	public Request(String requestType, int requestID) {
		
		this.requestType = requestType;
		this.requestID = requestID;
		
		this.isWritten = false;
		this.isRead = false;
		
	}
	
	public static Request createEmptyRequest() {
		
		Request emptyRequest = new Request("null", 0);
		
		return emptyRequest;
		
	}
	
	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public int getRequestID() {
		return requestID;
	}

	public void setRequestID(int requestID) {
		this.requestID = requestID;
	}

	public String getInputString() {
		return inputString;
	}

	public void setInputString(String inputString) {
		this.inputString = inputString;
	}

	public String getTargetModel() {
		return targetModel;
	}

	public void setTargetModel(String targetModel) {
		this.targetModel = targetModel;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public boolean isWritten() {
		return isWritten;
	}

	public void setWritten(boolean isWritten) {
		this.isWritten = isWritten;
	}

	public boolean isRead() {
		return isRead;
	}

	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}
	
}
