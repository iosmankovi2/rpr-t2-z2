package ba.unsa.etf.rpr.tutorijal02;

public class Interval {

    double pocetna = 0, krajnja = 0;
    boolean daLiPocetnaPripadaIntervalu = false;
    boolean daLiKrajnjaPripadaIntervalu = false;
    public Interval(double pocetna_tacka, double krajnja_tacka, boolean pripadapocetna, boolean pripadakrajnja)
    {
        if(pocetna_tacka < krajnja_tacka) throw new  IllegalArgumentException("Greska");
        pocetna = pocetna_tacka;
        krajnja = krajnja_tacka;
        daLiPocetnaPripadaIntervalu = pripadapocetna;
        daLiKrajnjaPripadaIntervalu = pripadakrajnja;
    }

    public Interval() {}




}
