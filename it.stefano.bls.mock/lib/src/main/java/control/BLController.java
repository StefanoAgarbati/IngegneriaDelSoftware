package control;

import interf.ILed;
import observable.GenericObserver;

public class BLController extends GenericObserver implements IBLController {
	
	private String curState = "s0";
	private ILed led;
	
	public BLController(ILed led) {
		setLed(led);
	}
	
	@Override
	public void update(String data) {
		if(data.equals("pressed"))
			onPressed();
		else if(data.equals("released"))
			onReleased();
	}
	
	private void onPressed() {
		if(curState.equals("s0")) {
			turnOnLed();
			setState("sOn0");
		} else if(curState.equals("sOn1")) {
			turnOffLed();
			setState("sOff0");
		} else if(curState.equals("sOff1")) {
			turnOnLed();
			setState("sOn0");
		}
	}
	private void onReleased(){
		if(curState.equals("sOn0")) {
			setState("sOn1");
		} else if(curState.equals("sOff0")) {
			setState("sOff1");
		} 
	}
	private void setState(String state) {
		this.curState = state;
	}
	private void turnOffLed() {
		led.off();
	}
	private void turnOnLed() {
		led.on();
	}
	
	private void setLed(ILed aLed) {
		this.led = aLed;
	}
}
