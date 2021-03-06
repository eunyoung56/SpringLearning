package com.spring.diex8;

import org.springframework.beans.factory.annotation.Autowired;

public class OneLineExamPrint implements ExamConsole {
	@Autowired
	private Exam exam;
		
	public OneLineExamPrint(Exam exam) {		
		this.exam = exam;
	}
	
	public OneLineExamPrint() {		
		System.out.println("OneLineExamPrint() ");
	}
		
	@Override
	public void setExam(Exam exam) {
		this.exam = exam;
		
	}
	
	@Override
	public void print() {
		System.out.println("total : " + exam.total() + 
				  		   ", avg : " + exam.avg());
	}

}
