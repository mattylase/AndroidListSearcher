package software.sweven.ListSearcher;

/**
 * Created by mlaser on 11/19/15.
 */
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

public class SearchFieldWatcher implements TextWatcher {
    int length = 0;
    boolean clearing = false;
    StringListAdapter mAdapter;
    StringSearchUtility mUtil;

    public SearchFieldWatcher(StringListAdapter adapter, StringSearchUtility util) {
        mAdapter = adapter;
        mUtil = util;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        length = count;
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (!clearing && count < before) {
            Log.i("TextWatcher", "Backspace detected, Clearing string from EditText");
            clearing = true;
            mUtil.getSearchField().setText("");
        }
    }

    @Override
    public void afterTextChanged(Editable s) {
        if (s.length() == 0) {
            mAdapter.resetList();
            clearing = false;
        } else if (s.length() > length && !clearing) {
            mAdapter.addNameCharacter(s.charAt(s.length() - 1));
        }
    }

}