package server.postgress.admin;

import pojo.client.admin.CardDATA;
import pojo.client.admin.EmployeeDATA;
import pojo.client.admin.RoleDATA;

import java.util.List;

/**
 * Created by Guardeec on 08.02.16.
 */
public interface HRImpl {
    public EmployeeDATA addEmployee(EmployeeDATA employeeDATA);
    public EmployeeDATA changeEmployee(EmployeeDATA employeeDATA);
    public EmployeeDATA deleteEmployee(EmployeeDATA employeeDATA);
    public List<EmployeeDATA> getEmployee(EmployeeDATA employeeDATA);

    public List<CardDATA> getFreeCards ();
    public List<RoleDATA> getRoles();
}
