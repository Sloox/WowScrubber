package wrightstuff.wowscrubber.ui;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import wrightstuff.wowscrubber.R;


public class BaseActivity extends AppCompatActivity {

    public void replaceFragment(BaseFragment fragment, boolean addToBackStack) {
        final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        // fragmentTransaction.setCustomAnimations(0, 0, R.anim.in_from_left, R.anim.out_to_right);
        fragmentTransaction.replace(R.id.frame_content, fragment, fragment.getCurrentTag());
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(fragment.getCurrentTag());
        }
        fragmentTransaction.commit();
    }
}
