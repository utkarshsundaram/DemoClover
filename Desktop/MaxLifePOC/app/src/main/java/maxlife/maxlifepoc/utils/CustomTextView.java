package maxlife.maxlifepoc.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;

import maxlife.maxlifepoc.R;

public class CustomTextView extends android.support.v7.widget.AppCompatTextView {

private static final String TAG = "CustomEditText";

public CustomTextView(Context context) {
        super(context);
        }

public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setCustomFont(context, attrs);
        }

public CustomTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setCustomFont(context, attrs);
        }
/**
 * this method is used to set the custom Font
 * @param ctx : it contains the Context
 * @param attrs : it contains the  object of AttributeSet .
 */
private void setCustomFont(Context ctx, AttributeSet attrs) {
        TypedArray a = ctx.obtainStyledAttributes(attrs, R.styleable.MaxLifeTextView, 0, 0);
        int customFont = a.getInt(R.styleable.MaxLifeTextView_customTypeFace, 0);
        setCustomFont(ctx, customFont);
        a.recycle();
        }

public boolean setCustomFont(Context ctx, int asset) {
        Typeface typeface = null;
        try {
        switch (asset) {
        case 0:
        typeface = Typeface.createFromAsset(ctx.getAssets(), "fonts/Montserrat-Black.otf");
        break;
        case 1:
        typeface = Typeface.createFromAsset(ctx.getAssets(), "fonts/Montserrat-BlackItalic.otf");
        break;
        case 2:
        typeface = Typeface.createFromAsset(ctx.getAssets(), "fonts/Montserrat_Bold.otf");
        break;
        case 3:
        typeface = Typeface.createFromAsset(ctx.getAssets(), "fonts/Montserrat_Italic.otf");
        break;

        }
        } catch (Exception e) {
        Log.e(TAG, "Unable to load typeface: " + e.getMessage());
        return false;
        }

        setTypeface(typeface);
        return true;
        }
}
