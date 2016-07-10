package xyz.winthanhtike.travelandtour.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import at.blogc.android.views.ExpandableTextView;

/**
 * Created by winthanhtike on 6/30/16.
 */
public class CustomExpendableTextView extends ExpandableTextView {


    public CustomExpendableTextView(Context context) {
        super(context);

    }

    public CustomExpendableTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public CustomExpendableTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        super.setText(text, type);

        if (!isInEditMode()){
            MMFontUtils.setMMFont(this);
        }

    }
}

