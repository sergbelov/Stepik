package ru.stepik.example;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorExample2 {

    public static void main(String[] args) {
        Product[] p = new Product[3];

        // заполним объект Product содержимым
        p[0] = new Product();
        p[0].setName("Milk");
        p[0].setPrice(7.56);
        p[0].setQuantity(56);

        p[1] = new Product();
        p[1].setName("Coffee");
        p[1].setPrice(17.00);
        p[1].setQuantity(32);

        p[2] = new Product();
        p[2].setName("Tea");
        p[2].setPrice(12.50);
        p[2].setQuantity(0);

        // выведем данные без сортировки
        System.out.println("============ no sorted ==============");

        for (Product i : p) {
            System.out.println("Name: " + i.getName() +
                    " price: " + i.getPrice() +
                    " quantity: " + i.getQuantity());
        }

        // отсортируем и выведем данные по цене
        System.out.println("========== sorted by price===========");

        Arrays.sort(p, new SortedByPrice());

        for (Product i : p) {
            System.out.println("Name: " + i.getName() +
                    " price: " + i.getPrice() +
                    " quantity: " + i.getQuantity());
        }

        // отсортируем и выведем данные по названию
        System.out.println("========== sorted by name ===========");

        Arrays.sort(p, new SortedByName());
        for (Product i : p) {
            System.out.println("Name: " + i.getName() +
                    " price: " + i.getPrice() +
                    " quantity: " + i.getQuantity());
        }
    }


    // создадим простой объект, в котором будем хранить данные
    public static class Product {
        private String name;
        private double price;
        private int quantity;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }

    // теперь собственно реализуем интерфейс Comparator, для сортировки по названию
    static class SortedByName implements Comparator<Product> {

        public int compare(Product obj1, Product obj2) {

            String str1 = obj1.getName();
            String str2 = obj2.getName();

            return str1.compareTo(str2);
        }
    }

    // а так же реализуем интерфейс Comparator, для сортировки по цене
    static class SortedByPrice implements Comparator<Product> {

        public int compare(Product obj1, Product obj2) {

            double price1 = obj1.getPrice();
            double price2 = obj2.getPrice();

            if (price1 > price2) {
                return 1;
            } else if (price1 < price2) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}