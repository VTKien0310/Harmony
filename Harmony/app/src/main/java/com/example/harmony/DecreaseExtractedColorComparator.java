package com.example.harmony;

import java.util.Comparator;

public class DecreaseExtractedColorComparator implements Comparator<ExtractedColor> {
    /* used for sorting in decreasing order */
    @Override
    public int compare(ExtractedColor o1, ExtractedColor o2) {
        return o2.compareTo(o1);
    }
}
