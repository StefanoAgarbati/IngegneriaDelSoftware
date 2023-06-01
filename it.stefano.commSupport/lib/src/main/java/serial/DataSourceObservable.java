package serial;

import java.util.ArrayList;
import java.util.List;

public class DataSourceObservable implements IDataSourceObservable {

	private List<IDataSourceObserver> observers = new ArrayList<>();
	private byte[] data;
	
	public void addObserver(IDataSourceObserver observer) {
		observers.add(observer);
	}
	
	public void removeObserver(IDataSourceObserver observer) {
		observers.remove(observer);
	}
	
	protected void setData(byte[] data) {
		this.data = data;
		updateObservers();
	}

	private void updateObservers() {
		observers.forEach(observer -> observer.update(data));
	}
}
