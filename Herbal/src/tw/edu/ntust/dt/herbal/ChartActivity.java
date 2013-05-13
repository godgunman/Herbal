package tw.edu.ntust.dt.herbal;

import java.util.Arrays;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

import com.androidplot.series.XYSeries;
import com.androidplot.xy.LineAndPointFormatter;
import com.androidplot.xy.SimpleXYSeries;
import com.androidplot.xy.XYPlot;

public class ChartActivity extends Activity{
	
	private XYPlot mCardiograph;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chart);
		
		mCardiograph = (XYPlot) findViewById(R.id.cardiograph);
		XYSeries series = new SimpleXYSeries(Arrays.asList(new Number[]{1, 2, 3, 5, 8}), 
											 SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "");
		LineAndPointFormatter seriesFormat = new LineAndPointFormatter(Color.rgb(0, 200,  0), Color.rgb(0, 100, 0), null);
		mCardiograph.addSeries(series, seriesFormat);
		mCardiograph.setTicksPerRangeLabel(3);
		mCardiograph.disableAllMarkup();
		
	}
	
}
