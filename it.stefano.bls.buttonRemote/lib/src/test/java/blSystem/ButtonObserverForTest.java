package blSystem;

import static org.junit.jupiter.api.Assertions.assertTrue;

import observable.GenericObserver;

public class ButtonObserverForTest extends GenericObserver {

	private String[] data;
	private int count = 0;
	
	public ButtonObserverForTest(String data) {
		initData(data);
	}
	private void initData(String data) {
		this.data = new String[data.length()];
		for(int i = 0; i < data.length(); i++) {
			this.data[i] = (data.charAt(i) == '0') ? "released" : "pressed";
		}
	}
	//010111111000000111000011110011100011000
	@Override
	public void update(String data) {
		System.out.println("ButtonObserverForTest|Data received " + count + ": " + data);
		assertTrue(this.data[count].equals(data));
		count++;
	}

}
