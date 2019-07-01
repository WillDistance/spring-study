package com.itheima.e_lifecycle;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

    /**
      postProcessBeforeInitialization��������ÿһ��bean����ĳ�ʼ����������֮ǰ�ص�
      postProcessAfterInitialization��������ÿ��bean����ĳ�ʼ����������֮�󱻻ص�
                ��������������Object���͵�ʵ��������ֵ�ȿ����ǽ����Object beanԭ�ⲻ���ķ��س�ȥ��Ҳ���ԶԵ�ǰbean���а�װ�ٷ���
         
                ��ͨ�� new CopyOfUserServiceImpl() �µĶ��󷵻� ��������bean����
                �ӿ��������������ܷ���null���������null��ô�ں�����ʼ������������ָ���쳣����ͨ��getBean()������ȡ����benaʵ������
                ��Ϊ���ô�������Spring IoC������ȡ��beanʵ������û���ٴηŻ�IoC������
     */
    
    
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("ǰ���� �� " + beanName);
		
		//return new CopyOfUserServiceImpl(); //�ı�bean����
		
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(final Object bean, String beanName) throws BeansException {
		System.out.println("�󷽷� �� " + beanName);
		// bean Ŀ�����
		// ���� jdk ����
		return Proxy.newProxyInstance(
					MyBeanPostProcessor.class.getClassLoader(), 
					bean.getClass().getInterfaces(), 
					new InvocationHandler(){
						@Override
						public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
							
							System.out.println("------��������");
							
							//����ͨ��method.getName() ��ȡ���������ж���һЩ���ָ�������Ĳ���
							
							//ִ��Ŀ�귽��
							Object obj = method.invoke(bean, args);
							
							System.out.println("------�ύ����");
							return obj;
						}});
	}
}
