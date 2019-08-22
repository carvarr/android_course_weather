package curso.carlos.weather

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import carlos.curso.weather.WeatherService
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {

    private lateinit var mAdView : AdView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val locationTv = findViewById<TextView>(R.id.location)
        val weatherTv = findViewById<TextView>(R.id.weather)
        val metricTv = findViewById<TextView>(R.id.metric)
        val weatherIcon = findViewById<ImageView>(R.id.weatherIcon)

        val lat = "6.25184"
        val lon = "-75.56359"
        val weatherService = WeatherService()

        var subs = weatherService.getWeatherMetricsInLocation(lat, lon).subscribe{ weather ->
            locationTv.text = "${weather.city}, ${weather.location.country}"
            weatherTv.text = weather.data.get(0).description
            metricTv.text = "${weather.metrics.getTemp()}°"

            Picasso.get()
                .load("http://openweathermap.org/img/wn/${weather.data.get(0).icon}@2x.png")
                .into(weatherIcon)
        }


        MobileAds.initialize(this, "ca-app-pub-5671424531462473~5400024009")

        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

    }
}
