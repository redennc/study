/*package cn.ceetop.client;

import javax.xml.namespace.QName;

import org.apache.axis.client.Call;  
import org.apache.axis.client.Service;  
  
public class TestClient {  
  
    public static void main(String[] args) throws Exception {  
  
        // ָ��service����URL       
  
        String endpoint = "http://127.0.0.1:8080/TestWebService/services/Login.jws";  
  
        // ����һ������(service)����(call)       
  
        Service service = new Service();  
  
        Call call = (Call) service.createCall();// ͨ��service����call����       
  
        // ����service����URL       
  
        call.setTargetEndpointAddress(new java.net.URL(endpoint));  
  
        // ������(processService)��SayHello.java����������һ��       
  
        //call.setOperationName("getName");  
  
        // Object �����װ�˲���������Ϊ"This is Test!",����processService(String arg)       
        
        //String ret = (String) call.invoke(new Object[] { "����","xxxxxx" });  
        String ret = (String) call.invoke(new QName("getName2"),new Object[] { "����","xxxxxx" }); 
        System.out.println(ret);  
  
    }  
  
}  */