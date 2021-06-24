import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainWindow.getInstance();
		
		Model model = ModelFactory.createDefaultModel();
		
		try {
			InputStream is = new FileInputStream("src\\attacks.ttl");
			RDFDataMgr.read(model, is, Lang.TURTLE);
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//PRVI UPIT
		System.out.println("*****Svi napadi sortirani po abecednom redu:*****");
		System.out.println();
		String queryString1 = "" + "PREFIX foaf: <https://github.com/stefanwert/InzenjeringZnanja_Project#>"
								+ "SELECT ?nazivNapada "
								+ "WHERE {"
								+ "    ?napad a foaf:Attack ;"
								+ "        foaf:name ?nazivNapada ."
								+ "} "
								+ "ORDER BY asc(?napad)";	
		Query query1 = QueryFactory.create(queryString1) ;
		QueryExecution qexec1 = QueryExecutionFactory.create(query1, model);
		ResultSet results1 = qexec1.execSelect() ;
		while (results1.hasNext()) {
			QuerySolution solution = results1.nextSolution() ;
			Literal nazivNapadaLiteral = solution.getLiteral("nazivNapada");
			System.out.println(nazivNapadaLiteral.getString());
		}
		
		//DRUGI UPIT
		System.out.println();
		System.out.println("*****Svi napadi koji pocinju na slovo M i, izmedju ostalog, napadaju i hardver, sortirani po duzini karaktera u nazivu:*****");
		System.out.println();
		String queryString2 = "" + "PREFIX foaf: <https://github.com/stefanwert/InzenjeringZnanja_Project#> "
								+ "SELECT ?nazivNapada ?domenNapada "
								+ "WHERE {"
								+ "    ?napad a foaf:Attack ;"
								+ "        foaf:domains_of_attacks ?domenNapada ;"
								+ "        foaf:name ?nazivNapada ."
								+ "FILTER strstarts(str(?nazivNapada), \"M\")"
								+ "FILTER contains(str(?domenNapada),\"Hardware\")"
								+ "} "
								+ "ORDER BY strlen(str(?napad))";	
		Query query2 = QueryFactory.create(queryString2) ;
		QueryExecution qexec2 = QueryExecutionFactory.create(query2, model);
		ResultSet results2 = qexec2.execSelect() ;
		while (results2.hasNext()) {
			QuerySolution solution = results2.nextSolution() ;
			Literal nazivNapadaLiteral = solution.getLiteral("nazivNapada");
			Literal domenNapadaLiteral = solution.getLiteral("domenNapada");
			System.out.println(nazivNapadaLiteral.getString());
			System.out.println(domenNapadaLiteral.getString());
			System.out.println();
		}
		
		/*StandardCBRApplication recommender = new CbrApplication();
		try {
			recommender.configure();

			recommender.preCycle();

			CBRQuery query = new CBRQuery();*/
			
			/*TransactionDescription txDescription = new TransactionDescription();
			RealEstateDescription reDescription = new RealEstateDescription();
			reDescription.setAge(25);
			reDescription.setDistanceToPublicTransportation(300);
			reDescription.setLocalStores(5);
			txDescription.setRealEstateDescription(reDescription);
			txDescription.setYear(2013);
			
			query.setDescription( txDescription );*/

			/*Attack attack = new Attack();
			attack.setName("proba");
			attack.setParentOf("HTTP DoS ");
			attack.setCanFallow("Use of Captured Hashes (Pass The Hash)");
			attack.setDomainsOfAttack("Hardware,, Software");
			attack.setMitigations("Use safe libraries to access resources such as files");
			attack.setWeakness("None");

			query.setDescription(attack);

			recommender.cycle(query);

			recommender.postCycle();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		//TRECI UPIT
		/*System.out.println("*****Svi napadi koji se sastoje iz 3 reci (podrazumeva se da su reci odvojene tacno jednim razmakom):*****");
		System.out.println();
		String queryString3 = "" + "PREFIX foaf: <https://github.com/stefanwert/InzenjeringZnanja_Project#> "
								+ "SELECT ?nazivNapada ?domenNapada (count(regex( ?nazivNapada ,\" \")) as ?brojReci)"
								+ "WHERE {"
								+ "    ?napad a foaf:Attack ;"
								+ "        foaf:domains_of_attacks ?domenNapada ;"
								+ "        foaf:name ?nazivNapada ."
								+ "}"
								+ "GROUP BY ?nazivNapada ?domenNapada";	
		Query query3 = QueryFactory.create(queryString3) ;
		QueryExecution qexec3 = QueryExecutionFactory.create(query3, model);
		ResultSet results3 = qexec3.execSelect() ;
		while (results3.hasNext()) {
			QuerySolution solution = results3.nextSolution() ;
			Literal nazivNapadaLiteral = solution.getLiteral("nazivNapada");
			Literal domenNapadaLiteral = solution.getLiteral("domenNapada");
			Literal brojReciLiteral = solution.getLiteral("brojReci");
			System.out.println(nazivNapadaLiteral.getString());
			System.out.println(domenNapadaLiteral.getString());
			System.out.println(brojReciLiteral.getInt());
			System.out.println();
		}
		System.out.println("AAAA");*/
	}
}
