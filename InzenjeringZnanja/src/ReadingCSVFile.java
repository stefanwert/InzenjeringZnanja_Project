import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class ReadingCSVFile {

	private ArrayList<String[]> procitano = new ArrayList<>();
    private String[] jedanRedIzFajlaSplitovano;
	
	public ArrayList<String[]> ReadCSVfile(File attacks) {
		
		try {
            BufferedReader brd = new BufferedReader(new FileReader(attacks));
            
            while (brd.ready()) {
                String jedanRedIzFajla = brd.readLine();
                jedanRedIzFajlaSplitovano = jedanRedIzFajla.split(";");
                procitano.add(jedanRedIzFajlaSplitovano);
                System.out.println(Arrays.toString(jedanRedIzFajlaSplitovano));
            } 
            brd.close();
        } 
        catch (Exception e) {
            String errmsg = e.getMessage();
            System.out.println("File not found: " + errmsg);
        } 
        return procitano;
	}

}
