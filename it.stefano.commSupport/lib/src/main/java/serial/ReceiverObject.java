package serial;

public class ReceiverObject implements IReceiverObject{

	private IDataSourceObservable dataSource;
	private IDataSourceObserver dataSourceObserver;
	private IDataStore<Byte> dataStore = new DataStore<>();
	private IDataStore<String> msgStore = new DataStore<>();
	private IDataProcessor processor;
	
	public ReceiverObject(IDataSourceObservable dataSource) {
		this.dataSource = dataSource;
		processor = new DataProcessor(dataStore, msgStore);
		dataSourceObserver = new DataSourceObserver(dataStore);
		dataSource.addObserver(dataSourceObserver);
		processor.activate();
	}
	
	@Override
	public String receiveMsg() {
		return msgStore.getData();
	}

}
