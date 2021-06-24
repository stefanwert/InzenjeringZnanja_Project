package cbr;

import java.util.ArrayList;
import java.util.Collection;
import javax.swing.JFrame;

import connector.CsvConnector;
import model.Attack;
import ucm.gaia.jcolibri.casebase.LinealCaseBase;
import ucm.gaia.jcolibri.cbraplications.StandardCBRApplication;
import ucm.gaia.jcolibri.cbrcore.Attribute;
import ucm.gaia.jcolibri.cbrcore.CBRCase;
import ucm.gaia.jcolibri.cbrcore.CBRCaseBase;
import ucm.gaia.jcolibri.cbrcore.CBRQuery;
import ucm.gaia.jcolibri.cbrcore.Connector;
import ucm.gaia.jcolibri.exception.ExecutionException;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.similarity.local.MaxString;
import ucm.gaia.jcolibri.method.retrieve.RetrievalResult;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.NNConfig;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.NNScoringMethod;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.similarity.global.Average;
import ucm.gaia.jcolibri.method.retrieve.selection.SelectCases;

public class CbrApplication implements StandardCBRApplication {
	
	Connector _connector;  /** Connector object */
	CBRCaseBase _caseBase;  /** CaseBase object */

	NNConfig simConfig;  /** KNN configuration */
	
	public void configure() throws ExecutionException {
		_connector =  new CsvConnector();
		
		_caseBase = new LinealCaseBase();  // Create a Lineal case base for in-memory organization
		
		simConfig = new NNConfig(); // KNN configuration
		simConfig.setDescriptionSimFunction(new Average());  // global similarity function = average

		simConfig.addMapping(new Attribute("parentOf", Attack.class), new MaxString());
		simConfig.addMapping(new Attribute("canFallow",Attack.class), new MaxString());
		simConfig.addMapping(new Attribute("domainsOfAttack",Attack.class), new MaxString());
		simConfig.addMapping(new Attribute("mitigations",Attack.class), new MaxString());
		simConfig.addMapping(new Attribute("weakness",Attack.class), new MaxString());
		// Equal - returns 1 if both individuals are equal, otherwise returns 0
		// Interval - returns the similarity of two number inside an interval: sim(x,y) = 1-(|x-y|/interval)
		// Threshold - returns 1 if the difference between two numbers is less than a threshold, 0 in the other case
		// EqualsStringIgnoreCase - returns 1 if both String are the same despite case letters, 0 in the other case
		// MaxString - returns a similarity value depending of the biggest substring that belong to both strings
		// EnumDistance - returns the similarity of two enum values as the their distance: sim(x,y) = |ord(x) - ord(y)|
		// EnumCyclicDistance - computes the similarity between two enum values as their cyclic distance
		// Table - uses a table to obtain the similarity between two values. Allowed values are Strings or Enums. The table is read from a text file.
		// TableSimilarity(List<String> values).setSimilarity(value1,value2,similarity) 
	}

	public void cycle(CBRQuery query) throws ExecutionException {
		Collection<RetrievalResult> eval = NNScoringMethod.evaluateSimilarity(_caseBase.getCases(), query, simConfig);
		eval = SelectCases.selectTopKRR(eval, 5);
		System.out.println("Retrieved cases:");
		for (RetrievalResult nse : eval)
			System.out.println(nse.get_case().getDescription() + " -> " + nse.getEval());
		
		ArrayList<String[]> procitano = new ArrayList<>();
		String[] jedanRedSplitovano;
		
		
		for (RetrievalResult nse : eval) {
			String[] a = new String[7];
			jedanRedSplitovano = a;
			String[] split1 = nse.get_case().getDescription().toString().split("=");
			//System.out.println(split1[1])
			//name
			String[] splitName = split1[1].split("'");
			jedanRedSplitovano[0] = splitName[1];
			//System.out.println(splitName[1]);
			//parentOf
			String[] splitParentOf = split1[2].split("'");
			jedanRedSplitovano[1] = splitParentOf[1];
			//System.out.println(splitParentOf[1]);
			//canFollow
			String[] splitCanFollow = split1[3].split("'");
			jedanRedSplitovano[2] = splitCanFollow[1];
			//System.out.println(splitCanFollow[1]);
			//domainsOfAttack
			String[] splitDomainsOfAttack = split1[4].split("'");
			jedanRedSplitovano[3] = splitDomainsOfAttack[1];
			//System.out.println(splitDomainsOfAttack[1]);
			//mitigation
			String[] splitMitigations = split1[5].split("'");
			jedanRedSplitovano[4] = splitMitigations[1];
			//System.out.println(splitMitigations[1]);
			//weakness
			String[] splitWeakness = split1[6].split("'");
			jedanRedSplitovano[5] = splitWeakness[1];
			//System.out.println(splitWeakness[1]);
			
			nse.getEval();
			jedanRedSplitovano[6] = String.valueOf((nse.getEval()));
			procitano.add(jedanRedSplitovano);
			for(String s : jedanRedSplitovano) {
				System.out.println(s);
			}
			
		}
		JFrame frame = new JFrame("Table of similar attacks");
        // Create and set up the content pane.
        T2Data newContentPane = new T2Data(procitano);
        frame.setContentPane(newContentPane);
        // Display the window.
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
		
	}
	
	public void parseCycle(CBRQuery query) {
		Collection<RetrievalResult> eval = NNScoringMethod.evaluateSimilarity(_caseBase.getCases(), query, simConfig);
		eval = SelectCases.selectTopKRR(eval, 5);
		
		ArrayList<String[]> procitano = new ArrayList<>();
		String[] jedanRedSplitovano;
		
		
		for (RetrievalResult nse : eval) {
			String[] split1 = nse.get_case().getDescription().toString().split("{");
			String[] split2 = split1[1].split("=");
			
			//name
			String[] splitName = split2[1].split(",");
			String splitName1 = splitName[0].substring(1,(splitName[0].length()-1));
			System.out.println(splitName1);
			nse.get_case().getDescription();
			nse.getEval();
		}
	}
	

	public void postCycle() throws ExecutionException {
		
	}

	public CBRCaseBase preCycle() throws ExecutionException {
		_caseBase.init(_connector);
		java.util.Collection<CBRCase> cases = _caseBase.getCases();
		for (CBRCase c: cases)
			System.out.println(c.getDescription());
		return _caseBase;
	}



}