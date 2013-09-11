package cn.lt.web.listener;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionScanner implements HttpSessionListener,ServletContextListener {

	private List<HttpSession> list = Collections.synchronizedList(new LinkedList<HttpSession>());
	private Object lock = new Object();
	public static final int SESSION_INVALID_TIME = 3000; 
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		Timer timer = new Timer();
		timer.schedule(new Task(list, lock), 0, 3*1000);
		System.out.println("ServletContext������");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("ServletContext������");
	}
	
	
	public void sessionCreated(HttpSessionEvent se) {
		synchronized(lock){
			list.add(se.getSession());
			System.out.println("session������");
		}
		
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		System.out.println("session������");
	}
}


class Task extends TimerTask{

	private List<HttpSession> list;
	private Object lock;
	
	Task(List<HttpSession> list, Object lock)
	{
		this.list = list;
		this.lock = lock;
	}
	
	@Override
	public void run() {
		System.out.println("��ʱ������ �� ִ��");
		Iterator<HttpSession> it = list.listIterator();
		synchronized (lock) {
			while(it.hasNext())
			{
				HttpSession session = it.next();
				if((System.currentTimeMillis() - session.getLastAccessedTime()) > SessionScanner.SESSION_INVALID_TIME)
				{
					session.invalidate();
					it.remove();
				}
			}
		}
	}
	
}
