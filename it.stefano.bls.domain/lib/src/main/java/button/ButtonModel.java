package button;

import java.util.Observable;

import interf.IButtonModel;
import observable.GenericObservable;


public class ButtonModel extends GenericObservable implements IButtonModel {

	private boolean state = false;
	
	@Override
	public boolean isPressed() {
		return state;
	}
	
	public void setState(boolean state) {
		this.state = state;
		updateObservers();
	}

	private void updateObservers() {
		String state = this.state ? "pressed" : "released";
		updateObservers(state);
	}

	@Override
	public void update(Observable o, Object arg) {
		update(""+arg);
	}

	@Override
	public void update(String data) {
		if(data.equals("pressed"))
			setState(true);
		else if(data.equals("released"))
			setState(false);
	}


}
