import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddingNewAttack extends JDialog {

	private JLabel nameLabel;
	private JTextField nameTF;
	private JLabel parentOfLabel;
	private JTextField parentOfTF;
	private JLabel canFollowLabel;
	private JTextField canFollowTF;
	private JLabel domainsOfAttacksLabel;
	private ButtonGroup domainsOfAttacksButton;
	private JLabel mitigationsLabel;
	private JTextField mitigationsTF;
	private JLabel weaknessesLabel;
	private JTextField weaknessesTF;
	
	private JButton applyButton;
	private JButton cancelButton;
	
	public AddingNewAttack()
	{
		setTitle("Add new attack");
		
		JPanel addingAttackPanel = new JPanel();
		JPanel forButtons = new JPanel();
		
		addingAttackPanel.setBackground(Color.LIGHT_GRAY);
		setModal(true);
		this.setSize(400, 500);
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		nameLabel = new JLabel("Name of attack: ");
		parentOfLabel = new JLabel("Parent of: ");
		canFollowLabel = new JLabel("Can follow: ");
		domainsOfAttacksLabel = new JLabel("Domains od attack: ");
		mitigationsLabel = new JLabel("Mitigations: ");
		weaknessesLabel = new JLabel("Weaknesses: ");
		
		nameLabel.setPreferredSize(new Dimension(110, 20));
		parentOfLabel.setPreferredSize(new Dimension(110, 20));
		canFollowLabel.setPreferredSize(new Dimension(110, 20));
		domainsOfAttacksLabel.setPreferredSize(new Dimension(110, 20));
		mitigationsLabel.setPreferredSize(new Dimension(110, 20));
		weaknessesLabel.setPreferredSize(new Dimension(110, 20));
		
		nameTF = new JTextField(20);
		parentOfTF = new JTextField(20);
		canFollowTF = new JTextField(20);
		mitigationsTF = new JTextField(20);
		weaknessesTF = new JTextField(20);
		
		domainsOfAttacksButton = new ButtonGroup();
		JRadioButton softwareRB = new JRadioButton("Software");
		JRadioButton hardwareRB = new JRadioButton("Hardware");
		JRadioButton communicationsRB = new JRadioButton("Communications");
		JRadioButton socialEngineeringRB = new JRadioButton("Social Engineering");
		domainsOfAttacksButton.add(softwareRB);
		domainsOfAttacksButton.add(hardwareRB);
		domainsOfAttacksButton.add(communicationsRB);
		domainsOfAttacksButton.add(socialEngineeringRB);
		
		addingAttackPanel.add(nameLabel);
		addingAttackPanel.add(nameTF);
		addingAttackPanel.add(parentOfLabel);
		addingAttackPanel.add(parentOfTF);
		addingAttackPanel.add(canFollowLabel);
		addingAttackPanel.add(canFollowTF);
		addingAttackPanel.add(domainsOfAttacksLabel);
		addingAttackPanel.add(softwareRB);
		addingAttackPanel.add(hardwareRB);
		addingAttackPanel.add(communicationsRB);
		addingAttackPanel.add(socialEngineeringRB);
		addingAttackPanel.add(mitigationsLabel);
		addingAttackPanel.add(mitigationsTF);
		addingAttackPanel.add(weaknessesLabel);
		addingAttackPanel.add(weaknessesTF);
		
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
		
		this.add(addingAttackPanel, BorderLayout.CENTER);
		this.add(forButtons, BorderLayout.SOUTH);
		
	}	
	
}
