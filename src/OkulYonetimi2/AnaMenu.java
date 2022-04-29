package OkulYonetimi2;


import java.util.Scanner;

//implements yapilirve
public class AnaMenu implements AnaMenuInterface {

    static Scanner scan = new Scanner(System.in);//static yapilarak giris metodundan kullanicidan girdi alacagiz

    public static void giris() {
    AnaMenu object = new AnaMenu();
        System.out.println("Okul yonetimi");
        System.out.println("lutfen seciminizi yapiniz");
        System.out.println("1-Ogrenci Islemleri 2-Ogretmen Islemleri Q- Cikis");
      String scm = scan.next().toUpperCase();//nextline kullansaydik dammy alinirdi kullanmadigim icin almadim
                                //Kullanici Q yerine kucuk q yazabilir bununicin UpperCase kullaniyoruz

        //secim yaptiracagiz bunun icin switch yapacagiz

        switch(scm){
            case "1":                       //sayiyi string olarak aldgim icin tirnak icinde yazdim.intiger alsaydim tirnagi kullanmiyacaktik
                object.ogrenciIslemleri();  //override ettigimiz ogrenciIslemlerine gecemiyor.altini kirmizi cizdi.
           break;
            case "2":                                // cunku public static void giris() statik metoddayiz statik olmayan public void ogrenciIslemleri() metoda gecmeye
                object.ogretmenIslemleri();         //calistigimiz icin izin vermiyor bunun icin override static edip interface leride statik etmek gerekir.
                break;
            case "Q":                            // bunun yerine ayni metod adinda  AnaMenu object = new AnaMenu();obje olusturusak statik metoddan statik olmayan object.ogrenciIslemleri(); metoda gecebiliriz
                object.cikis();
                break;
            default:
                System.out.println("lutfen gecerli bir secim yapiniz");
                giris();//bizi tekrar girise dondursun
        }

    }

    @Override
    public void ogrenciIslemleri() {

        Islemler.IslemlerMenu(1);//1 referanstir 1 yerine baska seylerde yazilabilir.ogrenciislemleri oldugunu belirtir.

    }

    @Override
    public void ogretmenIslemleri() {
        Islemler.IslemlerMenu(2);
    }

    @Override
    public void cikis() {

    }
}

