package com.lesson02.jaeger;
public class JaegerTest {
	public static void main(String[] args) {
		Jaeger robot1 = new Jaeger();
		Jaeger robot2 = new Jaeger();

		robot1.setModelName("Gipsy Danger");
		robot1.setWeight(1.98);
		robot1.setSpeed(7);
		robot1.setKaijuKilled(9);

		robot2.setModelName("Striker Eureka");
		robot2.setWeight(1.85);
		robot2.setSpeed(10);
		robot2.setKaijuKilled(11);

		System.out.println("Сводная информация по роботам:");
		/*
		System.out.println(robot1.toString()); выводит такое сообщение: Jaeger@15db9742
		"Но когда мы пытаемся вывести информацию об объекте, мы отображаем данные из 
		classname@HashCode_in_Hexadeciaml_form. 
		Если нужна соответствующая информация об объекте класса Jaeger, тогда нужно 
		переопределить метод toString Java класса Object в классе Jaeger"
		
		Тупо, как обезьяна, переопределяю (см. класс Jaeger), не особо понимая, что там происходит.
		*/
		System.out.println(robot1);
		System.out.println(robot2);

		// в результате боя робот1 уничтожил 3 Кайдзю
		robot1.setKaijuKilled(robot1.getKaijuKilled()+3);

		System.out.println("\n"+robot1.getModelName() + " уничтожил суммарно " + 
			robot1.getKaijuKilled() + " Кайдзю");

		System.out.println("Обновленная информация по роботам:");
		System.out.println(robot1);
		System.out.println(robot2);
	}
}