package com.example.kotlincard_footer;

import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;


    public class VerticalSpaceItemDecoration extends RecyclerView.ItemDecoration {
        private int space;

        public VerticalSpaceItemDecoration(int space) {
            this.space = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            outRect.left = space;
            outRect.right = space;
            outRect.bottom = space;

            // Add top margin only for the first item to avoid double space between items
            if(parent.getChildAdapterPosition(view) == 0) {
                outRect.top = space;
            }
        }
    }
