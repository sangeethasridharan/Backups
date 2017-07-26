package com;
import javax.jdo.annotations.*;

@PersistenceCapable
public class Jdo_ex {
	    
	    @PrimaryKey
        @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	    private String empId;
        
	    @Persistent
	    private String empName;

	    @Persistent
	    private String empSalary;
	    
	    public Jdo_ex()
	    {
	    	
	    }
	    
	    public Jdo_ex(String empId, String empName, String empSalary) {
	        this.empId = empId;
	        this.empName = empName;
	        this.empSalary = empSalary;
	    }
	    

	    

		public String getEmpId() {
			return empId;
		}

		public void setEmpId(String empId) {
			this.empId = empId;
		}

		public String getEmpName() {
			return empName;
		}

		public void setEmpName(String empName) {
			this.empName = empName;
		}

		public String getEmpSalary() {
			return empSalary;
		}

		public void setEmpSalary(String empSalary) {
			this.empSalary = empSalary;
		}

	   
	}	
	
