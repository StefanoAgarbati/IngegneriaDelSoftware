package serial;

public interface ISerialPort extends IDataSourceObservable {

	void sendData(byte[] data);
	
	byte[] receiveData();
	
}
