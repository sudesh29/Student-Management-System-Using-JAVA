import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ViewFrame extends JFrame{
Container c;
TextArea taData;
JButton btnBack;

ViewFrame(){
c = getContentPane();
c.setLayout(new FlowLayout());
taData = new TextArea(12,50);
btnBack = new JButton("Back");

String data = DbHandler.viewStudent();
taData.setText(data);

ActionListener a1 = (ae) -> {
MainFrame m = new MainFrame();
dispose();
};
btnBack.addActionListener(a1);

c.add(taData);
c.add(btnBack);

setTitle("View Student ");
setSize(400,400);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}