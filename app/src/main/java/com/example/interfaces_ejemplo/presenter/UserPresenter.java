package com.example.interfaces_ejemplo.presenter;

import com.example.interfaces_ejemplo.model.User;
import com.example.interfaces_ejemplo.view.UserView;

import java.util.ArrayList;

public class UserPresenter {

    private UserView userView;
    private ArrayList<User> usuariosBaseDatos;

    public UserPresenter(UserView userView) {

        this.userView = userView;
        this.usuariosBaseDatos = new ArrayList<>();

    }

    public void consultarUsuarios() {
        usuariosBaseDatos.add(new User("Peter", "peter@gmail.com", "1234", ""));
        usuariosBaseDatos.add(new User("John", "john@gmail.com", "1234", ""));
        usuariosBaseDatos.add(new User("Mary", "mary@gmail.com", "1234", ""));
        usuariosBaseDatos.add(new User("Jane", "jane@gmail.com", "1234", ""));
        usuariosBaseDatos.add(new User("Bob", "bob@gmail.com", "1234", ""));
        usuariosBaseDatos.add(new User("Alice", "alice@gmail.com", "1234", ""));
        usuariosBaseDatos.add(new User("Tom", "tom@gmail.com", "1234", ""));
        usuariosBaseDatos.add(new User("Jerry", "jerry@gmail.com", "1234", ""));

        userView.listarUsuarios(usuariosBaseDatos);
    }

    public void crearUsuario(User user) {
        userView.agregarUsuarioALista(user);
    }

    public void eliminarUsuario(User user) {
        userView.eliminarUsuarioLista(user);
    }
}
