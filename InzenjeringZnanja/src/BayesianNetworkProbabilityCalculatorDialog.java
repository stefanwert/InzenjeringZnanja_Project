import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

import unbbayes.io.NetIO;
import unbbayes.io.exception.LoadException;
import unbbayes.prs.Node;
import unbbayes.prs.bn.JunctionTreeAlgorithm;
import unbbayes.prs.bn.ProbabilisticNetwork;
import unbbayes.prs.bn.ProbabilisticNode;

public class BayesianNetworkProbabilityCalculatorDialog extends JDialog {

	private static final long serialVersionUID = -6861733121411280505L;

	private JLabel enterpriseLabel;
	private JComboBox<?> enterpriseCB;
	private JLabel continentLabel;
	private JComboBox<?> continentCB;
	private JLabel numberOfEmployeesLabel;
	private JComboBox<?> numberOfEmployeesCB;
	private JLabel threatLabel;
	private JComboBox<?> threatCB;
	private JScrollPane factorsP;
	private JLabel factorsLabel;
	private JList<?> factorsList;
	private JTextArea resultTA;
	
	private JButton calculateButton;
	private JButton cancelButton;
	
	public BayesianNetworkProbabilityCalculatorDialog() {		
		setTitle("Bayesian network probability calculator");
		JPanel selectItemsPanel = new JPanel();
		JPanel forButtons = new JPanel();
		
		selectItemsPanel.setBackground(Color.LIGHT_GRAY);
		setModal(true);
		this.setSize(600, 670);
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		enterpriseLabel = new JLabel("Enterprise: ");
		continentLabel = new JLabel("Continent: ");
		numberOfEmployeesLabel = new JLabel("Number of employees: ");
		threatLabel = new JLabel("Threat: ");
		factorsLabel = new JLabel("Factors: ");
		
		enterpriseLabel.setPreferredSize(new Dimension(250, 50));
		continentLabel.setPreferredSize(new Dimension(250, 50));
		numberOfEmployeesLabel.setPreferredSize(new Dimension(250, 50));
		threatLabel.setPreferredSize(new Dimension(250, 50));
		factorsLabel.setPreferredSize(new Dimension(250, 50));
		
		String enterpriseItems[] = { "Bank", "Military", "Trade center", "Health", "Other" };
		enterpriseCB = new JComboBox<Object>(enterpriseItems);
		String continentItems[] = { "Asia", "Africa", "North America", "South America", "Europe", "Australia" };
		continentCB = new JComboBox<Object>(continentItems);
		String numberOfEmployeesItems[] = { "Less than 100", "100-1000", "1000-10000", "More than 10000" };
		numberOfEmployeesCB = new JComboBox<Object>(numberOfEmployeesItems);
		String threatItems[] = { "Loss of confidentiality", "Loss of integrity", "Loss of availability" };
		threatCB = new JComboBox<Object>(threatItems);
		factorsP = new JScrollPane();
		factorsP.setPreferredSize(new Dimension(500, 120));
		ArrayList<String> factors = addFactors();
		factorsList = new JList<Object>(factors.toArray());
		factorsList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		factorsP.setViewportView(factorsList);
		
		enterpriseCB.setPreferredSize(new Dimension(200, 50));
		continentCB.setPreferredSize(new Dimension(200, 50));
		numberOfEmployeesCB.setPreferredSize(new Dimension(200, 50));
		threatCB.setPreferredSize(new Dimension(200, 50));

		resultTA = new JTextArea(16, 50);
		resultTA.setLineWrap(true);
		resultTA.setText("Results will appear here...");
		resultTA.setEditable(false);
		resultTA.setFont(new Font("Arial", 2, 12));
		
		selectItemsPanel.add(enterpriseLabel);
		selectItemsPanel.add(enterpriseCB);
		selectItemsPanel.add(continentLabel);
		selectItemsPanel.add(continentCB);
		selectItemsPanel.add(numberOfEmployeesLabel);
		selectItemsPanel.add(numberOfEmployeesCB);
		selectItemsPanel.add(threatLabel);
		selectItemsPanel.add(threatCB);
		//selectItemsPanel.add(factorsLabel);
		selectItemsPanel.add(factorsP);
		selectItemsPanel.add(resultTA);
		
		calculateButton = new JButton("Calculate");
		cancelButton = new JButton("Cancel");
		
		forButtons.add(calculateButton);
		forButtons.add(cancelButton);
		
		calculateButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ProbabilisticNetwork net = null;
				try {
					net = (ProbabilisticNetwork)new NetIO().load(new File("src//attacks_bayesian_network.net"));
				} catch (LoadException e1) {
					e1.printStackTrace();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
				JunctionTreeAlgorithm alg = new JunctionTreeAlgorithm();
				alg.setNetwork(net);
				alg.run();
				
				ProbabilisticNode findingNodeEnterprise = (ProbabilisticNode)net.getNode("Enterprise");
				ProbabilisticNode findingNodeContinent = (ProbabilisticNode)net.getNode("Continent");
				ProbabilisticNode findingNodeNumberOfEmployees = (ProbabilisticNode)net.getNode("Number_Of_Employees");
				ProbabilisticNode findingNodeThreat = (ProbabilisticNode)net.getNode("Threat");
				
				switch (enterpriseCB.getSelectedItem().toString()) {
				case "Bank":
					findingNodeEnterprise.addFinding(0);
					break;
				case "Military":
					findingNodeEnterprise.addFinding(1);
					break;
				case "Trade center":
					findingNodeEnterprise.addFinding(2);
					break;
				case "Health":
					findingNodeEnterprise.addFinding(3);
					break;
				case "Other":
					findingNodeEnterprise.addFinding(4);
					break;
				default:
					break;
				}
				
				switch (continentCB.getSelectedItem().toString()) {
				case "Asia":
					findingNodeContinent.addFinding(0);
					break;
				case "Africa":
					findingNodeContinent.addFinding(1);
					break;
				case "North America":
					findingNodeContinent.addFinding(2);
					break;
				case "South America":
					findingNodeContinent.addFinding(3);
					break;
				case "Europe":
					findingNodeContinent.addFinding(4);
					break;
				case "Australia":
					findingNodeContinent.addFinding(5);
					break;
				default:
					break;
				}
				
				switch (numberOfEmployeesCB.getSelectedItem().toString()) {
				case "Less than 100":
					findingNodeNumberOfEmployees.addFinding(0);
					break;
				case "100-1000":
					findingNodeNumberOfEmployees.addFinding(1);
					break;
				case "1000-10000":
					findingNodeNumberOfEmployees.addFinding(2);
					break;
				case "More than 10000":
					findingNodeNumberOfEmployees.addFinding(3);
					break;
				default:
					break;
				}
			
				switch (threatCB.getSelectedItem().toString()) {
				case "Loss of confidentiality":
					findingNodeThreat.addFinding(0);
					break;
				case "Loss of integrity":
					findingNodeThreat.addFinding(1);
					break;
				case "Loss of availability":
					findingNodeThreat.addFinding(2);
					break;
				default:
					break;
				}
				
				for (Object factor : factorsList.getSelectedValuesList()) {
					ProbabilisticNode findingNodeFactor = (ProbabilisticNode)net.getNode(factor.toString().replace(" ", "_"));
					findingNodeFactor.addFinding(0);
				}
				
				try {
					net.updateEvidences();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				HashMap<String, Float> results = new HashMap<String, Float>();		
				for (Node node : net.getNodes()) {
					if (node.getStatesSize() == 2 && node.getStateAt(0).equals("Attack happened")) {
						results.put(node.getName(), ((ProbabilisticNode)node).getMarginalAt(0));
					}
				}
				
				List<Entry<String, Float>> list = new LinkedList<Entry<String, Float>>(results.entrySet());
				Collections.sort(list, new Comparator<Entry<String, Float>>() {
					public int compare(Entry<String, Float> o1, Entry<String, Float> o2) {
						return ((Comparable<Float>)((Entry<String, Float>)(o2)).getValue()).compareTo(((Entry<String, Float>)(o1)).getValue());
					}
				});
				HashMap<String, Float> sortedResults = new LinkedHashMap<String, Float>();
				for (Iterator<Entry<String, Float>> it = list.iterator(); it.hasNext();) {
					Entry<String, Float> entry = (Entry<String, Float>)it.next();
					sortedResults.put(entry.getKey(), entry.getValue());
				}
				
				resultTA.setText("");
				resultTA.append("----------------------------------------------------------------------------------------------------------------------------\n");
				int counter = 0;
				Iterator<Entry<String, Float>> iterator = sortedResults.entrySet().iterator();
				while (iterator.hasNext() && counter < 5) {
					Map.Entry<String, Float> pair = (Map.Entry<String, Float>)iterator.next();
					resultTA.append("Attack name: " + pair.getKey().replace("_", " ") + "\n" + "Probability: " + pair.getValue()*100 + "%" + "\n");
					resultTA.append("----------------------------------------------------------------------------------------------------------------------------\n");
					iterator.remove();
					counter++;
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
	
	private ArrayList<String> addFactors() {
		ArrayList<String> factors = new ArrayList<String>();
		factors.add("Deadlock Condition");
		factors.add("Exposed API");
		factors.add("Concurrent Resource Access");
		factors.add("Modifying Resource");
		factors.add("User State Maintenance");
		factors.add("Faulty Finite State Machine");
		factors.add("Exposed Interface Functionality");
		factors.add("Vulnerable To Flooding Attack");
		factors.add("Manipulating Variables Used In Allocation Bug");
		factors.add("Resource Leak");
		factors.add("Safeguards Not Adequately Implemented");
		factors.add("Using Open Communications Channel");
		factors.add("Channel Vulnerable To Interception");
		factors.add("Request Takes More Time To Complete");
		factors.add("Protocol Or Implementations Contain Bugs");
		factors.add("Protection Functionality Problem");
		factors.add("Vulnerable Buffer");
		factors.add("Functions Share Resources Between Themselves");
		factors.add("Sharing Application Or Threads Compromised");
		factors.add("Pointer Variable Influenced");
		factors.add("Data Process Format Or Flag Compromised");
		factors.add("Separators And Parameter Identifiers Expressed In Regular Text");
		factors.add("User Input String Failed To Process Special Characters");
		factors.add("External Code Or Libraries Are Influenced");
		factors.add("Parameters Are Crafted Externally");
		factors.add("User Controlled Input Not Validated");
		factors.add("User Specified The Identifier Used To Access A System Resource");
		factors.add("String Input Is Concatenated To Form The Full Command");
		factors.add("Data Is Unserialized Before Validation");
		factors.add("Knowledge Of Systems Vulnerabilities");
		factors.add("Physical Access To The System");
		factors.add("Fault Injection Vulnerabilities Exposed");
		factors.add("Failed To Verify That The Communication Channel Is Operating Correctly");
		factors.add("Affected File Is Used Without Verifying Its Integrity");
		factors.add("Application Consulted External Files Or Configuration Controls");
		factors.add("Deployed System Influenced");
		factors.add("Deployed Component Accessed");
		factors.add("Failed To Protect Content From Modification");
		factors.add("Identity Associated With The Message Or Resource Is Removable Or Modifiable");
		factors.add("Decoy Action Performed");
		factors.add("Users Interface Manipulated");
		factors.add("Knowledge On How To Communicate With Target In Some Manner");
		
		return factors;
	}
}
