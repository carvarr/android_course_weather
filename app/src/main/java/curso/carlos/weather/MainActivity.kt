package curso.carlos.weather

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {

    lateinit var mAdView : AdView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*val locationTv = findViewById<TextView>(R.id.location)
        val weatherTv = findViewById<TextView>(R.id.weather)
        val metricTv = findViewById<TextView>(R.id.metric)
        val weatherIcon = findViewById<ImageView>(R.id.weatherIcon)

        var lat = "6.25184"
        var lon = "-75.56359"
        var weatherService = WeatherService()

        var subs = weatherService.getWeatherMetricsInLocation(lat, lon).subscribe{ weather ->
            locationTv.text = "${weather.city}, ${weather.location.country}"
            weatherTv.text = weather.data.get(0).description
            metricTv.text = "${weather.metrics.getTemp()}°"

            Picasso.get()
                .load("http://openweathermap.org/img/wn/${weather.data.get(0).icon}@2x.png")
                .into(weatherIcon)
        }*/


        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");

        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().addTestDevice("DE37B87ABF158A224EC6F562B9B197A7").build()
        mAdView.loadAd(adRequest)

    }
}
