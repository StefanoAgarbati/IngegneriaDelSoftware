package mactor.impl;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import mactor.interfaces.IMsgStore;

public class MsgStore<T> implements IMsgStore<T> {

	private BlockingQueue<T> queue = new LinkedBlockingQueue<>();

	@Override
	public void storeMsg(T msg) {
		try {
			queue.put(msg);
			System.out.println("MsgStore | message stored ");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public T getMsg() {
		try {
			return queue.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

	

}
