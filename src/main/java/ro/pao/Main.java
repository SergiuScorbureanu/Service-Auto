package ro.pao;

import ro.pao.application.Menu;
import ro.pao.exceptions.CustomFileNotFoundException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws CustomFileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Menu menu = Menu.getInstance();

            menu.application();

            if ("exit".equals(scanner.next())) {
                break;
            }
        }
    }
}
