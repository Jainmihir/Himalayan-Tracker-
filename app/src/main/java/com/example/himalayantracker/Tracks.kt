
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import android.Manifest
import android.content.Intent
import android.net.Uri
import android.view.View
import com.example.himalayantracker.R
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

class Tracks : AppCompatActivity() {
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private val LOCATION_PERMISSION_REQUEST_CODE = 123
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.track_details)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        val getDirectionsButton1: Button = findViewById(R.id.getDirectionsButton)
        val getDirectionsButton2: Button = findViewById(R.id.getDirectionsButton1)
        val getDirectionsButton3: Button = findViewById(R.id.getDirectionsButton2)
        val getDirectionsButton4: Button = findViewById(R.id.getDirectionsButton3)
        val getDirectionsButton5: Button = findViewById(R.id.getDirectionsButton4)
        val getDirectionsButton6: Button = findViewById(R.id.getDirectionsButton6)
        val getDirectionsButton7: Button = findViewById(R.id.getDirectionsButton7)
        val getDirectionsButton8: Button = findViewById(R.id.getDirectionsButton5)

        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                LOCATION_PERMISSION_REQUEST_CODE
            )
        } else {
            showNearbyHotels()
        }
        getDirectionsButton1.setOnClickListener {
            openMapWithDirections("Kedarnath")
        }

        getDirectionsButton2.setOnClickListener {
            openMapWithDirections("Weastern Ghats")
        }

        getDirectionsButton3.setOnClickListener {
            openMapWithDirections("Esatern Ghats")
        }

        getDirectionsButton4.setOnClickListener {
            openMapWithDirections("Garhwal")
        }

        getDirectionsButton5.setOnClickListener {
            openMapWithDirections("Kumaon")
        }

        getDirectionsButton6.setOnClickListener {
            openMapWithDirections("Guru Sikhar")
        }

        getDirectionsButton7.setOnClickListener {
            openMapWithDirections("Satpura Hill")
        }

        getDirectionsButton8.setOnClickListener {
            openMapWithDirections("Vindhya")
        }
    }

    fun onNearbyHotelsClick(view: View?) {
        showNearbyHotels()
    }

    fun onNearbyBanksClick(view: View?) {
        // Handle the click for Nearby Banks button
    }

    fun onNearbyHospitalsClick(view: View?) {
        // Handle the click for Nearby Hospitals button
    }

    private fun openMapWithDirections(placeName: String) {
        val gmmIntentUri: Uri = Uri.parse("google.navigation:q=$placeName")
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.`package` = "com.google.android.apps.maps"
        startActivity(mapIntent)
    }

    private fun showNearbyHotels() {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }
        fusedLocationClient.lastLocation
            .addOnSuccessListener(this) { location ->
                if (location != null) {
                    val latitude: Double = location.latitude
                    val longitude: Double = location.longitude
                    val category = "Hotels"
                    val gmmIntentUri: Uri = Uri.parse("geo:$latitude,$longitude?q=$category")
                    val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                    mapIntent.`package` = "com.google.android.apps.maps"
                    startActivity(mapIntent)
                }
            }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                showNearbyHotels()
            }
        }
    }
}