package  com.example.android.examenadolfo.presentation.ui.tvs

import androidx.lifecycle.MutableLiveData
import com.example.android.examenadolfo.domain.data.HeroesRepository
import com.example.android.examenadolfo.presentation.BaseViewModel
import com.example.android.examenadolfo.utils.Event


import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


import javax.inject.Inject
import com.example.android.examenadolfo.data.network.model.response.Tv


class HeroesViewModel
@Inject constructor(
    private val loginRepository: HeroesRepository
) : BaseViewModel() {

    private val disposable = CompositeDisposable()

    private val _heroesResponse = MutableLiveData<Event<ArrayList<Tv>>>()
    val heroesResponse get() = _heroesResponse

    private val _heroesResponseMore = MutableLiveData<Event<ArrayList<Tv>>>()
    val heroesResponseMore get() = _heroesResponseMore



    internal fun getTvs(offset:String,more:Boolean) {
        showLoading()
        val task = loginRepository.getListTvs(offset)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
        val subscriber = task.subscribe({
            hideLoading()
            if(more)
                _heroesResponseMore.postValue(Event(it.data.results) )
            else
                _heroesResponse.postValue(Event(it.data.results) )
        }, {
            hideLoading()
            serviceError(it.message!!)
        })
        disposable.add(subscriber)
    }


}