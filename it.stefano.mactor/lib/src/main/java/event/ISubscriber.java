package event;

public interface ISubscriber {

	void handleEvent(String evName, String msg);
	
}
