package com.kunal.zipwriter.model;

public class Asset {

	private int assetId;
	private String assetName;
	private double assetPrice;

	public Asset(int assetId, String assetName, double assetPrice) {
		super();
		this.assetId = assetId;
		this.assetName = assetName;
		this.assetPrice = assetPrice;
	}

	public int getAssetId() {
		return assetId;
	}

	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public double getAssetPrice() {
		return assetPrice;
	}

	public void setAssetPrice(double assetPrice) {
		this.assetPrice = assetPrice;
	}

}
