package nick.template.ui

import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.google.android.gms.maps.model.LatLng
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import nick.template.data.Item

class MainViewModel(
    private val handle: SavedStateHandle
) : ViewModel() {

    val items = MutableStateFlow<List<Item>>(emptyList())

    fun load() {
        items.value = listOf(
            Item.Map(LatLng(43.651070, -79.347015)),
            Item.ColorRow,
            Item.ButtonRow("Click me"),
            Item.Map(LatLng(-31.9523, 115.8613)),
            Item.ColorRow,
            Item.ButtonRow("Close"),
            Item.Map(LatLng(-34.0, 151.0)),
            Item.ColorRow,
            Item.Map(LatLng(43.651070, -79.347015)),
            Item.ColorRow,
            Item.ButtonRow("Click me"),
            Item.Map(LatLng(-31.9523, 115.8613)),
            Item.ColorRow,
            Item.ButtonRow("Close"),
            Item.Map(LatLng(-34.0, 151.0)),
            Item.ColorRow,
            Item.Map(LatLng(43.651070, -79.347015)),
            Item.ColorRow,
            Item.ButtonRow("Click me"),
            Item.Map(LatLng(-31.9523, 115.8613)),
            Item.ColorRow,
            Item.ButtonRow("Close"),
            Item.Map(LatLng(-34.0, 151.0)),
            Item.ColorRow,
            Item.Map(LatLng(43.651070, -79.347015)),
            Item.ColorRow,
            Item.ButtonRow("Click me"),
            Item.Map(LatLng(-31.9523, 115.8613)),
            Item.ColorRow,
            Item.ButtonRow("Close"),
            Item.Map(LatLng(-34.0, 151.0)),
            Item.ColorRow,
            Item.Map(LatLng(43.651070, -79.347015)),
            Item.ColorRow,
            Item.ButtonRow("Click me"),
            Item.Map(LatLng(-31.9523, 115.8613)),
            Item.ColorRow,
            Item.ButtonRow("Close"),
            Item.Map(LatLng(-34.0, 151.0)),
            Item.ColorRow,
            Item.Map(LatLng(-33.920455, 18.466941)),
            Item.Map(LatLng(39.937795, 116.387224)),
            Item.Map(LatLng(46.948020, 7.448206)),
            Item.Map(LatLng(51.589256, 4.774396)),
            Item.Map(LatLng(50.854509, 4.376678)),
            Item.Map(LatLng(55.679423, 12.577114)),
            Item.Map(LatLng(52.372026, 9.735672)),
            Item.Map(LatLng(60.169653, 24.939480)),
            Item.Map(LatLng(22.325862, 114.165532)),
            Item.Map(LatLng(41.034435, 28.977556)),
            Item.Map(LatLng(-26.202886, 28.039753)),
            Item.Map(LatLng(38.707163, -9.135517)),
            Item.Map(LatLng(51.500208, -0.126729)),
            Item.Map(LatLng(40.420006, -3.709924)),
            Item.Map(LatLng(19.427050, -99.127571)),
            Item.Map(LatLng(55.750449, 37.621136)),
            Item.Map(LatLng(40.750580, -73.993584)),
            Item.Map(LatLng(59.910761, 10.749092)),
            Item.Map(LatLng(48.859972, 2.340260)),
            Item.Map(LatLng(50.087811, 14.420460)),
            Item.Map(LatLng(-22.90187, -43.232437)),
            Item.Map(LatLng(41.889998, 12.500162)),
            Item.Map(LatLng(-22.863878, -43.244097)),
            Item.Map(LatLng(37.560908, 126.987705)),
            Item.Map(LatLng(59.330650, 18.067360)),
            Item.Map(LatLng(-33.873651, 151.2068896)),
            Item.Map(LatLng(25.022112, 121.478019)),
            Item.Map(LatLng(35.670267, 139.769955)),
            Item.Map(LatLng(36.149777, -95.993398)),
            Item.Map(LatLng(47.141076, 9.521482)),
            Item.Map(LatLng(48.209206, 16.372778)),
            Item.Map(LatLng(52.235474, 21.004057)),
            Item.Map(LatLng(-41.286480, 174.776217)),
            Item.Map(LatLng(49.875832, -97.150726))
        )
    }

    class Factory @Inject constructor() {
        fun create(owner: SavedStateRegistryOwner): AbstractSavedStateViewModelFactory {
            return object : AbstractSavedStateViewModelFactory(owner, null) {
                override fun <T : ViewModel?> create(
                    key: String,
                    modelClass: Class<T>,
                    handle: SavedStateHandle
                ): T {
                    @Suppress("UNCHECKED_CAST")
                    return MainViewModel(handle) as T
                }
            }
        }
    }
}
