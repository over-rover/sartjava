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
		robot1.generalInfo();
		robot2.generalInfo();

		// в результате боя робот1 уничтожил 3 Кайдзю
		robot1.setKaijuKilled(robot1.getKaijuKilled()+3);

		System.out.println("\n"+robot1.getModelName() + " уничтожил в последнем бою " + 
			robot1.getKaijuKilled() + " Кайдзю");

		System.out.println("Обновленная информация по роботам:");
		robot1.generalInfo();
		robot2.generalInfo();
	}
}