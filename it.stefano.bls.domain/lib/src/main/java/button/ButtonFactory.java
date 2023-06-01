package button;

import button.concrete.ButtonGui;
import button.concrete.ButtonMock;
import button.concrete.ButtonPi4j;
import button.concrete.SerialButton;
import button.concrete.proxy.buttonProxyClient0.ButtonProxyClient;
import button.concrete.proxy.buttonProxyServer0.ButtonProxyServer;
import interf.IButtonDevice;
import interf.IButtonModel;
import interfaces.ProtocolType;
import utils.DeviceConfig;

public class ButtonFactory {

	public static IButtonDevice createButtonDevice(String type) {
		switch(type) {
		case ButtonType.MOCK:
			return createMockButton();
		case ButtonType.GUI:
			return createGuiButton();
		case ButtonType.RASPBERRY:
			return createPi4jButton(DeviceConfig.buttonPin);
		case ButtonType.PROXY:
			return createButtonProxyServer(DeviceConfig.buttonPort, DeviceConfig.buttonProtocol);
		case ButtonType.SERIAL:
			return createSerialButton(DeviceConfig.serialPortName);
		}
		return new ButtonMock();
	}
	
	public static IButtonDevice createSerialButton(String serialPortName) {
		return new SerialButton(serialPortName);
	}

	public static IButtonModel createLogicalButton() {
		return new ButtonModel();
	}
	public static IButtonDevice createMockButton() {
		return new ButtonMock();
	}
	public static IButtonDevice createPi4jButton(int pinNum) {
		return new ButtonPi4j(pinNum);
	}
	public static IButtonDevice createGuiButton() {
		return new ButtonGui();
	}
	public static IButtonDevice createButtonProxyServer(int port, ProtocolType protocol) {
		return new ButtonProxyServer(port, protocol);
	}
	public static ButtonProxyClient createButtonProxyClient(String host, int port, ProtocolType protocol) {
		return new ButtonProxyClient(host, port, protocol);
	}
	
}
