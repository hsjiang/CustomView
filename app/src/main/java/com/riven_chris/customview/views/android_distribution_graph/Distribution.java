package com.riven_chris.customview.views.android_distribution_graph;

import android.graphics.Color;

/**
 * Created by riven_chris on 2018/2/2.
 */

public enum Distribution {

    GINGER_BREAD("G", 0.09f, Color.rgb(205, 220, 57)),
    ICS("ICS", 0.4f, Color.rgb(195, 211, 218)),
    JELLY_BEAN("JB", 4.09f, Color.rgb(86, 71, 101)),
    KITKAT("K", 12.67f, Color.rgb(44, 186, 221)),
    LOLLIPOP("L", 21.07f, Color.rgb(223, 245, 134)),
    MARSHMALLOW("M", 27.14f, Color.rgb(255, 161, 20)),
    NOUGAT("N", 32.59f, Color.rgb(18, 111, 126)),
    OREO("O", 1.93f, Color.rgb(153, 183, 31));

    private String key;
    private float value;
    private int color;

    Distribution(String key, float value, int color) {
        this.key = key;
        this.value = value;
        this.color = color;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
