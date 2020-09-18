import javax.swing.*;
import org.jfree.data.category.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import java.io.*;
import java.util.*;

class ChartFrame extends JFrame{

ChartFrame() {

DefaultCategoryDataset ds = new DefaultCategoryDataset();

List<Student> n = DbHandler.chartStudent();

for(Student m: n)
{
String name = m.getSname();
int phy = m.getPhy_m();
int chem = m.getChem_m();
int maths = m.getMaths_m();

ds.addValue(phy, name, "Phy");
ds.addValue(chem, name, "Chem");
ds.addValue(maths, name, "Maths");
}

JFreeChart ch = ChartFactory.createBarChart("Student Performance ", "Subjects", "Marks ", ds, PlotOrientation.VERTICAL, true, false, false);

ChartPanel pa = new ChartPanel(ch);
setContentPane(pa);
try{
	File bn = new File("bn.png");
	ChartUtilities.saveChartAsPNG(bn, ch, 500, 500);
} catch(Exception e) {
System.out.println("issue "+ e);
}
setSize(500,500);
setLocationRelativeTo(null);
setTitle("Marks Chart ");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}
