package com.example.interfaces_ejemplo.view;

import com.example.interfaces_ejemplo.model.User;
import java.util.ArrayList;

public interface UserView {

    public void listarUsuarios(ArrayList<User> usuariosBaseDatos);
    public void agregarUsuarioALista(User user);
    public void eliminarUsuarioLista(User user);

}
