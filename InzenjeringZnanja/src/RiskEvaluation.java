import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.JFuzzyLogic;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class RiskEvaluation  extends JDialog{

	private static final long serialVersionUID = 7446218372803787216L;
	
	private ButtonGroup access_vector = new ButtonGroup();
	private ButtonGroup access_complexity = new ButtonGroup();
	private ButtonGroup confidentiality_impact = new ButtonGroup();
	private ButtonGroup integrity_impact = new ButtonGroup();
	private ButtonGroup availability_impact = new ButtonGroup();
	private ButtonGroup report_confidence = new ButtonGroup();
	private ButtonGroup collateral_damage_potential = new ButtonGroup();
	private ButtonGroup attack_complexity = new ButtonGroup();
	private ButtonGroup privileges_required = new ButtonGroup();
	
	private JRadioButton local= new JRadioButton("LOCAL");
	private JRadioButton remote = new JRadioButton("REMOTE");
	
	private JRadioButton high= new JRadioButton("HIGH");
	private JRadioButton low = new JRadioButton("LOW");
	
	private JRadioButton noneb= new JRadioButton("NONE");
	private JRadioButton partial = new JRadioButton("PARTIAL");
	private JRadioButton complete= new JRadioButton("COMPLETE");
	
	private JRadioButton none2= new JRadioButton("NONE");
	private JRadioButton partial2 = new JRadioButton("PARTIAL");
	private JRadioButton complete2= new JRadioButton("COMPLETE");
	
	private JRadioButton none3= new JRadioButton("NONE");
	private JRadioButton partial3 = new JRadioButton("PARTIAL");
	private JRadioButton complete3= new JRadioButton("COMPLETE");
	
	private JRadioButton unconfirmed= new JRadioButton("UNCONFIRMED");
	private JRadioButton uncorroborated = new JRadioButton("UNCORROBORATED");
	private JRadioButton confirmed= new JRadioButton("CONFIRMED");
	
	private JRadioButton none4= new JRadioButton("NONE");
	private JRadioButton low4 = new JRadioButton("LOW");
	private JRadioButton medium4= new JRadioButton("MEDIUM");
	private JRadioButton high4= new JRadioButton("HIGH");
	
	private JRadioButton low5= new JRadioButton("LOW");
	private JRadioButton high5= new JRadioButton("HIGH");
	
	private JRadioButton low6= new JRadioButton("LOW");
	private JRadioButton high6= new JRadioButton("HIGH");
	private JRadioButton none6= new JRadioButton("NONE");
	
	private JTextArea resultTA;
	
	private JButton calculateButton;
	private JButton cancelButton;
	
	public RiskEvaluation() {
		setTitle("Risk evaluation");
		JPanel forButtons = new JPanel();
		
		setModal(true);
		this.setSize(560, 700);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		access_vector.add(local);
		access_vector.add(remote);
		local.setSelected(true);
		JPanel p1 = new JPanel();
		p1.add(new Label("ACCESS VECTOR:"));
		p1.add(local);
		p1.add(remote);
		p1.setBackground(Color.LIGHT_GRAY);
		panel.add(p1);
		
		access_complexity.add(high);
		access_complexity.add(low);
		low.setSelected(true);
		JPanel p2 = new JPanel();
		p2.add(new Label("ACCESS COMPLEXITY:"));
		p2.add(low);
		p2.add(high);
		p2.setBackground(Color.LIGHT_GRAY);
		panel.add(p2);
		
		confidentiality_impact.add(noneb);
		confidentiality_impact.add(partial);
		confidentiality_impact.add(complete);
		noneb.setSelected(true);
		JPanel p3 = new JPanel();
		p3.add(new Label("CONFIDENTIALITY IMPACT:"));
		p3.add(noneb);
		p3.add(partial);
		p3.add(complete);
		p3.setBackground(Color.LIGHT_GRAY);
		panel.add(p3);
		
		integrity_impact.add(none2);
		integrity_impact.add(partial2);
		integrity_impact.add(complete2);
		none2.setSelected(true);
		JPanel p4 = new JPanel();
		p4.add(new Label("INTEGRITY IMPACT:"));
		p4.add(none2);
		p4.add(partial2);
		p4.add(complete2);
		p4.setBackground(Color.LIGHT_GRAY);
		panel.add(p4);
		
		availability_impact.add(none3);
		availability_impact.add(partial3);
		integrity_impact.add(complete3);
		none3.setSelected(true);
		JPanel p5 = new JPanel();
		p5.add(new Label("AVAILABILITY IMPACT:"));
		p5.add(none3);
		p5.add(partial3);
		p5.add(complete3);
		p5.setBackground(Color.LIGHT_GRAY);
		panel.add(p5);
		
		report_confidence.add(uncorroborated);
		report_confidence.add(unconfirmed);
		report_confidence.add(confirmed);
		unconfirmed.setSelected(true);
		JPanel p6 =new JPanel();
		p6.add(new Label("REPORT CONFIDENCE:"));
		p6.add(unconfirmed);
		p6.add(uncorroborated);
		p6.add(confirmed);
		p6.setBackground(Color.LIGHT_GRAY);
		panel.add(p6);
		
		collateral_damage_potential.add(none4);
		collateral_damage_potential.add(low4);
		collateral_damage_potential.add(medium4);
		collateral_damage_potential.add(high4);
		none4.setSelected(true);
		JPanel p7 =new JPanel();
		p7.add(new Label("COLLATERAL DAMAGE POTENTIAL"));
		p7.add(none4);
		p7.add(low4);
		p7.add(medium4);
		p7.add(high4);
		p7.setBackground(Color.LIGHT_GRAY);
		panel.add(p7);
		
		attack_complexity.add(low5);
		attack_complexity.add(high5);
		low5.setSelected(true);
		JPanel p8 = new JPanel();
		p8.add(new Label("ATTACK COMPLEXITY"));
		p8.add(low5);
		p8.add(high5);
		p8.setBackground(Color.LIGHT_GRAY);
		panel.add(p8);
		
		privileges_required.add(none6);
		privileges_required.add(low6);
		privileges_required.add(high6);
		none6.setSelected(true);
		JPanel p9 = new JPanel();
		p9.add(new Label("PRIVILEGES REQUIRED"));
		p9.add(none6);
		p9.add(low6);
		p9.add(high6);
		p9.setBackground(Color.LIGHT_GRAY);
		panel.add(p9);
		
		resultTA = new JTextArea(16, 50);
		resultTA.setLineWrap(true);
		resultTA.setText("Results will appear here...");
		resultTA.setEditable(false);
		resultTA.setFont(new Font("Arial", 2, 12));
		
		panel.add(resultTA);
		
		calculateButton = new JButton("Calculate");
		cancelButton = new JButton("Cancel");
		
		forButtons.add(calculateButton);
		forButtons.add(cancelButton);
		panel.add(forButtons);
		
		cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		
		calculateButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				double arg[] = new double[9];
				
				//access_vector
				if(local.isSelected()) {
					arg[0] = 0.5;
				}else {
					arg[0] = 0.8;
				}
				//access_complexity
				if(low.isSelected()) {
					arg[1] = 0.6;
				}else {
					arg[1]= 0.9;
				}
				//confidentiality_impact
				if(noneb.isSelected()) {
					arg[2] = 0.2;
				}else if(partial.isSelected()) {
					arg[2] = 0.6; 
				}else {
					arg[2] = 0.8;
				}
				//integrity_impact
				if(none2.isSelected()) {
					arg[3] = 0.2;
				}else if(partial2.isSelected()) {
					arg[3] = 0.5;
				}else {
					arg[3] = 0.8;
				}
				//availability_impact
				if(none3.isSelected()) {
					arg[4] = 0.2;
				}else if(partial3.isSelected()) {
					arg[4] = 0.5;
				}else {
					arg[4] = 0.8;
				}
				//report_confidence
				if(unconfirmed.isSelected()) {
					arg[5] = 0.9;
				}else if(uncorroborated.isSelected()) {
					arg[5]= 0.95;
				}else {
					arg[5] = 1;
				}
				//collateral_damage_potential
				if(none4.isSelected()) {
					arg[6] = 0.05;
 				}else if(low4.isSelected()) {
					arg[6] = 0.2;
				}else if(medium4.isSelected()) {
					arg[6] = 0.3;
				}else {
					arg[6] = 0.4;
				}
				//attack_complexity
				if(low5.isSelected()) {
					arg[7] = 0.77;
				}else {
					arg[7] = 0.44;
				}
				//privileges_required
				if(none6.isSelected()) {
					arg[8] = 0.85;
				}else if(low6.isSelected()) {
					arg[8] = 0.62;
				}else {
					arg[8] = 0.27;
				}
				
				// TODO Auto-generated method stub
				String[] strings = {"-noCharts", "-e", "src//RiskOfVulnerability.fcl.txt",
						Double.toString(arg[1]),
						Double.toString(arg[0]),
						Double.toString(arg[7]),
						Double.toString(arg[4]),
						Double.toString(arg[6]),
						Double.toString(arg[2]),
						Double.toString(arg[3]),
						Double.toString(arg[8]),
						Double.toString(arg[5])};
		 		JFuzzyLogic f2 = new JFuzzyLogic(strings);
		 		f2.run();
		 		FIS fis = f2.getFis();
		 		Variable accessVector = fis.getVariable("access_vector");
		 		Variable accessComplexity = fis.getVariable("access_complexity");
		 		Variable confidentialityImpact = fis.getVariable("confidentiality_impact");
		 		Variable integrityImpact = fis.getVariable("integrity_impact");
		 		Variable availabilityImpact = fis.getVariable("availability_impact");
		 		Variable reportConfidence = fis.getVariable("report_confidence");
		 		Variable collateralDamagePotential = fis.getVariable("collateral_damage_potential");
		 		Variable attackComplexity = fis.getVariable("attack_complexity");
		 		Variable privilegesRequired = fis.getVariable("privileges_required");
		 		Variable riskOfVulnerability = fis.getVariable("risk_of_vulnerability");
		 		
		 		resultTA.setText("");
		 		resultTA.append("----------------------------------------------------------------------------------------------------------------------------\n");
		 		resultTA.append("Risk of vulnerability is " + riskOfVulnerability.getValue() + ".\n\n\n");
		 		resultTA.append("[DETAILED OUTPUT]\n\n");
		 		resultTA.append("Access Vector -> " + accessVector.getValue() + "\n");
		 		resultTA.append("Access Complexity -> " + accessComplexity.getValue() + "\n");
		 		resultTA.append("Confidentiality Impact -> " + confidentialityImpact.getValue() + "\n");
		 		resultTA.append("Integrity Impact -> " + integrityImpact.getValue() + "\n");
		 		resultTA.append("Availability Impact -> " + availabilityImpact.getValue() + "\n");
		 		resultTA.append("Report Confidence -> " + reportConfidence.getValue() + "\n");
		 		resultTA.append("Collateral Damage Potential -> " + collateralDamagePotential.getValue() + "\n");
		 		resultTA.append("Attack Complexity -> " + attackComplexity.getValue() + "\n");
		 		resultTA.append("Privileges Required -> " + privilegesRequired.getValue() + "\n");
		 		resultTA.append("----------------------------------------------------------------------------------------------------------------------------");
			}
		});
		this.add(panel);
	}
	
}

