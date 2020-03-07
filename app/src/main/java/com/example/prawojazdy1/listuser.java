package com.example.prawojazdy1;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class listuser extends ArrayAdapter<user> {
    private Activity context;
    private List <user> useerList;

    public listuser(Activity context, List<user> useerList){

        super(context, R.layout.statyst, useerList);
        this.context= context;
        this.useerList= useerList;

    }

    @NonNull
    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.statyst, null, true);
        TextView textName = (TextView) listViewItem.findViewById((R.id.textname));
        TextView textkat = (TextView) listViewItem.findViewById(R.id.textkat);
        TextView textwynik = (TextView) listViewItem.findViewById(R.id.textwynik);

        user userr = useerList.get(position);

        textName.setText(userr.getName());
        textkat.setText("Kategoria: "+userr.getKategoria());
        int wynik = userr.getWynik();

        textwynik.setText("Pkt:  "+ wynik);
        return listViewItem;
    }
}
