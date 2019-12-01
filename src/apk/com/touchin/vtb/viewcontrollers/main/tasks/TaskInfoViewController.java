package com.touchin.vtb.viewcontrollers.main.tasks;

import android.widget.ImageView;
import android.widget.TextView;
import com.touchin.vtb.R;
import com.touchin.vtb.activities.MainActivity;
import com.touchin.vtb.g.j;
import com.touchin.vtb.viewcontrollers.base.VTBViewController;
import kotlin.e.b.h;
import ru.touchin.roboswag.components.navigation.viewcontrollers.c.a;

/* compiled from: TaskInfoViewController.kt */
public final class TaskInfoViewController extends VTBViewController<MainActivity, j> {
    private final ImageView backNavigationImage = ((ImageView) findViewById(R.id.view_controller_task_info_back_image));
    private final TextView description = ((TextView) findViewById(R.id.view_controller_task_info_description_text));
    private final TextView title = ((TextView) findViewById(R.id.view_controller_task_info_title));

    public TaskInfoViewController(a aVar) {
        h.b(aVar, "creationContext");
        super(aVar, R.layout.view_controller_task_info);
        this.title.setText(((j) getState()).o());
        this.description.setText(((j) getState()).n());
        this.backNavigationImage.setOnClickListener(new d(this));
    }
}
