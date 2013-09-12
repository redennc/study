package cn.ceetop.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class TestSerializable {

	public static byte[] ToSerialization(Object p)
	{
		ByteArrayOutputStream out = new ByteArrayOutputStream();
    	ObjectOutputStream oos = null;
    	try{
			oos = new ObjectOutputStream(out);
			oos.writeObject(p);
			
    	}catch(IOException e){
    		throw new RuntimeException(e);
    	}finally{
    		try {
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	byte[] bytearr = out.toByteArray();
 
    	try {
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return bytearr;
	}
	
	public static Object ToDeserialization(byte[] bytearr)
	{
		ByteArrayInputStream bis = new ByteArrayInputStream(bytearr);
    	ObjectInputStream ois = null;
    	Object o = null;
		try {
			ois = new ObjectInputStream(bis);
			o = ois.readObject();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	try {
				bis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    	return o;

	}
}
