import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.ugos.jiprolog.engine.JIPEngine;
import com.ugos.jiprolog.engine.JIPQuery;
import com.ugos.jiprolog.engine.JIPTerm;
import com.ugos.jiprolog.engine.JIPVariable;

public class MitigationsDialog extends JDialog {

	private static final long serialVersionUID = 3845720553999385964L;
	
	private JLabel selectLabel;
	private JComboBox<?> selectCB;
	private JTextArea resultTA;
	
	private JButton suggestMitigationsButton;
	private JButton cancelButton;
	
	public MitigationsDialog() {
		setTitle("Mitigations suggestion");
		JPanel selectItemsPanel = new JPanel();
		JPanel forButtons = new JPanel();
		
		selectItemsPanel.setBackground(Color.LIGHT_GRAY);
		setModal(true);
		this.setSize(600, 450);
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		selectLabel = new JLabel("Select attack: ");
		selectLabel.setPreferredSize(new Dimension(250, 100));
		
		ReadingCSVFile readingCSVFile = new ReadingCSVFile();
        File file = new File("src//attacks.csv");
        ArrayList<String[]> readFile = readingCSVFile.ReadCSVfile(file);
        ArrayList<String> attackNames = new ArrayList<String>();
        for (String[] attackInfo : readFile) {
        	attackNames.add(attackInfo[0]);
		}
        selectCB = new JComboBox(attackNames.toArray());
        
        resultTA = new JTextArea(16, 50);
        resultTA.setLineWrap(true);
		resultTA.setText("Results will appear here...");
		resultTA.setEditable(false);
		resultTA.setFont(new Font("Arial", 2, 12));
        
        selectItemsPanel.add(selectLabel);
        selectItemsPanel.add(selectCB);
        selectItemsPanel.add(resultTA);
        
        suggestMitigationsButton = new JButton("Suggest Mitigations");
		cancelButton = new JButton("Cancel");
		
		forButtons.add(suggestMitigationsButton);
		forButtons.add(cancelButton);
		
		suggestMitigationsButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JIPEngine engine = new JIPEngine();
				engine.consultFile("src//knowledge_base.pl");
				String attackName = selectCB.getSelectedItem().toString().toLowerCase().replace(" ", "_");
				JIPQuery query = engine.openSynchronousQuery("mitigations(" + attackName + ",M)");
				
				resultTA.setText("");
				resultTA.append("----------------------------------------------------------------------------------------------------------------------------\n");
				
				JIPTerm solution;
				while ((solution = query.nextSolution()) != null) {
					for (JIPVariable var: solution.getVariables()) {
						resultTA.append(var.getValue().toString().replace("'", "") + "\n");
						resultTA.append("----------------------------------------------------------------------------------------------------------------------------\n");						
					}
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
		
		this.add(selectItemsPanel, BorderLayout.CENTER);
		this.add(forButtons, BorderLayout.SOUTH);
	}
	
}
