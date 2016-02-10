package server.postgress.admin;

import pojo.client.admin.*;

import java.util.List;

/**
 * Created by Guardeec on 09.02.16.
 */
public interface SecurityImpl {
    public AccountDATA addAccount(AccountDATA accountDATA);
    public AccountDATA changeAccount(AccountDATA accountDATA);
    public AccountDATA deleteAccount(AccountDATA accountDATA);
    public List<AccountDATA> getAccount(AccountDATA accountDATA);

    public CardDATA addCard(CardDATA cardDATA);
    public CardDATA deleteCard(CardDATA cardDATA);
    public List<CardDATA> getCard(CardDATA cardDATA);

    public List<DeviceDATA> getDevice(DeviceDATA deviceDATA);

    public RightDATA changeRigth(RightDATA rightDATA);
    public List<RightDATA> getRights(RightDATA rightDATA);

    public RoleDATA addRole(RoleDATA roleDATA);
    public RoleDATA changeRole(RoleDATA roleDATA);
    public RoleDATA deleteRole(RoleDATA roleDATA);
    public List<RoleDATA> getRoles(RoleDATA roleDATA);
}
