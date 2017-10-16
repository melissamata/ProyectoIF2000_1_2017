package guigato;

public class Matriz {

    public boolean esGanador (String[][] matrizTablero, String simboloJugador) {

        String patronGanador = simboloJugador + simboloJugador + simboloJugador;//puntos de comparación
        int r = 2;//variable para manejar la opción 8 
        String patronFilaUno = "";
        String patronFilaDos = "";
        String patronFilaTres = "";
        String patronColumnaUno = "";
        String patronColumnaDos = "";
        String patronColumnaTres = "";
        String patronDiagonalUno = "";
        String patronDiagonalDos = "";
        boolean ganador = false;

        for (int f = 0; f < matrizTablero.length; f++) {//este for se ejecuta mientras nadie gane, si alguien gana se termina
            patronFilaUno += matrizTablero[0][f];//posibilidad de la primera fila
            patronFilaDos += matrizTablero[1][f];//posibilidad de la segunda fila
            patronFilaTres += matrizTablero[2][f];//posibilidad de la tercera fila
            patronColumnaUno += matrizTablero[f][0];//posibilidad de la primera columna
            patronColumnaDos += matrizTablero[f][1];//posibilidad de la segunda columna
            patronColumnaTres += matrizTablero[f][2];//posibilidad de la tercera columna
            patronDiagonalUno += matrizTablero[f][f];//posibilidad de la diagonal hacia abajo
            patronDiagonalDos += matrizTablero[r][r];//posibilidad de la diagional hacia arriba

            r -= 1;
        }

        if (patronFilaUno.equals(patronGanador)
                || patronFilaDos.equals(patronGanador)
                || patronFilaTres.equals(patronGanador)
                || patronColumnaUno.equals(patronGanador)
                || patronColumnaDos.equals(patronGanador)
                || patronColumnaTres.equals(patronGanador)
                || patronDiagonalUno.equals(patronGanador)
                || patronDiagonalDos.equals(patronGanador)) {
            ganador = true;

        }
        return ganador;
    }
}
