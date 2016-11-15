package cn.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;

import cn.vo.User;

/**
 * ����ServletContext���󴴽�������
 * @author ����
 *
 */
public class MyServletContextListener implements ServletContextListener{
	// ServletContext���󴴽� ������������ͻ�ִ��
	// ServletContextEvent�¼�����. ����������---��ServletContext����.(�¼�Դ)
	public void contextInitialized(ServletContextEvent sce) {
		Map<User,HttpSession> userMap = new HashMap<User,HttpSession>();
		sce.getServletContext().setAttribute("userMap", userMap);
	}
	
	public void contextDestroyed(ServletContextEvent sce) {
		
	}



}

