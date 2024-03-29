package slidenerd.vivz;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Vivz on 10/22/13.
 */
public class MyDialog extends DialogFragment implements View.OnClickListener {
    Button yes, no;
    Communicator communicator;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        communicator= (Communicator) activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.my_dialog, null);
        yes= (Button) view.findViewById(R.id.yes);
        no= (Button) view.findViewById(R.id.no);
        yes.setOnClickListener(this);
        no.setOnClickListener(this);
        setCancelable(false);
        return view;
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.yes)
        {
            communicator.onDialogMessage("Yes was clicked");
            dismiss();

        }
        else
        {
            communicator.onDialogMessage("No was clicked");
            dismiss();

        }
    }
    interface Communicator
    {
        public void onDialogMessage(String message);
    }
}
