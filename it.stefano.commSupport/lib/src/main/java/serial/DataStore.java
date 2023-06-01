package serial;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class DataStore<T> implements IDataStore<T> {
	
	private BlockingQueue<T> store = new LinkedBlockingQueue<>();
	
	public void addData(T data) {
		try {
			store.put(data);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public T getData() {
		try {
			return store.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

}
