public class Wolf {
	String name;
	int age;
	String gender;
	double weight;
	String colour;

	void go() {
		System.out.println("Идет");
	}

	void run() {
		System.out.println("Бежит");
	}

	String sit() {
		return "Сидит";
	}

	boolean howl() {
		return false;
	}
	
	boolean hunt() {
		System.out.println("Метод hunt возвращает true, а значит");
		return true;
	}
}