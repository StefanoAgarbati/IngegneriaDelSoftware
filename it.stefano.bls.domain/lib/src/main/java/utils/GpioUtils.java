package utils;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.RaspiPin;

public class GpioUtils {

	public static Pin getPin(int pinNum) {
		switch(pinNum) {
		case 23: return RaspiPin.GPIO_14;
		case 16: return RaspiPin.GPIO_04;
		}
		return null;
	}
	
	public static GpioPinDigitalInput createDigitalInputPin(int pinNumber) {
		return getGpio().provisionDigitalInputPin(getPin(pinNumber));
	}
	public static GpioPinDigitalOutput createDigitalOutputPin(int pinNumber) {
		return getGpio().provisionDigitalOutputPin(getPin(pinNumber));
	}
	public static GpioController getGpio() {
		return GpioFactory.getInstance();
	}
}
