package androidx.appcompat.widget;

import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: ResourcesWrapper */
class V extends Resources {

    /* renamed from: a reason: collision with root package name */
    private final Resources f903a;

    public V(Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f903a = resources;
    }

    public XmlResourceParser getAnimation(int i2) throws NotFoundException {
        return this.f903a.getAnimation(i2);
    }

    public boolean getBoolean(int i2) throws NotFoundException {
        return this.f903a.getBoolean(i2);
    }

    public int getColor(int i2) throws NotFoundException {
        return this.f903a.getColor(i2);
    }

    public ColorStateList getColorStateList(int i2) throws NotFoundException {
        return this.f903a.getColorStateList(i2);
    }

    public Configuration getConfiguration() {
        return this.f903a.getConfiguration();
    }

    public float getDimension(int i2) throws NotFoundException {
        return this.f903a.getDimension(i2);
    }

    public int getDimensionPixelOffset(int i2) throws NotFoundException {
        return this.f903a.getDimensionPixelOffset(i2);
    }

    public int getDimensionPixelSize(int i2) throws NotFoundException {
        return this.f903a.getDimensionPixelSize(i2);
    }

    public DisplayMetrics getDisplayMetrics() {
        return this.f903a.getDisplayMetrics();
    }

    public Drawable getDrawable(int i2) throws NotFoundException {
        return this.f903a.getDrawable(i2);
    }

    public Drawable getDrawableForDensity(int i2, int i3) throws NotFoundException {
        return this.f903a.getDrawableForDensity(i2, i3);
    }

    public float getFraction(int i2, int i3, int i4) {
        return this.f903a.getFraction(i2, i3, i4);
    }

    public int getIdentifier(String str, String str2, String str3) {
        return this.f903a.getIdentifier(str, str2, str3);
    }

    public int[] getIntArray(int i2) throws NotFoundException {
        return this.f903a.getIntArray(i2);
    }

    public int getInteger(int i2) throws NotFoundException {
        return this.f903a.getInteger(i2);
    }

    public XmlResourceParser getLayout(int i2) throws NotFoundException {
        return this.f903a.getLayout(i2);
    }

    public Movie getMovie(int i2) throws NotFoundException {
        return this.f903a.getMovie(i2);
    }

    public String getQuantityString(int i2, int i3, Object... objArr) throws NotFoundException {
        return this.f903a.getQuantityString(i2, i3, objArr);
    }

    public CharSequence getQuantityText(int i2, int i3) throws NotFoundException {
        return this.f903a.getQuantityText(i2, i3);
    }

    public String getResourceEntryName(int i2) throws NotFoundException {
        return this.f903a.getResourceEntryName(i2);
    }

    public String getResourceName(int i2) throws NotFoundException {
        return this.f903a.getResourceName(i2);
    }

    public String getResourcePackageName(int i2) throws NotFoundException {
        return this.f903a.getResourcePackageName(i2);
    }

    public String getResourceTypeName(int i2) throws NotFoundException {
        return this.f903a.getResourceTypeName(i2);
    }

    public String getString(int i2) throws NotFoundException {
        return this.f903a.getString(i2);
    }

    public String[] getStringArray(int i2) throws NotFoundException {
        return this.f903a.getStringArray(i2);
    }

    public CharSequence getText(int i2) throws NotFoundException {
        return this.f903a.getText(i2);
    }

    public CharSequence[] getTextArray(int i2) throws NotFoundException {
        return this.f903a.getTextArray(i2);
    }

    public void getValue(int i2, TypedValue typedValue, boolean z) throws NotFoundException {
        this.f903a.getValue(i2, typedValue, z);
    }

    public void getValueForDensity(int i2, int i3, TypedValue typedValue, boolean z) throws NotFoundException {
        this.f903a.getValueForDensity(i2, i3, typedValue, z);
    }

    public XmlResourceParser getXml(int i2) throws NotFoundException {
        return this.f903a.getXml(i2);
    }

    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return this.f903a.obtainAttributes(attributeSet, iArr);
    }

    public TypedArray obtainTypedArray(int i2) throws NotFoundException {
        return this.f903a.obtainTypedArray(i2);
    }

    public InputStream openRawResource(int i2) throws NotFoundException {
        return this.f903a.openRawResource(i2);
    }

    public AssetFileDescriptor openRawResourceFd(int i2) throws NotFoundException {
        return this.f903a.openRawResourceFd(i2);
    }

    public void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) throws XmlPullParserException {
        this.f903a.parseBundleExtra(str, attributeSet, bundle);
    }

    public void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) throws XmlPullParserException, IOException {
        this.f903a.parseBundleExtras(xmlResourceParser, bundle);
    }

    public void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
        Resources resources = this.f903a;
        if (resources != null) {
            resources.updateConfiguration(configuration, displayMetrics);
        }
    }

    public Drawable getDrawable(int i2, Theme theme) throws NotFoundException {
        return this.f903a.getDrawable(i2, theme);
    }

    public Drawable getDrawableForDensity(int i2, int i3, Theme theme) {
        return this.f903a.getDrawableForDensity(i2, i3, theme);
    }

    public String getQuantityString(int i2, int i3) throws NotFoundException {
        return this.f903a.getQuantityString(i2, i3);
    }

    public String getString(int i2, Object... objArr) throws NotFoundException {
        return this.f903a.getString(i2, objArr);
    }

    public CharSequence getText(int i2, CharSequence charSequence) {
        return this.f903a.getText(i2, charSequence);
    }

    public void getValue(String str, TypedValue typedValue, boolean z) throws NotFoundException {
        this.f903a.getValue(str, typedValue, z);
    }

    public InputStream openRawResource(int i2, TypedValue typedValue) throws NotFoundException {
        return this.f903a.openRawResource(i2, typedValue);
    }
}
