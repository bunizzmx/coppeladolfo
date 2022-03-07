package  com.frentetecnologicoponce.elder.presentation

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner

import com.example.android.examenadolfo.domain.data.HeroesRepository
import com.example.android.examenadolfo.presentation.ui.tvs.HeroesViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(
    private val loginRepository: HeroesRepository,
    owner: SavedStateRegistryOwner,
    defaultArgs: Bundle?
) :
    AbstractSavedStateViewModelFactory(owner, defaultArgs) {

    override fun <T : ViewModel?> create(key: String, clazz: Class<T>, state: SavedStateHandle): T {
        val viewModel: ViewModel = if (clazz == HeroesViewModel::class.java) {
            HeroesViewModel(loginRepository)
        } else {
            throw RuntimeException("Unsupported view model class: $clazz")
        }
        return viewModel as T
    }
}