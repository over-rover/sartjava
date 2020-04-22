package com.lesson01.variable;
public class Variable {	
    public static void main(String[] args) {
        byte hardDiskQuantity = 5;
        short coreQuantity = 4;
        int valueRAM = 4000;
        long hardDiskVal = 1000l;
        float proceccorFrequency = 2.4f;
        double paramA = 35.325;
        char mainDisk = 'C';
        boolean goodComputer = false;

        System.out.println("Характеристики компьютера:" + 
        	"\n Количество жестких дисков: " +  hardDiskQuantity +
        	"\n Объем жесткого диска: " + hardDiskVal + 
        	"\n Основной диск: " + mainDisk + 
        	"\n Частота процессора: " + proceccorFrequency + 
        	"\n Количество ядер: " + coreQuantity +
        	"\n Объем RAM: " + valueRAM +
        	"\n Значение параметра А: " + paramA +
        	"\n Отличный комп? " + goodComputer);
    }
}