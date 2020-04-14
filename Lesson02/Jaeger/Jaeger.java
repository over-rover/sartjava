public class Jaeger {
	private String modelName;
	private double weight;
	private int speed;
	private int kaijuKilled;

	void setModelName(String modelName) {
		this.modelName = modelName;
	}
	void setWeight(double weight) {
		this.weight = weight;
	}
	void setSpeed(int speed) {
		this.speed = speed;
	}
	void setKaijuKilled(int kaijuKilled) {
		this.kaijuKilled = kaijuKilled;
	}

	String getModelName() {
		return this.modelName;
	}	
	double getWeight() {
		return this.weight;
	}
	int getSpeed() {
		return this.speed;
	}
	int getKaijuKilled() {
		return this.kaijuKilled;
	}

	void generalInfo () {
	System.out.println("Модель: " + this.modelName + "\tМасса: " + this.weight + "\tСкорость: " + 
		this.speed + "\tУничтожено Кайдзю: " + this.kaijuKilled);	
	}	
}	