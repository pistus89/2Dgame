
public class Pelimoottori extends Thread {

    private Kayttoliittyma kayttoliittyma;
    private Maailma maailma;
    private boolean kaynnissa;

    public Pelimoottori(Kayttoliittyma kayttoliittyma, Maailma maailma) {
        this.kayttoliittyma = kayttoliittyma;
        this.maailma = maailma;

        this.kaynnissa = true;
    }

    @Override
    public void run() {
        //maailma.nopeuta();
        //maailma.nopeuta();

        while (kaynnissa) {
            paivita();
            piirra();

            odota();
        }
    }

    public void paivita() {
        maailma.liikuta();
        maailma.getPelihahmo().etene();
        
        
    }

    public void piirra() {
        kayttoliittyma.piirra();
    }
    
    // metodikutsu sammuta sulkee pelimoottorin seuraavan odota-kutsun jälkeen
    public void sammuta() {
        kaynnissa = false;
    }

    // metodikutsu odota pyytää ohjelmaa odottamaan yhden kuudeskymmenesosasekunnin 
    // ajan, eli ajan, joka on 1000 millisekuntia jaettuna kuudellakymmenellä
    
    // käytännössä tämä johtaa animaatioon, jossa pelimoottori kutsuu paivita-
    // ja piirra-metodeita noin 60 kertaa sekunnissa
    public void odota() {
        try {
            Thread.sleep(1000 / 60);
        } catch (InterruptedException e) {
            System.exit(0);
        }
    }
}
