package guigato;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.lang.Math;
import javafx.scene.control.ButtonType;
import javax.swing.JOptionPane;

public class Tablero extends Application {

    CalculosTablero cT = new CalculosTablero();
    int cuentaJugadas = 0;
    public final int jugadorUno = 1;
    public final int jugadorDos = 2;
    int turnoActual;
    boolean juegoTerminado = false;

    Image imgX = new Image("/ImagenesTablero/X.png");
    String X = "/ImagenesTablero/O.png";
    Image imgO = new Image("/ImagenesTablero/O.png");
    String O = "/ImagenesTablero/X.png";

    ImageView imagenUno;
    ImageView imagenDos;
    ImageView imagenTres;
    ImageView imagenCuatro;
    ImageView imagenCinco;
    ImageView imagenSeis;
    ImageView imagenSiete;
    ImageView imagenOcho;
    ImageView imagenNueve;

    String[][] casillas = new String[3][3];

    public Tablero() {

        imagenUno = crearImagenTablero(0, 0);
        imagenDos = crearImagenTablero(0, 1);
        imagenTres = crearImagenTablero(0, 2);
        imagenCuatro = crearImagenTablero(1, 0);
        imagenCinco = crearImagenTablero(1, 1);
        imagenSeis = crearImagenTablero(1, 2);
        imagenSiete = crearImagenTablero(2, 0);
        imagenOcho = crearImagenTablero(2, 1);
        imagenNueve = crearImagenTablero(2, 2);

    }

    @Override
    public void start(Stage primaryStage) {

        turnoActual = aleatorioJugador();

        GridPane tablero = new GridPane();

        tablero.setPadding(new Insets(10, 10, 10, 10));

        tablero.setAlignment(Pos.CENTER);
        tablero.setStyle("-fx-background-color: #F7EAAA; -fx-grid-lines-visible: true");

        GridPane.setConstraints(imagenUno, 0, 0);
        tablero.getChildren().add(imagenUno);

        GridPane.setConstraints(imagenDos, 0, 1);
        tablero.getChildren().add(imagenDos);

        GridPane.setConstraints(imagenTres, 0, 2);
        tablero.getChildren().add(imagenTres);

        GridPane.setConstraints(imagenCuatro, 1, 0);
        tablero.getChildren().add(imagenCuatro);

        GridPane.setConstraints(imagenCinco, 1, 1);
        tablero.getChildren().add(imagenCinco);

        GridPane.setConstraints(imagenSeis, 1, 2);
        tablero.getChildren().add(imagenSeis);

        GridPane.setConstraints(imagenSiete, 2, 0);
        tablero.getChildren().add(imagenSiete);

        GridPane.setConstraints(imagenOcho, 2, 1);
        tablero.getChildren().add(imagenOcho);

        GridPane.setConstraints(imagenNueve, 2, 2);
        tablero.getChildren().add(imagenNueve);

        Scene scene = new Scene(tablero, 300, 300);

        primaryStage.setTitle("Gato - Nuevo Juego");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public int aleatorioJugador() {

        int jugadorInicial = 1 + (int) (Math.random() * 2);

        return jugadorInicial;
    }

    private ImageView crearImagenTablero(int fila, int columna) {
        Casilla imagen = new Casilla(fila, columna);
        imagen.setFitWidth(100);
        imagen.setFitHeight(100);
        imagen.setPreserveRatio(true);
        imagen.setSmooth(true);
        imagen.setCache(true);
        imagen.setPickOnBounds(true);

        imagen.setOnMouseClicked((MouseEvent event) -> {
            if (!juegoTerminado) {
                cuentaJugadas++;
                int filaSeleccionada = imagen.getFila();
                int columnaSeleccionada = imagen.getColumna();
                if (turnoActual == jugadorUno) {
                    imagen.setImage(imgX);
                    turnoActual = jugadorDos;
                    casillas[filaSeleccionada][columnaSeleccionada] = "X";
                    if (cT.esGanador(casillas, "X")) {
                        juegoTerminado = true;
                        Alert AlertaGanadorUno = new Alert(Alert.AlertType.INFORMATION);
                        AlertaGanadorUno.setTitle("Gato - Ganador");
                        AlertaGanadorUno.setHeaderText(null);
                        AlertaGanadorUno.setContentText("¡El ganador es el jugador uno!");
                        AlertaGanadorUno.initStyle(StageStyle.UTILITY);
                        AlertaGanadorUno.showAndWait();
                        anuncioJugar();
                    }
                } else {
                    imagen.setImage(imgO);
                    turnoActual = jugadorUno;
                    casillas[filaSeleccionada][columnaSeleccionada] = "O";
                    if (cT.esGanador(casillas, "O")) {
                        juegoTerminado = true;
                        Alert AlertaGanadorDos = new Alert(Alert.AlertType.INFORMATION);
                        AlertaGanadorDos.setTitle("Gato - Ganador");
                        AlertaGanadorDos.setHeaderText(null);
                        AlertaGanadorDos.setContentText("¡El ganador es el jugador dos!");
                        AlertaGanadorDos.initStyle(StageStyle.UTILITY);
                        AlertaGanadorDos.showAndWait();
                        anuncioJugar();
                    }
                }
                if (cuentaJugadas >= 9) {
                    juegoTerminado = true;
                    Alert AlertaEmpate = new Alert(Alert.AlertType.INFORMATION);
                    AlertaEmpate.setTitle("Gato - Ganador");
                    AlertaEmpate.setHeaderText(null);
                    AlertaEmpate.setContentText("¡Hay un empate!");
                    AlertaEmpate.initStyle(StageStyle.UTILITY);
                    AlertaEmpate.showAndWait();
                    anuncioJugar();

                }
            }
        });

        return imagen;
    }

    public void reiniciarJuego() {

        cT.reiniciarTablero(casillas);

        juegoTerminado = false;
        cuentaJugadas = 0;

        imagenUno.setImage(null);
        imagenDos.setImage(null);
        imagenTres.setImage(null);
        imagenCuatro.setImage(null);
        imagenCinco.setImage(null);
        imagenSeis.setImage(null);
        imagenSiete.setImage(null);
        imagenOcho.setImage(null);
        imagenNueve.setImage(null);
    }

    public void anuncioJugar() {

        int resp = JOptionPane.showConfirmDialog(null, "Desea seguir jugando", "Reiniciar Juego", JOptionPane.YES_NO_OPTION);
        
        if (resp == 0) {
            reiniciarJuego();
        } else {
            System.exit(0);
        } 
    }

}
