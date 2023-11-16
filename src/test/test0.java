package test;

import java.util.Scanner;

public class test0 {

    public static void main(String[] args) {

            //hier wir eine 2d array erstellt das 4 rows und 75 columns
            int[][] kistenArray = new int[4][76];
            //hier wird eine while true schleife erstellt da wir ja mehrere kisten erstellen wollen und deswegen ist es eine unendliche schleife
            while (true){
                //hier ist ein lehrer integer der kistenNummer heißt
                int kistenNummer;

                //Hier haben wir ein kleines menu, dort wird angezeigt was man in die konsole eingeben muss um z.B. eine neue kiste erstellen
                System.out.println("test: 1->new Box 2->delete box 3->edit box 4->all chests 5-> stop");
                //Hier fängt man dann den input ab und speichert es in einen integer
                int x = new Scanner(System.in).nextInt();

                //hier wird dann x durchgereicht
                switch (x){

                    //hier wird dann nachdem man 1 eingegeben hat noch mehrere inputs abgefragt und danach in eine methode übergeben
                    //das array wird natürlich auch übergeben
                    case 1:
                        System.out.println("kistenNummer: ");
                        kistenNummer = new Scanner(System.in).nextInt();
                        System.out.println("Breite: ");
                        int Breite = new Scanner(System.in).nextInt();
                        System.out.println("Länge: ");
                        int Laenge = new Scanner(System.in).nextInt();
                        System.out.println("Höhe: ");
                        int Hoehe = new Scanner(System.in).nextInt();
                        neueKiste(kistenArray, kistenNummer, Breite, Laenge, Hoehe);
                        break;
                    //wenn man 2 eigegeben hätte wird nur ein input abgefragt und das ist die kistennummer da man mit der alles steuern kann
                    //die wird danach auch wieder in eine methode übergeben und natürlich auch das array wird übergeben
                    case 2:
                        System.out.println("KistenNummer: ");
                        kistenNummer = new Scanner(System.in).nextInt();
                        kisteLoeschen(kistenArray, kistenNummer);
                        break;
                    //wenn man 3 eingegeben hätte würde dort genau das gleiche passieren wie bei 2 da wir hier eine kiste editieren wollen
                    //und weil wir ja über die kistennummer alles editieren wollen würde das über die gehen. in der methode kisteEditieren werdeb
                    //noch das array übergeben und die kistennummer
                    case 3:
                        System.out.println("KistenNummer: ");
                        kistenNummer = new Scanner(System.in).nextInt();
                        kisteEditieren(kistenArray, kistenNummer);
                    //hier wird hauptsächlich nur eine methode aufgerufen die alle sachen im array ausgibt
                    case 4:
                        System.out.println("Alle Kisten: ");
                        alleKisten(kistenArray);
                        break;
                    //hier wird das programm geschlossen
                    case 5:
                        System.exit(1);
                }
            }
    }

    //in dieser methode werden die parameter arr, kistennummer, breite, laenge und hoehe verwendet
    private static void neueKiste(int[][] arr, int kistenNummer, int breite, int laenge, int hoehe){
        //da wir schauen wollen ob eine kiste schon exestiert wird hier eine if abfrage erstellt die abfragt ob die methode true rückgibt
        //in der methode wird die kistennummer und das array übergeben
        if (exestiertKiste(kistenNummer, arr)){
            //wenn es dann true ist also wenn die kiste schon exestiert wird ausgegeben das diese kiste schon exestiert
                System.out.println("exestiert: kiste: " + "Nummer " + arr[0][kistenNummer] + " Breite " + arr[1][kistenNummer] + " Länge " + arr[2][kistenNummer] + " Höhe " + arr[3][kistenNummer]);
            }
            else {
                //wenn die kiste noch nicht exestiert wird eine neue methode verwendet mit der dann die kisten erstellt wird
                //dort werden die parameter arr, kistennummer, breite, laenge, hoehe verwendet
                System.out.println("exestiert noch nicht! wird erstellt!");
                kisteErstellen(arr, kistenNummer, breite, laenge, hoehe);
            }
        }
        //in dieser methode wird endgültig die kiste erstellt
        private static void kisteErstellen(int[][] arr, int kistenNummer, int breite, int laenge, int hoehe){

        //da wir alles über die kistennummern steuern wird alles dort drinne gespeichert also ein beispiel dafür wäre
        // arr[1][2] = 10 hier würde in der row 2 column 2 eine datei reingeschrieben und das wäre die höhe 10
            arr[0][kistenNummer] = kistenNummer;
            arr[1][kistenNummer] = breite;
            arr[2][kistenNummer] = laenge;
            arr[3][kistenNummer] = hoehe;
            // hier wird dann noch die kiste ausgegeben
            System.out.println("Deine neue Kiste: " + "Nummer " + kistenNummer + " Breite " + breite + " Länge " + laenge +  " Höhe " + hoehe);
        }
        //Hier wird die abfrage getätigt ob eine kiste schon exestiert oder nicht dafür brauchen wir als paramete die kistennummer und das array
        private static Boolean exestiertKiste(int kistenNummer, int[][] arr){
        //da es einen fehler geben würde wenn man ein array getten will das noch 0 ist wird hier dieser fehler mit einem try catch statemeant abgefangen
        try {
            //hier wird jede kiste von der 1 bis zur 75 kiste geschaut ob sie mit der neuen kistennummer übereinstimmen, wenn sie übereinstimmen wird true zurückgegeben
            for (int j = 0; j < 75; j++) {
                if (arr[0][j] == kistenNummer){
                    return true;
                }
            }
        }catch (ArrayIndexOutOfBoundsException ignored){}
        //wenn sie noch nicht erstellt wurde oder noch keine exestiert wird hier false zurückgegeben
            return false;
        }

        //hier werden kisten gelöscht da wir wieder die parameter kistennummer und das array brauchen werden die hier wieder angefragt
        private static void kisteLoeschen(int[][] arr, int kistenNummer){
            //da man nicht richtig sachen löschen kann setzten wie alles auf null
            //das mit der kistennumer agecachelt ist
            arr[0][kistenNummer] = 0;
            arr[1][kistenNummer] = 0;
            arr[2][kistenNummer] = 0;
            arr[3][kistenNummer] = 0;
        }

        //in der methode kann man kisten editieren
        private static void kisteEditieren(int[][] arr, int kistenNummer){
        //hier wurden wieder inputs erstellt mit den neuen values die wo man haben will
            System.out.println("Breite: ");
            int Breite = new Scanner(System.in).nextInt();
            System.out.println("Länge: ");
            int Laenge = new Scanner(System.in).nextInt();
            System.out.println("Höhe: ");
            int Hoehe = new Scanner(System.in).nextInt();

            // die werden dann hier sozusagen über die anderen überschrieben
                arr[1][kistenNummer] = Breite;
                arr[2][kistenNummer] = Laenge;
                arr[3][kistenNummer] = Hoehe;
        }

        // hier werden dann alle kisten angezeigt da wir ja alle kisten anzeigen wollen müssen wir nur das array übergeben
        private static void alleKisten(int[][] arr){
        //hier wird eine for schleife erstellt die wo so oft durchläuft wie die länge von dem array ein beispiel wäre wenn das array die länge
        //10 hätte würde die schleife 10 mal durchlaufen
        for (int x = 0; x < arr.length; x++){
            //hier wird dann geschaut ob sich was mit einer null reingekommen hat wenn ja wird das returnt
            if (arr[0][x] == 0){return;}
            //wenn nicht wird dann ein sysout erstellt das was alles ausgibt also die kistennummer, breite, länge und die höhe
            else {
                System.out.println("kiste: " + arr[0][x] + " Breite: " + arr[1][x] + " Länge: " + arr[2][x] + " Höhe: " + arr[3][x]);
            }
            }
        }
}