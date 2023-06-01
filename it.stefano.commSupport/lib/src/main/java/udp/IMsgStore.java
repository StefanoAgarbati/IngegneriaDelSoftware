package udp;

public interface IMsgStore<T> {

	void put(T msg);
	
	T take();
	
}
