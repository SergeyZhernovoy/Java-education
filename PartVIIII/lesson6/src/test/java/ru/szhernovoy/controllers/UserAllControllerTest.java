package ru.szhernovoy.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import ru.szhernovoy.model.DBManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by dort on 15.12.16.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(DBManager.class)
public class UserAllControllerTest {
    @Mock HttpServletRequest request;
    @Mock HttpServletResponse response;
    @Mock RequestDispatcher dispatcher;
    @Mock DBManager manager;
    @Mock HttpSession session;

    @Before
    public void init(){
        PowerMockito.mockStatic(DBManager.class);
        PowerMockito.when(DBManager.newInstance()).thenReturn(manager);
        //PowerMockito.mockStatic(HttpSession.class);
    }

    @Test
    public void whenRootCreateUserWeShouldGetNewUser() throws ServletException, IOException {
        UserCreate roleController = new UserCreate();
        when(request.getParameter("name")).thenReturn("full_rights");
        when(request.getParameter("root")).thenReturn("root");
        when(request.getParameter("role")).thenReturn("1");
        when(request.getRequestDispatcher("/WEB-INF/views/Create.jsp")).thenReturn(dispatcher);
        PowerMockito.when(manager.addUser(any())).thenReturn(true);
        roleController.doPost(request,response);
        verify(request,atLeastOnce()).getParameter("name");
    }

    @Test
    public void whenRootUpdateUserWeShouldUpdateUser() throws ServletException, IOException {
        UserUpdate roleController = new UserUpdate();
        when(request.getParameter("name")).thenReturn("full_rights");
        when(request.getParameter("root")).thenReturn("root");
        when(request.getParameter("role")).thenReturn("1");
        when(request.getSession(false)).thenReturn(session);
        when(session.getAttribute("root")).thenReturn(true);

        when(request.getRequestDispatcher("/WEB-INF/views/Update.jsp")).thenReturn(dispatcher);
        roleController.doPost(request,response);
        verify(request,atLeastOnce()).getParameter("name");
    }

    @Test
    public void whenRootDeleteUserThenItDelete() throws ServletException, IOException {
        UserDelete roleController = new UserDelete();
        when(request.getParameter("name")).thenReturn("full_rights");
        when(request.getParameter("root")).thenReturn("root");
        when(request.getRequestDispatcher("/WEB-INF/views/Delete.jsp")).thenReturn(dispatcher);
        roleController.doPost(request,response);
        verify(request,atLeastOnce()).getParameter("name");
    }


}