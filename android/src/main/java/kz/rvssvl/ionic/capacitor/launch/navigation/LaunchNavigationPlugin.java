package kz.rvssvl.ionic.capacitor.launch.navigation;

import android.content.Intent;
import android.net.Uri;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import java.util.Locale;


@CapacitorPlugin(name = "LaunchNavigationPlugin")
public class LaunchNavigationPlugin extends Plugin {

        @PluginMethod()
        public void openMap(PluginCall call) {
            Float longitude = call.getFloat("longitude");
            Float latitude = call.getFloat("latitude");
            String address = call.getString("address");
            String customer = call.getString("customer");
            this.invokeIntent(LaunchNavigationPlugin.createMapIntent(latitude, longitude, address, customer));
            JSObject result = new JSObject();
            if (address != null && !address.isEmpty()) {
                result.put("uri", String.format(
                        Locale.US,
                        "geo:%f,%f?q=%s",
                        latitude,
                        longitude,
                        Uri.encode(address)
                ));
            } else {
                result.put("uri", String.format(
                        Locale.US,
                        "geo:%f,%f?q=%f,%f(%s)",
                        latitude,
                        longitude,
                        latitude,
                        longitude,
                        Uri.encode(customer)
                ));
            }
            call.resolve(result);
        }

        public static Intent createMapIntent(Float latitude, Float longitude, String address, String customer) {
            Uri gmmIntentUri;
            if (address != null && !address.isEmpty()) {
                gmmIntentUri = Uri.parse(
                    String.format(
                        Locale.US,
                        "geo:%f,%f?q=%s",
                        latitude,
                        longitude,
                        Uri.encode(address)
                    )
                );
            } else {
                gmmIntentUri = Uri.parse(
                    String.format(
                        Locale.US,
                        "geo:%f,%f?q=%s,%s(%s)",
                        latitude,
                        longitude,
                        latitude,
                        longitude,
                        Uri.encode(customer)
                    )
                );
            }
            return new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        }

        private void invokeIntent(Intent intent) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            getContext().startActivity(intent);
        }

}
