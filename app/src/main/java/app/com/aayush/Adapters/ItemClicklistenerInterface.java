package app.com.aayush.Adapters;

import android.view.View;

/**
 * Created by Stan on 1/31/2018.
 */


public interface ItemClicklistenerInterface {
        void onItemClick(View v, int position);
        void addItem(View v, int tag);
        void removeItem(int tag);

}
