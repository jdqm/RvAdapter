package com.jdqm.rvadapter;

import android.content.res.Resources;

/**
 * Created by Jdqm on 2018-6-14.
 */
public class DisplayUtil {
    public static int dpToPixel(float dpValue) {
        return (int) (Resources.getSystem().getDisplayMetrics().density * dpValue);
    }

    public static int spToPixel(float spValue) {
        return (int) (Resources.getSystem().getDisplayMetrics().density * spValue);
    }
}
