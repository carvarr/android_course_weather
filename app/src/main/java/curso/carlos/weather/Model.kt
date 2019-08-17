package curso.carlos.weather

import com.google.gson.annotations.SerializedName

class Weather {
    @SerializedName("main")
    var metrics = Metrics()
    @SerializedName("weather")
    var data = ArrayList<Data>()
    @SerializedName("sys")
    var location = Location()
    @SerializedName("name")
    var city = ""
}

class Metrics {
    var temp = 0.0

    fun getTemp() = String.format("%.0f", temp)
}

class Data {
    var id = 0
    var main = ""
    var description = ""
    var icon = ""
}

class Location {
    var country = ""
}