package es.montanus.beeradviser;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class FindBeerActivity extends Activity {
    private final BeerExpert beerExpert = new BeerExpert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_beer);
    }

    public void onClickFindBeer(View view) {
        List<String> brands = beerExpert.getBrands(getBeerType());
        setBrands(brands);
    }

    private String getBeerType() {
        Spinner color = findViewById(R.id.color);
        return String.valueOf(color.getSelectedItem());
    }

    private void setBrands(Iterable<String> brands) {
        TextView brandsField = findViewById(R.id.brands);
        brandsField.setText(format(brands));
    }

    private String format(Iterable<String> brands) {
        final StringBuilder formattedBrands = new StringBuilder();
        for (String brand: brands)
            formattedBrands.append(String.format("%s%n", brand));
        return formattedBrands.toString();
    }
}
