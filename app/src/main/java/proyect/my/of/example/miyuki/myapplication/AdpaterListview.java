package proyect.my.of.example.miyuki.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by Hazexirs on 02/04/2018.
 */

public class AdpaterListview extends BaseAdapter {

    ArrayList<String> arrayList;
    ArrayList<String> arrayListTEMP;
    Context context;
    LayoutInflater layoutInflater;


    public AdpaterListview(ArrayList<String> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.arrayListTEMP = new ArrayList<String>();
        arrayListTEMP.addAll(arrayList);


    }



    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {


        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ViewHolder holder;


        if (convertView == null) {
            holder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.listview_item, null);
            holder.textViewITEM = convertView.findViewById(R.id.textViewid);
            convertView.setTag(holder);
        } else {

            holder = (ViewHolder) convertView.getTag();
        }
        holder.textViewITEM.setText(arrayList.get(position));

        return convertView;

    }


    public class ViewHolder {

        TextView textViewITEM;
    }


    public void filter(String charText) {

        charText = charText.toLowerCase(Locale.getDefault());
        arrayList.clear();

        if(charText.length()==0){
            arrayList.addAll(arrayListTEMP);

        }
        else{
            for( String StringTemp :arrayListTEMP){
                if(StringTemp.toLowerCase(Locale.getDefault()).contains(charText)){
                    arrayList.add(StringTemp);
                }
            }

        }
        notifyDataSetChanged();
    }
}
