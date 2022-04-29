package OkulYonetimi2;

import java.util.HashMap;
import java.util.Map;

public class Ogrenci extends Kisi {
   // Öğrenci: Ad-Soyad,  kimlik No, yaş, bunlar ortakti
    // numara, sınıf bilgileri içermelidir.bunlari olusturacagiz

    static Map<String, Ogrenci> ogrenciListesiMap = new HashMap<String, Ogrenci>();
//kimlik id string olarak alacagimdan key'i string aldim.Volue kisminada obje yazacagim ogrenci clasinda olusturdugum bir obje


    private String numara ="";
    private String sinif ="";

    public Ogrenci() {

    }

    public Ogrenci(String numara, String sinif) {
        this.numara = numara;
        this.sinif = sinif;
    }

    public Ogrenci(String adSoyad, String yas, String numara, String sinif) {
        super(adSoyad, yas);
        this.numara = numara;
        this.sinif = sinif;
    }

    public String getNumara() {
        return numara;
    }

    public void setNumara(String numara) {
        this.numara = numara;
    }

    public String getSinif() {
        return sinif;
    }

    public void setSinif(String sinif) {
        this.sinif = sinif;
    }

    @Override
    public String toString() {
        return "Ogrenci{" +
                "numara='" + numara + '\'' +
                ", sinif='" + sinif + '\'' +
                "} " + super.toString();
    }
}

