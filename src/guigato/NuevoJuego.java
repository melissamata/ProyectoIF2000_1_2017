
package guigato;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class NuevoJuego extends Application {

    Tablero t;
    Menu m;
    Label lbl_ingreseJugadores;
    Button btn_ingresar, btn_regresar;
    TextField tf_jugadorUno, tf_jugadorDos;
    Tooltip textoUno;

    @Override
    public void start(Stage primaryStage) {

        lbl_ingreseJugadores = new Label("Ingrese el nombre de los jugadores");
        lbl_ingreseJugadores.setFont(new Font("Arial", 18));

        tf_jugadorUno = new TextField();
        tf_jugadorUno.setText("Jugador 1");
        tf_jugadorUno.setStyle("-fx-font: 18 arial; -fx-base: #EBC504;");
        textoUno = new Tooltip("Enter para continuar");
        tf_jugadorUno.setTooltip(textoUno);
        
        
        tf_jugadorUno.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               tf_jugadorUno.setDisable(true);
               tf_jugadorDos.setDisable(false);
               btn_ingresar.setDisable(false);
            }
        });
        
                
       
        

        tf_jugadorDos = new TextField();
        tf_jugadorDos.setDisable(true);
        tf_jugadorDos.setText("Jugador 2");
        tf_jugadorDos.setStyle("-fx-font: 18 arial; -fx-base: #EBC504;");
        textoUno = new Tooltip("Enter para continuar");
        tf_jugadorDos.setTooltip(textoUno);
        
        tf_jugadorDos.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tf_jugadorDos.setDisable(true);
                btn_ingresar.setDisable(false);
            }
        });
        
        

        t = new Tablero();

        btn_ingresar = new Button();
        btn_ingresar.setText("Ingresar");
        btn_ingresar.setDisable(true);
        btn_ingresar.setPrefSize(100, 30);
        btn_ingresar.setStyle("-fx-font: 18 arial; -fx-base: #EBC504;");
        btn_ingresar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                t.start(primaryStage);

            }
        });

        m = new Menu();

        btn_regresar = new Button();
        btn_regresar.setText("Menu");
        btn_regresar.setPrefSize(100, 30);
        btn_regresar.setStyle("-fx-font: 18 arial; -fx-base: #E9E8E2;");
        btn_regresar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                m.start(primaryStage);

            }
        });

        VBox verticalWindow = new VBox();
        verticalWindow.setSpacing(15);

        String image = "Background.png";
        verticalWindow.setStyle("-fx-background-image: url('" + image + "'); "
                + "-fx-background-position: left top, center;"
                + "-fx-background-repeat: no-repeat;"
                + "-fx-background-size: cover, auto;");
        verticalWindow.setAlignment(Pos.CENTER);
        verticalWindow.getChildren().addAll(lbl_ingreseJugadores, tf_jugadorUno, tf_jugadorDos, btn_ingresar, btn_regresar);

        
        BorderPane window = new BorderPane();

        window.setCenter(verticalWindow);

        Scene scene = new Scene(window, 300, 300);

        primaryStage.setTitle("Gato - Nuevo Juego");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
