package com.github.zipcodewilmington;
import java.util.Arrays;
import java.util.Scanner;


/**
 * @author xt0fer
 * @version 1.0.0
 * @date 5/27/21 11:02 AM
 */
public class Hangman {
    //starts the game
    //a random word is chosen from a list
    //the number of tries allowed is set to the length of the word
    //setup the two (the solution and the player's guesses) character arrays
    //WHILE the numbers of tries is less than tries allowed AND
    //the player has not guessed the word
    //print the current state of the player's guesses
    //ask the player for a letter (a character)
    //if the letter is a minus "-", quit the game
    //else process the letter
    //if the letter makes the work complete,
    //the player wins
    //after the while loop
    //if the word is not guessed, player loses
    public static void main(String[] args) {
        String[] wordList = {"cat","gunna", "wunya", "pets", "phone", "macbook"};

        int randomWordChooser = (int) (Math.random() * 6);
        char[] solutionArray = wordList[randomWordChooser].toCharArray();
        char[] playerArray = new char[solutionArray.length];
        System.out.println(solutionArray);

        Scanner myObj = new Scanner(System.in);

        //number of guesses set to the random word length
        int counter = solutionArray.length;
        while (0 < counter) {
            System.out.println("You currently have " + counter + " guesses");
            //console function to print out guesses
            for (int i = 0; i < playerArray.length; i++) {
                if (solutionArray[i] == playerArray[i]) {
                    System.out.print(playerArray[i]);
                } else {
                    System.out.print('-');
                }
            }
            //gets input from the user and assigns it to the index of the chosen random word
            System.out.println("\nPlease enter a character: ");
            String userGuess = myObj.nextLine();
            for (int j = 0; j < playerArray.length; j++) {
                if (solutionArray[j] == userGuess.charAt(0)) {
                    playerArray[j] = userGuess.charAt(0);
                }
            }
            counter--;
        }
        if (Arrays.equals(playerArray, solutionArray)){
            System.out.print("Congrats you guessed the word correctly: ");
            System.out.print(playerArray);
            System.out.println("\nYou won");
        }
    }
}