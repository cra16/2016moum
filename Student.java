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
        //���� ȸ��(Student)�� ������, �����ϰ��� �ϴ� ��ǰ�� ������ �޾ƿ�

        //����Ʈ �̿�

            if (point >= selected.menuPrice)
            {
                point-=selected.menuPrice;

                //Sales_Management(selected);

            }else{

                //����Ʈ ����
                JOptionPane.showMessageDialog(null, "����Ʈ�� �����մϴ�.");

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