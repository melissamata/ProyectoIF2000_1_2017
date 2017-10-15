
package guigato;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Melissa
 */
public class Menu extends Application {

    NuevoJuego nJ = new NuevoJuego();
    Tablero t = new Tablero();
    Creditos c = new Creditos();
    Button btn_nuevoJuego, btn_reiniciarJuego, btn_creditos;

    @Override
    public void start(Stage primaryStage) {

        btn_nuevoJuego = new Button();
        btn_nuevoJuego.setText("Nuevo Juego");
        btn_nuevoJuego.setPrefSize(200, 30);
        btn_nuevoJuego.setStyle("-fx-font: 22 arial; -fx-base: #EBC504;");

        btn_nuevoJuego.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                nJ.start(primaryStage);
            }
        });

        btn_reiniciarJuego = new Button();
        btn_reiniciarJuego.setText("Reiniciar Juego");
        btn_reiniciarJuego.setPrefSize(200, 30);
        btn_reiniciarJuego.setStyle("-fx-font: 22 arial; -fx-base: #ECD66A;");
        btn_reiniciarJuego.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                t.start(primaryStage);
            }
        });

        btn_creditos = new Button();
        btn_creditos.setText("Créditos");
        btn_creditos.setPrefSize(200, 30);
        btn_creditos.setStyle("-fx-font: 22 arial; -fx-base: #E9E8E2;");
        btn_creditos.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                c.start(primaryStage);

            }
        });

        GridPane menu = new GridPane();

        menu.setPadding(new Insets(4, 1, 5, 5));
        menu.setVgap(10);

        GridPane.setConstraints(btn_nuevoJuego, 0, 0);
        menu.getChildren().add(btn_nuevoJuego);

        GridPane.setConstraints(btn_reiniciarJuego, 0, 1);
        menu.getChildren().add(btn_reiniciarJuego);

        GridPane.setConstraints(btn_creditos, 0, 2);
        menu.getChildren().add(btn_creditos);

        String image = "Background.png";
        menu.setStyle("-fx-background-image: url('" + image + "'); "
                + "-fx-background-position: left top, center;"
                + "-fx-background-repeat: no-repeat;"
                + "-fx-background-size: cover, auto;");

        menu.setAlignment(Pos.CENTER);

        Scene scene = new Scene(menu, 300, 300);

        primaryStage.setTitle("Gato");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
