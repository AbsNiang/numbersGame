package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        mainMenu(startingNumb());
    }

    public static int startingNumb() {
        Random random = new Random();
        return (random.nextInt(30 - 20 + 1) + 20);
    }

    public static int userNumb() {
        Scanner input = new Scanner(System.in);
        boolean validSubtraction = false;
        int subtractedNumber = 0;
        //gets a
        while (!validSubtraction) {
            try {
                System.out.println("How many do you want to remove? (1-3) ");
                subtractedNumber = input.nextInt();
                if (subtractedNumber == 1 || subtractedNumber == 2 || subtractedNumber == 3) {
                    validSubtraction = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("This is not a number");
                input.next();
            }
        }
        return subtractedNumber;
    }

    public static int computerNumb(int currentNumb) {
        int computerNumber;
        if (currentNumb == 4) { // goes to 1 so they are forced to lose
            computerNumber = 3;
        } else if (currentNumb == 3) {// goes to 1 so they are forced to lose
            computerNumber = 2;
        } else if (currentNumb == 2) {// goes to 1 so they are forced to lose
            computerNumber = 1;
        } //stays on the pattern 4n +5 so that you will win if you start with a good number or they mess up
        else if (currentNumb == 30) {
            computerNumber = 1;
        }//stays on the pattern 4n +5 so that you will win if you start with a good number or they mess up
        else if (currentNumb < 29 && currentNumb > 25) {
            if (currentNumb == 28) {
                computerNumber = 3;
            } else if (currentNumb == 27) {
                computerNumber = 2;
            } else {
                computerNumber = 1;
            }
        }//stays on the pattern 4n +5 so that you will win if you start with a good number or they mess up
        else if (currentNumb < 25 && currentNumb > 21) {
            if (currentNumb == 24) {
                computerNumber = 3;
            } else if (currentNumb == 23) {
                computerNumber = 2;
            } else {
                computerNumber = 1;
            }
        }//stays on the pattern 4n +5 so that you will win if you start with a good number or they mess up
        else if (currentNumb < 21 && currentNumb > 17) {
            if (currentNumb == 20) {
                computerNumber = 3;
            } else if (currentNumb == 19) {
                computerNumber = 2;
            } else {
                computerNumber = 1;
            }
        }//stays on the pattern 4n +5 so that you will win if you start with a good number or they mess up
        else if (currentNumb < 17 && currentNumb > 13) {
            if (currentNumb == 16) {
                computerNumber = 3;
            } else if (currentNumb == 15) {
                computerNumber = 2;
            } else {
                computerNumber = 1;
            }
        }//stays on the pattern 4n +5 so that you will win if you start with a good number or they mess up
        else if (currentNumb < 13 && currentNumb > 9) {
            if (currentNumb == 12) {
                computerNumber = 3;
            } else if (currentNumb == 11) {
                computerNumber = 2;
            } else {
                computerNumber = 1;
            }
        }//stays on the pattern 4n +5 so that you will win if you start with a good number or they mess up
        else if (currentNumb < 9 && currentNumb > 5) {
            if (currentNumb == 8) {
                computerNumber = 3;
            } else if (currentNumb == 7) {
                computerNumber = 2;
            } else {
                computerNumber = 1;
            }
        }else{
            computerNumber =1;
        }
        return computerNumber;
    }

    public static void mainMenu(int currentNumb) {
        int turn = 0;
        int removedVal;
        while (currentNumb > 0) {
            System.out.println("The value is currently " + currentNumb);
            try {
                if (turn % 2 == 0) {
                    System.out.println("It is your turn");
                    removedVal = userNumb();
                    currentNumb = currentNumb - removedVal;
                } else {
                    removedVal = computerNumb(currentNumb);
                    System.out.println("The computer has removed " + removedVal);
                    currentNumb = currentNumb - removedVal;
                }
                turn++;
            } catch (InputMismatchException e) {
                System.out.println("You have not typed a number");
            }
        }
        if (turn %2 ==0){
            System.out.println("You have won");
        }else{
            System.out.println("You have lost");
        }
    }
}
