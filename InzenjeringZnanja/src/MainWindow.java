import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class MainWindow extends JFrame {

	private static MainWindow instance = null;

	public static MainWindow getInstance() {
		if(instance ==  null) 
			instance = new MainWindow();

		return instance;
	}
	
	public MainWindow() {
		Toolkit t = Toolkit.getDefaultToolkit();
		Dimension dimenzije = t.getScreenSize();
		setSize(dimenzije.width * 3 / 4, dimenzije.height * 3 / 4);

		setLocationRelativeTo(null);

		setTitle("Informaciona bezbednost");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setBackground(Color.GRAY);

		StatusBar statusBar = new StatusBar();
		c.add(statusBar, BorderLayout.SOUTH);

		this.addWindowListener(new MainWindowListener());
		this.setVisible(true);
	}
}
