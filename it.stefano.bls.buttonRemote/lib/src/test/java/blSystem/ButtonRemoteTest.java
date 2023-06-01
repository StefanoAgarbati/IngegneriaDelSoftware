package blSystem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import button.concrete.ButtonMock;
import button.concrete.proxy.buttonProxyClient0.ButtonProxyClient;
import button.concrete.proxy.buttonProxyServer0.ButtonProxyServer;
import interf.IButtonDevice;
import interfaces.ProtocolType;
import observable.IObserver;

class ButtonRemoteTest {

	private IButtonDevice buttonDevice;
	private IObserver buttonProxyClient;
	private IButtonDevice buttonProxyServer;
	private IObserver buttonObserver;
	private int port = 8090;
	private ProtocolType protocol = ProtocolType.TCP;
	
	private void createComponents() {
		buttonDevice = new ButtonMock();
		buttonProxyServer = new ButtonProxyServer(port, protocol);
		buttonProxyClient = new ButtonProxyClient("localhost", 
				port, protocol);
		buttonObserver = new ButtonObserverForTest("010111111000000111000011110011100011000");
		
	}
	
	private void configureAndStartSimulation() {
		buttonProxyServer.addObserver(buttonObserver);
		buttonDevice.addObserver(buttonProxyClient);
	}
	
	@Test
	void buttonRemoteSendingMessagesToLogicTest() {
		createComponents();
		configureAndStartSimulation();
	}

}
