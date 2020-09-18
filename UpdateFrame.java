import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class UpdateFrame extends JFrame{
Container c;
JLabel lblRno, lblRname, lblPhy, lblChem, lblMaths;
JTextField txtRno, txtRname, txtPhy, txtChem, txtMaths;
JButton btnSave, btnBack;

UpdateFrame(){
c = getContentPane();
c.setLayout(new FlowLayout());

lblRno = new JLabel("Enter Rno to Update: ");
lblRname = new JLabel("Enter Name: ");
lblPhy = new JLabel("Enter Updated Physics Marks: ");
lblChem = new JLabel("Enter Updated Chemistry Marks: ");
lblMaths = new JLabel("Enter Updated Maths Marks: ");

txtRno = new JTextField(35);
txtRname = new JTextField(35);
txtPhy = new JTextField(35);
txtChem = new JTextField(35);
txtMaths = new JTextField(35);

btnSave = new JButton("Save ");
btnBack = new JButton("Back ");

ActionListener a1 = (ae) -> {
MainFrame m = new MainFrame();
dispose();
};
btnBack.addActionListener(a1);

ActionListener a2 = (ae) -> {
String r_no = txtRno.getText();
String phy_ma = txtPhy.getText();
String chem_ma = txtChem.getText();
String maths_ma = txtMaths.getText();
if(!r_no.matches("^[-+]?\\d*$") || !phy_ma.matches("^[-+]?\\d*$") || !chem_ma.matches("^[-+]?\\d*$") || !maths_ma.matches("^[-+]?\\d*$")){
JOptionPane.showMessageDialog(new JDialog(), "Only numeric values are allowed with no spaces ");
}else{
try{
int rno = Integer.parseInt(txtRno.getText());
String sname = txtRname.getText();
int phy_m = Integer.parseInt(txtPhy.getText());
int chem_m = Integer.parseInt(txtChem.getText());
int maths_m = Integer.parseInt(txtMaths.getText());
//DbHandler.updateStudent(rno, sname, phy_m, chem_m, maths_m);
Validation.validateUpdate(rno, sname, phy_m, chem_m, maths_m);
}catch(NullPointerException | NumberFormatException e){
JOptionPane.showMessageDialog(new JDialog(), "All fields are mandatory:-) ");
}}
};
btnSave.addActionListener(a2);

c.add(lblRno);
c.add(txtRno);
c.add(lblRname);
c.add(txtRname);
c.add(lblPhy);
c.add(txtPhy);
c.add(lblChem);
c.add(txtChem);
c.add(lblMaths);
c.add(txtMaths);
c.add(btnSave);
c.add(btnBack);

setTitle("Update Student ");
setSize(400,400);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}