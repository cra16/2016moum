package oodp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


import java.util.*;
import java.sql.*;

public class SuperviseCustomer
{

	private static Connection conn;
	private static Statement stmt;
	private ResultSet rs;
	private int number_of_student;
	private int number_of_professor;
	private ArrayList<Customer> customer;
	private Iterator iterator;
	
	public SuperviseCustomer()
	{
		customer = new ArrayList<Customer>();
		
		try
			{
	           conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "bitnami");
	           stmt=conn.createStatement();
	           rs = stmt.executeQuery("SELECT * FROM stuinfo");	          
	           
	       		while(rs.next()){
	       			if(rs.getInt("identifier")==1){
	       				Student newStudent = 	new Student(rs.getString("id"),rs.getString("password"),rs.getString("name"),rs.getInt("point"),rs.getInt("coupon"));
	       				customer.add((Customer)newStudent);
	       				number_of_student++;
	       			}
	       			else{
	       				Professor newProfessor = 	new Professor(rs.getString("id"),rs.getString("password"),rs.getString("name"),rs.getInt("coupon"));
	    				customer.add(newProfessor);
	    				number_of_professor++;
	       			}
	       			
	       			iterator = customer.iterator();
	       		}
			}
	        catch(Exception exc){}
    	
	}
    
		
		public int getStudentNumber(){
			return this.number_of_student;
		}
		public int getProfessorNumber(){
			return this.number_of_professor;
		}	
		public int getCustomerNumber(){
			return this.number_of_student + this.number_of_professor;
		}
//		public ArrayList<Professor> getProfessorlist(){
//			ArrayList<Professor> professortList = new ArrayList<Professor>();
//			Customer temp;
//			while(iterator.hasNext()){
//				temp = (Customer)(iterator.next());
//				
//				if(temp instanceof Professor){
//					professortList.add((Professor)temp);
//				}
//			}
//			
//			return professortList;
//		}
//		public ArrayList<Student> getStudentlist(){
//			ArrayList<Student> studnetList = new ArrayList<Student>();
//			Customer temp;
//			while(iterator.hasNext()){
//				temp = (Customer)(iterator.next());
//				
//				if(temp instanceof Student){
//					studnetList.add((Student)temp);
//				}
//			}
//			
//			return studnetList;
//		}
		public String[] getStudentList(){
			String[] studentList = new String[this.getStudentNumber()];
			int count = 0;
			for(Customer temp : customer){
				if(temp instanceof Student){
					studentList[count] = temp.getId();
					count++;
				}
			}
			
			return studentList;
		}
		public String[] getProfessorList(){
			String[] professortList = new String[this.getStudentNumber()];
			int count = 0;
			for(Customer temp : customer){
				if(temp instanceof Professor){
					professortList[count] = temp.getId();
					count++;
				}
			}
			
			return professortList;
		}
		public Customer findById(String id){
			for(Customer temp : customer){

				if((temp instanceof Professor)&&temp.getId().equals(id)){
					Customer theProf = new Professor(temp.getId(),temp.getPassword(),temp.getName(),temp.getCoupon());
					return theProf;
				} 
				if((temp instanceof Student)&&temp.getId().equals(id)){
					System.out.println("student");
					try{
						conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "bitnami");
				           stmt=conn.createStatement();
					ResultSet qry = stmt.executeQuery("SELECT * FROM stuinfo WHERE id = "+id.toString());	    
					

					System.out.println(qry.getInt("point"));

					Customer theStu = new Student(temp.getId(),temp.getName(),temp.getPassword(),qry.getInt("point"),temp.getCoupon());
					return theStu;
					
					}
					catch(Exception exc){}
					
				}
			}

			return null;
		}

}
