package com.example.laizihan.startfornewlife.widgets;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * 创建时间：2016年05月25日 下午11:45
 * 创建人：赖梓瀚
 * 类名：BaseViewHolder
 * 用途：
 */
public class BaseViewHolder extends RecyclerView.ViewHolder {

    private OnItemClickListener mOnItemClickListener;

    public static interface OnItemClickListener {
        void onItemClick(int position, View view);
    }


    public void setOnItemClickListener(OnItemClickListener listener) {
        mOnItemClickListener = listener;
    }

    public BaseViewHolder(View itemView) {
        super(itemView);
        if (mOnItemClickListener != null) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onItemClick(getAdapterPosition(), v);
                }
            });
        }
    }













}
