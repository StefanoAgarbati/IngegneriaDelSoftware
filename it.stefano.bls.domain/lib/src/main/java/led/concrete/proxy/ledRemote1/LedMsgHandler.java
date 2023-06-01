package led.concrete.proxy.ledRemote1;

import interf.ILedDevice;
import interfaces.IConnection;
import led.concrete.proxy.ledProxy0.LedMsg;

public class LedMsgHandler implements IMsgHandler {

	private ILedDevice led;
	
	public LedMsgHandler(ILedDevice led) {
		this.led = led;
	}
	@Override
	public void handleMsg(String msg, IConnection conn) {
		if(msg.equals(LedMsg.on))
			turnLedOn();
		else if(msg.equals(LedMsg.off))
			turnOffLed();
	}
	private void turnOffLed() {
		led.off();
	}
	private void turnLedOn() {
		led.on();
	}

}
