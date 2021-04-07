package com.pebblescrow.skillsewaproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ElementsListAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<Elements> elementslist;

    public ElementsListAdapter(Context context, int layout, ArrayList<Elements> elementslist) {
        this.context = context;
        this.layout = layout;
        this.elementslist = elementslist;
    }

    @Override
    public int getCount() {
        return elementslist.size();
    }

    @Override
    public Object getItem(int position) {
        return elementslist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{
        ImageView imageView,imgViewProblemFinding;
        TextView textViewLocation, textViewCity, textViewInspector, textViewDOI, textViewHN;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder = new ViewHolder();

        if (row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);
            holder.imageView = (ImageView) row.findViewById(R.id.imgViewFront);
            holder.textViewLocation = (TextView) row.findViewById(R.id.txtViewLocation);
            holder.textViewCity = (TextView) row.findViewById(R.id.txtViewCity);
            holder.textViewInspector = (TextView) row.findViewById(R.id.txtViewInspector);
            holder.textViewDOI = (TextView) row.findViewById(R.id.txtViewDOI);
            holder.textViewHN = (TextView)  row.findViewById(R.id.txtViewHN);
            holder.imgViewProblemFinding = (ImageView) row.findViewById(R.id.imgViewProblemFinding);

            row.setTag(holder);
        }
        else {
            holder = (ViewHolder) row.getTag();
        }
        Elements elements = elementslist.get(position);
        byte[] elementImage = elements.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(elementImage,0,elementImage.length);
        holder.imageView.setImageBitmap(bitmap);

        holder.textViewLocation.setText(elements.getLocation());
        holder.textViewCity.setText(elements.getCity());
        holder.textViewInspector.setText(elements.getInspector());
        holder.textViewDOI.setText(elements.getDOI());
        holder.textViewHN.setText(elements.getHouseName());
        holder.imgViewProblemFinding.setImageBitmap(bitmap);


        return row;
    }
}
