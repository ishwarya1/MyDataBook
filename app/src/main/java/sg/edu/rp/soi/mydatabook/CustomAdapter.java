package sg.edu.rp.soi.mydatabook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<String> {
    Context c;
    int res;
    ArrayList<String> al;
    TextView tvItem;
    ImageView iv;

    public CustomAdapter(Context c, int res, ArrayList<String> al) {
        super(c, res, al);
        this.c = c;
        this.res = res;
        this.al = al;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        v = LayoutInflater.from(c).inflate(res, parent, false);
        tvItem = v.findViewById(R.id.tv3);
        iv = v.findViewById(R.id.iv2);
        tvItem.setText(al.get(position));
        if (position == 0) {
            iv.setImageResource(android.R.drawable.ic_dialog_info);
        } else if (position == 1) {
            iv.setImageResource(android.R.drawable.ic_menu_edit);
        } else if (position == 2) {
            iv.setImageResource(android.R.drawable.ic_menu_my_calendar);
        } else {
            iv.setImageResource(android.R.drawable.star_big_on);
        }
        return v;
    }
}
