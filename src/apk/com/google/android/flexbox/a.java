package com.google.android.flexbox;

import android.view.View;
import java.util.List;

/* compiled from: FlexContainer */
interface a {
    int a(int i2, int i3, int i4);

    int a(View view);

    int a(View view, int i2, int i3);

    View a(int i2);

    void a(int i2, View view);

    void a(View view, int i2, int i3, c cVar);

    void a(c cVar);

    boolean a();

    int b(int i2, int i3, int i4);

    View b(int i2);

    int getAlignContent();

    int getAlignItems();

    int getFlexDirection();

    int getFlexItemCount();

    List<c> getFlexLinesInternal();

    int getFlexWrap();

    int getLargestMainSize();

    int getMaxLine();

    int getPaddingBottom();

    int getPaddingEnd();

    int getPaddingLeft();

    int getPaddingRight();

    int getPaddingStart();

    int getPaddingTop();

    int getSumOfCrossSize();

    void setFlexLines(List<c> list);
}
