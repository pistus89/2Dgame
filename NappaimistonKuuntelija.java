
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class NappaimistonKuuntelija implements KeyListener {

    private Pelihahmo pelihahmo;
    private Maailma maailma;
    

    public NappaimistonKuuntelija(Pelihahmo pelihahmo, Maailma maailma) {
        this.pelihahmo = pelihahmo;
        this.maailma = maailma;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // ei koodia
        if (e.getKeyCode() == KeyEvent.VK_E) {
            
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            
            pelihahmo.hyppaa();
            pelihahmo.setIlmassa(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            //this.pelihahmo.vauhti(2);
            if (this.pelihahmo.getJumissa()) {
                if (this.pelihahmo.getSuunta().equalsIgnoreCase("oikea")) {
                    this.maailma.setNopeus(2);
                    this.pelihahmo.setJumissa(false);
                } else {
                    this.maailma.setNopeus(0);
                    return;
                }
            }
            this.maailma.setNopeus(2);
            this.pelihahmo.setOikea();
            
        }
        
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            
            if (this.pelihahmo.getJumissa()) {
                if (this.pelihahmo.getSuunta().equalsIgnoreCase("vasen")) {
                    this.maailma.setNopeus(-2);
                    this.pelihahmo.setJumissa(false);
                } else {
                    this.maailma.setNopeus(0);
                    return;
                }
            }    
            this.maailma.setNopeus(-2);
            this.pelihahmo.setVasen();
            
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // ei koodia
        
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.maailma.pysayta();
            this.pelihahmo.setPaikallaan();
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.maailma.pysayta();
            this.pelihahmo.setPaikallaan();
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            this.pelihahmo.setIlmassa(true);
        }
        
        
    }
}
