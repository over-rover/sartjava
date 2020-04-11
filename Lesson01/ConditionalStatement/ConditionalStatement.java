public class ConditionalStatement {	
    public static void main(String[] args) {
        int objAge = 18;
        if (objAge > 20) {
        	System.out.println("Объект разменял третий десяток");
        }

        boolean objMale = true;
        if (objMale) {
        	System.out.println("Объект мужского рода");
        }
        
        if (!objMale) {
        	System.out.println("Объект женского рода");
        }

        double objHight = 1.92;
        if (objHight < 1.8) {
        	System.out.println("Рост объекта не превышает допустимых норм");
        }  
        else {
        	System.out.println("Рост объекта превышает допустимую норму");
        }      

        char nameFirstLetter = 'П';
        if (nameFirstLetter == 'М') {
        	System.out.println("Имя начинается на М");
        }
        else if (nameFirstLetter == 'И') {
        	System.out.println("Имя начинается на И");
        }
        else {
        	System.out.println("Имя начинается на букву " + nameFirstLetter +
        		" и эта буква отлична от 'М' и 'И'");
        }
    }
}