
import java.util.ArrayList;

public class Maailma {
    // lisää tänne muuttuja "kierros", jonka avulla voidaan pitää kirjaa
    // kierroksista
    private int kierros;
    
    private int painovoima;
    private int nopeus;
    private ArrayList<Alusta> alustat;
    private Pelihahmo pelihahmo;
    private ArrayList<Esine> esineet;
    
    public Maailma() {
        // alusta täällä muuttujan kierros arvoksi 0
        this.kierros = 0;
        
        this.painovoima = 1;
        this.nopeus = 0;
        
        
        this.alustat = new ArrayList<Alusta>();
        this.alustat.add(new Alusta(0, 700, 800, 30)); //pohja-alusta
        this.alustat.add(new Alusta(600,20,30,800)); // väliseinä
        this.alustat.add(new Alusta(0,600,500,30)); // toinen kerros
        this.alustat.add(new Alusta(60,530,520,30)); // ensimmäinen rappuaskelma
        this.alustat.add(new Alusta(90,500,490,30)); // toinen rappuaskelma
        this.alustat.add(new Alusta(120,470,460,30)); // kolmas rappuaskelma
        this.alustat.add(new Alusta(150,440,430,30)); // neljäs rappuaskelma
        this.alustat.add(new Alusta(180,410,400,30)); // viides rappuaskelmais
        this.alustat.add(new Alusta(210,380,370,30)); // kuudes rappuaskelma
        this.alustat.add(new Alusta(240,350,340,30));// seitsemäs rappuaskelma
        this.alustat.add(new Alusta(270,320,310,30)); // kahdeksas rappuaskelma
        this.alustat.add(new Alusta(30,260,200,30)); // ensimmäinen ylätasanne
        this.alustat.add(new Alusta(270,230,200,30));
        
        // voit lisätä toki omia alustoja halutessasi!

        this.pelihahmo = new Pelihahmo(350, 0, 20);
        
        this.esineet = new ArrayList<Esine>();
        this.esineet.add((new Esine(400,200)));
        this.esineet.add(new Esine(500, 200));
        this.esineet.add(new Esine(550,200));
        esineet.get(0).setTyyppi("tahti");
        esineet.get(1).setTyyppi("kolikko");
        esineet.get(2).setTyyppi("sieni");
    }

    public void nopeuta() {
        this.nopeus = nopeus + 1;
    }
    public void pysayta() {
        this.nopeus = 0;
    }

    public void liikuta() {
        for (Alusta alusta : alustat) {
            alusta.liiku(nopeus);
        }
        
        this.pelihahmo.liiku(painovoima);
        
        // asetetaan hahmo alustalle jos mahdollista
        for (Alusta alusta : alustat) {
            this.pelihahmo.yritaKayttaaAlustaa(alusta);
        }
        
        for (Esine esine : esineet) {
            esine.liiku(nopeus);
        }
        
        for (Esine esine : esineet) {
            this.pelihahmo.nappaaEsine(esine);
            
            
        }
        
        if (this.pelihahmo.getX() < 0) {
            for (Alusta alusta : this.alustat) {
                alusta.liiku((this.pelihahmo.getX())*-1);
            }
            
            this.pelihahmo.vauhti(this.pelihahmo.getX());
            this.pelihahmo.etene();
            
        }
        
        
        // siirretään alustoja uudestaan oikealle
       // for (Alusta alusta : alustat) {
        //    if(alusta.getX() + alusta.getLeveys() < 0) {
          //      alusta.setX(800);
           // }
       // }
        
        // nopeutetaan peliä 600 kierroksen välein (600 kierrosta on noin 
        // 10 sekuntia)
        //this.kierros = this.kierros + 1;
        //if(kierros % 300 == 0) {
          //  nopeuta();
       // }
    }
    
    public ArrayList<Alusta> getAlustat() {
        return alustat;
    }
    
    public ArrayList<Esine> getEsineet() {
        return esineet;
    }
    
    public Pelihahmo getPelihahmo() {
        return pelihahmo;
    }

    public int getNopeus() {
        return nopeus;
    }
    public void setNopeus(int nopeus) {
        this.nopeus = nopeus;
    }
}
