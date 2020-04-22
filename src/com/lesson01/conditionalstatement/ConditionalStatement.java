package com.lesson01.conditionalstatement;
public class ConditionalStatement {	
    public static void main(String[] args) {
        int age = 18;
        if (age > 20) {
        	System.out.println("Объект разменял третий десяток");
        }

        boolean male = true;
        if (male) {
        	System.out.println("Объект мужского рода");
        }
        
        if (!male) {
        	System.out.println("Объект женского рода");
        }

        double hight = 1.92;
        if (hight < 1.8) {
        	System.out.println("Рост объекта не превышает допустимых норм");
        } else {
        	System.out.println("Рост объекта превышает допустимую норму");
        }      

        char nameFirstLetter = 'П';
        if (nameFirstLetter == 'М') {
        	System.out.println("Имя начинается на М");
        } else if (nameFirstLetter == 'И') {
            System.out.println("Имя начинается на И");
        } else {
        	System.out.println("Имя начинается на букву " + nameFirstLetter +
        		" и эта буква отлична от 'М' и 'И'");
        }
    }
}