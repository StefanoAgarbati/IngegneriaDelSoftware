package serial;

public interface IDataSourceObservable {

	void addObserver(IDataSourceObserver observer);
	
	void removeObserver(IDataSourceObserver observer);
	
}
