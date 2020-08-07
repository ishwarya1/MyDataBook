package sg.edu.rp.soi.mydatabook;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import sg.edu.rp.soi.mydatabook.R;

public class CustomDialog extends Dialog implements android.view.View.OnClickListener {
    public Activity c;
    public Dialog d;
    public Button yes, no;
    public TextView tvName;
    public EditText etEdit;

    public CustomDialog(Activity a) {

        super(a);

        // TODO Auto-generated constructor stub

        this.c = a;

    }


    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.dialog);

        yes = (Button) findViewById(R.id.btnOk);

        no = (Button) findViewById(R.id.btnCancel);

        tvName = findViewById(R.id.tvName);

        etEdit = findViewById(R.id.etEdit);

        final SharedPreferences sharedPref = c.getPreferences(Context.MODE_PRIVATE);

        final String name = sharedPref.getString("name", "Error");

        tvName.setText(name);

        no.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                dismiss();

            }

        });

        yes.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                if (name.contains("Vaccination")) {

                    SharedPreferences sharedPref = c.getPreferences(Context.MODE_PRIVATE);

                    SharedPreferences.Editor editor = sharedPref.edit();

                    editor.putString("edit", etEdit.getText().toString());

                    editor.commit();


                } else if (name.contains("Bio")) {

                    SharedPreferences sharedPref = c.getPreferences(Context.MODE_PRIVATE);

                    SharedPreferences.Editor editor = sharedPref.edit();

                    editor.putString("edit1", etEdit.getText().toString());

                    editor.commit();


                } else {

                    SharedPreferences sharedPref = c.getPreferences(Context.MODE_PRIVATE);

                    SharedPreferences.Editor editor = sharedPref.edit();

                    editor.putString("edit2", etEdit.getText().toString());

                    editor.commit();

                }

                c.finish();


            }

        });


    }


    @Override

    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btnOk:

                c.finish();

                break;

            case R.id.btnCancel:

                dismiss();

                break;

            default:

                break;

        }

        dismiss();

    }

}
