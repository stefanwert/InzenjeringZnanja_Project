package connector;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import model.Attack;
import ucm.gaia.jcolibri.cbrcore.CBRCase;
import ucm.gaia.jcolibri.cbrcore.CaseBaseFilter;
import ucm.gaia.jcolibri.cbrcore.Connector;
import ucm.gaia.jcolibri.exception.InitializingException;
import ucm.gaia.jcolibri.util.FileIO;

public class CsvConnector implements Connector {
	
	@Override
	public Collection<CBRCase> retrieveAllCases() {
		LinkedList<CBRCase> cases = new LinkedList<CBRCase>();
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(FileIO.openFile("data/attacks.csv")));
			if (br == null)
				throw new Exception("Error opening file");

			String line = "";
			while ((line = br.readLine()) != null) {
				if (line.startsWith("#") || (line.length() == 0))
					continue;
				String[] values = line.split(";");

				CBRCase cbrCase = new CBRCase();

				/*TransactionDescription txDescription = new TransactionDescription();
				
				RealEstateDescription reDescription = new RealEstateDescription();
				reDescription.setAge(Integer.parseInt(values[1]));
				reDescription.setDistanceToPublicTransportation(Integer.parseInt(values[2]));
				reDescription.setLocalStores(Integer.parseInt(values[3]));
				txDescription.setRealEstateDescription(reDescription);
				
				txDescription.setYear(Integer.parseInt(values[0]));
				txDescription.setPrice(Integer.parseInt(values[4]));
				
				cbrCase.setDescription(txDescription);*/
				Attack attack = new Attack();
				sortAllValues(values);

				attack.setName(values[0]);
				attack.setParentOf(values[1]);
				attack.setCanFallow(values[2]);
				attack.setDomainsOfAttack(values[3]);
				attack.setMitigations(values[4]);
				attack.setWeakness(values[5]);

				cbrCase.setDescription(attack);

				cases.add(cbrCase);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cases;
	}

	private void sortAllValues(String[] values) {
		values[1] = sortStrings(values[1]);
		values[2] = sortStrings(values[2]);
		values[3] = sortStrings(values[3]);
		values[4] = sortStrings(values[4]);
		values[5] = sortStrings(values[5]);
	}

	private String sortStrings(String value) {
		String[] strings = value.split(",,");
		int count = strings.length;
		String temp;
		for (int i = 0; i < count; i++)
		{
			for (int j = i + 1; j < count; j++) {
				if (strings[i].compareTo(strings[j])>0)
				{
					temp = strings[i];
					strings[i] = strings[j];
					strings[j] = temp;
				}
			}
		}
		value ="";
		for (String str:strings
			 ) {
			value += str;
			value += ",,";
		}
		value= value.substring(0,value.length()-2);
		return value;
	}

	@Override
	public Collection<CBRCase> retrieveSomeCases(CaseBaseFilter arg0) {
		return null;
	}

	@Override
	public void storeCases(Collection<CBRCase> arg0) {
	}
	
	@Override
	public void close() {
	}

	@Override
	public void deleteCases(Collection<CBRCase> arg0) {
	}

	@Override
	public void initFromXMLfile(URL arg0) throws InitializingException {
	}

}