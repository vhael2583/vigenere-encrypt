/*
Name: Vincent Hael
Student ID: 2583
Course: Applied Cryptography
Teacher: Dr. Khoshavi
 */

package com.company;

import java.util.ArrayList;

public class Project1CodeHaelVincent {
    public static ArrayList repeatedKeyList(int[] key, int[] message) {
        int counter = 0;
        int keyLength = key.length;
        ArrayList<Integer> repeatedKey = new ArrayList<>();

        for (int i = 0; i < message.length; i++) {
            //check for spaces
            if (message[i] == -33) {
                repeatedKey.add(-33);
            }
            // check for repeat key
            else if (message[i] == -19) {
                repeatedKey.add(-19);
            } else {
                repeatedKey.add(key[counter % keyLength]);
                counter++;
            }
        }
        return repeatedKey;
    }

    public static void execute(String message, String key) {
        //Turning the message into a collection of ASCII values in an array
        int messageArray[] = new int[message.length()];
        for (int i = 0; i < messageArray.length; i++) {
            messageArray[i] = message.charAt(i) - 65; //assign the integer value of character.
            //NOTE - 65 is ASCII value of A, -33 is the ASCII Value of space - 65.
        }

        //Turning the key into a collection of ASCII values in an array
        int keyArray[] = new int[key.length()];
        for (int i = 0; i < keyArray.length; i++) {
            keyArray[i] = key.charAt(i) - 65; //assign the integer value of character.
            //NOTE - 65 is ASCII value of A, -33 is the ASCII Value of space - 65.
        }

        //Repeating the key
        int counter = 0;
        ArrayList<Integer> keyArrayList = repeatedKeyList(keyArray, messageArray);

        //Encrypting Procedure
        int cryptArray[] = new int[message.length()];
        for (int i = 0; i < cryptArray.length; i++) {
            cryptArray[i] = (messageArray[i] + keyArrayList.get(i)) % 26;
        }
        //Decrypting the message to english
        System.out.println("\nThe encrypted message of each message is: ");
        String decryptMessage = " ";
        for (int i = 0; i < cryptArray.length; i++) {
            cryptArray[i] = cryptArray[i] + 65;
            if (cryptArray[i] == 51) //Resulted value of ASCII + 65
            {
                decryptMessage += " ";
            } else if (cryptArray[i] == 53) //Resulted value of ASCII + 65
            {
                decryptMessage += ".";
            } else {
                decryptMessage += String.valueOf((char) cryptArray[i]);
            }
        }
        System.out.println("\n" + decryptMessage);
    }

    public static void main(String[] args) {
        //Prompting the user for message and key
        System.out.print("Welcome to the Vigenere Encrypter.\n");

        String stressTest1 = "A HEALTHY ATTITUDE IS CONTAGIOUS BUT DONT WAIT TO CATCH IT FROM OTHERS.";
        String stressTest2 = "IF YOU CARRY YOUR CHILDHOOD WITH YOU YOU NEVER BECOME OLDER.";
        String stressTest3 = "FROM PRINCIPLES IS DERIVED PROBABILITY BUT TRUTH OR CERTAINTY IS OBTAINED ONLY FROM FACTS.";
        String key = "KHOSHAVI";

        execute(stressTest1, key);
        execute(stressTest2, key);
        execute(stressTest3, key);
    }
}
