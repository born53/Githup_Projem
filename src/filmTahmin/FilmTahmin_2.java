package filmTahmin;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class FilmTahmin_2 {





        /*
   TASK :
    yukarıdaki film listinde bulunan filmlerden herhangi birisini kullanıcının filim ismini  görmeden
    filmin index nosuna göre sectiriniz
    seçilen filmin  ismini filmin harf saysının 2 katı kadar hak tanıyarak tahmin etmesini
    sağlayan method create ediniz...
    Ahanda TRICK...
    kullanıcının sectiği filmin harf sayısını  console yazdırınız.
    kullanıcının sectiği film için tahmin hakkını  console yazdırınız.
    kullanıcının her tahmininde kalan hak sayısını console yazdırınız.
    kullanıcının her tahmininde doğru ve yanlış tahmin  sayısını console yazdırınız.
    kullanıcının kaybedip veya kazandığını ve tahmin etmesi gereken filmin ismini  console yazdırınız.
  ​
   */

        static Map<Integer, String> filmMap = new HashMap<>();
        static Scanner scan = new Scanner(System.in);

        public static void main(String[] args) {

            System.out.println("~~~FILM TAHMIN OYUNUNA HOSGELDINIZ~~~");
            int secim;
            int dogrutahminsayisi = 0;
            int yanlistahminsayisi = 0;

            filmMap.put(1, "JOKER");
            filmMap.put(2, "INCEPTION");
            filmMap.put(3, "GREENMILE");
            filmMap.put(4, "LEON");
            filmMap.put(5, "GODFATHER");
            filmMap.put(6, "JURASSICPARK");
            filmMap.put(7, "TITANIC");
            filmMap.put(8, "GLADIATOR");

            do {
                System.out.println("Bitirmek için 0'a basınız.");
                System.out.print("1-" + filmMap.size() + " arasinda bir sayi giriniz \n\nSecim : ");

                while (true) {
                    try {
                        secim = scan.nextInt();
                        if (secim < 0 || secim > filmMap.size()) { // -1 ve daha küçük, 9 ve üzeri için
                            throw new ArithmeticException();
                        } else
                            break;
                    } catch (ArithmeticException e) {
                        System.out.println("1 ile " + filmMap.size() + " arasında girmelisin.");
                    } catch (InputMismatchException e) {
                        String str = scan.next();
                        System.out.println("Hatalı giris yaptiniz. Tekrar deneyin.");
                    }
                }

                String tahminedilecekfilm = filmMap.get(secim);
                String[] tahminedilecekfilmArray = tahminedilecekfilm.split("");
                StringBuilder stringBuilder = new StringBuilder(tahminedilecekfilm.replaceAll("\\w", "_"));

                System.out.println("Tahmin hakkı: " + tahminedilecekfilm.length()*2);
                int kalahhak = tahminedilecekfilm.length()*2;// 5*2

                int sayac = 0;
                String dogrutahminharfler = "";
                boolean kazandımı = false;
                while (kalahhak > 0) { //sürece
                    sayac++;
                    System.out.println("Kalan hakkınız : " + kalahhak);
                    System.out.println(sayac + " . harf tahmini : ");
                    String tahminedilenharf = scan.next().toUpperCase();
                    if (tahminedilecekfilm.contains(tahminedilenharf)) {
                        for (int i = 0; i < tahminedilecekfilmArray.length; i++) {
                            if (tahminedilecekfilmArray[i].equals(tahminedilenharf)) {
                                stringBuilder.replace(i, i+1, tahminedilenharf);
                                dogrutahminsayisi++;
                                if (stringBuilder.toString().equals(tahminedilecekfilm)) {
                                    System.out.println("Kazandınız...");
                                    kazandımı = true;
                                    kalahhak = 0;
                                    break;
                                }
                            }
                        }
                        System.out.println(stringBuilder);
                    } else {
                        yanlistahminsayisi++;
                        System.out.println("Yanlıs tahmin");
                    }
                    kalahhak--;
                }
                if (!kazandımı) {
                    System.out.println("Maalesef kazanadınız...");
                }
            } while (secim !=0); // programı bitirmeyi kontrol ediyor.
        }
    }

