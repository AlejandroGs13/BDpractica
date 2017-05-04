package com.example.alejandrogs.bdpractica;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private AdminSQLiteOpenHelper bd;
    private EditText eclave,edesc,eprecio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eclave = (EditText)findViewById(R.id.edit_clave);
        edesc = (EditText)findViewById(R.id.edit_des);
        eprecio = (EditText)findViewById(R.id.edit_precio);
        bd = new AdminSQLiteOpenHelper(this);
    }


    public void Alta(View view) {
        String clave,desc,precio;
        clave = String.valueOf(eclave.getText());
        desc = String.valueOf(edesc.getText());
        precio = String.valueOf(eprecio.getText());
        bd.addproducto(clave,desc,precio,view);
        limpiar();
    }

    public void consultaporclave(View view) {
        String clave,desc,precio;
        clave = String.valueOf(eclave.getText());
        desc = String.valueOf(edesc.getText());
        precio = String.valueOf(eprecio.getText());
        edesc.setText(bd.getForClaveDesc(clave,view));
        eprecio.setText(bd.getForClavePrecio(clave,view));

    }

    public void consultapordes(View view) {
        String clave,desc,precio;
        clave = String.valueOf(eclave.getText());
        desc = String.valueOf(edesc.getText());
        precio = String.valueOf(eprecio.getText());
        eclave.setText(bd.getForDesClave(desc,view));
        eprecio.setText(bd.getForDesPrecio(desc,view));
    }

    public void eliminar(View view) {
        String clave,desc,precio;
        clave = String.valueOf(eclave.getText());
        desc = String.valueOf(edesc.getText());
        precio = String.valueOf(eprecio.getText());
        bd.DeleteProduc(clave);
        limpiar();
    }

    public void modificar(View view) {
        String clave,desc,precio;
        clave = String.valueOf(eclave.getText());
        desc = String.valueOf(edesc.getText());
        precio = String.valueOf(eprecio.getText());
        bd.updateDesProduc(clave,desc,precio,view);
        bd.updatePrecioProduc(clave,desc,precio,view);
        limpiar();
    }


    public void limpiar(){
        eclave.setText("");
        eprecio.setText("");
        edesc.setText("");
    }
}
