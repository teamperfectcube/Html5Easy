package com.itsgaurav.html5easy.adapters;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itsgaurav.html5easy.R;
import com.itsgaurav.html5easy.activities.HTMLAudioActivity;
import com.itsgaurav.html5easy.activities.HTMLCanvasActivity;
import com.itsgaurav.html5easy.activities.HTMLDragAndDropActivity;
import com.itsgaurav.html5easy.activities.HTMLElementsActivity;
import com.itsgaurav.html5easy.activities.HTMLGeoLocationActivity;
import com.itsgaurav.html5easy.activities.HTMLIntroductionActivity;
import com.itsgaurav.html5easy.activities.HTMLSseActivity;
import com.itsgaurav.html5easy.activities.HTMLSvgActivity;
import com.itsgaurav.html5easy.activities.HTMLVideoActivity;
import com.itsgaurav.html5easy.activities.HTMLWebStorageActivity;
import com.itsgaurav.html5easy.activities.HTMLWebWorkersActivity;
import com.itsgaurav.html5easy.models.MainModel;

import java.util.List;

/**
 * Adapter class for providing data binding for MainActivity recyclerView.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ItemViewHolder> {

    List<MainModel> mDataList;
    FragmentActivity mContext;

    /**
     * Required constructor.
     *
     * @param mDataList List of main data.
     * @param mContext  Context to use.
     */
    public MainAdapter(List<MainModel> mDataList, FragmentActivity mContext) {
        this.mDataList = mDataList;
        this.mContext = mContext;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_main, parent, false));
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        MainModel data = mDataList.get(position);
        //Set item title text
        holder.textTitle.setText(data.getTitleText());
        // item click functionality
        itemOnClick(holder.itemView, data.getPosition());
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    /**
     * CLick functionality of item to launch appropriate activity.
     *
     * @param view     View to be clicked.
     * @param position Item position value.
     */
    private void itemOnClick(View view, final int position) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passToSelectedItemScreen(position);
            }
        });
    }


    /**
     * Method to launch the corresponding activity on item click.
     *
     * @param i Position of item.
     */
    private void passToSelectedItemScreen(int i) {
        Intent localIntent = new Intent();
        switch (i) {
            case 0:
                localIntent.setClass(mContext, HTMLIntroductionActivity.class);
                mContext.startActivity(localIntent);
                break;
            case 1:
                localIntent.setClass(mContext, HTMLElementsActivity.class);
                mContext.startActivity(localIntent);
                break;
            case 2:
                localIntent.setClass(mContext, HTMLVideoActivity.class);
                mContext.startActivity(localIntent);
                break;
            case 3:
                localIntent.setClass(mContext, HTMLAudioActivity.class);
                mContext.startActivity(localIntent);
                break;
            case 4:
                localIntent.setClass(mContext, HTMLDragAndDropActivity.class);
                mContext.startActivity(localIntent);
                break;
            case 5:
                localIntent.setClass(mContext, HTMLCanvasActivity.class);
                mContext.startActivity(localIntent);
                break;
            case 6:
                localIntent.setClass(mContext, HTMLSvgActivity.class);
                mContext.startActivity(localIntent);
                break;
            case 7:
                localIntent.setClass(mContext, HTMLGeoLocationActivity.class);
                mContext.startActivity(localIntent);
                break;
            case 8:
                localIntent.setClass(mContext, HTMLWebStorageActivity.class);
                mContext.startActivity(localIntent);
                break;
            case 9:
                localIntent.setClass(mContext, HTMLWebWorkersActivity.class);
                mContext.startActivity(localIntent);
                break;
            case 10:
                localIntent.setClass(mContext, HTMLSseActivity.class);
                mContext.startActivity(localIntent);
                break;
            default:
                break;
        }
    }

    //View holder class
    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        AppCompatTextView textTitle;

        public ItemViewHolder(View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.textTitle);
        }
    }


}
