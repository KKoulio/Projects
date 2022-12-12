package gr.aueb.cf.projects;

import java.util.Scanner;

public class ProjectCh5App {
    final static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        boolean quit = false;
        String response;

        do {
            printMenu();
            response = getChoice();

            try {
                if (response.matches("[qQ]")) {
                    quit = true;
                } else {
                    printOnChoice(response);
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid Choice");
            }

        } while (!quit);
    }

    public static void printOnChoice(String s) throws IllegalArgumentException {
        int choice;
        int n = 0;

        try {
            choice = Integer.parseInt(s);
            if ((choice >= 1) && (choice <= 5)) {
                System.out.println("Please insert the number of stars");
                n = Integer.parseInt(getChoice());
            }

            switch (choice) {
                case 1:
                    printStarsH(n);
                    break;
                case 2:
                    printStarsV(n);
                    break;
                case 3:
                    printStarsHV(n);
                    break;
                case 4:
                    printStarsAsc(n);
                    break;
                case 5:
                    printStarsDesc(n);
                    break;
                default:
                    throw new IllegalArgumentException();
            }

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static void printMenu() {
        System.out.println("Please select one of the following");
        System.out.println(); //Visual Styling
        System.out.println("1. Print H");
        System.out.println("2. Print V");
        System.out.println("3. Print HV");
        System.out.println("4. Print Asc");
        System.out.println("5. Print Desc");
        System.out.println("6. Q or q to Quit");
    }

    public static String getChoice() {
        return in.nextLine().trim();
    }

    public static void printStarsH(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print("*");
        }
    }

    public static void printStarsV(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println("*");
        }
    }

    public static void printStarsHV(int n) {
        for (int i = 1; i <= n; i++) {
            printStarsH(n);
            System.out.println();
        }
    }

    public static void printStarsAsc(int n) {
        for (int i = 1; i <= n; i++) {
            printStarsH(i);
            System.out.println();
        }
    }

    public static void printStarsDesc(int n) {
        for (int i = n; i >= 1; i--) {
            printStarsH(i);
            System.out.println();
        }
    }
}
