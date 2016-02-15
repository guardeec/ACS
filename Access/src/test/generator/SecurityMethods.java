package generator;

import com.google.gson.Gson;
import soap.SoapURL;
import soap.security.*;

import java.util.List;

/**
 * Created by Guardeec on 13.02.16.
 */
public class SecurityMethods {

    private static final java.net.URL URL = SoapURL.getInstance().SECURITY_URL();

    public static AccountDATA addAccount(AccountDATA accountDATA){
        SecuritySOAPService securitySOAPService = new SecuritySOAPService(URL);
        SecuritySOAP securitySOAP = securitySOAPService.getSecuritySOAPPort();

        accountDATA = (AccountDATA) securitySOAP.securityMethods("ACCOUNT_CREATE", accountDATA, null, null, null, null);
        return accountDATA;
    }
    public static AccountDATA changeAccount(AccountDATA accountDATA){
        SecuritySOAPService securitySOAPService = new SecuritySOAPService(URL);
        SecuritySOAP securitySOAP = securitySOAPService.getSecuritySOAPPort();

        accountDATA = (AccountDATA) securitySOAP.securityMethods("ACCOUNT_UPDATE", accountDATA, null, null, null, null);
        return accountDATA;
    }
    public static AccountDATA deleteAccount(AccountDATA accountDATA){
        SecuritySOAPService securitySOAPService = new SecuritySOAPService(URL);
        SecuritySOAP securitySOAP = securitySOAPService.getSecuritySOAPPort();

        accountDATA = (AccountDATA) securitySOAP.securityMethods("ACCOUNT_DELETE", accountDATA, null, null, null, null);
        return accountDATA;
    }
    public static List<AccountDATA> getAccount(AccountDATA accountDATA){
        SecuritySOAPService securitySOAPService = new SecuritySOAPService(URL);
        SecuritySOAP securitySOAP = securitySOAPService.getSecuritySOAPPort();

        String json = (String) securitySOAP.securityMethods("ACCOUNT_READ", accountDATA, null, null, null, null);
        Gson gson = new Gson();
        return gson.fromJson(json, List.class);
    }




    public static CardDATA addCard(CardDATA cardDATA){
        SecuritySOAPService securitySOAPService = new SecuritySOAPService(URL);
        SecuritySOAP securitySOAP = securitySOAPService.getSecuritySOAPPort();

        cardDATA = (CardDATA) securitySOAP.securityMethods("CARD_CREATE", null, cardDATA, null, null, null);
        return cardDATA;
    }
    public static CardDATA deleteCard(CardDATA cardDATA){
        SecuritySOAPService securitySOAPService = new SecuritySOAPService(URL);
        SecuritySOAP securitySOAP = securitySOAPService.getSecuritySOAPPort();

        cardDATA = (CardDATA) securitySOAP.securityMethods("CARD_DELETE", null, cardDATA, null, null, null);
        return cardDATA;
    }
    public static List<CardDATA> getCard(CardDATA cardDATA){
        SecuritySOAPService securitySOAPService = new SecuritySOAPService(URL);
        SecuritySOAP securitySOAP = securitySOAPService.getSecuritySOAPPort();

        String json = (String) securitySOAP.securityMethods("CARD_READ", null, cardDATA, null, null, null);
        Gson gson = new Gson();
        return gson.fromJson(json, List.class);
    }





    public static List<DeviceDATA> getDevice(DeviceDATA deviceDATA){
        SecuritySOAPService securitySOAPService = new SecuritySOAPService(URL);
        SecuritySOAP securitySOAP = securitySOAPService.getSecuritySOAPPort();

        String json = (String) securitySOAP.securityMethods("DEVICE_READ", null, null, deviceDATA, null, null);
        Gson gson = new Gson();
        return gson.fromJson(json, List.class);
    }





    public static RightDATA changeRight(RightDATA rightDATA){
        SecuritySOAPService securitySOAPService = new SecuritySOAPService(URL);
        SecuritySOAP securitySOAP = securitySOAPService.getSecuritySOAPPort();

        rightDATA = (RightDATA) securitySOAP.securityMethods("RIGHT_UPDATE", null, null, null, rightDATA, null);
        return rightDATA;
    }
    public static List<RightDATA> getRight(RightDATA rightDATA){
        SecuritySOAPService securitySOAPService = new SecuritySOAPService(URL);
        SecuritySOAP securitySOAP = securitySOAPService.getSecuritySOAPPort();

        String json = (String) securitySOAP.securityMethods("RIGHT_READ", null, null, null, rightDATA, null);
        Gson gson = new Gson();
        return gson.fromJson(json, List.class);
    }



    public static RoleDATA addRole(RoleDATA roleDATA){
        SecuritySOAPService securitySOAPService = new SecuritySOAPService(URL);
        SecuritySOAP securitySOAP = securitySOAPService.getSecuritySOAPPort();

        roleDATA = (RoleDATA) securitySOAP.securityMethods("ROLE_CREATE", null, null, null, null, roleDATA);
        return roleDATA;
    }
    public static RoleDATA changeRole(RoleDATA roleDATA){
        SecuritySOAPService securitySOAPService = new SecuritySOAPService(URL);
        SecuritySOAP securitySOAP = securitySOAPService.getSecuritySOAPPort();

        roleDATA = (RoleDATA) securitySOAP.securityMethods("ROLE_UPDATE", null, null, null, null, roleDATA);
        return roleDATA;
    }
    public static RoleDATA deleteRole(RoleDATA roleDATA){
        SecuritySOAPService securitySOAPService = new SecuritySOAPService(URL);
        SecuritySOAP securitySOAP = securitySOAPService.getSecuritySOAPPort();

        roleDATA = (RoleDATA) securitySOAP.securityMethods("ROLE_DELETE", null, null, null, null, roleDATA);
        return roleDATA;
    }
    public static List<RoleDATA> getRole(RoleDATA roleDATA){
        SecuritySOAPService securitySOAPService = new SecuritySOAPService(URL);
        SecuritySOAP securitySOAP = securitySOAPService.getSecuritySOAPPort();

        String json = (String) securitySOAP.securityMethods("ROLE_READ", null, null, null, null, roleDATA);
        Gson gson = new Gson();
        return gson.fromJson(json, List.class);
    }
}
