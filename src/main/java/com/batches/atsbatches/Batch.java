package com.batches.atsbatches;

public interface Batch {
	public void start();
	public void preProcess();
	void process(String email, Long phone);
	public void PostProcess();
}
