package cn.ceetop.service;

import cn.ceetop.ObjectsForTransfer.Person;
import cn.ceetop.utils.TestSerializable;

import java.util.ArrayList;
import java.util.List;


public class SayHello {  
    public String getName(String name,String value) {  
        return "hello====>" + name + value;  
    }  
    
    public int getName2(String name,int value) {  
        return value;  
    }  
    
    // ²»ÐÐ
    public List<String> getName3(String name,String value) {  
    	List<String> list = new ArrayList<String>();
    	list.add(name);
    	list.add(value);
        return list;  
    }  
 
    public byte[] getName4(String name,int value){ 
    	Person p = new Person();
    	p.setId(value);
    	p.setName(name);

    	return TestSerializable.ToSerialization(p);
    	
    } 
    
    public byte[] getName5(byte[] bytearr){ //String name,int value
    	
    	Person p1=(Person)TestSerializable.ToDeserialization(bytearr);

    	p1.setId(99999);
    	p1.setName("wwwwwww");
    	
    	return TestSerializable.ToSerialization(p1);
    	
    } 
}  
