package com.study.a_proxy.b_cglib;
import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
/**
 * 
 * @����: ���з����Ĵ���Ļص�
 * @��Ȩ: Copyright (c) 2019 
 * @��˾: ˼�ϿƼ� 
 * @����: ����
 * @�汾: 1.0 
 * @��������: 2019��7��1�� 
 * @����ʱ��: ����2:44:28
 */
public class ProxyFactory implements MethodInterceptor {

	//Ҫ�������ʵ����
	private Object obj;
	
	public Object createProxy(Object target) {
		this.obj = target;
		Enhancer enhancer = new Enhancer();
		//���ô���Ŀ��
		enhancer.setSuperclass(this.obj.getClass());
		//���õ�һ�ص������ڵ��������ض�Ŀ�귽���ĵ���
		enhancer.setCallback(this);
		//�����������
		enhancer.setClassLoader(this.obj.getClass().getClassLoader());
		
		return enhancer.create();
	}
	/**
	 * 
	 * �������� ���Ի��ڴ���ķ����ص�ʱ���ڵ���ԭ����֮ǰ����ø÷���
	 * ���ض�Ŀ�귽���ĵ���
	 *
	 * @param obj �������
	 * @param method ���صķ���
	 * @param args ���صķ����Ĳ���
	 * @param proxy ����
	 * @return
	 * @throws Throwable
	 */
	@Override
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		Object result = null;
		try {
			//ǰ��֪ͨ
			before();
			result = proxy.invokeSuper(obj, args);
			//����֪ͨ
			after();
		} catch (Exception e) {
			//�쳣֪ͨ
			exception();
		} finally {
			//��������ǰ֪ͨ
			beforeReturning();
		}
		
		return result;
	}

	private void before() {
		System.out.println("ǰ��  method invoke...");
	}
	private void after() {
		System.out.println("����  method invoke...");
	}
	private void exception() {
		System.out.println("�쳣  method invoke...");
	}
	private void beforeReturning() {
		System.out.println("��������ǰ  method invoke...");
	}
}