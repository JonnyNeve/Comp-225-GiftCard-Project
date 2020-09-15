import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Stack;


public class FirstScreen extends Application implements EventHandler<ActionEvent> {

    Button button;
    Scene sceneOne;

    Button saveButton;
    TextField cardNumber;
    Button backButton;
    Scene sceneTwo;

    int counter = 0;

    ArrayList<GiftCard> cardList = new ArrayList<>();
    ArrayList<Label> cardLabelList = new ArrayList<>();
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Store Gift cards");
        button = new Button("Add a new gift card");
        button.setOnAction(actionEvent -> {stage.setScene(sceneTwo);
        });
        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        sceneOne = new Scene(layout, 300, 500);
        stage.setScene(sceneOne);
        stage.show();

        saveButton = new Button("Add Card");
        cardNumber = new TextField("Enter a Gift Card Number");
        backButton = new Button("Back");
        StackPane layout2 = new StackPane();

        saveButton.setOnAction(actionEvent -> {
            cardList.add(new GiftCard(cardNumber.getText()));
            Label label = new Label("Card number: " + cardNumber.getText());
            cardLabelList.add(label);
            StackPane.setAlignment(label, Pos.TOP_CENTER);
            StackPane.setMargin(label, new Insets(counter));
            counter+=20;
            layout2.getChildren().add(label);
        });
        backButton.setOnAction(actionEvent -> {
            for(Label label: cardLabelList){
                layout2.getChildren().remove(label);
            }
            counter = 0;
            stage.setScene(sceneOne);
        });

        layout2.getChildren().add(backButton);
        StackPane.setAlignment(backButton, Pos.TOP_LEFT);
        layout2.getChildren().add(cardNumber);
        StackPane.setAlignment(cardNumber, Pos.CENTER);
        layout2.getChildren().add(saveButton);
        StackPane.setAlignment(saveButton, Pos.BOTTOM_CENTER);
        sceneTwo = new Scene(layout2, 300, 500);

//        saveButton.setOnAction(actionEvent ->


    }

    @Override
    public void handle(ActionEvent actionEvent) {
    if(actionEvent.getSource() == button){

    }
    }
}
