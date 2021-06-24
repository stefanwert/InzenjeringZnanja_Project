import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatusBar extends JPanel {

	private static final long serialVersionUID = 4942410523704853090L;

	public StatusBar() {
		JLabel naslovLabela = new JLabel("Information security");
		add(naslovLabela);

		final JLabel vremeLabela = new JLabel();
		final JLabel datumLabela = new JLabel();
		
		add(vremeLabela);
		add(datumLabela);
		
		Thread aktuelnoVreme = new Thread() {
			public void run() {
				try {
					while(true) {
						Calendar calendar = new GregorianCalendar();
						int dan = calendar.get(Calendar.DAY_OF_MONTH);
						int mesec = calendar.get(Calendar.MONTH) + 1;
						int godina = calendar.get(Calendar.YEAR);
						int sat = calendar.get(Calendar.HOUR);
						int minut = calendar.get(Calendar.MINUTE);
						int sekunda = calendar.get(Calendar.SECOND);
						vremeLabela.setText(sat + ":" + minut + ":" + sekunda);
						datumLabela.setText(dan + "." + mesec + "." + godina + ".");
						sleep(1000);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		aktuelnoVreme.start();
	}
}
