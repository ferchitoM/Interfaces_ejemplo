package com.example.interfaces_ejemplo;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.interfaces_ejemplo.model.User;
import com.example.interfaces_ejemplo.presenter.UserPresenter;
import com.example.interfaces_ejemplo.view.UserView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements UserView {

    User user;

    UserPresenter userPresenter;
    ArrayList<String> listaUsuarios;
    Button botonCrear;
    Button botonEliminar;
    EditText nombre;
    TextView itemSeleccionado;
    ListView lista;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = new User();
        userPresenter = new UserPresenter((UserView) this);
        listaUsuarios = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaUsuarios);

        botonCrear = findViewById(R.id.botonCrear);
        botonEliminar = findViewById(R.id.botonEliminar);
        nombre = findViewById(R.id.nombre);
        itemSeleccionado = findViewById(R.id.itemSeleccionado);
        itemSeleccionado.setText("");

        lista = findViewById(R.id.lista);
        lista.setAdapter(adapter);

        userPresenter.consultarUsuarios();

        botonCrear.setOnClickListener(v -> {

            user.name = nombre.getText().toString();
            userPresenter.crearUsuario(user);
        });


        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                itemSeleccionado.setText(listaUsuarios.get(i));

                user = new User();
                user.name = listaUsuarios.get(i);
            }

        });

        botonEliminar.setOnClickListener(v -> {
            userPresenter.eliminarUsuario(user);
        });

    }

    @Override
    public void listarUsuarios(ArrayList<User> usuariosBaseDatos) {

        for (User user : usuariosBaseDatos) {
            listaUsuarios.add(user.name + " - " + user.email + " - " + user.password );
        }

        adapter.notifyDataSetChanged();
    }

    @Override
    public void agregarUsuarioALista(User user) {

        listaUsuarios.add(user.name + " - " + user.email + " - " + user.password);
        adapter.notifyDataSetChanged();

        Toast.makeText(this, "Nuevo usuario creado", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void eliminarUsuarioLista(User user) {

        for (int i = 0; i < listaUsuarios.size(); i++) {
            if(user.name == listaUsuarios.get(i)) listaUsuarios.remove(i);
        }
        adapter.notifyDataSetChanged();
        itemSeleccionado.setText("");

        Toast.makeText(this, "Nuevo usuario creado", Toast.LENGTH_SHORT).show();

    }
}