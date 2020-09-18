import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class MainFrame extends JFrame
{
Container c;
JButton btnAdd, btnView, btnUpdate, btnDelete, btnCharts;
MainFrame() 
{
c = getContentPane();
c.setLayout(new FlowLayout());

btnAdd = new JButton("Add ");
btnAdd.setPreferredSize(new Dimension(100, 30));
btnView = new JButton("View ");
btnView.setPreferredSize(new Dimension(100, 30));
btnUpdate = new JButton("Update ");
btnUpdate.setPreferredSize(new Dimension(100, 30));
btnDelete = new JButton("Delete ");
btnDelete.setPreferredSize(new Dimension(100, 30));
btnCharts = new JButton("Charts ");
btnCharts.setPreferredSize(new Dimension(100, 30));

ActionListener a1 = (ae) -> {
AddFrame a = new AddFrame();
dispose();
};
btnAdd.addActionListener(a1);

ActionListener a2 = (ae) -> {
ViewFrame v = new ViewFrame();
dispose();
};
btnView.addActionListener(a2);

ActionListener a3 = (ae) -> {
UpdateFrame u = new UpdateFrame();
dispose();
};
btnUpdate.addActionListener(a3);

ActionListener a4 = (ae) -> {
DeleteFrame d = new DeleteFrame();
dispose();
};
btnDelete.addActionListener(a4);

ActionListener a5 = (ae) -> {
ChartFrame d = new ChartFrame();
dispose();
};
btnCharts.addActionListener(a5);

c.add(btnAdd);
c.add(btnView);
c.add(btnUpdate);
c.add(btnDelete);
c.add(btnCharts);
setTitle("S. M. S. ");
setSize(300,300);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}