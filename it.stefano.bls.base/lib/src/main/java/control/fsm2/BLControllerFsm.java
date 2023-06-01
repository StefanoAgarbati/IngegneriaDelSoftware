package control.fsm2;

import interf.ILed;
import interfaces.IBLController;
import it.stefano.fsm.FsmBuilder;
import it.stefano.fsm.IFsm;
import observable.GenericObserver;

public class BLControllerFsm extends GenericObserver implements IBLController {
	
	private ILed led;
	private IFsm fsm;
	
	public BLControllerFsm(ILed aLed) {
		this.led = aLed;
		initFsm();
	}
	private void initFsm() {
		
		BLFsmActions actions = new BLFsmActions(led);
		
		FsmBuilder builder = FsmBuilder.create();
		
		fsm = builder.withState("s0")
		.withState("sOn0")
		.withState("sOn1")
		.withState("sOff0")
		.withState("sOff1")
		.withTransition("pressed", "s0", "sOn0")
		.withTransition("released", "sOn0", "sOn1")
		.withTransition("pressed", "sOn1", "sOff0")
		.withTransition("released", "sOff0", "sOff1")
		.withTransition("pressed", "sOff1", "sOn0")
		.withAction("s0", "pressed", () -> actions.execute("on"))
		.withAction("sOn1","pressed", () -> actions.execute("off"))
		.withAction("sOff1", "pressed", () -> actions.execute("on"))
		.withInitialState("s0")
		.build();
		
	}
	
	@Override
	public void update(String data) {
		fsm.update(data);
	}
	
}
