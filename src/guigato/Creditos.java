package guigato;

import javafx.application.Application;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Melissa
 */
public class Creditos extends Application {

    Menu m;
    Button btn_regresar;
    TextArea ta_muestraCreditos;

    @Override
    public void start(Stage primaryStage) {

        ta_muestraCreditos = new TextArea();
        ta_muestraCreditos.setText("\n Universidad de Costa Rica"
                + "\n"
                + "\n Proyecto IF2000"
                + "\n"
                + "\n Desarrolladores:"
                + "\n Jonathan Castro Ulloa - B41654"
                + "\n Melissa Mata Argüello - B54185"
                + "\n"
                + "\n 2017 ©");
        ta_muestraCreditos.setStyle("-fx-font: 12 arial; -fx-base: #FFFFFE;");
        ta_muestraCreditos.setPrefSize(190, 190);
        ta_muestraCreditos.setEditable(false);

        m = new Menu();

        btn_regresar = new Button();
        btn_regresar.setText("Menu");
        btn_regresar.setPrefSize(100, 30);
        btn_regresar.setStyle("-fx-font: 18 arial; -fx-base: #EBC504;");

        btn_regresar.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                m.start(primaryStage);

            }
        });

        VBox ventanaVertical = new VBox();
        ventanaVertical.setSpacing(15);

        String image = "Background.png";
        ventanaVertical.setStyle("-fx-background-image: url('" + image + "'); "
                + "-fx-background-position: left top, center;"
                + "-fx-background-repeat: no-repeat;"
                + "-fx-background-size: cover, auto;");

        ventanaVertical.setAlignment(Pos.CENTER);
        ventanaVertical.getChildren().addAll(ta_muestraCreditos, btn_regresar);

        BorderPane ventana = new BorderPane();

        ventana.setCenter(ventanaVertical);

        Scene scene = new Scene(ventana, 300, 300);

        primaryStage.setTitle("Gato - Créditos");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}
