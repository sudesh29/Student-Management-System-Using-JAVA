class Student       //POJO class
{
private int rno;
private String sname;
private int phy_m;
private int chem_m;
private int maths_m;

public Student(){

}

public Student(int rno, String sname, int phy_m, int chem_m, int maths_m){
this.rno = rno;
this.sname = sname;
this.phy_m = phy_m;
this.chem_m = chem_m;
this.maths_m = maths_m;
}

public void setRno(int rno){
this.rno = rno;
}

public int getRno(){
return rno;
}

public void setSname(String sname){
this.sname = sname;
}

public String getSname(){
return sname;
}

public void setPhy_m(int phy_m){
this.phy_m = phy_m;
}

public int getPhy_m(){
return phy_m;
}

public void setChem_m(int chem_m){
this.chem_m = chem_m;
}

public int getChem_m(){
return chem_m;
}

public void setMaths_m(int maths_m){
this.maths_m = maths_m;
}

public int getMaths_m(){
return maths_m;
}
}