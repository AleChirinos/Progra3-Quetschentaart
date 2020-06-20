package com.alejandrachirinos.therealcupid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.alejandrachirinos.therealcupid.R;
import com.alejandrachirinos.therealcupid.model.User;

import java.util.List;

public class ContactsAdapter extends BaseAdapter {
    private Context context;
    private List<User> items;

    public ContactsAdapter(Context context, List<User> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return items.get(position).getUniversityCode();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {

            viewHolder = new ViewHolder();

            //Mostrar el layout
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.contact_layout, null);

            //Vincular los objetos con los IDs
            viewHolder.nameTextView = view.findViewById(R.id.nameTextView);
            viewHolder.careerTextView = view.findViewById(R.id.careerTextView);
            viewHolder.ageTextView = view.findViewById(R.id.ageTextView);
            viewHolder.profileImageView = view.findViewById(R.id.photo_contact);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag(); //Obtenemos el dato reciclado
        }

        //Sí o sí tenemos una vista, ya sea reciclada o nueva
        User user = this.items.get(position);
        viewHolder.nameTextView.setText(user.getName());
        viewHolder.careerTextView.setText(user.getCareer());
        viewHolder.ageTextView.setText((user.getAge()+""));
        viewHolder.profileImageView.setImageResource(user.getImage());
        return view;
    }
    static class ViewHolder {
        TextView nameTextView;
        TextView careerTextView;
        TextView ageTextView;
        ImageView profileImageView;
    }
}
