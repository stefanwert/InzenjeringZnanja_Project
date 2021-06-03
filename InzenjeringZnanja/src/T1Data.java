import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class T1Data extends JPanel {
    private final JTable table;

    public T1Data() {
        super(new BorderLayout(3, 3));
        this.table = new JTable(new TableOfAttacks());
        this.table.setPreferredScrollableViewportSize(new Dimension(700, 70));
        this.table.setFillsViewportHeight(true);
        JPanel ButtonOpen = new JPanel(new FlowLayout(FlowLayout.CENTER));
        add(ButtonOpen, BorderLayout.SOUTH);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
        // add a nice border
        setBorder(new EmptyBorder(5, 5, 5, 5));
        ReadingCSVFile readingCSVFile = new ReadingCSVFile();
        TableOfAttacks tableOfAttacks = new TableOfAttacks();
        this.table.setModel(tableOfAttacks);
        File DataFile = new File("src\\attacks.csv");
        ArrayList<String[]> procitano = readingCSVFile.ReadCSVfile(DataFile);
        tableOfAttacks.AddCSVData(procitano);
    }
}