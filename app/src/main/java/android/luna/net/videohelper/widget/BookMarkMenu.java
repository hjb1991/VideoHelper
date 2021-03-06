package android.luna.net.videohelper.widget;

import android.app.Activity;
import android.app.Dialog;
import android.luna.net.videohelper.adapter.BookmarkListAdapter;
import android.luna.net.videohelptools.R;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.TextView;


public class BookMarkMenu extends Dialog {

    Activity activity;
    View view;
    BookmarkListAdapter adapter;
    TextView deleteBtn;
    TextView selectAllBtn;
    boolean hasSelectAll = false;
    // With action button
    public BookMarkMenu(Activity activity, BookmarkListAdapter adapter) {
        super(activity, android.R.style.Theme_Translucent);
        this.activity = activity;
        this.adapter = adapter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.menu_bookmark);
        setCanceledOnTouchOutside(false);
        view = findViewById(R.id.snackbar);
        selectAllBtn = (TextView) findViewById(R.id.btn_right);
        deleteBtn = (TextView) findViewById(R.id.btn_delete);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return activity.dispatchTouchEvent(event);
    }

    @Override
    public void onBackPressed() {
    }

    public void changeSelectedStatus() {
        if (hasSelectAll) {
            selectAllBtn.setText(activity.getResources().getString(R.string.select_all));
        } else {
            selectAllBtn.setText(activity.getResources().getString(R.string.cancel));
        }
        hasSelectAll = !hasSelectAll;
    }

    public boolean isHasSelectAll() {
        return hasSelectAll;
    }

    @Override
    public void show() {
        super.show();
        view.setVisibility(View.VISIBLE);
        view.startAnimation(AnimationUtils.loadAnimation(activity, R.anim.snackbar_show_animation));
    }


    /**
     * @author Jack Tony
     */
    @Override
    public void dismiss() {
        Animation anim = AnimationUtils.loadAnimation(activity, R.anim.snackbar_hide_animation);
        anim.setAnimationListener(new AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                BookMarkMenu.super.dismiss();
            }
        });
        view.startAnimation(anim);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO 自动生成的方法存根
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (adapter != null) {
                adapter.changeEditStatus();
            }
            dismiss();
        }
        return super.onKeyDown(keyCode, event);
    }


}
