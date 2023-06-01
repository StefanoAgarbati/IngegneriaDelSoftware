package button.concrete;

import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;

import utils.GpioUtils;

public class ButtonPi4j extends ButtonDevice implements GpioPinListenerDigital {
	
	private GpioPinDigitalInput pin;
	
	public ButtonPi4j(int pinNum) {
		pin = createDigitalInputPin(pinNum);
		pin.addListener(this);
	}
	
	private GpioPinDigitalInput createDigitalInputPin(int pinNum) {
		return GpioUtils.createDigitalInputPin(pinNum);
	}

	@Override
	public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
		if(pin.isHigh())
			super.setState(true);
		else if(pin.isLow())
			super.setState(false);
	}
	
	
}
