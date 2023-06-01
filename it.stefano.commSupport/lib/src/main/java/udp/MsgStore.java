package udp;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MsgStore<T> implements IMsgStore<T> {

	private BlockingQueue<T> msgStore = new LinkedBlockingQueue<>();
	
	@Override
	public void put(T msg) {
		try {
			msgStore.put(msg);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public T take() {
		try {
			T msg = msgStore.take();
			return msg;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
		
	}

}
