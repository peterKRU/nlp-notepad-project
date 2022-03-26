package request.library;

import java.io.Serializable;

public class Product implements Serializable{
	
	private String senderName;
	private String productType;
	private int productID;
	private String resultString;
	private String targetComponent;
	private int[] operationRange;
	
	public Product(String productType, int productID) {
		
		this.productType = productType;
		this.productID = productID;
		
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getResultString() {
		return resultString;
	}

	public void setResultString(String resultString) {
		this.resultString = resultString;
	}

	public String getTargetComponent() {
		return targetComponent;
	}

	public void setTargetComponent(String targetComponent) {
		this.targetComponent = targetComponent;
	}

	public int[] getOperationRange() {
		return operationRange;
	}

	public void setOperationRange(int[] operationRange) {
		this.operationRange = operationRange;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	
}
