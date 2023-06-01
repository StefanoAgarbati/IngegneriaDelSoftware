package observable;

import java.util.Observer;

public interface IObserver extends Observer {
	
	void update(String data);
	
}
