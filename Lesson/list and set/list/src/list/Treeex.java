package list;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
 
public class Treeex {
 
    public static void main(String a[]){
         
        Set<Emp> ts = new TreeSet<Emp>(new EmpComp());
        ts.add(new Emp(201,"san",40000));
        ts.add(new Emp(302,"sangy",44500));
        ts.add(new Emp(146,"sony",20000));
        ts.add(new Emp(543,"sri",10000));
        ts.add(new Emp(12,"sita",50000));
        
        ts.add(new Emp(146,"sita",20000));
        //check duplicate entry is there or not
        for(Emp e:ts){
            System.out.println(e);
        }
    }
}
 
class EmpComp implements Comparator<Emp>{
 
    @Override
    public int compare(Emp e1, Emp e2) {
        if(e1.getEmpId() == e2.getEmpId()){
            return 0;
        } if(e1.getEmpId() > e2.getEmpId()){
            return 1;
        } else {
            return -1;
        }
    }
}
 
class Emp {
     
    private int empId;
    private String empName;
    private int empSal;
     
    public Emp(int id, String name, int sal){
        this.empId = id;
        this.empName = name;
        this.empSal = sal;
    }
     
    public int getEmpId() {
        return empId;
    }
     
    public void setEmpId(int empId) {
        this.empId = empId;
    }
     
    public String getEmpName() {
        return empName;
    }
     
    public void setEmpName(String empName) {
        this.empName = empName;
    }
     
    public int getEmpSal() {
        return empSal;
    }
    public void setEmpSal(int empSal) {
        this.empSal = empSal;
    }
     
    public String toString(){
        return empId+" : "+empName+" : "+empSal;
    }
}
