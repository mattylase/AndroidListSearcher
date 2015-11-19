package software.sweven.ListSearcher;

/**
 * Created by mlaser on 11/19/15.
 */

import android.util.Log;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by mattylase on 11/13/15.
 */
public class StringSearchUtility {
    private final Map<String, Integer> positionMap = new HashMap<String, Integer>();
    private Set<String> mValidStrings = new HashSet<String>();
    private List<Integer> mValidIndices = new ArrayList<Integer>();

    private final List<String> LIST_A = new ArrayList<String>();
    private final List<String> LIST_B = new ArrayList<String>();
    private final List<String> LIST_C = new ArrayList<String>();
    private final List<String> LIST_D = new ArrayList<String>();
    private final List<String> LIST_E = new ArrayList<String>();
    private final List<String> LIST_F = new ArrayList<String>();
    private final List<String> LIST_G = new ArrayList<String>();
    private final List<String> LIST_H = new ArrayList<String>();
    private final List<String> LIST_I = new ArrayList<String>();
    private final List<String> LIST_J = new ArrayList<String>();
    private final List<String> LIST_K = new ArrayList<String>();
    private final List<String> LIST_L = new ArrayList<String>();
    private final List<String> LIST_M = new ArrayList<String>();
    private final List<String> LIST_N = new ArrayList<String>();
    private final List<String> LIST_O = new ArrayList<String>();
    private final List<String> LIST_P = new ArrayList<String>();
    private final List<String> LIST_Q = new ArrayList<String>();
    private final List<String> LIST_R = new ArrayList<String>();
    private final List<String> LIST_S = new ArrayList<String>();
    private final List<String> LIST_T = new ArrayList<String>();
    private final List<String> LIST_U = new ArrayList<String>();
    private final List<String> LIST_V = new ArrayList<String>();
    private final List<String> LIST_W = new ArrayList<String>();
    private final List<String> LIST_X = new ArrayList<String>();
    private final List<String> LIST_Y = new ArrayList<String>();
    private final List<String> LIST_Z = new ArrayList<String>();
    private final List<String> EMPTY_LIST = new ArrayList<String>();
    private boolean noMatches;

    private StringListAdapter mStringListAdapter;
    private EditText mSearchField;
    private ListView mStringListView;

    public StringSearchUtility(List<String> names, EditText searchField, ListView stringListView, LayoutInflater inflater) {
        mSearchField = searchField;
        mStringListView = stringListView;
        mStringListAdapter = new StringListAdapter(new ArrayList<String>(names), inflater, this);

        mStringListView.setAdapter(mStringListAdapter);
        mSearchField.addTextChangedListener(new SearchFieldWatcher(mStringListAdapter, this));

        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i).toUpperCase();
            positionMap.put(name, i);
            addNameToPartition(name);
            noMatches = false;
        }
    }

    public void setVisibleNames(List<String> names) {
        positionMap.clear();
        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i).toUpperCase();
        }
    }

    public void clearNames() {
        mValidStrings.clear();
        mValidIndices.clear();
        noMatches = false;
    }

    private void addNameToPartition(String name) {
        if (name.contains("A")) {
            LIST_A.add(name);
        }
        if (name.contains("B")) {
            LIST_B.add(name);
        }
        if (name.contains("C")) {
            LIST_C.add(name);
        }
        if (name.contains("D")) {
            LIST_D.add(name);
        }
        if (name.contains("E")) {
            LIST_E.add(name);
        }
        if (name.contains("F")) {
            LIST_F.add(name);
        }
        if (name.contains("G")) {
            LIST_G.add(name);
        }
        if (name.contains("H")) {
            LIST_H.add(name);
        }
        if (name.contains("I")) {
            LIST_I.add(name);
        }
        if (name.contains("J")) {
            LIST_J.add(name);
        }
        if (name.contains("K")) {
            LIST_K.add(name);
        }
        if (name.contains("L")) {
            LIST_L.add(name);
        }
        if (name.contains("M")) {
            LIST_M.add(name);
        }
        if (name.contains("N")) {
            LIST_N.add(name);
        }
        if (name.contains("O")) {
            LIST_O.add(name);
        }
        if (name.contains("P")) {
            LIST_P.add(name);
        }
        if (name.contains("Q")) {
            LIST_Q.add(name);
        }
        if (name.contains("R")) {
            LIST_R.add(name);
        }
        if (name.contains("S")) {
            LIST_S.add(name);
        }
        if (name.contains("T")) {
            LIST_T.add(name);
        }
        if (name.contains("U")) {
            LIST_U.add(name);
        }
        if (name.contains("V")) {
            LIST_V.add(name);
        }
        if (name.contains("W")) {
            LIST_W.add(name);
        }
        if (name.contains("X")) {
            LIST_X.add(name);
        }
        if (name.contains("Y")) {
            LIST_Y.add(name);
        }
        if (name.contains("Z")) {
            LIST_Z.add(name);
        }
    }

    private List<String> getListForCharacter(Character character) {
        switch (character) {
            case 'A' : return LIST_A;
            case 'B' : return LIST_B;
            case 'C' : return LIST_C;
            case 'D' : return LIST_D;
            case 'E' : return LIST_E;
            case 'F' : return LIST_F;
            case 'G' : return LIST_G;
            case 'H' : return LIST_H;
            case 'I' : return LIST_I;
            case 'J' : return LIST_J;
            case 'K' : return LIST_K;
            case 'L' : return LIST_L;
            case 'M' : return LIST_M;
            case 'N' : return LIST_N;
            case 'O' : return LIST_O;
            case 'P' : return LIST_P;
            case 'Q' : return LIST_Q;
            case 'R' : return LIST_R;
            case 'S' : return LIST_S;
            case 'T' : return LIST_T;
            case 'U' : return LIST_U;
            case 'V' : return LIST_V;
            case 'W' : return LIST_W;
            case 'X' : return LIST_X;
            case 'Y' : return LIST_Y;
            case 'Z' : return LIST_Z;
            default: return EMPTY_LIST;
        }
    }

    public List<Integer> checkIndicesForCharacter(Character character) {
        if (Character.isAlphabetic(character)) {
            List<String> listForCharacter = getListForCharacter(Character.toUpperCase(character));
            Set<String> tempSet = new HashSet<String>(mValidStrings);
            if (mValidStrings.size() == 0 && !noMatches) {
                mValidStrings.addAll(listForCharacter);
            } else {
                for (String s : mValidStrings) {
                    if (!listForCharacter.contains(s)) {
                        tempSet.remove(s);
                    }
                }
                mValidStrings = tempSet;
            }
            mValidIndices.clear();
            for (String s : mValidStrings) {
                mValidIndices.add(positionMap.get(s));
            }
            if (mValidIndices.size() == 0) {
                noMatches = true;
            }
            Log.d("StringSearchUtility", "Valid matches are: " + mValidStrings);
            return mValidIndices;
        } else {
            return mValidIndices;
        }
    }

    // Utilities
    public EditText getSearchField() {
        return mSearchField;
    }

    public StringListAdapter getListAdapter() {
        return mStringListAdapter;
    }
}

