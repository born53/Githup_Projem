package OkulYonetimi2;


import java.util.Scanner;

public class Islemler implements IslemlerInterface{
static Scanner scan = new Scanner(System.in);
static int secim =0;

    public static void IslemlerMenu(int i){//herkezin gormesi icin static ay yerlestiriyoruz
    secim =i;//bu bilgi statik oldu.herkez bunu kullanabilecek
        Islemler obj = new Islemler();
        System.out.println("lutfen secim yapiniz");
        System.out.println("1-ekleme 2-arama 3-listeleme 4-silme 5-anamenu 6-cıkış");

       /* int scm = scan.nextInt(); //try catch
        scan.nextLine();*/

        int scm = TryCatches.IntegerGiris();//try catch metod yapiyoruz.dummy icerisinde olacak

        switch(scm){
            case 1:
                obj.ekleme();//kirmizilik gitmesi icin override static olmadigi icin obje ile ulasiyoruz
               IslemlerMenu(secim);
                break;
            case 2:
                obj.arama();
                IslemlerMenu(secim);
                break;
            case 3:
                obj.listeleme();
                IslemlerMenu(secim);
                break;
            case 4:
                obj.silme();
                IslemlerMenu(secim);
                break;
            case 5:
                obj.anaMenu();

                break;
            case 6:
                obj.cikis();
                IslemlerMenu(secim);
                break;
            default :
                System.out.println("lütfen geçerli bir giriş yapınız");
                IslemlerMenu(secim);
        }










    }


    @Override
    public void ekleme() {//eklemeler yapmak icin once poje claslari olusturup map olusturacagiz.poje claslar ogretmen ogrenci kisi ,kisi parent olacak child ve perent iliskisi kuracagiz
        System.out.println("Kimlik numarasi giriniz");
        String kimlikID =scan.nextLine();
        kimlikIDKontrol(kimlikID); //method
        if(secim==1){
            ogrenciBilgiAlKaydet(kimlikID);

        }else ogretmenBilgiAlKaydet(kimlikID);

    }

    private void ogretmenBilgiAlKaydet(String kimlikID) {
        System.out.println("AdSoyad yas numara bolum sicil Giriniz");
        scan.nextLine();
        String adSoyad = scan.nextLine();
        String yas = scan.next();
        String bolum = scan.next();
        String sicil = scan.next();
        Ogretmen obj =new Ogretmen(adSoyad,yas,bolum,sicil);//ogretmen clasinda obje olusturup Map kaydetmemiz gerekiyor.kimlik nosu ile beraber
        Ogretmen.ogretmenListesiMap.put(kimlikID,obj);


    }

    private void ogrenciBilgiAlKaydet(String kimlikID) {
        System.out.println("AdSoyad yas numara sinif Giriniz");
        String adSoyad = scan.nextLine();
        String yas = scan.next();
        String numara = scan.next();
        String sinif = scan.next();
        Ogrenci obj =new Ogrenci(adSoyad,yas,numara,sinif);//ogrenci clasinda obje olusturup Map kaydetmemiz gerekiyor.kimlik nosu ile beraber
        Ogrenci.ogrenciListesiMap.put(kimlikID,obj);
    }

    private void kimlikIDKontrol(String kimlikID) {//olusturdugumuz iki ogrenci ve ogretmen clasinda olusturdugumuz map de kimlik Id varmi diye bakacagiz
   if(Ogrenci.ogrenciListesiMap.containsKey(kimlikID) || Ogretmen.ogretmenListesiMap.containsKey(kimlikID) );
        System.out.println("Bu ID kayit yapilmis");
        AnaMenu.giris();
    }

    @Override
    public void arama() {
        System.out.println("kimlik numarasi giriniz");
        String kimlikID = scan.next();
        if (secim == 1) {
            if (Ogrenci.ogrenciListesiMap.containsKey(kimlikID)) {
                System.out.println(Ogrenci.ogrenciListesiMap.get(kimlikID));
            }else System.out.println("Kayitli Degil");
        } else if (secim == 2){
            if (Ogretmen.ogretmenListesiMap.containsKey(kimlikID)) {
                System.out.println(Ogretmen.ogretmenListesiMap.get(kimlikID));
            }else System.out.println("Kayitli Degil");
        }

    }



    @Override
    public void listeleme() {
if(secim == 1){
    System.out.println(Ogrenci.ogrenciListesiMap);
}else if (secim==2){
    System.out.println(Ogretmen.ogretmenListesiMap);
}


    }

    @Override
    public void silme() {
        System.out.println("kimlik numarasi giriniz");
        String kimlikID = scan.next();
        if (secim==1){
            if (Ogrenci.ogrenciListesiMap.containsKey(kimlikID)){
                Ogrenci.ogrenciListesiMap.remove(kimlikID);
            }else System.out.println("KimlikID mevcut Degil");
        }else if(secim==2){
            if(Ogretmen.ogretmenListesiMap.containsKey(kimlikID)){
                Ogretmen.ogretmenListesiMap.remove(kimlikID);
            }else System.out.println("KimlikID mevcut Degil");
        }


        if(Ogrenci.ogrenciListesiMap.containsKey(kimlikID) || Ogretmen.ogretmenListesiMap.containsKey(kimlikID) );
        System.out.println("Bu ID kayit yapilmis");
        AnaMenu.giris();
    }

    @Override
    public void anaMenu() {
AnaMenu.giris();
    }

    @Override
    public void cikis() {
        System.out.println("Bay bay Gorusuruz");
    }
}
