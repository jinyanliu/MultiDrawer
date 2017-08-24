package se.sugarest.jane.multidrawer;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by jane on 17-8-24.
 */

public class CustomAdapter extends BaseAdapter {

    String mResult[];
    Context mContext;
    int img[];

    private static LayoutInflater mInflater = null;

    public CustomAdapter(String[] mResult, Context mContext, int[] img) {
        this.mResult = mResult;
        this.mContext = mContext;
        this.img = img;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mResult.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Holder holder = new Holder();
        View rootView;
        rootView = mInflater.inflate(R.layout.list_gridview, null);
        holder.tv = (TextView) rootView.findViewById(R.id.tv_hello_world);
        holder.iv = (ImageView) rootView.findViewById(R.id.iv_five);
        holder.tv.setText(mResult[position]);
        holder.iv.setImageResource(img[position]);
        holder.tv.setTextColor(Color.BLUE);
        return rootView;
    }

    public class Holder {
        TextView tv;
        ImageView iv;
    }


}
