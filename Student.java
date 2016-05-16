package oodp;

import javax.swing.*;

public class Student implements Customer{

    public Student(String id, String password, String name,int point,int coupon){
        this.id=id;
        this.password=password;
        this.name=name;
        this.point= point;
        this.coupon = coupon;
    }


    public String id;
    private String password;
    private String name;
    private int point;
    private int coupon;
    
    
    
    
    public void PaymentPoint(Menu selected){
        //결제 회원(Student)의 정보와, 결제하고자 하는 물품의 정보를 받아옴

        //포인트 이용

            if (point >= selected.menuPrice)
            {
                point-=selected.menuPrice;

                //Sales_Management(selected);

            }else{

                //포인트 부족
                JOptionPane.showMessageDialog(null, "포인트가 부족합니다.");

            }

       

    }
    public int getPoint(){
    	return this.point;
    }
    public void setPoint(int point){
    	this.point = point;
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
    public String getId(){
    	return this.id;
    }
    public String getName(){
    	return this.name;
    }
    public String getPassword(){
    	return this.password;
    }



}