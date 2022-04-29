package OkulYonetimi2;


import java.util.Scanner;



public class TryCatches {


    public static int IntegerGiris() {
        Scanner scan = new Scanner(System.in);
        int giris = 0;
        boolean flag = false;
        do {
            System.out.println("lutfen Giris Yapiniz");
            if (flag == true) {
               scan.nextLine();
               flag = false;
            }
            //ctrl+alt+t
            try {
                giris = scan.nextInt();  //dammy - hatali giris olursa islem sout gider.
                // integerGiris(); gider surekli doner.dammy calismasina engel oluyor.hata verdigi zaman dummy calismasini saglayan flag(bayrak) yapmak gerekir
            } catch (Exception e) {
                System.out.println("Hatali giris yaptiniz");
                 flag = true;
                IntegerGiris();
            }
            scan.nextLine();
        } while (flag);

        return giris;
    }
}