package blSystem;

import interf.ILedDevice;
import led.LedFactory;
import led.concrete.proxy.ledRemote2.LedProxyServer;

public class MainBLSystemLedRemote {

	private LedProxyServer ledRemote;
	private ILedDevice ledDevice;
	
	private void createComponents() {
		ledDevice = LedFactory.createLedDevice(BLSystemConfig.ledType);
		ledRemote = LedFactory.createLedProxyServer(ledDevice, BLSystemConfig.port, BLSystemConfig.protocol);
		
	}
	private void configureSystem() {
		BLSystemConfig.setConfiguration();
	}
	private void activate() {
		ledRemote.activate();
	}
	public void startTheSystem() {
		configureSystem();
		createComponents();
		activate();
		System.out.println("MainBLSystemLedRemote | started");
	}
	
	public static void main(String[] args) {
		new MainBLSystemLedRemote().startTheSystem();
	}
}
