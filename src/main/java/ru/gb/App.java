package ru.gb;

public class App 
{
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_CYAN = "\u001B[36m";

    public static void main(String[] args) {

        System.out.println(ANSI_CYAN + "--------------------------------------------------------------------------------------------\n" +
                           "        Задание 1. Перенесите сценарии для CRM в src/test/java. Добавьте ассерты.\n" +
                           "--------------------------------------------------------------------------------------------\n" + ANSI_RESET);

    }
}
