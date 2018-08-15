package com.yc.web.listeners;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.yc.bean.Tag;
import com.yc.biz.TagBiz;
//ServletContextListener监听器启动
public class InitListener implements ServletContextListener{
    public InitListener(){
    	
    }
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
        ServletContext application=arg0.getServletContext();
        //通过WebApplicationContextUtils得到Spring容器的实例
        ApplicationContext ac=WebApplicationContextUtils.getWebApplicationContext(application);
        //从spring容器中取tagBizImpl
        TagBiz tagBiz=(TagBiz) ac.getBean("tagBizImpl");
        Map<String,Tag>map=new HashMap<String,Tag>();
        try {
			map=tagBiz.findAllTag();
			application.setAttribute("ALLTAG", map);//存好标签
		} catch (Exception e) {
			e.printStackTrace();
		}
        
	}

}
