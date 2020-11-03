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

    public boolean isIn(double v)
    {
        if(v < pocetna || v > krajnja) return  false;
        else if(v == pocetna) return  daLiPocetnaPripadaIntervalu;
        else if(v == krajnja) return daLiKrajnjaPripadaIntervalu;
        else return false;
    }
        public  boolean isNull()
        {
            return (pocetna == 0 && krajnja == 0 && daLiPocetnaPripadaIntervalu == false && daLiKrajnjaPripadaIntervalu == false);
        }
    public Interval intersect(Interval interval)
    {
        Interval presjek = new Interval();
        if(interval.getPocetnaTacka() >= pocetna) {

            presjek.pocetna = interval.getPocetnaTacka();
            presjek.daLiPocetnaPripadaIntervalu = interval.getdaLiPocetnaTackaPripadaIntervalu();
        }
            else
            {
            presjek.krajnja = pocetna;
            presjek.daLiPocetnaPripadaIntervalu = daLiPocetnaPripadaIntervalu;

        }
            if(interval.getKrajnjaTacka() <= krajnja)
            {
                presjek.krajnja = interval.getKrajnjaTacka();
                presjek.daLiKrajnjaPripadaIntervalu = interval.daLiKrajnjaPripadaIntervalu;
            }

            else
            {
                presjek.krajnja = krajnja;
                presjek.daLiKrajnjaPripadaIntervalu = daLiKrajnjaPripadaIntervalu;
            }
            return  presjek;
    }

    private double getKrajnjaTacka() {
        return  krajnja;
    }

    private boolean getdaLiPocetnaTackaPripadaIntervalu() {
        return  daLiPocetnaPripadaIntervalu;
    }

    private double getPocetnaTacka() {
        return  pocetna;
    }

    public static Interval intersect(Interval interval1, Interval interval2)
    {
        Interval presjek = new Interval();
        if(interval1.getPocetnaTacka() <= interval2.getPocetnaTacka())
        {
            presjek.pocetna = interval1.getPocetnaTacka();
            presjek.daLiPocetnaPripadaIntervalu = interval1.getdaLiPocetnaTackaPripadaIntervalu();
        }

        else
        {
            presjek.krajnja = interval2.getPocetnaTacka();
            presjek.daLiPocetnaPripadaIntervalu = interval2.getdaLiPocetnaTackaPripadaIntervalu();
        }

        if(interval1.getKrajnjaTacka() <= interval2.getKrajnjaTacka())
        {
            presjek.krajnja = interval1.getKrajnjaTacka();
            presjek.daLiKrajnjaPripadaIntervalu = interval1.daLiKrajnjaPripadaIntervalu;
        }

        else
        {
            presjek.krajnja = interval2.getKrajnjaTacka();
            presjek.daLiKrajnjaPripadaIntervalu = interval2.getDaLiKrajnjaTackaPripadaIntervalu();
        }
        return  presjek;
    }

    private boolean getDaLiKrajnjaTackaPripadaIntervalu() {
        return  daLiKrajnjaPripadaIntervalu;
    }

    @Override

    public String toString()
    {
        String s = null;
        if(this.isNull()) return  "()";
        if(this.daLiPocetnaPripadaIntervalu == true) s = "[";
        else s = s + "(";
        s = s + new Double(this.pocetna).toString() + "," + new Double(this.krajnja).toString();
        if(this.daLiKrajnjaPripadaIntervalu == true) s = s + "]";
        else s = s + ")";
        return  s;
    }

};
