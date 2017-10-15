package guigato;

public class Matriz {

    String a = "";
    String b = "";
    String c = "";
    String d = "";
    String e = "";
    String f = "";
    String g = "";
    String h = "";
    String i = "";

    String Temp[][] = {{"a", "b", "c"},
                      {"d", "e", "f"},
                      {"g", "h", "i"}};

    public String ganó(String n[][]) {

        String ganoA = "XXX";//puntos de comparación
        String ganoB = "OOO";
        boolean ganó1 = false, ganó2 = false;
        int r = 2;//variable para manejar la opción 8 
        String gana = "";
        String f1 = "", f2 = "", f3 = "", f4 = "", f5 = "", f6 = "", f7 = "", f8 = "";

        for (int f = 0; f < n.length && ganó1 == false && ganó2 == false; f++) {//este for se ejecuta mientras nadie gane, si alguien gana se termina
            f1 += n[0][f];//posibilidad de la primera fila
            f2 += n[1][f];//posibilidad de la segunda fila
            f3 += n[2][f];//posibilidad de la tercera fila
            f4 += n[f][0];//posibilidad de la primera columna
            f5 += n[f][1];//posibilidad de la segunda columna
            f6 += n[f][2];//posibilidad de la tercera columna
            f7 += n[f][f];//posibilidad de la diagonal hacia abajo
            f8 += n[r][r];//posibilidad de la diagional hacia arriba
            ganó1 = f1.equals(ganoA) ? true : f2.equals(ganoA) ? true : f3.equals(ganoA) ? true : f4.equals(ganoA) ? true : f5.equals(ganoA) ? true : f6.equals(ganoA) ? true : f7.equals(ganoA) ? true : f8.equals(ganoA) ? true : false;//sirve para saber si el primer jugador gana
            ganó2 = f1.equals(ganoB) ? true : f2.equals(ganoB) ? true : f3.equals(ganoB) ? true : f4.equals(ganoB) ? true : f5.equals(ganoB) ? true : f6.equals(ganoB) ? true : f7.equals(ganoB) ? true : f8.equals(ganoB) ? true : false;//sirve para saber si el segundo jugador gana
            r -= 1;
        }
        if (ganó1 == true) {
            gana += "jugador1";
        } else {
            if (ganó2 == true) {
                gana += "jugador2";
            } else {
                gana += "empate";
            }

        }
        return gana;
    }
}
