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
    TextField cvv;
    TextField expirationMonth;
    TextField expirationYear;
    TextField cardName;
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
        cardName = new TextField("Store Name");
        cardNumber = new TextField("Enter a Gift Card #");
        cvv = new TextField("Enter 3 digit CVV #");
        expirationMonth = new TextField("Expiration Month ex: '09");
        expirationYear = new TextField("Expiration Year ex: '23'");
        backButton = new Button("Back");
        StackPane layout2 = new StackPane();

        layout2.getChildren().add(cardName);
        layout2.getChildren().add(cvv);
        layout2.getChildren().add(expirationMonth);
        layout2.getChildren().add(expirationYear);
        StackPane.setAlignment(cardName, Pos.TOP_CENTER);
        StackPane.setAlignment(cvv, Pos.TOP_CENTER);
        StackPane.setAlignment(expirationMonth, Pos.TOP_CENTER);
        StackPane.setAlignment(expirationYear, Pos.TOP_CENTER);
        StackPane.setMargin(cardName, new Insets(120, 0, 0, 0));
        StackPane.setMargin(cvv, new Insets(150, 0, 0, 0));
        StackPane.setMargin(expirationMonth, new Insets(180, 0, 0, 0));
        StackPane.setMargin(expirationYear, new Insets(210, 0, 0, 0));



        saveButton.setOnAction(actionEvent -> {
            GiftCard card = new GiftCard(cardName.getText(), cardNumber.getText(), cvv.getText(), expirationMonth.getText() + "/" + expirationYear);
            cardList.add(card);
            Label label = new Label(cardName.getText() + " Card Saved!");
            cardLabelList.add(label);
            StackPane.setAlignment(label, Pos.TOP_CENTER);
            StackPane.setMargin(label, new Insets(counter));
            counter+=20;
            layout2.getChildren().add(label);
            System.out.println(card.toString());
        });
        backButton.setOnAction(actionEvent -> {
            for(Label label: cardLabelList){
                layout2.getChildren().remove(label);
            }
            counter = 0;
            stage.setScene(sceneOne);
            cardName.setText("What store is this card for?");
            cardNumber.setText("Enter a Gift Card #");
            cvv.setText("Enter 3 digit CVV #");
            expirationMonth.setText("Expiration Month ex: '09");
            expirationYear.setText("Expiration Year ex: '23'");
        });

        layout2.getChildren().add(backButton);
        StackPane.setAlignment(backButton, Pos.TOP_LEFT);
        layout2.getChildren().add(cardNumber);
        StackPane.setAlignment(cardNumber, Pos.TOP_CENTER);
        StackPane.setMargin(cardNumber, new Insets(240, 0, 0, 0));
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
