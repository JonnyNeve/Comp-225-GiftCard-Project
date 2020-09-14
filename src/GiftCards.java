import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Stack;

public class GiftCards extends Application implements EventHandler<ActionEvent> {
    Button button;
    ArrayList<String> cardList = new ArrayList<>();
    TextField cardNumber;
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Add a Gift Card");
        button = new Button("Save");
        button.setOnAction(this);

        cardNumber = new TextField("Enter a Gift Card Number");

        StackPane layout = new StackPane();


        for(String card: cardList){
            Label label = new Label(card);
            layout.getChildren().add(label);
        }

        layout.getChildren().add(cardNumber);
        layout.getChildren().add(button);
        layout.alignmentProperty();

        Scene scene = new Scene(layout, 300, 500);
        stage.setScene(scene);
        stage.show();

    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if(actionEvent.getSource() == button){
            cardList.add(cardNumber.getText());
            for (String s : cardList) {
                System.out.println(s);
            }

        }
    }
}
