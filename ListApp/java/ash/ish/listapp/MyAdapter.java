package ash.ish.listapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Ashish.Sadhwani on 13-02-2015.
 */
public class MyAdapter extends BaseAdapter {

    private Context mContext;
    private Object[] menuItems;
    private int mLayout;
    private LayoutInflater inflater;

    public MyAdapter(Context context, int layout, Object[] myListItems){
        mContext = context;
        mLayout = layout;
        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        menuItems = myListItems;
    }
    @Override
    public int getCount() {
        return menuItems.length;
    }

    @Override
    public Object getItem(int position) {
        return menuItems[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(mLayout, parent, false);
        }
        TextView mListText = (TextView) convertView.findViewById(R.id.list_text);
        mListText.setText((CharSequence) menuItems[position]);
        return convertView;
    }
}
