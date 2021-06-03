import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.util.ArrayList;
import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
		
		JPanel zaDugmice = new JPanel();
		JButton izlistavanjeNapada = new JButton("Izlistaj sve napade");
		JButton dodavanjeNapada = new JButton("Dodaj novi napad");
		zaDugmice.add(izlistavanjeNapada);
		zaDugmice.add(dodavanjeNapada);
		this.add(zaDugmice, BorderLayout.NORTH);
        
        tableOfAttacks();
        
		StatusBar statusBar = new StatusBar();
		c.add(statusBar, BorderLayout.SOUTH);

		this.addWindowListener(new MainWindowListener());
		this.setVisible(true);
	}
	
	private static void tableOfAttacks() {
        // Create and set up the window.
        JFrame frame = new JFrame("Table of attacks");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Create and set up the content pane.
        T1Data newContentPane = new T1Data();
        frame.setContentPane(newContentPane);
        // Display the window.
        frame.pack();
        frame.setVisible(true);
    }
	
}
