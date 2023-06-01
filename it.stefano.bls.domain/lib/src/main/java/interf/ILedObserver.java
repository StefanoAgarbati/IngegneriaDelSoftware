package interf;

import observable.IObserver;

public interface ILedObserver extends IObserver {
	void setLed(ILed aLed);
}
