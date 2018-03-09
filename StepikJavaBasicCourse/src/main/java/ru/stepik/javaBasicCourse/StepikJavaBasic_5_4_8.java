package ru.stepik.javaBasicCourse;

import java.io.*;
import java.util.Objects;

public class StepikJavaBasic_5_4_8 {

    public static void main(String[] args){
        final File file = new File("Stepik_5_4_8.txt");
        byte[] arrByte;

        int countAnimals = 4;
        Animal animal1 = new Animal("Animal1");
        Animal animal2 = new Animal("Animal2");
        Animal animal3 = new Animal("Animal3");
        Animal animal4 = new Animal("Animal4");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeInt(countAnimals);
            objectOutputStream.writeObject(animal1);
            objectOutputStream.writeObject(animal2);
            objectOutputStream.writeObject(animal3);
            objectOutputStream.writeObject(animal4);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch(IOException e) { 
            e.printStackTrace(); 
        }

        arrByte = new byte[(int) file.length()];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(arrByte);
        } catch(IOException e) { 
            e.printStackTrace(); 
        }

        Animal[] animals = deserializeAnimalArray(arrByte);
        for (Animal animal : animals) {
            System.out.println(animal.getName());
        }
    }

    public static Animal[] deserializeAnimalArray(byte[] data) {
        int lenArr;
        Animal[] arrAnimal = null;
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new ByteArrayInputStream(data));
            lenArr = objectInputStream.readInt();
            arrAnimal = new Animal[lenArr];
            for (int i = 0; i < arrAnimal.length; i++) {
                arrAnimal[i] = (Animal) objectInputStream.readObject();
            }
            objectInputStream.close();
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
        return arrAnimal;
    }

    static class Animal implements Serializable {
        private final String name;

        public Animal(String name) {
            this.name = name;
        }

        String getName() {
            return name;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Animal) {
                return Objects.equals(name, ((Animal) obj).name);
            }
            return false;
        }
    }

}