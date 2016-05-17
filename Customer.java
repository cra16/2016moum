package oodp;

public interface Customer {

	 public  abstract int getCoupon();
	 public abstract void setCoupon(int coupon);
	 public abstract int useCoupon();
	 
	 public String getId();
	 public void setIdOutsider();
	 public String getPassword();
}
