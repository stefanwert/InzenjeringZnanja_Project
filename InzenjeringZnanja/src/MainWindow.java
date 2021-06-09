import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

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

		setTitle("Information security");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setBackground(Color.GRAY);
		
		JPanel welcomePanel = new JPanel(new GridBagLayout());
		TitledBorder title;
		Border blackline = BorderFactory.createLineBorder(Color.black);
		title = BorderFactory.createTitledBorder(blackline, "Welcome to the information security department");
		title.setTitleFont(new Font("Courier", Font.BOLD, 30));
		title.setTitleJustification(TitledBorder.CENTER);
		welcomePanel.setBorder(title);
		welcomePanel.setBackground(Color.LIGHT_GRAY);
		
		JLabel welcome1 = new JLabel("The application offers a display of all potential attacks and the entry of a new attack.");
		welcome1.setFont(new Font("Verdana", Font.PLAIN, 20));
		welcomePanel.add(welcome1);
		
		JLabel welcome2 = new JLabel("neki tekst - DOPISATI STA APLIKACIJA NUDI.");
		welcome2.setFont(new Font("Verdana", Font.PLAIN, 20));
		GridBagConstraints grid = new GridBagConstraints();
		grid.gridy = 1;
		grid.insets = new Insets(10, 0, 0, 0);
		welcomePanel.add(welcome2, grid);
		
		JPanel zaDugmice = new JPanel();
		zaDugmice.setBackground(new Color(240, 240, 245));
		JButton izlistavanjeNapada = new JButton("Show all attacks");
		JButton dodavanjeNapada = new JButton("Add new attack");
		
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
		
		this.add(welcomePanel, BorderLayout.CENTER);
        
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
