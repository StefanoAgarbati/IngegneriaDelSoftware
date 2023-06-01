package led;

import java.awt.Color;

import interf.ILed;
import interf.ILedDevice;
import interfaces.ProtocolType;
import led.concrete.LedGui;
import led.concrete.LedMock;
import led.concrete.LedPi4j;
import led.concrete.SerialLed;
import led.concrete.proxy.ledProxy4.LedProxyClient;
import led.concrete.proxy.ledRemote2.LedProxyServer;
import utils.DeviceConfig;

public class LedFactory {

	public static ILedDevice createLedDevice(String ledType) {
		switch(ledType) {
		case LedType.MOCK:
			return createLedMock();
		case LedType.GUI:
			return createLedGui(new Color(DeviceConfig.ledOnColor), new Color(DeviceConfig.ledOffColor));
		case LedType.RASPBERRY:
			return createLedPi4j(DeviceConfig.ledPin);
		case LedType.PROXY:
			return createLedProxyClient(DeviceConfig.ledAddress, DeviceConfig.ledPort, DeviceConfig.ledProtocol);
		case LedType.SERIAL:
			return createSerialLed(DeviceConfig.serialPortName);
		}
		return new LedMock();
	}
	public static ILedDevice createSerialLed(String serialPortName) {
		return new SerialLed(serialPortName);
	}
	public static ILedDevice createLedPi4j(int pinNum) {
		return new LedPi4j(pinNum);
	}
	public static ILedDevice createLedGui(Color onColor, Color offColor) {
		return new LedGui(onColor, offColor);
	}
	public static ILedDevice createLedMock() {
		return new LedMock();
	}
	public static ILedDevice createLedProxyClient(String host, int port, ProtocolType protocol) {
		System.out.println("LedFactory | creating led proxy client on port " + port + " with protocol " + protocol);
		return new LedProxyClient(host, port, protocol);
	}
	public static LedProxyServer createLedProxyServer(ILedDevice led, int port, ProtocolType protocol) {
		System.out.println("LedFactory | creating led proxy server on port " + port + " with protocol " + protocol);
		return new LedProxyServer(led, port, protocol);
	}
	public static ILed createLogicalLed(ILedDevice device) {
		return new LedModel(device);
	}

}
