package oodp;

public class Admin {
	private String id;
	private String password;
	
	
	public Admin(String id,String password){
		this.id = id;
		this.password = password;
	}
	
	public String getId(){
		return this.id;
	}
	
}
