import javax.swing.*;
class Validation 
{
public static void validateAdd(int rno, String sname, int phy_m, int chem_m, int maths_m)
{
if(rno<=0){
	JOptionPane.showMessageDialog(new JDialog(), "pls enter a valid Rno... eg. 1,2,3... ");
}
else{
	if(sname.equals("") || sname == null){
		JOptionPane.showMessageDialog(new JDialog(), "Student name cannot be empty ");
	}
	else{
		if(sname.length()<2){
			JOptionPane.showMessageDialog(new JDialog(), "Name with min length of 2 is allowed... eg. om ");
		}
		else{
			if(!sname.matches("^[A-Z][a-zA-z]+([\\s][A-Z][a-zA-Z]+)*$")){
				JOptionPane.showMessageDialog(new JDialog(), "Pls enter valid name... which only contain alphabets and start with capital letter ");
			}
			else{
				if((phy_m<=-1) || (phy_m>=101)){
					JOptionPane.showMessageDialog(new JDialog(), "Enter Phy Marks in range of 0-100 ");
				}
				else{
					if((chem_m<0) || (chem_m>100)){
						JOptionPane.showMessageDialog(new JDialog(), "Enter Chem Marks in range of 0-100 ");
					}
					else{
						if((maths_m<0) || (maths_m>100)){
						JOptionPane.showMessageDialog(new JDialog(), "Enter Maths Marks in range of 0-100 ");
						}
						else{
							DbHandler.addStudent(rno, sname, phy_m, chem_m, maths_m);
						}}}}}}}
}

public static void validateUpdate(int rno, String sname, int phy_m, int chem_m, int maths_m)
{
if(rno<=0){
	JOptionPane.showMessageDialog(new JDialog(), "pls enter a valid Rno... eg. 1,2,3... ");
}
else{
	if(sname.equals("") || sname == null){
		JOptionPane.showMessageDialog(new JDialog(), "Student name cannot be empty ");
	}
	else{
		if(sname.length()<2){
			JOptionPane.showMessageDialog(new JDialog(), "Name with min length of 2 is allowed... eg. om ");
		}
		else{
			if(!sname.matches("^[A-Z][a-zA-z]+([\\s][A-Z][a-zA-Z]+)*$")){
				JOptionPane.showMessageDialog(new JDialog(), "Pls enter valid name... which only contain alphabets and start with capital letter ");
			}
			else{
				if((phy_m<=-1) || (phy_m>=101)){
					JOptionPane.showMessageDialog(new JDialog(), "Enter Phy Marks in range of 0-100 ");
				}
				else{
					if((chem_m<0) || (chem_m>100)){
						JOptionPane.showMessageDialog(new JDialog(), "Enter Chem Marks in range of 0-100 ");
					}
					else{
						if((maths_m<0) || (maths_m>100)){
						JOptionPane.showMessageDialog(new JDialog(), "Enter Maths Marks in range of 0-100 ");
						}
						else{
							DbHandler.updateStudent(rno, sname, phy_m, chem_m, maths_m);
						}}}}}}}
}

public static void validateDelete(int rno)
{
if(rno<=0){
	JOptionPane.showMessageDialog(new JDialog(), "pls enter a valid Rno... eg. 1,2,3... ");
}
else{
	DbHandler.deleteStudent(rno);
}
}
}