import org.hibernate.*;
import org.hibernate.cfg.*;
import javax.swing.*;
import java.util.*;

class DbHandler{

public static void addStudent(int rno, String sname, int phy_m, int chem_m, int maths_m)
{

Configuration cfg = new Configuration();
cfg.configure("hibernate.cfg.xml");

SessionFactory sfact = cfg.buildSessionFactory();

Session s = null;
Transaction t = null;

try{
	s = sfact.openSession();
	t = s.beginTransaction();
	
	Student stu = new Student(rno, sname, phy_m, chem_m, maths_m);
	s.save(stu);
	t.commit();
	JOptionPane.showMessageDialog(new JDialog(), "Student Record Added Succesfully ");
}
catch(Exception e){
	t.rollback();
	JOptionPane.showMessageDialog(new JDialog(), "Rno already exist... if u wish to override the given rno pls click on update button:-) ");
}
finally{
	s.close();
}
}

public static String viewStudent()
{
Configuration cfg = new Configuration();
cfg.configure("hibernate.cfg.xml");

SessionFactory sfact = cfg.buildSessionFactory();
Session s = null;

String data = "";
String info = "";
try{
s = sfact.openSession();
List<Student> l = new ArrayList<>();
l = s.createQuery("from Student").list();
for (Student m : l){
	info =" Rno = " + m.getRno() + "; " + " Name = " + m.getSname() + "; " + " Physics = " + m.getPhy_m() + "; " + " Chemistry = " + m.getChem_m() + "; " + " Maths = " + m.getMaths_m() + ";";
	data = data + info + "\n";
}
}catch(Exception e){
JOptionPane.showMessageDialog(new JDialog(), "View Issue " + e);
}
finally{
s.close();
}
return data;
}

public static void updateStudent(int rno, String sname, int phy_m, int chem_m, int maths_m)
{
Configuration cfg = new Configuration();
cfg.configure("hibernate.cfg.xml");
SessionFactory sfact = cfg.buildSessionFactory();

Session s = null;
Transaction t = null;

try{
	s = sfact.openSession(); 
	t = s.beginTransaction();
	
	Student stu1 = (Student)s.get(Student.class, rno);
	if(stu1!=null){
		stu1.setSname(sname);
		stu1.setPhy_m(phy_m);
		stu1.setChem_m(chem_m);
		stu1.setMaths_m(maths_m);
		t.commit();
		JOptionPane.showMessageDialog(new JDialog(), "Rno " + rno + " Record Updated ");		 
	} else{
		JOptionPane.showMessageDialog(new JDialog(), "Rno " + rno + " does not exist ");
	}
}catch(Exception e){
	t.rollback();
	JOptionPane.showMessageDialog(new JDialog(), "issue " + e);
}
finally{
	s.close();
}
}

public static void deleteStudent(int rno)
{
Configuration cfg = new Configuration();
cfg.configure("hibernate.cfg.xml");
SessionFactory sfact = cfg.buildSessionFactory();

Session s = null;
Transaction t = null;

try{
s = sfact.openSession();
t = s.beginTransaction();

Student stu2 = (Student)s.get(Student.class, rno);
if(stu2!= null){
	s.delete(stu2);
	t.commit();
	JOptionPane.showMessageDialog(new JDialog(), "Rno " + rno + " record deleted ");
}
else{
	JOptionPane.showMessageDialog(new JDialog(), "Rno " + rno + " does not exist ");
}
}
catch(Exception e){
t.rollback();
JOptionPane.showMessageDialog(new JDialog(), "issue " + e);
}
finally{
s.close();
}
}

public static List<Student> chartStudent()
{
Configuration cfg = new Configuration();
cfg.configure("hibernate.cfg.xml");

SessionFactory sfact = cfg.buildSessionFactory();
Session s = null;

List<Student> l = new ArrayList<>();
try{
s = sfact.openSession();
l = s.createQuery("from Student").list();
}catch(Exception e){
JOptionPane.showMessageDialog(new JDialog(), "View Issue " + e);
}
finally{
s.close();
}
return l;
}
} 
