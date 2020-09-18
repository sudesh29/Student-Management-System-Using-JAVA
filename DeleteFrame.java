import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class DeleteFrame extends JFrame{
Container c;
JLabel lblRno;
JTextField txtRno;
JButton btnSave, btnBack;

DeleteFrame(){
c = getContentPane();
c.setLayout(new FlowLayout());

lblRno = new JLabel("Enter Rno to Delete: ");
txtRno = new JTextField(30);
btnSave = new JButton("Save ");
btnBack = new JButton("Back ");

ActionListener a1 = (ae) -> {
MainFrame m = new MainFrame();
dispose();
};
btnBack.addActionListener(a1);

ActionListener a2 = (ae) -> {
String r_no = txtRno.getText();
if(!r_no.matches("^[-+]?\\d*$")){
JOptionPane.showMessageDialog(new JDialog(), "Only numeric values are allowed with no spaces ");
}else{
try{
int rno = Integer.parseInt(txtRno.getText());
//DbHandler.deleteStudent(rno);
Validation.validateDelete(rno);
}catch(NumberFormatException e){
JOptionPane.showMessageDialog(new JDialog(), "All fields are mandatory:-) ");
}}
};
btnSave.addActionListener(a2);
c.add(lblRno);
c.add(txtRno);
c.add(btnSave);
c.add(btnBack);

setTitle("Delete Student ");
setSize(350,350);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}