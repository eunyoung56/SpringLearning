package com.spring.diex8;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Program {

	public static void main(String[] args) {
	
		ApplicationContext  context =
				new ClassPathXmlApplicationContext("setting_ano.xml");
		
//		ApplicationContext  context =
//				new AnnotationConfigApplicationContext(ProgramConfig.class);
		
		Exam exam = (Exam) context.getBean("exam2");
		System.out.println(exam.toString());
		
		ExamConsole eCon = context.getBean(ExamConsole.class);
		eCon.print();
	}

}
