package com.lesson02.guessnumber;
public class Player {
	private String name;
	private int number;

	Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}
}