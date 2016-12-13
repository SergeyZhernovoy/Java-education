package ru.szhernovoy.controllers;

import org.junit.Assert;
import org.junit.Test;
import ru.szhernovoy.model.DBManager;
import ru.szhernovoy.model.Role;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by admin on 13.12.2016.
 */
public class RoleCreateTest {
    @Test
    public void addRole() throws ServletException, IOException {
        RoleCreate roleController = new RoleCreate();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        roleController.doPost(request,response);
        when(request.getParameter("name")).thenReturn("full_rights");
        List<Role> roles = DBManager.instance().getRoles();
        Assert.assertThat(roles.get(1).getName(),is("full_rights"));
    }
}