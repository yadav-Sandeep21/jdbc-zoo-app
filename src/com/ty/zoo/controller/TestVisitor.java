package com.ty.zoo.controller;

import java.util.ArrayList;
import java.util.List;

import com.ty.zoo.dao.VisitorDao;
import com.ty.zoo.dto.Visitor;
import com.ty.zoo.visitor.service.VisitorService;

public class TestVisitor {

	public static void main(String[] args) {
		
	//Save User
//		Visitor visitor=new Visitor();
//		visitor.setId(5);
//		visitor.setName("Rose");
//		visitor.setEmail("lily@gmail.com");
//		visitor.setPhone("lily");
//		visitor.setGender("female");
//		visitor.setAge(25);
//		
//		VisitorService visitorService=new VisitorService();
//		visitorService.saveVisitor(visitor);
		
			
		
	//get Visitor By Id
		/*
		VisitorDao dao = new VisitorDao();
	    Visitor v = dao.getVisitorById(1);
		System.out.println(v);
		*/
		
		VisitorDao crud=new VisitorDao();
		System.out.println(crud.getAllVisitor());
	}

}
