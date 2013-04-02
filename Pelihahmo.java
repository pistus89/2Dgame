
import javax.swing.ImageIcon;


public class Pelihahmo {

    private int x;
    private int y;
    private int halkaisija;
    private int nopeus;
    private int liikeY;
    private boolean jumissa;
    private int poistumisSuunta;
    private int pisteet;
    private int xmove;
    private int ymove;
    private boolean vasen;
    private boolean oikea;
    private boolean paikallaan;
    private boolean ilmassa;
    private ImageIcon oletusAnimaatio;

    public Pelihahmo(int x, int y, int halkaisija) {
        this.x = x;
        this.y = y;
        this.halkaisija = halkaisija;
        this.nopeus = 0;
        this.liikeY = 0;
        this.jumissa = false;
        this.poistumisSuunta = 0; //jos nolla, siirryttävä hahmolla vasemmalle, jos yksi, siirryttävä oikealle
        this.pisteet = 0;
        this.xmove = 0;
        this.ymove = 0;
        this.paikallaan = true;
        this.oikea = false;
        this.vasen = false;
        this.ilmassa = true;
        this.oletusAnimaatio = new ImageIcon("standanimation.gif");
    }
    public ImageIcon getKuva() {
        return this.oletusAnimaatio;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHalkaisija() {
        return halkaisija;
    }

    public boolean getJumissa() {
        return this.jumissa;
    }

    public void setJumissa(Boolean arvo) {
        this.jumissa = arvo;
    }

    public String getSuunta() {
        if (this.poistumisSuunta == 0) {
            return "vasen";
        } else {
            return "oikea";
        }
    }

    public void setSuunta(String suunta) {
        if (suunta.equals("vasen")) {
            this.poistumisSuunta = 0;
        } else if (suunta.equals("oikea")) {
            this.poistumisSuunta = 1;
        }
    }
    public void setVasen() {
        this.vasen = true;
        this.paikallaan = false;
        this.oikea = false;
    }
    public void setOikea() {
        this.oikea = true;
        this.paikallaan = false;
        this.vasen = false;
    }
    public void setPaikallaan() {
        this.paikallaan = true;
        this.oikea = false;
        this.vasen = false;
    }
    public void setIlmassa(Boolean arvo) {
        this.ilmassa = arvo;
    }

    public void liiku(int painovoima) {
        this.y = this.y - this.liikeY;
        this.liikeY = this.liikeY - painovoima;

        if (this.liikeY < -8) {
            this.liikeY = -8;
        }
    }

    public void nappaaEsine(Esine esine) {

        if (this.x >= esine.getX() && this.y <= esine.getY() + esine.getKorkeus()
                && this.x <= esine.getX() + esine.getLeveys() && esine.getElossa()) {

            this.pisteet = this.pisteet + esine.getPisteet();
            esine.setElossa(false);
        }
    }

    public void yritaKayttaaAlustaa(Alusta alusta) {
        
        
        
        
        
        
        if (this.x < alusta.getX()) { // pelihahmo alustan vasemmalla puolella
            this.jumissa = false;
            return;
        }

        if (this.x > alusta.getX() + alusta.getLeveys()) { //hahmo alustan oikealla puolella
            this.jumissa = false;
            return;
        }

        if (this.y + this.halkaisija < alusta.getY()) { //hahmo alustan päällä
            this.jumissa = false;
            return;
        }

        if (this.y > alusta.getY() + alusta.getKorkeus()) { //hahmo alustan alla
            this.jumissa = false;
            return;
        }
        
        
        
        
        if (this.oikea && this.x - this.halkaisija >= alusta.getX() - this.halkaisija  && 
                this.x < alusta.getX() + (alusta.getLeveys()/2) && this.y >= alusta.getY() && this.y <= alusta.getY() + alusta.getKorkeus()) {
            this.x = alusta.getX() - this.halkaisija - 2;
            this.nopeus = 0;
            this.jumissa = true;
            setSuunta("vasen");
            
        }
        if (this.vasen && !this.ilmassa && this.x + this.halkaisija <= alusta.getX() + this.halkaisija + alusta.getLeveys() && 
                this.x > alusta.getX() + (alusta.getLeveys()/2) && this.y + 1 > alusta.getY() && 
                this.y - 1< alusta.getY() + alusta.getKorkeus()) {
            this.x = alusta.getX() + alusta.getLeveys() + this.halkaisija + 2;
            this.nopeus = 0;
            this.jumissa = true;
            setSuunta("oikea");
        }
        
        if (this.paikallaan && this.y <= alusta.getY() + alusta.getKorkeus() + this.halkaisija && this.y > alusta.getY() + (alusta.getKorkeus()/2)
                && this.x > alusta.getX() && this.x < alusta.getX() + alusta.getLeveys()) {
            this.y = alusta.getY() + alusta.getKorkeus() + this.halkaisija;
            this.liikeY = -2;
        }
        
        if (this.x > alusta.getX() && this.x < alusta.getX() + alusta.getLeveys() && this.y < alusta.getY() +(alusta.getKorkeus()/2) &&
                this.y >= alusta.getY() - this.halkaisija) {
            
            this.y = alusta.getY() - this.halkaisija;
            this.liikeY = 0;
            this.ilmassa = false;
        }
        





//        if (this.x >= alusta.getX() || this.x <= (alusta.getX() + alusta.getLeveys()) || this.y >= (alusta.getY() - alusta.getKorkeus()) || this.y <= alusta.getY()) { //jos pelihahmo osuu alustan reunaan
//            this.nopeus = 0;
//            int puolivali = alusta.getLeveys() / 2;
//
//
//            if (this.x >= puolivali + alusta.getX()) { //tarkistetaan, kummalla puolella pelihahmo törmää alustaan
//                this.x = alusta.getX() + (puolivali * 2) + 1;
//                setJumissa(true);
//                setSuunta("oikea");
//            } else {
//                this.x = alusta.getX() - 1;
//                setJumissa(true);
//                setSuunta("vasen");
//            }
//             
//
//                if (this.x > alusta.getX() && this.x < alusta.getX() + alusta.getLeveys()) {
//                    if (this.y == alusta.getY() - alusta.getKorkeus()) {
//                        this.y = alusta.getY() - alusta.getKorkeus() + 32;
//                        this.liikeY = -4;
//                    }
//                }
//        
//            
//            
//        }
//        //if (this.x )
//
//        if (this.x > alusta.getX() && this.x < alusta.getX() + alusta.getLeveys()) { //jos hahmo on alustan sisällä, asetetaan hahmo alustan päälle
//            this.y = alusta.getY() - this.halkaisija;
//            this.liikeY = 0;
//        }
}

    public void hyppaa() {
        if (liikeY != 0) {
            return;
        }

        liikeY = 18;
    }

    public void etene() {
        this.x = this.x + this.nopeus;


    }

    public void vauhti(int nopeus) {
        this.nopeus = this.nopeus + nopeus;
    }

    public void pysahdy() {
        this.nopeus = 0;
    }

    public int getLiikeY() {
        return liikeY;
    }

    public int getPisteet() {
        return this.pisteet;
    }
}
