package nick.template.ui

import android.Manifest
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import javax.inject.Inject
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import nick.template.R
import nick.template.data.Item
import nick.template.databinding.MainFragmentBinding

class MainFragment @Inject constructor(
    private val factory: MainViewModel.Factory
) : Fragment(R.layout.main_fragment) {
    private val viewModel: MainViewModel by viewModels { factory.create(this) }
    private val locationRequest =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
            if (permissions.size != 2) error("Need permissions")
            viewModel.load()
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val binding = MainFragmentBinding.bind(view)
        requestPermissions()

        viewModel.items
            .onEach { items ->
                binding.list.withModels {
                    items.forEach { item ->
                        when (item) {
                            is Item.ButtonRow -> button {
                                id(item.id)
                                text(item.text)
                            }
                            Item.ColorRow -> color {
                                id(item.id)
                            }
                            is Item.Map -> map {
                                id(item.id)
                                city(item.city)
                            }
                        }
                    }
                }
            }
            .launchIn(viewLifecycleOwner.lifecycleScope)
    }

    private fun requestPermissions() {
        locationRequest.launch(
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
        )
    }
}
