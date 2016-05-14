package oodp;

public class Professor implements Customer{

	public String id;
    private String password;
    private String name;
    private int point;
    private int coupon;
    
	public Professor(String id, String password, String name, int coupon){
		 this.id=id;
	     this.password=password;
	     this.name=name;
	     this.coupon = coupon;
	}
	
	 public int getCoupon(){
	    	return this.coupon;
	    }
	    public void setCoupon(int coupon){
	    	this.coupon = coupon;
	    }
	    public int useCoupon(){
	    	if(this.coupon == 0)
	    		return -1;
	    	
	    	this.coupon--;
	    	
	    	return this.coupon;
	    }
	    
	    public String getName(){
	    	return this.name;
	    }
	
}
