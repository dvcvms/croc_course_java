package ru.croc.task12;

import java.util.*;

public class Task12 {
    public static void main(String[] args) {

        String [] stringsComment = {
                "Тестовый пример без ошибок №0",
                "Дерево зеленый упало",
                "Тестовый пример без ошибок №1",
                "Зеленый человек решил прыгнуть",
                "На дворе растет трава зеленый",
                "Тестовый пример без ошибок №2",
                "Red colour",
                "У меня red цвет волос",
                "Цвет стен - red",
                "RED",
        };

        String [] stringsBlack = {
                "red",
                "зеленый",
        };

        FilterComment filterComment = new FilterComment();

        List<String> comments = new ArrayList<>(Arrays.asList(stringsComment));

        Set<String> blackList = new HashSet<>(Arrays.asList(stringsBlack));

        filterComment.filterComments(comments, blackList);
        System.out.println(comments);
    }
}
