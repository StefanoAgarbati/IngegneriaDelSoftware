package button.concrete;

import observable.GenericObserver;
import observable.IObserver;
import utils.OutUtils;

public class ButtonMock extends ButtonDevice {

	private final String states = "010111111000000111000011110011100011000";
	

	public void startSimulation() {
		new Thread(() -> {
			doSimulation();
		}).start();
	}
	
	@Override
	public void addObserver(IObserver anObserver) {
		super.addObserver(anObserver);
		startSimulation();
	}

	private void doSimulation() {
		for(int i = 0; i < states.length(); i++) {
			char curState = states.charAt(i);
			setState(curState=='1' ? true : false);
			waitFor(200);
		}
	}
	private void waitFor(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	/*
	 * rapid testing
	 */
	public static void main(String[] args) {
		ButtonMock button = new ButtonMock();
		button.addObserver(new GenericObserver() {

			@Override
			public void update(String data) {
				OutUtils.out(data);
			}
			
		});
		button.startSimulation();
	}
}
