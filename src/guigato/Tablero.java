
package guigato;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Tablero extends Application {

    private final int jugadorUno = 1;
    private final int jugadorDos = 2;
    private int turnoActual = jugadorUno;
   
    Image imgX = new Image("/ImagenesTablero/X.png");
    String X = "/ImagenesTablero/O.png";
    Image imgO = new Image("/ImagenesTablero/O.png");
    String O  = "/ImagenesTablero/X.png";
    String valor="";
    

    @Override
    public void start(Stage primaryStage) {

        ImageView imagenUno = crearImagenTablero();
        ImageView imagenDos = crearImagenTablero();
        ImageView imagenTres = crearImagenTablero();
        ImageView imagenCuatro = crearImagenTablero();
        ImageView imagenCinco = crearImagenTablero();
        ImageView imagenSeis = crearImagenTablero();
        ImageView imagenSiete = crearImagenTablero();
        ImageView imagenOcho = crearImagenTablero();
        ImageView imagenNueve = crearImagenTablero();
        
        
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

    public ImageView crearImagenTablero() {
        ImageView imagen = new ImageView();
        imagen.setFitWidth(100);
        imagen.setFitHeight(100);
        imagen.setPreserveRatio(true);
        imagen.setSmooth(true);
        imagen.setCache(true);
        imagen.setPickOnBounds(true);
        
        imagen.setOnMouseClicked((MouseEvent event) -> {
            if (turnoActual == jugadorUno) {
                imagen.setImage(imgX);
                turnoActual = jugadorDos;
                valor=X;
            } else {
                imagen.setImage(imgO);
                turnoActual = jugadorUno;
                valor=O;
            }
            
        });
        return imagen;
    }
}
    

