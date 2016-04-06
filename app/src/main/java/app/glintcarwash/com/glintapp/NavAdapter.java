package app.glintcarwash.com.glintapp;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

/**
 * Created by root on 11/12/15.
 */
public class NavAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<NavDrawerItem> navDrawerItems;

    public NavAdapter(Context context, ArrayList<NavDrawerItem> navDrawerItems) {
        this.context = context;
        this.navDrawerItems = navDrawerItems;
    }

    @Override
    public int getCount() {
        return navDrawerItems.size();
    }

    @Override
    public Object getItem(int position) {
        return navDrawerItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.list_item, null);
        }

        ImageView imgIcon = (ImageView) convertView.findViewById(R.id.icon);
        TextView txtTitle = (TextView) convertView.findViewById(R.id.title);
        txtTitle.setText(navDrawerItems.get(position).getTitle());
        if (position == 0) {
            imgIcon.setVisibility(View.INVISIBLE);
            convertView.setBackgroundResource(R.drawable.list_selector);
            txtTitle.setTextColor(Color.parseColor("#848484"));
//            txtTitle.setTextSize(18);
//            txtTitle.setTypeface(null, Typeface.BOLD);
        } else {
            imgIcon.setVisibility(View.VISIBLE);
            convertView.setBackgroundResource(R.drawable.list_selector);
            txtTitle.setTextColor(Color.parseColor("#848484"));
//            txtTitle.setTextSize(15);
//            txtTitle.setTypeface(null, Typeface.NORMAL);
            imgIcon.setImageResource(navDrawerItems.get(position).getIcon());
        }

//        if (position == navDrawerItems.size() - 2) {
//            if (UserInfo.getUser() == null) {
//                txtTitle.setText("LOGIN");
//
//                Drawable upArrow;
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                    upArrow = context.getResources().getDrawable(R.drawable.login_ic, context.getTheme());
//                } else {
//                    upArrow = context.getResources().getDrawable(R.drawable.login_ic);
//                }
//                upArrow.setColorFilter(Color.parseColor("#33cc90"), PorterDuff.Mode.SRC_ATOP);
//
////                imgIcon.setImageResource(R.drawable.login_ic);
//                imgIcon.setImageDrawable(upArrow);
//            } else {
//                txtTitle.setText("LOGOUT");
//
//                Drawable upArrow;
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                    upArrow = context.getResources().getDrawable(R.drawable.logout, context.getTheme());
//                } else {
//                    upArrow = context.getResources().getDrawable(R.drawable.logout);
//                }
//                upArrow.setColorFilter(Color.parseColor("#33cc90"), PorterDuff.Mode.SRC_ATOP);
//
////                imgIcon.setImageResource(R.drawable.login_ic);
//                imgIcon.setImageDrawable(upArrow);
//
////                imgIcon.setImageResource(R.drawable.logout);
//            }
//        } else {
//            txtTitle.setText(navDrawerItems.get(position).getTitle().toUpperCase());
//        }
//        if (position == navDrawerItems.size() - 1) {
//            imgIcon.setVisibility(View.GONE);
//            txtTitle.setVisibility(View.GONE);
//        }

        return convertView;
    }
}
