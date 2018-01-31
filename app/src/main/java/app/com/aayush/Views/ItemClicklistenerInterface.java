package app.com.aayush.Views;

import android.view.View;

/**
 * Created by Stan on 12/28/2017.
 */

public interface ItemClicklistenerInterface {
    void onItemClick(View v, int position);
    void addItem(View v, int tag);
    void removeItem(int tag);
}
