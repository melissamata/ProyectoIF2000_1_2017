package guigato;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class Tablero extends Application {

    CalculosTablero cT = new CalculosTablero();
    private final int jugadorUno = 1;
    private final int jugadorDos = 2;
    private int turnoActual = jugadorUno;

    Image imgX = new Image("/ImagenesTablero/X.png");
    String X = "/ImagenesTablero/O.png";
    Image imgO = new Image("/ImagenesTablero/O.png");
    String O = "/ImagenesTablero/X.png";

    String[][] casillas = new String[3][3];

    @Override
    public void start(Stage primaryStage) {

        ImageView imagenUno = crearImagenTablero(0, 0);
        ImageView imagenDos = crearImagenTablero(0, 1);
        ImageView imagenTres = crearImagenTablero(0, 2);
        ImageView imagenCuatro = crearImagenTablero(1, 0);
        ImageView imagenCinco = crearImagenTablero(1, 1);
        ImageView imagenSeis = crearImagenTablero(1, 2);
        ImageView imagenSiete = crearImagenTablero(2, 0);
        ImageView imagenOcho = crearImagenTablero(2, 1);
        ImageView imagenNueve = crearImagenTablero(2, 2);

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

    public ImageView crearImagenTablero(int fila, int columna) {
        Casilla imagen = new Casilla(fila, columna);
        imagen.setFitWidth(100);
        imagen.setFitHeight(100);
        imagen.setPreserveRatio(true);
        imagen.setSmooth(true);
        imagen.setCache(true);
        imagen.setPickOnBounds(true);

        imagen.setOnMouseClicked((MouseEvent event) -> {

            int filaSeleccionada = imagen.getFila();
            int columnaSeleccionada = imagen.getColumna();

            if (turnoActual == jugadorUno) {
                imagen.setImage(imgX);
                turnoActual = jugadorDos;
                casillas[filaSeleccionada][columnaSeleccionada] = "X";
                if (cT.esGanador(casillas, "X")) {
                    new Alert(Alert.AlertType.INFORMATION, "El ganador es el jugador uno!").showAndWait();
                }

            } else {
                imagen.setImage(imgO);
                turnoActual = jugadorUno;
                casillas[filaSeleccionada][columnaSeleccionada] = "O";
                if (cT.esGanador(casillas, "O")) {
                    new Alert(Alert.AlertType.INFORMATION, "El ganador es el jugador dos!").showAndWait();
                }

            }

        });
        return imagen;
    }

}
