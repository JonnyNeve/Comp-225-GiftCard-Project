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
    Button viewCardsButton;
    Scene sceneOne;


    Button saveButton;
    TextField cardNumber;
    TextField cvv;
    TextField expirationMonth;
    TextField expirationYear;
    TextField cardName;
    Button backButton;
    Scene sceneTwo;

    Scene sceneThree;
    Button sceneThreeBack;

    int sceneTwoCounter = 0;
    int sceneThreeCounterLeft = 25;
    int sceneThreeCounterRight = 25;
    ArrayList<Label> cardLabelList = new ArrayList<>();
    ArrayList<GiftCard> cardList = new ArrayList<>();
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Store Gift cards");

        viewCardsButton = new Button("View Saved Cards");
        StackPane layout3 = new StackPane();

        button = new Button("Add a new gift card");
        button.setOnAction(actionEvent -> {stage.setScene(sceneTwo);
        });
        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        layout.getChildren().add(viewCardsButton);
        StackPane.setAlignment(viewCardsButton, Pos.TOP_CENTER);
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
            GiftCard card = new GiftCard(cardName.getText(), cardNumber.getText(), cvv.getText(), expirationMonth.getText() + "/" + expirationYear.getText());
            cardList.add(card);
            Label label = new Label(cardName.getText() + " Card Saved!");
            cardLabelList.add(label);
            StackPane.setAlignment(label, Pos.TOP_CENTER);
            StackPane.setMargin(label, new Insets(sceneTwoCounter));
            sceneTwoCounter+=20;
            layout2.getChildren().add(label);
            System.out.println(card.toString());

        });
        backButton.setOnAction(actionEvent -> {
            for(Label label: cardLabelList){
                layout2.getChildren().remove(label);
            }
            sceneTwoCounter = 0;
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

        viewCardsButton.setOnAction(actionEvent -> {
            for(GiftCard card: cardList){
                Label nameLabel = new Label(card.cardName);
                Label numberLabel = new Label("Card number: " + card.cardNumber);
                Label cvvLabel = new Label("CVV: " + card.cvv);
                Label expirationLabel = new Label("Exp. Date: " + card.expiration);
                layout3.getChildren().add(nameLabel);
                layout3.getChildren().add(numberLabel);
                layout3.getChildren().add(cvvLabel);
                layout3.getChildren().add(expirationLabel);
                StackPane.setAlignment(nameLabel, Pos.TOP_LEFT);
                StackPane.setAlignment(numberLabel, Pos.TOP_RIGHT);
                StackPane.setAlignment(cvvLabel, Pos.TOP_RIGHT);
                StackPane.setAlignment(expirationLabel, Pos.TOP_LEFT);
                StackPane.setMargin(nameLabel, new Insets(sceneThreeCounterLeft, 0, 0, 0));
                sceneThreeCounterLeft += 25;
                StackPane.setMargin(expirationLabel, new Insets(sceneThreeCounterLeft, 0, 0, 0));
                sceneThreeCounterLeft+=25;
                StackPane.setMargin(numberLabel, new Insets(sceneThreeCounterRight, 0, 0, 0));
                sceneThreeCounterRight+=25;
                StackPane.setMargin(cvvLabel, new Insets(sceneThreeCounterRight, 0, 0, 0));
                sceneThreeCounterRight+=25;
            }
            stage.setScene(sceneThree);
        });

        sceneThreeBack = new Button("Back");
        sceneThreeBack.setOnAction(actionEvent -> {
            stage.setScene(sceneOne);
            layout3.getChildren().clear();
            sceneThreeCounterRight = 0;
            sceneThreeCounterLeft = 0;
            layout3.getChildren().add(sceneThreeBack);
        });
        layout3.getChildren().add(sceneThreeBack);
        StackPane.setAlignment(sceneThreeBack, Pos.BOTTOM_CENTER);


        sceneThree = new Scene(layout3, 300, 500);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
    if(actionEvent.getSource() == button){

    }
    }
}
