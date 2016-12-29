package com.onlineshop.vo;

public class ProductVO {

	private String productId;
	private String productName;
	private String productDescription;
	private String unitPrice;
	private String msrp;
	private String sku;
	private String imageName;
	
	public ProductVO() {}
	
	public ProductVO(String productId, String productName, String productDescription, String unitPrice, String msrp,String sku){
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.unitPrice = unitPrice;
		this.msrp = msrp;
		this.sku = sku;
	}
	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getMsrp() {
		return msrp;
	}

	public void setMsrp(String msrp) {
		this.msrp = msrp;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	
	
}
