import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class GiftCard {
    ImageView barCodeImage;
    String cardNumber;
    String cvv;
    String expiration;
    String cardName;
    public GiftCard(String cardName, String cardNumber, String cvv, String expiration){
        this.cardName = cardName;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiration = expiration;
    }

    @Override
    public String toString() {
        return "GiftCard{" +
                "barCodeImage=" + barCodeImage +
                ", cardName='" + cardName + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", cvv='" + cvv + '\'' +
                ", expiration='" + expiration + '\'' +
                '}';
    }
}
