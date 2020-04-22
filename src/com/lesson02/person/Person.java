package com.lesson02.person;
public class Person {
	String name = "Иван";
	String familyName = "Иванов";
	int age = 20;
	Sting gender = "Мужской";
	double hight = 1.75;
	double weight = 81.4;

	void go() {
		System.out.println("Method go");
	}

	void run() {
		System.out.println("Method run");
	}

	String sit() {
		return "Method sit";
	}

	boolean speak() {
		return;
	}
	
	String studyJava() {
		return "Method studyJava";
	}
}