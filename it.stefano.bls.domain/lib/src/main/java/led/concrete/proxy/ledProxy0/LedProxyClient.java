package led.concrete.proxy.ledProxy0;

import led.concrete.LedDevice;

public abstract class LedProxyClient extends LedDevice {

	
	@Override
	protected void doOn() {
		sendMsg(LedMsg.on);
	}

	protected abstract void sendMsg(String msg);

	@Override
	protected void doOff() {
		sendMsg(LedMsg.off);
	}

}
