package led.concrete;

import utils.OutUtils;

public class LedMock extends LedDevice {

	private String rep = "led(state)";
	
	public LedMock() {
		OutUtils.out("LedMock | created wow");
	}
	@Override
	protected void doOn() {
		show("on");
	}

	@Override
	protected void doOff() {
		show("off");
	}
	
	private void show(String state) {
		OutUtils.out("led("+state+")");
	}
	private String getStringRep() {
		String state = isOn() ? "on" : "off";
		String rep = this.rep.replace("state", state);
		return rep;
	}

}
