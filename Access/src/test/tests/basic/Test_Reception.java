package tests.basic;

import generator.ReceptionMethods;
import generator.SecurityMethods;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import soap.reception.GuestDATA;
import soap.security.CardDATA;

/**
 * Created by Guardeec on 12.02.16.
 */
public class Test_Reception {
    private int cardId;

    @Before
    public void init(){
        try {
            CardDATA cardDATA = new CardDATA();
            cardDATA.setCardNumber("card");
            cardId = SecurityMethods.addCard(cardDATA).getCardId();
        }catch (NullPointerException ex){
            Assert.fail("RECEPTION_INIT");
        }
    }

    @Test
    public void GUEST(){
        //проверяем на поиск карт
        if (ReceptionMethods.getFreeCards(null).size()<1){
            Assert.fail("CARD_GET");
        }

        //проверяем на добавление
        GuestDATA guestDATA = new GuestDATA();
        guestDATA.setCardId(cardId);
        guestDATA.setGuestName("test");
        guestDATA = ReceptionMethods.addGuest(guestDATA);
        if (guestDATA.getGeneralDescription().compareTo("SUCCESS")!=0){
            Assert.fail("GUEST_ADD");
        }

        //проверяем на изменение
        if (ReceptionMethods.changeGuest(guestDATA).getGeneralDescription().compareTo("SUCCESS")!=0){
            Assert.fail("GUEST_CHANGE");
        }

        //проверяем на получение
        if (ReceptionMethods.getGuest(new GuestDATA()).size()<1){
            Assert.fail("GUEST_GET");
        }

        //проверяем на удаление
        if (ReceptionMethods.deleteGuest(guestDATA).getGeneralDescription().compareTo("SUCCESS")!=0){
            Assert.fail("GUEST_DELETE");
        }

        //проверяем на получение строии посещений
        if (ReceptionMethods.getGuestHistory(null).size()<1){
            Assert.fail("GUEST_HISTORY");
        }
    }

    @After
    public void clear(){
        CardDATA cardDATA = new CardDATA();
        cardDATA.setCardId(cardId);
        SecurityMethods.deleteCard(cardDATA);
    }
}
