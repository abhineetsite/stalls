package com.desicabana.stalls.controller;

import java.util.Arrays;

// A class to demonstrate reversing a string, array, sentence, and paragraph
public class Reverse {
    public static void main(String[] args) {
        // Reverse a string
        String str = "Hello World";
        String reverse = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reverse += str.charAt(i);
        }
        System.out.println(reverse);

        // Reverse an array
        int[] arr = { 1, 2, 3, 4, 5 };
        int[] reverseArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reverseArr[i] = arr[arr.length - 1 - i];
        }
        System.out.println(Arrays.toString(reverseArr));
        
        // Reverse an array in place
        int[] arr2 = { 1, 2, 3, 4, 5 };
        for (int i = 0; i < arr2.length / 2; i++) {
            int temp = arr2[i];
            arr2[i] = arr2[arr2.length - 1 - i];
            arr2[arr2.length - 1 - i] = temp;
        }
        System.out.println(Arrays.toString(arr2));

        // Reverse a Sentence
        String sentence = "Hello World";
        String[] words = sentence.split(" ");
        String reverseSentence = "";
        for (int i = words.length - 1; i >= 0; i--) {
            reverseSentence += words[i] + " ";
        }
        System.out.println(reverseSentence);

        // Reverse a Sentence in place
        String sentence2 = "Hello World";
        String[] words2 = sentence2.split(" ");
        for (int i = 0; i < words2.length / 2; i++) {
            String temp = words2[i];
            words2[i] = words2[words2.length - 1 - i];
            words2[words2.length - 1 - i] = temp;
        }   
        System.out.println(String.join(" ", words2));

        // Reverse a Sentence in place without using split
        String sentence3 = "Hello World";
        String reverseSentence3 = "";
        String word = "";
        for (int i = 0; i < sentence3.length(); i++) {
            if (sentence3.charAt(i) == ' ') {
                reverseSentence3 = word + " " + reverseSentence3;
                word = "";
            } else {
                word += sentence3.charAt(i);
            }
        }
        reverseSentence3 = word + " " + reverseSentence3;
        System.out.println(reverseSentence3);

        // Reverse a Sentence in place without using split and without using extra space
        String sentence4 = "Hello World";
        String reverseSentence4 = "";
        String word4 = "";
        for (int i = 0; i < sentence4.length(); i++) {
            if (sentence4.charAt(i) == ' ') {
                reverseSentence4 = word4 + " " + reverseSentence4;
                word4 = "";
            } else {
                word4 += sentence4.charAt(i);
            }
        }
        reverseSentence4 = word4 + " " + reverseSentence4;
        System.out.println(reverseSentence4);
        
        // Reverse a paragraph in place without using split and without using extra space
        String paragraph = "Hello World. This is a paragraph. It has multiple sentences.";
        String reverseParagraph = "";
        String sentence5 = "";
        String word5 = "";
        for (int i = 0; i < paragraph.length(); i++) {
            if (paragraph.charAt(i) == '.') {
                reverseParagraph = sentence5 + word5 + "." + reverseParagraph;
                sentence5 = "";
                word5 = "";
            } else if (paragraph.charAt(i) == ' ') {
                sentence5 = word5 + " " + sentence5;
                word5 = "";
            } else {
                word5 += paragraph.charAt(i);
            }
        }
        reverseParagraph = sentence5 + word5 + "." + reverseParagraph;
        System.out.println(reverseParagraph);


            
    }
    
}
