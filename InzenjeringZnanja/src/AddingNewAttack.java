import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AddingNewAttack extends JDialog {

	private JLabel warning;
	private JLabel nameLabel;
	private JTextField nameTF;
	private JLabel parentOfLabel;
	private JTextField parentOfTF;
	private JLabel canFollowLabel;
	private JTextField canFollowTF;
	private JLabel domainsOfAttacksLabel;
	private JLabel mitigationsLabel;
	private JLabel weaknessesLabel;
	private JTextArea mitigationsTA;
	private JTextArea weaknessTA;
	
	private JButton applyButton;
	private JButton cancelButton;
	
	public AddingNewAttack()
	{
		setTitle("Add new attack");
		
		JPanel addingAttackPanel = new JPanel();
		JPanel forButtons = new JPanel();
		
		addingAttackPanel.setBackground(Color.LIGHT_GRAY);
		setModal(true);
		this.setSize(400, 450);
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		warning = new JLabel("*** If there are not datas for some feature, just leave it blank.");
		warning.setFont(new Font("Verdana", Font.PLAIN, 11));
		nameLabel = new JLabel("Name of attack: ");
		parentOfLabel = new JLabel("Parent of: ");
		canFollowLabel = new JLabel("Can follow: ");
		domainsOfAttacksLabel = new JLabel("Domains od attack: ");
		mitigationsLabel = new JLabel("Mitigations: ");
		weaknessesLabel = new JLabel("Weaknesses: ");
		
		nameLabel.setPreferredSize(new Dimension(110, 20));
		parentOfLabel.setPreferredSize(new Dimension(110, 20));
		canFollowLabel.setPreferredSize(new Dimension(110, 20));
		domainsOfAttacksLabel.setPreferredSize(new Dimension(340, 20));
		mitigationsLabel.setPreferredSize(new Dimension(110, 20));
		weaknessesLabel.setPreferredSize(new Dimension(110, 20));
		
		nameTF = new JTextField(20);
		parentOfTF = new JTextField(20);
		canFollowTF = new JTextField(20);
		mitigationsTA = new JTextArea(4, 20);
		mitigationsTA.setLineWrap(true);
		weaknessTA = new JTextArea(4, 20);
		weaknessTA.setLineWrap(true);
		
		JRadioButton softwareRB = new JRadioButton("Software");
		JRadioButton hardwareRB = new JRadioButton("Hardware");
		JRadioButton communicationsRB = new JRadioButton("Communications");
		JRadioButton socialEngineeringRB = new JRadioButton("Social Engineering");
		JRadioButton supplyChainRB = new JRadioButton("Supply chain");
		JRadioButton physicalSecurityRB = new JRadioButton("Physical security");
		
		addingAttackPanel.add(warning);
		addingAttackPanel.add(nameLabel);
		addingAttackPanel.add(nameTF);
		addingAttackPanel.add(parentOfLabel);
		addingAttackPanel.add(parentOfTF);
		addingAttackPanel.add(canFollowLabel);
		addingAttackPanel.add(canFollowTF);
		addingAttackPanel.add(mitigationsLabel);
		addingAttackPanel.add(mitigationsTA);
		addingAttackPanel.add(weaknessesLabel);
		addingAttackPanel.add(weaknessTA);
		addingAttackPanel.add(domainsOfAttacksLabel);
		addingAttackPanel.add(softwareRB);
		addingAttackPanel.add(hardwareRB);
		addingAttackPanel.add(communicationsRB);
		addingAttackPanel.add(socialEngineeringRB);
		addingAttackPanel.add(supplyChainRB);
		addingAttackPanel.add(physicalSecurityRB);
		
		applyButton = new JButton("Save");
		cancelButton = new JButton("Cancel");
		
		forButtons.add(applyButton);
		forButtons.add(cancelButton);
		
		cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();	
			}
		});

		ReadingCSVFile readingCSVFile = new ReadingCSVFile();
		File attacks = new File("src\\\\attacks.csv");
		ArrayList<String[]> procitano = readingCSVFile.ReadCSVfile(attacks);
		
		applyButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(nameTF.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "You must enter name of attack.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				else {
					for(String[] element : procitano)
					{
						if(element[0].equals(nameTF.getText())) {
							JOptionPane.showMessageDialog(null, "That attack already exists.", "Error", JOptionPane.ERROR_MESSAGE);
							return;
						}		
					}
				}
				
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
				
				if(parentOfTF.getText().isEmpty())
					parentOfTF.setText("None");
				
				if(canFollowTF.getText().isEmpty())
					canFollowTF.setText("None");
				
				if(mitigationsTA.getText().isEmpty())
					mitigationsTA.setText("None");
				
				if(weaknessTA.getText().isEmpty())
					weaknessTA.setText("None");
				
				try(FileWriter fw = new FileWriter("src\\attacks.csv", true);
					BufferedWriter bw = new BufferedWriter(fw);
					PrintWriter pw = new PrintWriter(bw)) 
				{
					pw.println();
					pw.print(nameTF.getText() + ";" + parentOfTF.getText() + ";" + canFollowTF.getText() + ";" + selectedDomainOfAttack.toString() + ";" + mitigationsTA.getText() + ";" + weaknessTA.getText());
					
					pw.flush();
					pw.close();
					
					JOptionPane.showMessageDialog(null, "The attack was successfully added to the base.", "Succesfully action", JOptionPane.INFORMATION_MESSAGE);
				} catch(Exception E) {
					JOptionPane.showMessageDialog(null, "Error: the attack was NOT successfully added to the base.", "Succesfully action", JOptionPane.INFORMATION_MESSAGE);
					
				}
			}
		});
		
		this.add(addingAttackPanel, BorderLayout.CENTER);
		this.add(forButtons, BorderLayout.SOUTH);
		
	}	
	
}
