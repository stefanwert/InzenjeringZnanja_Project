import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UpdateAttack extends JDialog {

	private static final long serialVersionUID = 4980753439575514620L;
	
	private JButton updateButton;
	private JButton cancelButton;
	private JButton automaticFill;
	private JLabel nameLabel;
	private JComboBox nameCB;
	private JLabel parentOfLabel;
	private JTextField parentOfTF;
	private JLabel canFollowLabel;
	private JTextField canFollowTF;
	private JLabel domainsOfAttacksLabel;
	private JLabel mitigationsLabel;
	private JLabel weaknessesLabel;
	private JTextArea mitigationsTA;
	private JTextArea weaknessTA;
	
    private String[] jedanRedIzFajlaSplitovano;
	
	public UpdateAttack() 
	{
		setTitle("Update attack");
		
		JPanel updateAttackPanel = new JPanel();
		JPanel forButtons = new JPanel();
		
		updateAttackPanel.setBackground(Color.LIGHT_GRAY);
		setModal(true);
		this.setSize(490, 540);
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		nameLabel = new JLabel("Name of attack: *");
		parentOfLabel = new JLabel("Parent of: ");
		canFollowLabel = new JLabel("Can follow: ");
		domainsOfAttacksLabel = new JLabel("Domains od attack: *");
		mitigationsLabel = new JLabel("Mitigations: ");
		weaknessesLabel = new JLabel("Weaknesses: ");
		
		nameCB = new JComboBox();
		
		try {
            BufferedReader brd = new BufferedReader(new FileReader(new File("src\\attacks.csv")));
            
            while (brd.ready()) {
                String jedanRedIzFajla = brd.readLine();
                jedanRedIzFajlaSplitovano = jedanRedIzFajla.split(";");
                System.out.println(jedanRedIzFajlaSplitovano[0]);
                nameCB.addItem(jedanRedIzFajlaSplitovano[0]);
            } 
            brd.close();
        } 
        catch (Exception e) {
            String errmsg = e.getMessage();
            System.out.println("File not found: " + errmsg);
        } 
		
		nameCB.setSelectedIndex(-1);
		
		parentOfTF = new JTextField(30);
		canFollowTF = new JTextField(30);
		mitigationsTA = new JTextArea(9, 30);
		mitigationsTA.setLineWrap(true);
		weaknessTA = new JTextArea(9, 30);
		weaknessTA.setLineWrap(true);
	
		final JRadioButton softwareRB = new JRadioButton("Software");
		final JRadioButton hardwareRB = new JRadioButton("Hardware");
		final JRadioButton communicationsRB = new JRadioButton("Communications");
		final JRadioButton socialEngineeringRB = new JRadioButton("Social Engineering");
		final JRadioButton supplyChainRB = new JRadioButton("Supply chain");
		final JRadioButton physicalSecurityRB = new JRadioButton("Physical security");

		nameLabel.setPreferredSize(new Dimension(110, 20));
		parentOfLabel.setPreferredSize(new Dimension(110, 20));
		canFollowLabel.setPreferredSize(new Dimension(110, 20));
		domainsOfAttacksLabel.setPreferredSize(new Dimension(120, 20));
		mitigationsLabel.setPreferredSize(new Dimension(110, 20));
		weaknessesLabel.setPreferredSize(new Dimension(110, 20));
		
		updateAttackPanel.add(nameLabel);
		updateAttackPanel.add(nameCB);
		updateAttackPanel.add(parentOfLabel);
		updateAttackPanel.add(parentOfTF);
		updateAttackPanel.add(canFollowLabel);
		updateAttackPanel.add(canFollowTF);
		updateAttackPanel.add(mitigationsLabel);
		updateAttackPanel.add(mitigationsTA);
		updateAttackPanel.add(weaknessesLabel);
		updateAttackPanel.add(weaknessTA);
		updateAttackPanel.add(domainsOfAttacksLabel);

		updateAttackPanel.add(softwareRB);
		updateAttackPanel.add(hardwareRB);
		updateAttackPanel.add(communicationsRB);
		updateAttackPanel.add(socialEngineeringRB);
		updateAttackPanel.add(supplyChainRB);
		updateAttackPanel.add(physicalSecurityRB);
		
		updateButton = new JButton("Update");
		cancelButton = new JButton("Cancel");
		automaticFill = new JButton("Automatically fill");
		
		updateButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				StringBuilder selectedDomainOfAttack = new StringBuilder();
				if(softwareRB.isSelected() || hardwareRB.isSelected() || communicationsRB.isSelected() || socialEngineeringRB.isSelected() || supplyChainRB.isSelected() || physicalSecurityRB.isSelected())
				{
					if(softwareRB.isSelected())
						selectedDomainOfAttack.append("Software");
					
					if(hardwareRB.isSelected())
						if(selectedDomainOfAttack.toString().isEmpty())
							selectedDomainOfAttack.append("Hardware");
						else
							selectedDomainOfAttack.append(", Hardware");
					
					if(communicationsRB.isSelected())
						if(selectedDomainOfAttack.toString().isEmpty())
							selectedDomainOfAttack.append("Communications");
						else
							selectedDomainOfAttack.append(", Communications");
					
					if(socialEngineeringRB.isSelected())
						if(selectedDomainOfAttack.toString().isEmpty())
							selectedDomainOfAttack.append("Social Engineering");
						else
							selectedDomainOfAttack.append(", Social Engineering");
					
					if(supplyChainRB.isSelected())
						if(selectedDomainOfAttack.toString().isEmpty())
							selectedDomainOfAttack.append("Supply chain");
						else
							selectedDomainOfAttack.append(", Supply chain");
					
					if(physicalSecurityRB.isSelected())
						if(selectedDomainOfAttack.toString().isEmpty())
							selectedDomainOfAttack.append("Physical security");
						else
							selectedDomainOfAttack.append(", Physical security");
				}
				
				else
				{
					JOptionPane.showMessageDialog(null, "You must select an attack domain.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				

				File stariFajl = new File("src\\attacks.csv");
				File tempFile = null;
				BufferedReader br;
				try {
					br = new BufferedReader(new FileReader(stariFajl));
				
					tempFile = new File("tempfile.txt");
			        PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
			        
			        String line = null;
			        // Read from the original file and write to the new
			        // unless content matches data to be removed.
			        String attackID = (String)nameCB.getSelectedItem();
			        while ((line = br.readLine()) != null) {
	
			            if (line.contains(attackID)) {
			            	pw.println((String)nameCB.getSelectedItem() + ";" + parentOfTF.getText() + ";" + canFollowTF.getText() + ";" + selectedDomainOfAttack.toString() + ";" + mitigationsTA.getText() + ";" + weaknessTA.getText());
			            } else {
				            pw.println(line);
				            pw.flush();
			            }
			        }
			        pw.close();
			        br.close();
			        JOptionPane.showMessageDialog(null, "The attack was successfully updated.", "Succesfully action", JOptionPane.INFORMATION_MESSAGE);
					
		        } catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Error: the attack was NOT successfully updated.", "Succesfully action", JOptionPane.INFORMATION_MESSAGE);
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
				}
		        
		        if (!stariFajl.delete()) {
		            System.out.println("Could not delete file");
		            return;
		        }
		        
		        if (!tempFile.renameTo(stariFajl))
		            System.out.println("Could not rename file");
				
				ReadingCSVFile readingCSVFile = new ReadingCSVFile();
				File attacks = new File("src\\attacks.csv");
				ArrayList<String[]> procitano = readingCSVFile.ReadCSVfile(attacks);
				
				JOptionPane.showMessageDialog(null, "The attack was successfully updated.", "Succesfully action", JOptionPane.INFORMATION_MESSAGE);
						
				
			}
		});
		
		automaticFill.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String izabrano = (String)nameCB.getSelectedItem();
				
				try {
		            BufferedReader brd = new BufferedReader(new FileReader(new File("src\\attacks.csv")));
		            
		            while (brd.ready()) {
		                String jedanRedIzFajla = brd.readLine();
		                jedanRedIzFajlaSplitovano = jedanRedIzFajla.split(";");
		                if(jedanRedIzFajlaSplitovano[0].equals(izabrano))
		                {
		                	softwareRB.setSelected(false);
		                	hardwareRB.setSelected(false);
		                	communicationsRB.setSelected(false);
		                	supplyChainRB.setSelected(false);
		                	socialEngineeringRB.setSelected(false);
		                	physicalSecurityRB.setSelected(false);
		                	parentOfTF.setText(jedanRedIzFajlaSplitovano[1]);
		                	canFollowTF.setText(jedanRedIzFajlaSplitovano[2]);
		                	mitigationsTA.setText(jedanRedIzFajlaSplitovano[4]);
		                	mitigationsTA.setLineWrap(true);
		                	weaknessTA.setText(jedanRedIzFajlaSplitovano[5]);
		                	weaknessTA.setLineWrap(true);
		                	if(jedanRedIzFajlaSplitovano[3].contains("Software"))
		                		softwareRB.setSelected(true);
		                	if(jedanRedIzFajlaSplitovano[3].contains("Hardware"))
		                		hardwareRB.setSelected(true);
		                	if(jedanRedIzFajlaSplitovano[3].contains("Communications"))
		                		communicationsRB.setSelected(true);
		                	if(jedanRedIzFajlaSplitovano[3].contains("Supply Chain"))
		                		supplyChainRB.setSelected(true);
		                	if(jedanRedIzFajlaSplitovano[3].contains("Social Engineering"))
		                		socialEngineeringRB.setSelected(true);
		                	if(jedanRedIzFajlaSplitovano[3].contains("Physical Security"))
		                		physicalSecurityRB.setSelected(true);
		                	break;
		                }
		            } 
		            brd.close();
		        } 
		        catch (Exception e2) {
		            String errmsg = e2.getMessage();
		            System.out.println("File not found: " + errmsg);
		        } 
				
			}
		});
		
		cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();	
			}
		});
		
		forButtons.add(automaticFill);
		forButtons.add(updateButton);
		forButtons.add(cancelButton);
		
		this.add(updateAttackPanel, BorderLayout.CENTER);
		this.add(forButtons, BorderLayout.SOUTH);
	}

}
