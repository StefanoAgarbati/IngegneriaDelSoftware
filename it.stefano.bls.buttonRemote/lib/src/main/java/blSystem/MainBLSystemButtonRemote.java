package blSystem;

import button.ButtonFactory;
import interf.IButtonDevice;
import interfaces.ProtocolType;
import observable.IObserver;

public class MainBLSystemButtonRemote {
	
	private IButtonDevice buttonDevice;
	private IObserver buttonProxyClient;
	
	public void startTheSystem() {
		configureSystem();
		createComponents();
		configure();
	}
	
	private void createComponents() {
		buttonDevice = createButtonDevice(BLSystemConfig.buttonType);
		buttonProxyClient = createButtonProxyClient(BLSystemConfig.buttonAddress, 
				BLSystemConfig.buttonPort, BLSystemConfig.buttonProtocol);
	}
	private void configureSystem() {
		BLSystemConfig.setConfiguration();
	}
	private void configure() {
		buttonDevice.addObserver(buttonProxyClient);
	}
	
	private IObserver createButtonProxyClient(String host, int port, ProtocolType protocol) {
		return ButtonFactory.createButtonProxyClient(host, port, protocol);
	}

	private IButtonDevice createButtonDevice(String buttonType) {
		return ButtonFactory.createButtonDevice(buttonType);
	}
	
	public static void main(String[] args) {
		new MainBLSystemButtonRemote().startTheSystem();
	}
}







