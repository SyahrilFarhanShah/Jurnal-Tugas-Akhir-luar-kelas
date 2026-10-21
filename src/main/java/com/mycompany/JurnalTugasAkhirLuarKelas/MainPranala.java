/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.JurnalTugasAkhirLuarKelas;
import java.util.Scanner;
/**
 *
 * @author syahrilfarhan
 */
public class MainPranala {

    static class Pranala {
        private String url;

        Pranala(String url) {
            this.url = url;
        }

        String info() {
            return url;
        }
    }

    static class Node {
        Pranala data;
        Node next;

        Node(Pranala data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Stack {
        private Node top;
        private int count;

        boolean isEmpty() {
            return top == null;
        }

        int size() {
            return count;
        }

        void push(Pranala value) {
            Node newNode = new Node(value);
            newNode.next = top;
            top = newNode;
            count++;
        }

        Pranala pop() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack Underflow!");
            }
            Pranala value = top.data;
            top = top.next;
            count--;
            return value;
        }

        Pranala peek() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack kosong!");
            }
            return top.data;
        }

        void clear() {
            top = null;
            count = 0;
        }

        void display() {
            if (isEmpty()) {
                System.out.println("  (kosong)");
                return;
            }
            Node current = top;
            while (current != null) {
                System.out.println("  | " + current.data.info() + " |");
                current = current.next;
            }
        }
    }

    static void tampilkan(Stack history, Stack historyForward) {
        System.out.println(" ");
        System.out.println("--- Kondisi Stack ---");
        System.out.println("History (TOP = halaman saat ini):");
        history.display();
        System.out.println("HistoryForward:");
        historyForward.display();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack history = new Stack();    
        Stack historyForward = new Stack();

        int pilihan;
        do {
            System.out.println("");
            System.out.println("===== MENU BROWSER =====");
            System.out.println("1. Input URL baru");
            System.out.println("2. Klik Back");
            System.out.println("3. Klik Forward");
            System.out.println("4. Klik History");
            System.out.println("0. Keluar");
            System.out.print("Pilih > ");
            pilihan = Integer.parseInt(sc.nextLine());

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan URL: ");
                    String url = sc.nextLine();
                    history.push(new Pranala(url));
                    historyForward.clear();
                    System.out.println("Membuka: " + history.peek().info());
                    tampilkan(history, historyForward);
                    break;

                case 2:
                    if (history.size() > 1) {
                        historyForward.push(history.pop());
                        System.out.println("Kembali ke: " + history.peek().info());
                    } else {
                        System.out.println("Tidak ada halaman sebelumnya.");
                    }
                    tampilkan(history, historyForward);
                    break;

                case 3:
                    if (!historyForward.isEmpty()) {
                        history.push(historyForward.pop());
                        System.out.println("Maju ke: " + history.peek().info());
                    } else {
                        System.out.println("Tidak ada halaman setelahnya.");
                    }
                    tampilkan(history, historyForward);
                    break;

                case 4:
                    tampilkan(history, historyForward);
                    break;

                case 0:
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println("Menu tidak valid.");
            }
        } while (pilihan != 0);
    }
}
