package observable;

public interface IObservable {
	
	void addObserver(IObserver anObserver);
	
	void removeObserver(IObserver anObserver);
	
}
