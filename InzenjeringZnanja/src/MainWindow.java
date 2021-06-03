import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		setSize(dimenzije.width * 5 / 6, dimenzije.height * 5 / 6);

		setLocationRelativeTo(null);

		setTitle("Informaciona bezbednost");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setBackground(Color.GRAY);
		
		JPanel zaDugmice = new JPanel();
		JButton izlistavanjeNapada = new JButton("Izlistaj sve napade");
		JButton dodavanjeNapada = new JButton("Dodaj novi napad");
		
		izlistavanjeNapada.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tableOfAttacks();
			}
		});
		
		dodavanjeNapada.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddingNewAttack dialogNewAttack = new AddingNewAttack();
				dialogNewAttack.setVisible(true);
				
			}
		});
		
		zaDugmice.add(izlistavanjeNapada);
		zaDugmice.add(dodavanjeNapada);
		this.add(zaDugmice, BorderLayout.NORTH);
        
		StatusBar statusBar = new StatusBar();
		c.add(statusBar, BorderLayout.SOUTH);

		this.addWindowListener(new MainWindowListener());
		this.setVisible(true);
	}
	
	private static void tableOfAttacks() {
        JFrame frame = new JFrame("Table of attacks");
        // Create and set up the content pane.
        T1Data newContentPane = new T1Data();
        frame.setContentPane(newContentPane);
        // Display the window.
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
	
}
