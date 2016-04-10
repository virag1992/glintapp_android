package app.glintcarwash.com.glintapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class OrderActivity extends Fragment implements View.OnClickListener {
    ImageView imgCar,imgOrder;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_order,container,false);
        imgOrder = (ImageView) v.findViewById(R.id.imgOrder);
        imgCar = (ImageView) v.findViewById(R.id.imgCar);
        imgOrder.setOnClickListener(this);
        imgCar.setOnClickListener(this);
        return v;
    }


    @Override
    public void onClick(View v) {
        if(v==imgCar){
            Intent color_picker = new Intent(getActivity(), BookOrderActivity.class);
            startActivity(color_picker);
        }else if(v==imgOrder){
            Intent color_picker = new Intent(getActivity(), BookOrderActivity.class);
            startActivity(color_picker);
        }
    }
}
