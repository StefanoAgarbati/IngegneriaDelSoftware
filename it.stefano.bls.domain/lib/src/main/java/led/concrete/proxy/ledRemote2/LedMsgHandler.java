package led.concrete.proxy.ledRemote2;

import interf.ILedDevice;
import interfaces.IConnection;
import interfaces.IMsgHandler;
import led.concrete.proxy.ledProxy0.LedMsg;
import utils.OutUtils;

public class LedMsgHandler implements IMsgHandler {

	private ILedDevice led;
	
	public LedMsgHandler(ILedDevice led) {
		this.led = led;
	}
	@Override
	public void handleMsg(String msg, IConnection conn) {
		OutUtils.out("LedMsgHandler | handling message " + msg);
		if(msg.equals(LedMsg.on))
			turnLedOn();
		else if(msg.equals(LedMsg.off))
			turnOffLed();
	}
	private void turnOffLed() {
		led.off();
		OutUtils.out("LedMsgHandler | led is turned off");
	}
	private void turnLedOn() {
		led.on();
		OutUtils.out("LedMsgHandler | led is turned on");
	}

}
