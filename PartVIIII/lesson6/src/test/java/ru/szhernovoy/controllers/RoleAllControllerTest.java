package ru.szhernovoy.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;

import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import ru.szhernovoy.model.DBManager;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.*;


/**
 * Created by admin on 13.12.2016.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(DBManager.class)
public class RoleAllControllerTest {

    @Mock HttpServletRequest request;
    @Mock HttpServletResponse response;
    @Mock RequestDispatcher dispatcher;
    @Mock DBManager manager;

    @Before
    public void init(){
        PowerMockito.mockStatic(DBManager.class);
        PowerMockito.when(DBManager.newInstance()).thenReturn(manager);
    }

    @Test
    public void whenRootCreateRoleWeShouldGetNewRole() throws ServletException, IOException {
        RoleCreate roleController = new RoleCreate();
        when(request.getParameter("name")).thenReturn("full_rights");
        when(request.getParameter("root")).thenReturn("root");
        when(request.getRequestDispatcher("/WEB-INF/views/CreateRole.jsp")).thenReturn(dispatcher);
        PowerMockito.when(manager.addRole(any())).thenReturn(true);
        roleController.doPost(request,response);
        verify(request,atLeastOnce()).getParameter("name");
    }

    @Test
    public void whenRootUpdateRoleWeShouldUpdateRole() throws ServletException, IOException {
        RoleUpdate roleController = new RoleUpdate();
        when(request.getParameter("name")).thenReturn("full_rights");
        when(request.getParameter("root")).thenReturn("root");
        when(request.getRequestDispatcher("/WEB-INF/views/UpdateRole.jsp")).thenReturn(dispatcher);
        roleController.doPost(request,response);
        verify(request,atLeastOnce()).getParameter("name");
    }

    @Test
    public void whenRootDeleteThenItDelete() throws ServletException, IOException {
        RoleDelete roleController = new RoleDelete();
        when(request.getParameter("name")).thenReturn("full_rights");
        when(request.getParameter("root")).thenReturn("root");
        when(request.getRequestDispatcher("/WEB-INF/views/DeleteRole.jsp")).thenReturn(dispatcher);
        roleController.doPost(request,response);
        verify(request,atLeastOnce()).getParameter("name");
    }

}