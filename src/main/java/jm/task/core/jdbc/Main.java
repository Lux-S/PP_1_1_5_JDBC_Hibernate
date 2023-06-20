package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        // Создаем таблицу пользователей
        userService.createUsersTable();

        // Добавляем пользователей

        saveUserAndPrintMessage(userService, "Mila", "Sutormina", (byte) 40);
        saveUserAndPrintMessage(userService, "Evgeny", "Samsonov", (byte) 30);
        saveUserAndPrintMessage(userService, "Liza", "Artamonova", (byte) 35);
        saveUserAndPrintMessage(userService, "Alice", "Ivanova", (byte) 45);

        // Получаем всех пользователей
        List<User> users = userService.getAllUsers();
        for (User user : users) {
            System.out.println(user);
        }

        // Очищаем таблицу пользователей
        userService.cleanUsersTable();

        // Удаляем таблицу пользователей
        userService.dropUsersTable();
    }

    private static void saveUserAndPrintMessage(UserService userService, String firstName, String lastName, byte age) {
        userService.saveUser(firstName, lastName, age);
        System.out.printf("User с именем – %s добавлен в базу данных.\n", firstName);
    }
}
