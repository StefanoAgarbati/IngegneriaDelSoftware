package button.concrete;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonGui extends ButtonDevice {

	private JFrame frame;
	private JPanel panel;
	private JButton button;
	
	public ButtonGui() {
		initGui();
	}
	private void initGui() {
		frame = new JFrame("ButtonGui");
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		button = new JButton("Button");
		button.addMouseListener(new DefMouseListener());
		panel.add(button, BorderLayout.CENTER);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
	
	private class DefMouseListener implements MouseListener {
		
		
		@Override
		public void mouseClicked(MouseEvent e) {
		}

		@Override
		public void mousePressed(MouseEvent e) {
			setState(true);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			setState(false);
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}
		
	}
	public static void main(String[] args) {
		new ButtonGui();
	}
}
