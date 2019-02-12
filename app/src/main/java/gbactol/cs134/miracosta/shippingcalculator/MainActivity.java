package gbactol.cs134.miracosta.shippingcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * MainActivity.java: The class where the activity starts up. This class loads up the variables
 * and changes the what is display in the text in order to show off and calculate shipping costs
 * on an Android application.
 *
 * @author Gabriel Bactol
 * @since 2-11-19
 */
public class MainActivity extends AppCompatActivity {

    //Member variables to format as currency (NumberFormat)
    NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.getDefault());

    //Member variables used for each component of the app
    private EditText ouncesAmount;
    private TextView baseValue;
    private TextView addedValue;
    private TextView totalValue;
    private ShipItem item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize variables based on their id's in the onCreate method
        ouncesAmount = findViewById(R.id.weightEditText);
        baseValue =  findViewById(R.id.baseCostValue);
        addedValue = findViewById(R.id.addCostValue);
        totalValue = findViewById(R.id.totalCostValue);

        //initialize ShipItem object
        item = new ShipItem();


        /**
        * A method that checks whether the ounces value has changed within the activity
        */
        ouncesAmount.addTextChangedListener(new TextWatcher() {
            /**
             * A method that checks whether the text changed before it loads
             * @param s - The text before it is going to be changed
             * @param start - the location of where text is changing
             * @param after - the length of the text after it had been changed
             * @param count - How many characters a text has
             */
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //do nothing
            }

            /**
             * A method that checks whether the ounces value has changed within the activity
             * at that point in time.
             * @param s - The text currently being changed
             * @param before - the length of the text before it was changed
             * @param start - the location of where text is changing
             * @param count - How many characters a text has
             */
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //check whether there was any number in the user input;
                //program originally crashed without this statement
                if(ouncesAmount.getText().toString().equals(""))
                {
                    item.setWeight(0);
                }
                else
                {
                    //if not, display the current bill
                    item.setWeight(Integer.parseInt(ouncesAmount.getText().toString()));
                }

                //change the values of added cost and total cost displayed within the activity
                addedValue.setText(currency.format(item.getAddedCost()));
                totalValue.setText(currency.format(item.getTotalCost()));
            }

            /**
             * A method that checks whether the program should do something after the text has changed
             *
             * @param s - a notifier that tells the program that text had been changed
             */
            @Override
            public void afterTextChanged(Editable s) {
                //do nothing
            }
        });
    }
}
