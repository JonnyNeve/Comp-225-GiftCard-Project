import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;



public class firstScreen extends Application implements EventHandler<ActionEvent> {

    Button button;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
    stage.setTitle("Store Gift cards");
    button = new Button("Add a new gift card");
    button.setOnAction(this);

    StackPane layout = new StackPane();
    layout.getChildren().add(button);

    Scene scene = new Scene(layout, 300, 500);
    stage.setScene(scene);
    stage.show();

    }

    @Override
    public void handle(ActionEvent actionEvent) {
    if(actionEvent.getSource() == button){

    }
    }
}
