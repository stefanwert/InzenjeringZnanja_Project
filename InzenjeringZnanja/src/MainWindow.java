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
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import cbr.T2Data;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 230133077301730757L;
	
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
		
		JLabel welcome1 = new JLabel("The application offers a display of all potential attacks and the possibility of input a new attack.");
		welcome1.setFont(new Font("Verdana", Font.PLAIN, 20));
		welcomePanel.add(welcome1);
		
		JLabel welcome2 = new JLabel("Based on the symptoms you enter, you can see the likelihood that a particular attack has occurred.");
		welcome2.setFont(new Font("Verdana", Font.PLAIN, 20));
		GridBagConstraints grid = new GridBagConstraints();
		grid.gridy = 1;
		grid.insets = new Insets(10, 0, 0, 0);
		welcomePanel.add(welcome2, grid);
		
		JLabel welcome3 = new JLabel("Also, depending on the characteristics of the attack that we list, we can find the most similar attack.");
		welcome3.setFont(new Font("Verdana", Font.PLAIN, 20));
		GridBagConstraints grid2 = new GridBagConstraints();
		grid2.gridy = 2;
		grid2.insets = new Insets(10, 0, 0, 0);
		welcomePanel.add(welcome3, grid2);
		
		JLabel welcome4 = new JLabel("It is possible to suggest measures that the engineer should take.");
		welcome4.setFont(new Font("Verdana", Font.PLAIN, 20));
		GridBagConstraints grid3 = new GridBagConstraints();
		grid3.gridy = 3;
		grid3.insets = new Insets(10, 0, 0, 0);
		welcomePanel.add(welcome4, grid3);
		
		JLabel welcome5 = new JLabel("Based on input threats, the system risk calculation option is enabled.");
		welcome5.setFont(new Font("Verdana", Font.PLAIN, 20));
		GridBagConstraints grid4 = new GridBagConstraints();
		grid4.gridy = 4;
		grid4.insets = new Insets(10, 0, 0, 0);
		welcomePanel.add(welcome5, grid4);
		
		JLabel welcome6 = new JLabel("<html><br/>Let's stay protected :)<html>");
		welcome6.setFont(new Font("Verdana", Font.PLAIN, 20));
		GridBagConstraints grid5 = new GridBagConstraints();
		grid5.gridy = 6;
		grid5.insets = new Insets(10, 0, 0, 0);
		welcomePanel.add(welcome6, grid5);
		
		JPanel zaDugmice = new JPanel();
		zaDugmice.setBackground(new Color(240, 240, 245));
		JButton izlistavanjeNapada = new JButton("Show all attacks");
		JButton dodavanjeNapada = new JButton("Add new attack");
		JButton azuriranjeNapada = new JButton("Update attack");
		JButton procenaRizika = new JButton("Evaluate risk");
		JButton slicanNapad = new JButton("Find similar attack");
		JButton verovatnocaNapada = new JButton("Calculate probability");
		JButton sugerisanjeMera = new JButton("Mitigations suggestion");
		
		procenaRizika.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				RiskEvaluation riskEvalation = new RiskEvaluation();
				riskEvalation.setVisible(true);
			}
		});
		izlistavanjeNapada.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tableOfAttacks();
			}
		});
		
		slicanNapad.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FindSimilarAttacks findSimilarAttacks = new FindSimilarAttacks();
				findSimilarAttacks.setVisible(true);
				
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
		
		azuriranjeNapada.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UpdateAttack dialogUpdateAttack = new UpdateAttack();
				dialogUpdateAttack.setVisible(true);
				
			}
		});
		
		verovatnocaNapada.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BayesianNetworkProbabilityCalculatorDialog bayesianNetworkProbabilityCalculatorDialog = new BayesianNetworkProbabilityCalculatorDialog();
				bayesianNetworkProbabilityCalculatorDialog.setVisible(true);
			}
		});
		
		sugerisanjeMera.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MitigationsDialog mitigationsDialog = new MitigationsDialog();
				mitigationsDialog.setVisible(true);
			}
		});
		
		zaDugmice.add(izlistavanjeNapada);
		zaDugmice.add(dodavanjeNapada);
		zaDugmice.add(azuriranjeNapada);
		zaDugmice.add(procenaRizika);	
		zaDugmice.add(slicanNapad);
		zaDugmice.add(verovatnocaNapada);
		zaDugmice.add(sugerisanjeMera);
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
	
	private static void tableOfSimilarAttacks(ArrayList<String[]> procitano) {
		JFrame frame = new JFrame("Table of similar attacks");
        // Create and set up the content pane.
        T2Data newContentPane = new T2Data(procitano);
        frame.setContentPane(newContentPane);
        // Display the window.
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
	}
	
}
