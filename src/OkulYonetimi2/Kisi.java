package OkulYonetimi2;

public class Kisi {
//Öğretmen: Ad-Soyad,  kimlik No, yaş, bölüm, ve sicil No bilgileri içermelidir.
//		Öğrenci: Ad-Soyad,  kimlik No, yaş, numara, sınıf bilgileri içermelidir.
//kiside ortak ozellikleri yazacagiz parent clas oldugu icin.ad soyad kisi no yas

    private String adSoyad ="";
    private String yas ="";
//poje clas olmasi icin 4 seye ihtiyac var.variables,constructor,getir seterlara to stringler lazim
    public Kisi() {

    }

    public Kisi(String adSoyad, String yas) {//constructor
        this.adSoyad = adSoyad;
        this.yas = yas;
    }

    public String getAdSoyad() {//geter
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {//seter
        this.adSoyad = adSoyad;
    }

    public String getYas() {
        return yas;
    }

    public void setYas(String yas) {
        this.yas = yas;
    }

    @Override
    public String toString() {
        return "Kisi{" +
                "adSoyad='" + adSoyad + '\'' +
                ", yas='" + yas + '\'' +
                '}';
    }
}
