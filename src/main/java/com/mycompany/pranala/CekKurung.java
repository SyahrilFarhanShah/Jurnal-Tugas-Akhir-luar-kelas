package com.mycompany.pranala;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author syahrilfarhan
 */
import java.util.Scanner;

public class CekKurung {

    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
        }
    }

    static class Stack {
        private Node top;

        boolean isEmpty() {
            return top == null;
        }

        void push(char c) {
            Node n = new Node(c);
            n.next = top;
            top = n;
        }

        char pop() {
            char c = top.data;
            top = top.next;
            return c;
        }

        void display() {
            if (isEmpty()) {
                System.out.println("Stack: (kosong)");
                return;
            }
            StringBuilder sb = new StringBuilder("Stack (TOP -> BOTTOM): ");
            Node current = top;
            while (current != null) {
                sb.append("[").append(current.data).append("] ");
                current = current.next;
            }
            System.out.println(sb);
        }
    }

    static boolean isValid(String ekspresi) {
        Stack stack = new Stack();

        for (int i = 0; i < ekspresi.length(); i++) {
            char c = ekspresi.charAt(i);

            if (c == '(') {
                stack.push(c);
                System.out.println("Karakter '" + c + "' -> PUSH");
                stack.display();
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    System.out.println("Karakter '" + c + "' -> stack kosong, tidak ada pasangan '('");
                    stack.display();
                    return false;
                }
                stack.pop();
                System.out.println("Karakter '" + c + "' -> POP");
                stack.display();
            }
        }

        if (!stack.isEmpty()) {
            System.out.println("Akhir ekspresi: masih ada '(' yang belum ditutup");
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input : ");
        String input = sc.nextLine();

        System.out.println();
        boolean valid = isValid(input);

        System.out.println();
        System.out.println("Output: " + (valid ? "Valid" : "Tidak Valid"));
    }
}
