package com.lesson;


import java.util.Scanner;

public class Main {
    //create a variable, which will be to complete a process of the game
    private boolean stop;
    public void setStop(boolean stop) {
        this.stop = stop;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Main main = new Main();
        char[][] massive = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        main.showMassive(massive);
        main.processOfGame(main, scan, massive);

    }

    //show a playing field
    public void showMassive(char [][] massive) {
        System.out.println("---------");
        for (int j = 2; j >= 0; j--) {
            System.out.print("| ");
            for (char[] chars : massive) {
                System.out.print(chars[j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    //enter coordinates, check them and enter into the playing field
    public void enterCoordinates(Scanner scan, char [][] massive, char element) {
        boolean exit = false;
        while (!exit) {
            String inputCoordinates = scan.nextLine();
            //start check
            if (inputCoordinates.matches("[0-9]\\s[0-9]")) {
                String[] coordinates = inputCoordinates.split(" ");
                if (coordinates[0].matches("[123]") && coordinates[1].matches("[123]")) {
                    for (int j = 2; j >= 0; j--) {
                        for (int i = 0; i < massive.length; i++) {
                            if (i == Integer.parseInt(coordinates[0]) - 1 && j == Integer.parseInt(coordinates[1]) - 1) {
                                if (massive[Integer.parseInt(coordinates[0]) - 1][Integer.parseInt(coordinates[1]) - 1] == ' ') {
                                    massive[Integer.parseInt(coordinates[0]) - 1][Integer.parseInt(coordinates[1]) - 1] = element;
                                    exit = true;
                                } else {
                                    System.out.println("Enter the coordinates: " + coordinates[0] + " " + coordinates[1]);
                                    System.out.println("This cell is occupied! Choose another one!");

                                }
                            }
                        }

                    }
                } else {
                    System.out.println("Enter the coordinates: " + coordinates[0] + " " + coordinates[1]);
                    System.out.println("Coordinates should be from 1 to 3!");
                }
            } else {
                System.out.println("Enter the coordinates: " + inputCoordinates);
                System.out.println("You should enter numbers!");
            }
        }
    }

    public void processOfGame(Main main, Scanner scan, char [][] massive) {
        char element;
        int oORx = 1;
        main.setStop(false);
        while(!stop) {
            if (oORx % 2 == 0){
                element = 'O';
            } else{
                element = 'X';
            }
            main.enterCoordinates(scan, massive, element);
            main.showMassive(massive);
            main.algorithm(massive);
            oORx++;


        }

    }

    //This method reads the playing field and checks him
    public void algorithm(char [][] massive) {
        boolean resultX = false;
        boolean resultO = false;
        StringBuilder build = new StringBuilder();
        for (int j = 2; j >= 0; j--) {
            for (char[] chars : massive) {
                build.append(chars[j]);
            }
        }
        int countX = 0;
        int countO = 0;
        for (int i = 0; i < build.length(); i++){
            if (build.toString().charAt(i) == 'X'){
                countX++;
            }else if (build.toString().charAt(i) == 'O'){
                countO++;
            }
        }
        if ((build.toString().matches("X{3}.+") ||
                build.toString().matches("X.{3}X.{3}X") ||
                build.toString().matches(".{2}X.X.X.{2}") ||
                build.toString().matches(".{6}X{3}") ||
                build.toString().matches(".{3}X{3}.{3}") ||
                build.toString().matches("X.{2}X.{2}X.{2}") ||
                build.toString().matches(".X.{2}X.{2}X.") ||
                build.toString().matches(".{2}X.{2}X.{2}X"))) {
            resultX = true;
        }
        if ((build.toString().matches("O{3}.+") ||
                build.toString().matches("O.{3}O.{3}O") ||
                build.toString().matches(".{2}O.O.O.{2}") ||
                build.toString().matches(".{6}O{3}") ||
                build.toString().matches(".{3}O{3}.{3}") ||
                build.toString().matches("O.{2}O.{2}O.{2}") ||
                build.toString().matches(".O.{2}O.{2}O.") ||
                build.toString().matches(".{2}O.{2}O.{2}O"))) {
            resultO = true;
        }
        if (resultO) {
            System.out.println("O wins");
            stop = true;
        } else if (resultX) {
            System.out.println("X wins");
            stop = true;
        } else if (countX + countO == 9) {
            System.out.println("Draw");
            stop = true;
        }
    }
}