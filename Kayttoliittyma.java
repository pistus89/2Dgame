

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Maailma maailma;
    private Ikkuna ikkuna;
    private Valikko valikko;

    public Kayttoliittyma(Maailma maailma) {
        this.maailma = maailma;
        this.valikko = new Valikko();
    }

    @Override
    public void run() {
        // asetetaan käyttöliittymän otsikko, esimerkiksi "tasoloikka"
        frame = new JFrame("tasoloikka");
        // asetetaan käyttöliittymän kooksi 600 x 400 pikseliä
        // (käyttöliittymä on 600 pikseliä leveä, ja 400 pikseliä korkea)
        frame.setPreferredSize(new Dimension(800, 800));
        // kielletään käyttöliittymän koon muuttaminen
        frame.setResizable(true);

        // jos käyttöliittymä suljetaan, ohjelma tulee sulkea
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // kutsutaan luoKomponentit-metodia, jossa käyttöliittymään tulee
        // lisätä tarvittavat komponentit (esimerkiksi Ikkuna-johon peliin
        // kuuluvia osia piirretään)
        if (this.valikko.getAlku()){
            luoValikko(frame.getContentPane());
        } else {
            luoKomponentit(frame.getContentPane());
        }

        
        NappaimistonKuuntelija kuuntelija = new NappaimistonKuuntelija(maailma.getPelihahmo(),this.maailma);
        frame.addKeyListener(kuuntelija);
        
        // asetetaan käyttöliittymä näkyväksi
        frame.pack();
        frame.setVisible(true);
    }

    public void luoKomponentit(Container container) {
        container.removeAll();
        ikkuna = new Ikkuna(maailma);
        container.add(ikkuna);
        
        
    } 
    
    public void luoValikko(Container container) {
        container.removeAll();
        container.add(this.valikko);
    }

    // tarjotaan Kayttoliittyman ulkopuolelta pääsy ikkunan piirtämiseen
    public void piirra() {
        if (ikkuna != null) {
            //ikkuna.setKuva();
            ikkuna.repaint();
        } else if (valikko != null) {
            valikko.repaint();
        } else {
            return;
        }

        
    } 
    
    public Boolean onkoIkkunaOlemassa() {
        if (ikkuna == null) {
            return false;
        } else {
            return true;
        }
    }
    
    public Boolean onkoValikkoOlemassa() {
        if (valikko == null) {
            return false;
        } else {
            return true;
        }
    }

    public JFrame getFrame() {
        return frame;
    }
}