package by.mark.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MainViewModel : ViewModel() {

    private val retrofitBuilder = Retrofit.Builder()
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
    private val api = retrofitBuilder.baseUrl(url).build().create(Api::class.java)

    private val comopositeDisposable = CompositeDisposable()

    val dataStream: LiveData<List<Product>> = liveData(Dispatchers.IO) {
        emit(api.getProducts().products)
    }

    override fun onCleared() {
        super.onCleared()
        comopositeDisposable.clear()
    }

    companion object {
        private const val url = "https://s3-eu-west-1.amazonaws.com/"
    }
}