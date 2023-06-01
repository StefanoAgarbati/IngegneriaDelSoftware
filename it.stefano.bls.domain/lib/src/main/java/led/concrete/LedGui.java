package led.concrete;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import interf.ILedDevice;
import led.Led;
import led.LedFactory;
import led.LedType;

public class LedGui extends LedDevice {

	private JFrame frame;
	private JPanel panel;
	private Color onColor;
	private Color offColor;
	private Color curColor;
	
	public LedGui() {
		this(Color.GREEN, Color.RED);
	}
	public LedGui(Color onColor, Color offColor) {
		this.onColor = onColor;
		this.offColor = offColor;
		frame = new JFrame("LedGui");
		panel = new JPanel();
		frame.add(panel);
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		off();
	}
	@Override
	protected void doOn() {
		curColor = onColor;
		update();
	}

	@Override
	protected void doOff() {
		curColor = offColor;
		update();
	}
	private void update() {
		panel.setBackground(curColor);
	}
	
	public static void main(String[] args) throws Exception {
		ILedDevice led = LedFactory.createLedDevice(LedType.GUI);
		led.off();
		Thread.sleep(2000);
		led.on();
	}

}
