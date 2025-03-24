package szamalk.hu.modell;

import java.text.Collator;
import java.util.Comparator;

public class Tantargy implements Comparable<Tantargy> {
    private String tanar, nev, csak_vizsga;
    private int kredit, felev;


    public Tantargy(String tanar, String nev, String csak_vizsga, int kredit, int felev) {
        this.tanar = tanar;
        this.nev = nev;
        this.csak_vizsga = csak_vizsga;
        this.kredit = kredit;
        this.felev = felev;
    }

    public String getTanar() {
        return tanar;
    }

    public String getTargy_nev() {
        return nev;
    }

    public String getCsak_vizsga() {
        return csak_vizsga;
    }

    public int getKredit() {
        return kredit;
    }

    public int getFelev() {
        return felev;
    }

    public void setCsak_vizsga(String csak_vizsga) {
        this.csak_vizsga = csak_vizsga;
    }

    public void setKredit(int kredit) {
        this.kredit = kredit;
    }

    @Override
    public String toString() {
        return "Tantargy{" +
                "tanar='" + tanar + '\'' +
                ", targy_nev='" + nev + '\'' +
                ", csak_vizsga='" + csak_vizsga + '\'' +
                ", kredit=" + kredit +
                ", felev=" + felev +
                '}';
    }

    public String getNev() {
        return nev;
    }

    @Override
    public int compareTo(Tantargy masik){
        Collator coll = Collator.getInstance();
        return coll.compare(this.nev, masik.nev);
    }

    public static nevComporator rendezNev(){
        return new nevComporator();
    }

    private static class nevComporator implements Comparator<Tantargy> {
        @Override
        public int compare(Tantargy egyik, Tantargy masik) {
            Collator coll = Collator.getInstance();
            return coll.compare(egyik.nev, masik.nev);
        }
    }

}
