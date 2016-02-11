package pojo.client.admin;


import pojo.GeneralParams;

/**
 * Created by root on 27.10.15.
 */
public class CardDATA extends GeneralParams {
    private Integer cardId;
    private String cardNumber;

    public void setSpecificParams(
            Integer cardId,
            String cardNumber
    ) {
        this.cardId = cardId;
        this.cardNumber = cardNumber;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
