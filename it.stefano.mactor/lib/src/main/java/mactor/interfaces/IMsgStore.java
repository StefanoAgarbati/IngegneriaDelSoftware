package mactor.interfaces;

public interface IMsgStore<T> {

	void storeMsg(T msg);
	
	T getMsg();
	
}
