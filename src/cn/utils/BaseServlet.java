package cn.utils;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet {
	/*
	 * ������������е�m�����������ñ�����ĸ�����
	 */
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=utf-8");

		// ���磺http://localhost:8080/demo1/xxx?method=login
		String methodName = req.getParameter("method");// ����һ����������
		
		// ��û��ָ��Ҫ���õķ���ʱ����ôĬ���������execute()������
		if(methodName == null || methodName.isEmpty()) {
			methodName = "execute";
		}
		Class c = this.getClass();
		try {
			// ͨ���������ƻ�ȡ�����ķ������
			Method m = c.getMethod(methodName, HttpServletRequest.class,
					HttpServletResponse.class);
			// ���䷽��Ŀ�귽����Ҳ����˵�����methodNameΪadd����ô�͵���add������
			String result = (String) m.invoke(this, req, res);
			// ͨ������ֵ�������ת��
			if(result != null && !result.isEmpty()) {
				req.getRequestDispatcher(result).forward(req, res);
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
