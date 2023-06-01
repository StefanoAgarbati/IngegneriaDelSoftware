package led.concrete;

import com.pi4j.io.gpio.GpioPinDigitalOutput;

import utils.GpioUtils;

public class LedPi4j extends LedDevice {
	
	private GpioPinDigitalOutput pin;
	
	public LedPi4j(int pinNumber) {
		pin = GpioUtils.createDigitalOutputPin(pinNumber);
	}
	@Override
	protected void doOn() {
		pin.high();
	}

	@Override
	protected void doOff() {
		pin.low();
	}

}
