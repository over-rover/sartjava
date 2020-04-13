public class WolfTest {
	public static void main(String[] args) {
		Wolf myWolf = new Wolf();
		myWolf.name = "Волкан";
		myWolf.age = 2;
		myWolf.gender = "Самец";
		myWolf.colour = "белый";
		myWolf.weight = 46.3;

		System.out.println("В заповеднике обитает волк со следующими свойствами:" +
			"\nПол " + myWolf.gender + "\tОкрас " + myWolf.colour + "\tВозраст " + myWolf.age +
			"\tВес " + myWolf.weight + "\tКличка " + myWolf.name);

		System.out.println("Давайте скажем волку ИДТИ");
		myWolf.go();
		
		System.out.println("Теперь скажем волку БЕЖАТЬ");
		myWolf.run();
		
		System.out.println("А сейчас волк чем занимается?\t" + myWolf.sit());
		System.out.println("Он, наверное, воет на луну?\t" + myWolf.howl());
		
		System.out.println("Поясните, волк охотится на животных или кушает травку?");
		if (myWolf.hunt()) {
			System.out.println("Он хищник. Конечно, охотится");
		} else {
			System.out.println("Да, да, травку щиплет. Вот тебе пучок - сходи покорми его");
		}
	}
}