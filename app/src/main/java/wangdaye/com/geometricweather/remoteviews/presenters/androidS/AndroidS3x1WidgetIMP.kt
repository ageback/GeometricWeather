package wangdaye.com.geometricweather.remoteviews.presenters.androidS

import android.appwidget.AppWidgetManager
import android.content.ComponentName
import android.content.Context
import wangdaye.com.geometricweather.GeometricWeather
import wangdaye.com.geometricweather.R
import wangdaye.com.geometricweather.background.receiver.widget.androidSWeather.WidgetAndroidS3x1Provider
import wangdaye.com.geometricweather.common.basic.models.Location

class AndroidS3x1WidgetIMP: AbstractAndroidSWeatherWidgetIMP() {

    companion object {

        @JvmStatic
        fun isEnable(context: Context): Boolean {
            val widgetIds = AppWidgetManager.getInstance(
                context
            ).getAppWidgetIds(
                ComponentName(
                    context,
                    WidgetAndroidS3x1Provider::class.java
                )
            )
            return widgetIds.isNotEmpty()
        }

        @JvmStatic
        fun updateWidgetView(context: Context, location: Location) {
            AppWidgetManager.getInstance(context).updateAppWidget(
                ComponentName(context, WidgetAndroidS3x1Provider::class.java),
                buildWeatherWidget(
                    context,
                    R.layout.widget_s_card_3x1,
                    GeometricWeather.WIDGET_ANDROID_S_WEATHER_L_PENDING_INTENT_CODE_WEATHER,
                    location
                )
            )
        }
    }
}