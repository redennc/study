/*package cn.ceetop.client;

import javax.xml.namespace.QName;

import org.apache.axis.client.Call;  
import org.apache.axis.client.Service;  
  
public class TestClient {  
  
    public static void main(String[] args) throws Exception {  
  
        // 指出service所在URL       
  
        String endpoint = "http://127.0.0.1:8080/TestWebService/services/Login.jws";  
  
        // 创建一个服务(service)调用(call)       
  
        Service service = new Service();  
  
        Call call = (Call) service.createCall();// 通过service创建call对象       
  
        // 设置service所在URL       
  
        call.setTargetEndpointAddress(new java.net.URL(endpoint));  
  
        // 方法名(processService)与SayHello.java方法名保持一致       
  
        //call.setOperationName("getName");  
  
        // Object 数组封装了参数，参数为"This is Test!",调用processService(String arg)       
        
        //String ret = (String) call.invoke(new Object[] { "好了","xxxxxx" });  
        String ret = (String) call.invoke(new QName("getName2"),new Object[] { "好了","xxxxxx" }); 
        System.out.println(ret);  
  
    }  
  
}  */