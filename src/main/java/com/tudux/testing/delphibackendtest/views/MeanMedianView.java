package com.tudux.testing.delphibackendtest.views;

import com.tudux.testing.delphibackendtest.domain.Payment;

public class MeanMedianView {
	
	private double mean;
	private double median;
	public double getMean() {
		return mean;
	}
	public void setMean(double mean) {
		this.mean = mean;
	}
	public double getMedian() {
		return median;
	}
	public void setMedian(double median) {
		this.median = median;
	}
	public MeanMedianView(double mean, double median) {
		this.mean = mean;
		this.median = median;
	}
	
	
	

}
