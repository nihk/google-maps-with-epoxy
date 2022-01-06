package nick.template.ui

import android.view.View
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.maps.android.ktx.addMarker
import nick.template.R
import nick.template.databinding.ButtonBinding
import nick.template.databinding.ColorBinding
import nick.template.databinding.MapBinding

@EpoxyModelClass
abstract class MapModel : EpoxyModelWithHolder<MapModel.Holder>(), OnMapReadyCallback, GoogleMap.OnMapLoadedCallback {
    override fun getDefaultLayout(): Int {
        return R.layout.map
    }

    private var map: GoogleMap? = null

    @EpoxyAttribute
    lateinit var city: LatLng

    override fun bind(holder: Holder) {
        holder.binding.mapView.onResume()
        holder.binding.mapView.getMapAsync(this)
    }

    override fun onMapReady(map: GoogleMap) {
        check(this.map == null)
        this.map = map
        map.mapType = GoogleMap.MAP_TYPE_NORMAL
        map.setOnMapLoadedCallback(this)
    }

    override fun onMapLoaded() {
        val map = map ?: return
        map.isMyLocationEnabled = true
        map.addMarker {
            position(city)
            title("Toronto")
            snippet("Canada")
        }

        val bounds = LatLngBounds.Builder()
            .include(city)
            .include(LatLng(43.64600577912159, -79.39015526526872)) // Toronto
            .build()
        // animateCamera doesn't work in Lite mode
        map.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, 0))
    }

    override fun unbind(holder: Holder) {
        holder.binding.mapView.onPause()
        map?.setOnMapLoadedCallback(null)
        map?.clear()
        map?.mapType = GoogleMap.MAP_TYPE_NONE
        map = null
    }

    class Holder : EpoxyHolder() {
        lateinit var binding: MapBinding

        override fun bindView(itemView: View) {
            binding = MapBinding.bind(itemView)
            binding.mapView.apply {
                onCreate(null)
                isClickable = false
            }
        }
    }
}

@EpoxyModelClass
abstract class ColorModel : EpoxyModelWithHolder<ColorModel.Holder>() {
    override fun getDefaultLayout(): Int {
        return R.layout.color
    }

    class Holder : EpoxyHolder() {
        lateinit var binding: ColorBinding

        override fun bindView(itemView: View) {
            binding = ColorBinding.bind(itemView)
        }
    }
}

@EpoxyModelClass
abstract class ButtonModel : EpoxyModelWithHolder<ButtonModel.Holder>() {
    override fun getDefaultLayout(): Int {
        return R.layout.button
    }

    @EpoxyAttribute
    lateinit var text: String

    override fun bind(holder: Holder) {
        holder.binding.button.text = text
    }

    class Holder : EpoxyHolder() {
        lateinit var binding: ButtonBinding

        override fun bindView(itemView: View) {
            binding = ButtonBinding.bind(itemView)
        }
    }
}
