package serial;

public interface IDataStore<T> {

	void addData(T data);
	
	T getData();
	
}
