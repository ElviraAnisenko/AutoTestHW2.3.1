package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;
import lombok.experimental.UtilityClass;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

    public class DataGenerator {
        private DataGenerator() {
        }

        public static String generateDate(int shift) {
            // TODO: добавить логику для объявления переменной date и задания её значения, для генерации строки с датой
            // Вы можете использовать класс LocalDate и его методы для получения и форматирования даты
            return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        }

        public static String generateCity() {
            var cities= new String[]{"Москва", "Санкт-Петербург","Самара", "Краснодар", "Салехард", "Псков", "Ростов-на-Дону","Оренбург"};
            // TODO: добавить логику для объявления переменной city и задания её значения, генерацию можно выполнить
            // с помощью Faker, либо используя массив валидных городов и класс Random

            return cities[new Random().nextInt(cities.length)-1];
        }

        public static String generateName(String locale) {
            // TODO: добавить логику для объявления переменной name и задания её значения, для генерации можно

            return new Faker(new Locale(locale)).name().fullName();
        }

        public static String generatePhone(String locale) {
            // TODO: добавить логику для объявления переменной phone и задания её значения, для генерации можно
            // использовать Faker
            return new Faker(new Locale(locale)).phoneNumber().phoneNumber();
        }

        public static class Registration {
            private Registration() {
            }

            public static UserInfo generateUser(String locale) {
                // TODO: добавить логику для создания пользователя user с использованием методов generateCity(locale),
                // generateName(locale), generatePhone(locale)
                return new UserInfo(generateName(locale),generateCity(),generatePhone(locale));
            }
        }

        @Value
        public static class UserInfo {
            String city;
            String name;
            String phone;



        }
    }

