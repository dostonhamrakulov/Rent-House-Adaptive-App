package rtu.group.adaptive.renthouse;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;



public class HousesAdapter extends ArrayAdapter {

    List list = new ArrayList();
    public HousesAdapter(@NonNull Context context, int resource) {
        super(context, resource);

    }

    public void add(Houses houses){
        list.add(houses);
        super.add(houses);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {

        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;

        HouseHolder houseHolder;
        if (view == null){
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.list_houses, parent, false);

            houseHolder = new HouseHolder();

            houseHolder.empty = view.findViewById(R.id.textView0);

            houseHolder.id = view.findViewById(R.id.textView1);
            houseHolder.city = view.findViewById(R.id.textView2);
            houseHolder.num_rooms = view.findViewById(R.id.textView3);
            houseHolder.price = view.findViewById(R.id.textView4);
            houseHolder.period = view.findViewById(R.id.textView5);
            houseHolder.floor = view.findViewById(R.id.textView6);
            houseHolder.address = view.findViewById(R.id.textView7);
            houseHolder.phone = view.findViewById(R.id.textView8);


            view.setTag(houseHolder);


        } else {
            houseHolder = (HouseHolder) view.getTag();
        }

        Houses houses = (Houses)getItem(position);
        houseHolder.id.setText("ID: " + houses.getID());
        houseHolder.city.setText("City: " + houses.getCity());
        houseHolder.num_rooms.setText("Number of rooms: " + houses.getNum_rooms());
        houseHolder.price.setText("Price: " + houses.getPrice() + " euro");
        houseHolder.period.setText("Period price: " + houses.getPeriod() + " months");
        houseHolder.floor.setText("Floor: " + houses.getFloor());
        houseHolder.address.setText("Adress: " + houses.getAddress());
        houseHolder.phone.setText("Phone: " + houses.getPhone());
        houseHolder.empty.setText("---- House -----");

        return view;
    }

    static class HouseHolder
    {
        TextView id, city, num_rooms, price, period, floor, empty, address, phone;
    }
}
