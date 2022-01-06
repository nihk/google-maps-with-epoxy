package nick.template.data

import com.google.android.gms.maps.model.LatLng
import java.util.*

sealed class Item {
    val id: String = UUID.randomUUID().toString()

    data class Map(val city: LatLng) : Item()
    data class ButtonRow(val text: String) : Item()
    object ColorRow : Item()
}
