package com.example.newsfeedapp.features

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.feature.Base.Event
import com.example.feature.data.api.model.ApiArticleModel

data class ViewState(
    val articleList: List<ApiArticleModel>,
    val errorMesage: String?,
    val isloading: Boolean
)

@RequiresApi(Build.VERSION_CODES.S)
sealed class UIEvent(): Event{
    class OnArticleClick: UIEvent()
}

sealed class DataEvent(): Event {
    object OnloadData: DataEvent()
    data class SuccesNewsRequest(val articleList: List<ApiArticleModel>): DataEvent()

}