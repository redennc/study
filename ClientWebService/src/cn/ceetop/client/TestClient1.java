package cn.ceetop.client;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import cn.ceetop.ObjectsForTransfer.Person;
import cn.ceetop.utils.TestSerializable;

import javax.xml.namespace.QName;

import org.apache.axis.client.Call;  
import org.apache.axis.client.Service;  
  
public class TestClient1 {  
  
    public static void main(String[] args) throws Exception {  
  
        // 指出service所在URL       
  
        String endpoint = "http://192.168.1.45:8080/TestWebService/services/Logina.jws";  
  
        // 创建一个服务(service)调用(call)       
  
        Service service = new Service();  
  
        Call call = (Call) service.createCall();// 通过service创建call对象       
  
        // 设置service所在URL       
  
        call.setTargetEndpointAddress(new java.net.URL(endpoint));  
        
        //调用 service 的 getName 方法 
        //String ret = (String) call.invoke(new QName("getName"),new Object[] { "wwwwwww","555" });
        //List<String> ret = (List<String>) call.invoke(new QName("getName3"),new Object[] { "wwwwwww","555" });
        
       // test1(call);
        test2(call); 
        
    }  
    
    private static void test2(Call call) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
    	Person p = new Person();
    	p.setId(222);
    	p.setName("kkkk");

    	byte[] ret = (byte[]) call.invoke(new QName("getName5"),new Object[] {TestSerializable.ToSerialization(p)});
    	
    	//反序列化
    	Person p1 = (Person)TestSerializable.ToDeserialization(ret);
    	
    	System.out.println(p1.getId()+" "+p1.getName());
        System.out.println(ret); 
	}

	private static void test1(Call call) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
    	byte[] ret = (byte[]) call.invoke(new QName("getName4"),new Object[] { "wwwwwww",555 });
    	Person p1 = (Person)TestSerializable.ToDeserialization(ret);
        
    	System.out.println(p1.getId()+" "+p1.getName());
        System.out.println(ret); 
		
	}

	
}  