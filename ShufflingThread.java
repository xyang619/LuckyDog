
/**
 *
 * @author young
 */

import java.util.Random;

import javax.swing.ImageIcon;

public class ShufflingThread extends Thread {
  private boolean runFlag = true;
	private MainFrame frame = null;
	Random random = new Random();

	public ShufflingThread(MainFrame frame) {
		start();
		this.frame = frame;
	}

	public void start() {
		runFlag = false;
		super.start();
	}

	public void changeFlagStart() {
		runFlag = true;
	}

	public void changeFlagStop() {
		runFlag = false;
	}

	public void run() {
		while (runFlag) {
			frame.index = random.nextInt(frame.names.size());
			String image = "images/"+ frame.names.get(frame.index)+ ".png";
			frame.congLabel.setText(frame.names.get(frame.index));
			frame.picLabel.setIcon(new ImageIcon(image));
			try {
				sleep(20);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
