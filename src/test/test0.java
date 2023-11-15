package test;

import java.util.Scanner;

public class test0 {

    public static void main(String[] args) {

            int[][] arTests = new int[4][76];
            while (true){

                System.out.println("test: 1->new Box 2->delete box 3->edit box 4->all chests 5-> stop");
                int x = new Scanner(System.in).nextInt();

                if (x == 1) {
                    System.out.println("name: ");
                    int name = new Scanner(System.in).nextInt();
                    System.out.println("Breite: ");
                    int Breite = new Scanner(System.in).nextInt();
                    System.out.println("Länge: ");
                    int Länge = new Scanner(System.in).nextInt();
                    System.out.println("Höhe: ");
                    int Höhe = new Scanner(System.in).nextInt();

                    newChest(arTests, name, Breite, Länge, Höhe);
                }
                if (x == 2){
                    System.out.println("Box-nummer: ");
                    int name = new Scanner(System.in).nextInt();
                    deleteChest(arTests, name);
                }
                if (x == 3) {
                    System.out.println("Box-nummer: ");
                    int name = new Scanner(System.in).nextInt();
                    editChest(arTests, name);
                }
                if (x == 4) {
                    System.out.println("alle kisten: ");
                    allChests(arTests);
                }
                if (x == 5){
                    break;
                }
            }
    }

    private static void newChest(int[][] arr, int newBox, int breite, int length, int height){
            if (exitsBox(newBox, arr)){
                System.out.println("exestiert: kiste: " + "Nummer " + arr[0][newBox] + " Breite " + arr[1][newBox] + " Länge " + arr[2][newBox] + " Höhe " + arr[3][newBox]);
            }
            else {
                System.out.println("exestiert noch nicht! wird erstellt!");
                createChest(arr, newBox, breite,length,height);
            }
        }

        private static void createChest(int[][] arr, int newBoxNumber, int newBreite, int newLength, int newHeight){
            arr[0][newBoxNumber] = newBoxNumber;
            arr[1][newBoxNumber] = newBreite;
            arr[2][newBoxNumber] = newLength;
            arr[3][newBoxNumber] = newHeight;
            System.out.println("Deine neue Kiste: " + "Nummer " + newBoxNumber + " Breite " + newBreite + " Länge " + newLength +  " Höhe " + newHeight);
        }



        private static Boolean exitsBox(int newBoxNumber, int[][] arr){
        try {
            for (int j = 0; j < 75; j++) {
                if (arr[0][j] == newBoxNumber){
                    return true;
                }
            }
        }catch (ArrayIndexOutOfBoundsException ignored){}
            return false;
        }


        private static void deleteChest(int[][] arr, int boxNumber){
            arr[0][boxNumber] = 0;
            arr[1][boxNumber] = 0;
            arr[2][boxNumber] = 0;
            arr[3][boxNumber] = 0;
        }


        @SuppressWarnings("all")
        private static void editChest(int[][] arr, int boxNumber){
            System.out.println("Breite: ");
            int Breite = new Scanner(System.in).nextInt();
            System.out.println("Länge: ");
            int Länge = new Scanner(System.in).nextInt();
            System.out.println("Höhe: ");
            int Höhe = new Scanner(System.in).nextInt();

                arr[1][boxNumber] = Breite;
                arr[2][boxNumber] = Länge;
                arr[3][boxNumber] = Höhe;
        }

        private static void allChests(int[][] arr){
        for (int x = 0; x < arr.length; x++){
            if (arr[0][x] == 0){}
            else {
                System.out.println("kiste: " + arr[0][x] + " Breite: " + arr[1][x] + " Länge: " + arr[2][x] + " Höhe: " + arr[3][x]);
            }
            }
        }




}