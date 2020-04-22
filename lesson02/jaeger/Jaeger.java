public class Jaeger {
	private String modelName;
	private double weight;
	private int speed;
	private int kaijuKilled;

	void setModelName(String modelName) {
		this.modelName = modelName;
	}

	String getModelName() {
		return modelName;
	}

	void setWeight(double weight) {
		this.weight = weight;
	}

	double getWeight() {
		return weight;
	}

	void setSpeed(int speed) {
		this.speed = speed;
	}

	int getSpeed() {
		return speed;
	}

	void setKaijuKilled(int kaijuKilled) {
		this.kaijuKilled = kaijuKilled;
	}

	int getKaijuKilled() {
		return kaijuKilled;
	}

	// переопределяем метод toString Java класса Object
	public String toString() {
		return "Модель: " + modelName + "\tМасса: " + weight + "\tСкорость: " + speed + 
		"\tУничтожено Кайдзю: " + kaijuKilled;	
	}
}	