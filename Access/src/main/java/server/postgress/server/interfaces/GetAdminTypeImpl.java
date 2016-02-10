package server.postgress.server.interfaces;

import java.util.Map;

/**
 * Created by root on 06.08.15.
 */
public interface GetAdminTypeImpl {
    public Map<String, Boolean> get(String name, String password);
}
