package com.example.newharmony;

import java.util.Comparator;

public class DecreaseExtractedColorComparator implements Comparator<MyColor> {
    /* used for sorting in decreasing order */
    @Override
    public int compare(MyColor o1, MyColor o2) {
        return o2.compareTo(o1);
    }
}
