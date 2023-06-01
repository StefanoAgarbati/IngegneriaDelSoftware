package serial;

public class DataSourceObserver implements IDataSourceObserver {
	
	private IDataStore<Byte> dataStore;
	
	public DataSourceObserver(IDataStore<Byte> dataStore) {
		this.dataStore = dataStore;
	}
	
	@Override
	public void update(byte[] data) {
		for(byte b : data) {
			dataStore.addData(b);
		}
	}

}
