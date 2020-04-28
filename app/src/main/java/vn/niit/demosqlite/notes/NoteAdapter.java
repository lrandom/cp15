package vn.niit.demosqlite.notes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;

import vn.niit.demosqlite.R;

public class NoteAdapter extends ArrayAdapter<Note> {
    ArrayList<Note> notes;
    Context context;
    public NoteAdapter(@NonNull Context context, int resource, ArrayList<Note>notes) {
        super(context, resource, notes);
        this.notes = notes;
        this.context  = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if(v==null){
            v = LayoutInflater.from(context).inflate(R.layout.item_note,parent,false);
        }
        TextView tvContent =(TextView) v.findViewById(R.id.txtNote);
        tvContent.setText(this.notes.get(position).getContent());
        return v;
    }
}
