package com.pebblescrow.skillsewaproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.pebblescrow.skillsewaproject.utils.ImageUtils;

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

    private class ViewHolder {
        ImageView imgViewFront, imgViewBack, imgViewPDD, imgViewVPF1A, imgViewVPF1B, imgViewVPF1C, imgViewVPF2A, imgViewVPF3A, imgViewVPF3B, imgViewVPF3C, imgViewVPF3D, imgViewVPF4A, imgViewVPF4B, imgViewVPF4C, imgViewVPF5A;
        TextView textViewLocation, textViewInspector, textViewDOI, textViewHN, txtViewVPFOD, txtViewVPFOF, txtViewVPFOR, txtViewVPFTD, txtViewVPFTF, txtViewVPFTR, txtViewVPFTHD, txtViewVPFTHF, txtViewVPFTHR, txtViewVPFFD, txtViewVPFFF, txtViewVPFFR, txtViewVPFFID, txtViewVPFFIF, txtViewVPFFIR;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder = new ViewHolder();

        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);
            holder.imgViewFront = (ImageView) row.findViewById(R.id.imgViewFront);
            holder.imgViewBack = (ImageView) row.findViewById(R.id.imgViewBack);
            holder.imgViewPDD = (ImageView) row.findViewById(R.id.imgViewPDD);
            holder.textViewLocation = (TextView) row.findViewById(R.id.txtViewLocation);
            holder.textViewInspector = (TextView) row.findViewById(R.id.txtViewInspector);
            holder.textViewDOI = (TextView) row.findViewById(R.id.txtViewDOI);
            holder.textViewHN = (TextView) row.findViewById(R.id.txtViewHN);


            //PF5

            holder.imgViewVPF5A = (ImageView) row.findViewById(R.id.imgViewVPF5A);
            holder.txtViewVPFFID = (TextView) row.findViewById(R.id.txtViewVPFFID);
            holder.txtViewVPFFIF = (TextView) row.findViewById(R.id.txtViewVPFFIF);
            holder.txtViewVPFFIR = (TextView) row.findViewById(R.id.txtViewVPFFIR);
            //PF4

            holder.imgViewVPF4A = (ImageView) row.findViewById(R.id.imgViewVPF4A);
            holder.imgViewVPF4B = (ImageView) row.findViewById(R.id.imgViewVPF4B);
            holder.imgViewVPF4C = (ImageView) row.findViewById(R.id.imgViewVPF4C);
            holder.txtViewVPFFD = (TextView) row.findViewById(R.id.txtViewVPFFD);
            holder.txtViewVPFFF = (TextView) row.findViewById(R.id.txtViewVPFFF);
            holder.txtViewVPFFR = (TextView) row.findViewById(R.id.txtViewVPFFR);


            //PF3

            holder.imgViewVPF3A = (ImageView) row.findViewById(R.id.imgViewVPF3A);
            holder.imgViewVPF3B = (ImageView) row.findViewById(R.id.imgViewVPF3B);
            holder.imgViewVPF3C = (ImageView) row.findViewById(R.id.imgViewVPF3C);
            holder.imgViewVPF3D = (ImageView) row.findViewById(R.id.imgViewVPF3D);
            holder.txtViewVPFTHD = (TextView) row.findViewById(R.id.txtViewVPFTHD);
            holder.txtViewVPFTHF = (TextView) row.findViewById(R.id.txtViewVPFTHF);
            holder.txtViewVPFTHR = (TextView) row.findViewById(R.id.txtViewVPFTHR);

            //PF2

            holder.imgViewVPF2A = (ImageView) row.findViewById(R.id.imgViewVPF2A);
            holder.txtViewVPFTD = (TextView) row.findViewById(R.id.txtViewVPFTD);
            holder.txtViewVPFTF = (TextView) row.findViewById(R.id.txtViewVPFTF);
            holder.txtViewVPFTR = (TextView) row.findViewById(R.id.txtViewVPFTR);
            //PF1

            holder.imgViewVPF1A = (ImageView) row.findViewById(R.id.imgViewVPF1A);
            holder.imgViewVPF1B = (ImageView) row.findViewById(R.id.imgViewVPF1B);
            holder.imgViewVPF1C = (ImageView) row.findViewById(R.id.imgViewVPF1C);
            holder.txtViewVPFOD = (TextView) row.findViewById(R.id.txtViewVPFOD);
            holder.txtViewVPFOF = (TextView) row.findViewById(R.id.txtViewVPFOF);
            holder.txtViewVPFOR = (TextView) row.findViewById(R.id.txtViewVPFOR);

            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }
        Elements elements = elementslist.get(position);
        String encodedFrontImage = elements.getFrontImageEncodedInBase64();
        Bitmap frontBitmap = ImageUtils.decodeFromBase64String(encodedFrontImage);
        String encodedBackImage = elements.getBackImageEncodedInBase64();
        holder.imgViewFront.setImageBitmap(frontBitmap);
        Bitmap backBitmap = ImageUtils.decodeFromBase64String(encodedBackImage);
        holder.imgViewBack.setImageBitmap(backBitmap);

        String encodedPDImage = elements.getPDImageEncodedInBase64();
        Bitmap PDBitmap = ImageUtils.decodeFromBase64String(encodedPDImage);
        holder.imgViewPDD.setImageBitmap(PDBitmap);

        holder.textViewLocation.setText(elements.getLocation());
        holder.textViewInspector.setText(elements.getInspector());
        holder.textViewDOI.setText(elements.getDOI());
        holder.textViewHN.setText(elements.getHouseName());

        //PF1
        String encodedPF1A = elements.getEncodedPF1A();
        Bitmap PF1ABitmap = ImageUtils.decodeFromBase64String(encodedPF1A);
        holder.imgViewVPF1A.setImageBitmap(PF1ABitmap);

        String encodedPF1B = elements.getEncodedPF1B();
        Bitmap PF1BBitmap = ImageUtils.decodeFromBase64String(encodedPF1B);
        holder.imgViewVPF1B.setImageBitmap(PF1BBitmap);

        String encodedPF1C = elements.getEncodedPF1C();
        Bitmap PF1CBitmap = ImageUtils.decodeFromBase64String(encodedPF1C);
        holder.imgViewVPF1C.setImageBitmap(PF1CBitmap);

        holder.txtViewVPFOD.setText(elements.getPFOD());
        holder.txtViewVPFOF.setText(elements.getPFOF());
        holder.txtViewVPFOR.setText(elements.getPFOR());

        //PF2
        String encodedPF2A = elements.getEncodedPF2A();
        Bitmap PF2ABitmap = ImageUtils.decodeFromBase64String(encodedPF2A);
        holder.imgViewVPF2A.setImageBitmap(PF2ABitmap);


        holder.txtViewVPFTD.setText(elements.getPFTD());
        holder.txtViewVPFTF.setText(elements.getPFTF());
        holder.txtViewVPFTR.setText(elements.getPFTR());

        //PF4

        String encodedPF4A = elements.getEncodedPF4A();
        Bitmap PF4ABitmap = ImageUtils.decodeFromBase64String(encodedPF4A);
        holder.imgViewVPF4A.setImageBitmap(PF4ABitmap);

        String encodedPF4B = elements.getEncodedPF4B();
        Bitmap PF4BBitmap = ImageUtils.decodeFromBase64String(encodedPF4B);
        holder.imgViewVPF4B.setImageBitmap(PF4BBitmap);

        String encodedPF4C = elements.getEncodedPF4C();
        Bitmap PF4CBitmap = ImageUtils.decodeFromBase64String(encodedPF4C);
        holder.imgViewVPF4C.setImageBitmap(PF4CBitmap);

        holder.txtViewVPFFD.setText(elements.getPFFD());
        holder.txtViewVPFFF.setText(elements.getPFFF());
        holder.txtViewVPFFR.setText(elements.getPFFR());

        //PF3
        String encodedPF3A = elements.getEncodedPF3A();
        Bitmap PF3ABitmap = ImageUtils.decodeFromBase64String(encodedPF3A);
        holder.imgViewVPF3A.setImageBitmap(PF3ABitmap);

        String encodedPF3B = elements.getEncodedPF3B();
        Bitmap PF3BBitmap = ImageUtils.decodeFromBase64String(encodedPF3B);
        holder.imgViewVPF3B.setImageBitmap(PF3BBitmap);

        String encodedPF3C = elements.getEncodedPF3C();
        Bitmap PF3CBitmap = ImageUtils.decodeFromBase64String(encodedPF3C);
        holder.imgViewVPF3C.setImageBitmap(PF3CBitmap);

        String enDodedPF3D = elements.getEncodedPF3D();
        Bitmap PF3DBitmap = ImageUtils.decodeFromBase64String(enDodedPF3D);
        holder.imgViewVPF3D.setImageBitmap(PF3DBitmap);

        holder.txtViewVPFTHD.setText(elements.getPFTHD());
        holder.txtViewVPFTHF.setText(elements.getPFTHF());
        holder.txtViewVPFTHR.setText(elements.getPFTHR());

        //PF5

        String encodedPF5A = elements.getEncodedPF5A();
        Bitmap PF5ABitmap = ImageUtils.decodeFromBase64String(encodedPF5A);
        holder.imgViewVPF5A.setImageBitmap(PF5ABitmap);


        holder.txtViewVPFFID.setText(elements.getPFFID());
        holder.txtViewVPFFIF.setText(elements.getPFFIF());
        holder.txtViewVPFFIR.setText(elements.getPFFIR());


        return row;
    }
}
