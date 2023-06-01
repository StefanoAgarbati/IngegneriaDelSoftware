package interf;

import observable.IObservable;
import observable.IObserver;

public interface IButtonModel extends IObservable, IObserver {
	boolean isPressed();
}
