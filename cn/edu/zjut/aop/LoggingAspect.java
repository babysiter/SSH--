package cn.edu.zjut.aop;

import javax.swing.JOptionPane;

import org.aspectj.lang.ProceedingJoinPoint;

import cn.edu.zjut.po.admin;

public class LoggingAspect {
	
	public Object aroundMethod(ProceedingJoinPoint pjd){
		System.out.println("触发aop事件");
		Object result = null;
		Object[] params = pjd.getArgs();
		try {
			//前置通知
			admin temp = (admin)params[0];
			if(temp==null){
				result = "fail";
				JOptionPane.showMessageDialog(null, "您不是管理员,无法增加、修改或删除");
			}else if(temp.getPower()!=0){
				result = "fail";
				JOptionPane.showMessageDialog(null, "您的权限不足无法增加、修改或删除");
			}else{
				result = pjd.proceed();
			}
		} catch (Throwable e) {
			//异常通知
			throw new RuntimeException(e);
		}
		return result;
	}
}
