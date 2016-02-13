package generator;

import soap.security.*;
import soap.technical.DeviceDATA;

import java.util.List;

/**
 * Created by Guardeec on 13.02.16.
 */
public class SecurityMethods {

    public static AccountDATA addAccount(AccountDATA accountDATA){
        SecuritySOAPService securitySOAPService = new SecuritySOAPService();
        SecuritySOAP securitySOAP = securitySOAPService.getSecuritySOAPPort();

        accountDATA = (AccountDATA) securitySOAP.securityMethods("ACCOUNT_CREATE", accountDATA, null, null, null, null);
        return accountDATA;
    }
    public static AccountDATA changeAccount(AccountDATA accountDATA){
        SecuritySOAPService securitySOAPService = new SecuritySOAPService();
        SecuritySOAP securitySOAP = securitySOAPService.getSecuritySOAPPort();

        accountDATA = (AccountDATA) securitySOAP.securityMethods("ACCOUNT_UPDATE", accountDATA, null, null, null, null);
        return accountDATA;
    }
    public static AccountDATA deleteAccount(AccountDATA accountDATA){
        SecuritySOAPService securitySOAPService = new SecuritySOAPService();
        SecuritySOAP securitySOAP = securitySOAPService.getSecuritySOAPPort();

        accountDATA = (AccountDATA) securitySOAP.securityMethods("ACCOUNT_DELETE", accountDATA, null, null, null, null);
        return accountDATA;
    }
    public static List<AccountDATA> getAccount(AccountDATA accountDATA){
        return null;
    }




    public static CardDATA addCard(CardDATA cardDATA){
        SecuritySOAPService securitySOAPService = new SecuritySOAPService();
        SecuritySOAP securitySOAP = securitySOAPService.getSecuritySOAPPort();

        cardDATA = (CardDATA) securitySOAP.securityMethods("CARD_CREATE", null, cardDATA, null, null, null);
        return cardDATA;
    }
    public static CardDATA deleteCard(CardDATA cardDATA){
        SecuritySOAPService securitySOAPService = new SecuritySOAPService();
        SecuritySOAP securitySOAP = securitySOAPService.getSecuritySOAPPort();

        cardDATA = (CardDATA) securitySOAP.securityMethods("CARD_DELETE", null, cardDATA, null, null, null);
        return cardDATA;
    }
    public static List<CardDATA> getCard(CardDATA cardDATA){
        return null;
    }





    public static List<DeviceDATA> getDevice(DeviceDATA deviceDATA){
        return null;
    }





    public static RightDATA changeRight(RightDATA rightDATA){
        SecuritySOAPService securitySOAPService = new SecuritySOAPService();
        SecuritySOAP securitySOAP = securitySOAPService.getSecuritySOAPPort();

        rightDATA = (RightDATA) securitySOAP.securityMethods("RIGHT_UPDATE", null, null, null, rightDATA, null);
        return rightDATA;
    }
    public static List<RightDATA> getRight(RightDATA rightDATA){
        return null;
    }



    public static RoleDATA addRole(RoleDATA roleDATA){
        SecuritySOAPService securitySOAPService = new SecuritySOAPService();
        SecuritySOAP securitySOAP = securitySOAPService.getSecuritySOAPPort();

        roleDATA = (RoleDATA) securitySOAP.securityMethods("ROLE_CREATE", null, null, null, null, roleDATA);
        return roleDATA;
    }
    public static RoleDATA changeRole(RoleDATA roleDATA){
        SecuritySOAPService securitySOAPService = new SecuritySOAPService();
        SecuritySOAP securitySOAP = securitySOAPService.getSecuritySOAPPort();

        roleDATA = (RoleDATA) securitySOAP.securityMethods("ROLE_UPDATE", null, null, null, null, roleDATA);
        return roleDATA;
    }
    public static RoleDATA deleteRole(RoleDATA roleDATA){
        SecuritySOAPService securitySOAPService = new SecuritySOAPService();
        SecuritySOAP securitySOAP = securitySOAPService.getSecuritySOAPPort();

        roleDATA = (RoleDATA) securitySOAP.securityMethods("ROLE_DELETE", null, null, null, null, roleDATA);
        return roleDATA;
    }
    public static List<RoleDATA> getRole(RoleDATA roleDATA){
        return null;
    }
}
