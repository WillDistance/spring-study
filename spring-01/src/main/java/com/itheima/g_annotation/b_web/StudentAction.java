package com.itheima.g_annotation.b_web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller("studentActionId")
public class StudentAction {
	
	@Autowired //Ĭ�ϰ�������
	private StudentService studentService;

	public void execute() {
		studentService.addStudent();
	}

}
