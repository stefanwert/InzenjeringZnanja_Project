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
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainWindow.getInstance();
		
		Model model = ModelFactory.createDefaultModel();
		
		try {
			InputStream is = new FileInputStream("attacks.ttl");
			RDFDataMgr.read(model, is, Lang.TURTLE);
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String queryString = "";	//dodati
		Query query = QueryFactory.create(queryString) ;
		QueryExecution qexec = QueryExecutionFactory.create(query, model);
		ResultSet results = qexec.execSelect() ;
		while (results.hasNext()) {
			QuerySolution solution = results.nextSolution() ;
			Resource resource = solution.getResource("");	//dodati
			Literal literal = solution.getLiteral("");	//dodati
			System.out.println(resource.getURI());
			System.out.println(literal.getString());
		}
	}
}
