package guigato;

import javafx.scene.image.ImageView;

public class Casilla extends ImageView {

    private int fila = -1;
    private int columna = -1;
    
    
    //Constructor de la clase

    public Casilla(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    /**
     * @return the fila
     */
    public int getFila() {
        return fila;
    }

    /**
     * @return the columna
     */
    public int getColumna() {
        return columna;
    }
    
    

}
