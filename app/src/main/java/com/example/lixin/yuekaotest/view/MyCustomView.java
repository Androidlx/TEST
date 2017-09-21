package com.example.lixin.yuekaotest.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lixin.yuekaotest.R;

/**
 * Created by hua on 2017/9/21.
 */

public class MyCustomView extends LinearLayout {

    private TextView text_left;
    private TextView text_center;
    private ImageView img_right;
    private String left_btn_text;
    private float left_btn_text_size;
    private int left_btn_text_color;
    private String center_text_string;
    private float center_text_size;
    private int center_text_color;
    private int right_btn_img;

    public MyCustomView(Context context) {
        super(context);
        initView(context,null);
    }

    public MyCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context,attrs);
    }

    private void initView(Context context, AttributeSet attrs) {

        View inflate = inflate(context, R.layout.custom_view, this);
        text_left = inflate.findViewById(R.id.text_left);
        text_center = inflate.findViewById(R.id.text_center);
        img_right = inflate.findViewById(R.id.img_right);

        if (attrs==null){
            return;
        }

        initAttrs(context,attrs);
        setViewContext();
    }

    private void initAttrs(Context context, AttributeSet attrs) {
        if (attrs == null){
            return;
        }
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.MyCustomView);

        left_btn_text = typedArray.getString(R.styleable.MyCustomView_left_btn_text);
        left_btn_text_size = typedArray.getDimension(R.styleable.MyCustomView_left_btn_text_size, 18);
        left_btn_text_color = typedArray.getColor(R.styleable.MyCustomView_left_btn_text_color, 0x00ff00);

        center_text_string = typedArray.getString(R.styleable.MyCustomView_center_text);
        center_text_size = typedArray.getDimension(R.styleable.MyCustomView_center_text_size, 18);
        center_text_color = typedArray.getColor(R.styleable.MyCustomView_center_text_color, 0x000000);

        right_btn_img = typedArray.getResourceId(R.styleable.MyCustomView_right_btn_img, R.mipmap.ic_launcher);
    }

    private void setViewContext() {

        text_left.setText(left_btn_text);
        text_left.setTextColor(left_btn_text_color);
        text_left.setTextSize(left_btn_text_size);

        text_center.setText(center_text_string);
        text_center.setTextSize(center_text_size);
        text_center.setTextColor(center_text_color);

        img_right.setImageResource(right_btn_img);
    }

}
