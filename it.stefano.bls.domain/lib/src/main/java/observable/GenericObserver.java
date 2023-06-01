package observable;

import java.util.Observable;

public abstract class GenericObserver implements IObserver {

	@Override
	public void update(Observable o, Object arg) {
		update(""+arg);
	}
	
	public abstract void update(String data);

}
