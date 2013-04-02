
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author krister
 */
public class Valikko extends JPanel{
    private boolean kuollut;
    private boolean alku;
    private ArrayList<Alusta> lista;
    
    public Valikko() {
        this.alku = false;
        this.kuollut = false;
        this.lista = teePalkit();
        
}
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        g.setColor(Color.yellow);
        
        for (Alusta alusta : this.lista) {
            g.drawRect(alusta.getX(), alusta.getY(), alusta.getLeveys(), alusta.getKorkeus());
        }
    }
    
    
    private ArrayList<Alusta> teePalkit() {
        ArrayList<Alusta> alustat = new ArrayList<Alusta>();
        
        alustat.add(new Alusta(40,60,100,100));
        return alustat;
    }
    
    public void setAlku(Boolean arvo) {
        this.alku = arvo;
    }
    
    public Boolean getAlku() {
        return this.alku;
    }
    
    public void setKuollut(Boolean arvo) {
        this.kuollut = arvo;
    }
    public Boolean getKuollut() {
        return this.kuollut;
    }
     
}


