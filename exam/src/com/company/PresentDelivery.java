package com.company;

import java.util.Scanner;

public class PresentDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int presents = Integer.parseInt(scanner.nextLine());

        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        int rowPosition = 0;
        int colPosition = 0;

        for (int i = 0; i < size; i++) {
            String line = scanner.nextLine();
            matrix[i] = line.toCharArray();
            if (line.contains("S")){
                rowPosition  = i;
                colPosition  = line.indexOf("S");
            }
        }
        int happyKid = 0;

        String command = scanner.nextLine();

        while (!command.equals("Christmas morning") ){

            int row = rowPosition;
            int col = colPosition;

            switch (command){
                case "up":
                    row -= 1;
                    break;
                case "down":
                    row += 1;
                    break;
                case "right":
                    col +=2;
                    break;
                case "left":
                    col -=2;
                    break;
            }

            char symbol = matrix[row][col];

                if (symbol == '-'){
                    matrix [rowPosition][colPosition] = '-';
                    matrix [row][col] = 'S';
                    rowPosition = row;
                    colPosition = col;
                }else if (symbol == 'X'){
                    matrix [rowPosition][colPosition] = '-';
                    matrix [row][col] = 'S';
                    rowPosition = row;
                    colPosition = col;
                }else if (symbol == 'V'){
                    presents --;
                    happyKid ++;

                    matrix [rowPosition][colPosition] = '-';
                    matrix [row][col] = 'S';
                    rowPosition = row;
                    colPosition = col;

                    if (presents <= 0 ){
                        break;
                    }

                }else if (symbol == 'C'){
                    matrix [rowPosition][colPosition] = '-';
                    matrix [row][col] = 'S';
                    if (matrix[row +1][col] == 'X' || matrix[row +1][col] == 'V'){
                        presents --;
                        happyKid ++;
                        matrix [row +1] [col] = '-';
                        if (presents <= 0 ){
                            break;
                        }
                    }
                    if (matrix[row -1][col] == 'X' || matrix[row - 1][col] == 'V'){
                        presents --;
                        happyKid ++;
                        matrix [row - 1] [col] = '-';
                        if (presents <= 0 ){
                            break;
                        }
                    }
                    if (matrix[row ][col-2] == 'X' || matrix[row ][col-2] == 'V'){
                        presents --;
                        happyKid ++;
                        matrix [row ] [col-2] = '-';
                        if (presents <= 0 ){
                            break;
                        }
                    }
                    if (matrix[row ][col+2] == 'X' || matrix[row ][col+2] == 'V'){
                        presents --;
                        happyKid ++;
                        matrix [row ] [col+2] = '-';
                        if (presents <= 0 ){
                            break;
                        }
                    }
                    rowPosition = row;
                    colPosition = col;

                }

                command = scanner.nextLine();
        }

        if (presents <= 0 ){
            System.out.println("Santa ran out of presents!");
        }

        printMatrix(matrix);

        int countKidLeft = 0;
        char symbol = 'V';

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == symbol){
                    countKidLeft ++;
                }
            }
        }
        if (countKidLeft == 0){
            System.out.println(String.format("Good job, Santa! %d happy nice kid/s.",happyKid));
        }else {
            System.out.println(String.format("No presents for %d nice kid/s.",countKidLeft));
        }




    }

    private static void printMatrix(char[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }


    }
}
