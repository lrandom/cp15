package vn.niit.demosqlite.notes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

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

        ImageButton menu = v.findViewById(R.id.btnMenu);
        menu.setTag(position);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createMenu(getContext(), v);
            }
        });

        return v;
    }

    void createMenu(Context context,View v){
        final int position = (int)v.getTag();
       PopupMenu popupMenu = new PopupMenu(context,v);
       popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
           @Override
           public boolean onMenuItemClick(MenuItem item) {
               switch (item.getItemId()){
                   case R.id.delete:

                       Note note = NoteAdapter.this.notes.get(position);
                       Toast.makeText(getContext(),"Are you want delete "+note.getContent(),Toast.LENGTH_SHORT).show();
                       break;
               }
               return false;
           }
       });
       popupMenu.inflate(R.menu.popup_list_menu);
       popupMenu.show();
    }
}
