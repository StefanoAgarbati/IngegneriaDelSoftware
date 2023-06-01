package observable;

import java.util.Observable;

public class GenericObservable extends Observable implements IObservable {

	@Override
	public void addObserver(IObserver anObserver) {
		super.addObserver(anObserver);
	}

	@Override
	public void removeObserver(IObserver anObserver) {
		super.deleteObserver(anObserver);
	}
	
	protected void updateObservers(String data) {
		super.setChanged();
		super.notifyObservers(data);
	}

}
