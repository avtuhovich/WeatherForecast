package weather.activities;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import weather.R;

/**
 * Определение местоположения устройства и запрос разрешения на соеднение
 */
public class SplashActivity extends AppCompatActivity {

    static final int PERMISSION_ACCESS_FINE_LOCATION = 0;
    ConnectivityManager connectivityManager;
    NetworkInfo networkInfo;
    LocationManager locationManager;
    AlertDialog.Builder builder;
    boolean isConnected;
    int permissionRequestResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initMembers();
        checkPermissionAndConnectivity(permissionRequestResult, locationManager, isConnected);
    }

    /**
     * Запрос разрешения на подключение и проверка подключения
     * permissionRequestResult - результат запроса на разрешение (если permissionRequestResult == 0 подключение произошло)
     * LocationManager -  экземпляр класса locationManager(обеспечиввает доступ к системной службе определения местоположения android)
     * inConnected - произошло ли подключение(true or false)
     */
    private void checkPermissionAndConnectivity(int permissionRequestResult, LocationManager locationManager, boolean isConnected) {
        if (permissionRequestResult == 0) {
            if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)==true) {
                if (isConnected == true) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(new Intent(SplashActivity.this, ForecastActivity.class));
                            finish();
                        }
                    }, 100);
                } else {
                    builder.setMessage(R.string.msg_internet).setCancelable(false)
                            .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    finish();
                                }
                            });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
            } else {
                builder.setMessage(R.string.msg_gps).setCancelable(false)
                        .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        } else {
            // запрос на разрешение
            ActivityCompat.requestPermissions(SplashActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    PERMISSION_ACCESS_FINE_LOCATION);
        }
    }

    // результат запроса на разрешение
    //параметры requestCode и permission содержат данные которые передаются при запросе разрешений
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_ACCESS_FINE_LOCATION: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    initMembers();
                    checkPermissionAndConnectivity(permissionRequestResult, locationManager, isConnected);
                } else {
                    builder.setMessage(R.string.msg_location_services).setCancelable(false)
                            .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    finish();
                                }
                            });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
            }
        }
    }


    /**
     * Переопределение методов
     */
    private void initMembers() {
        builder = new AlertDialog.Builder(SplashActivity.this);
        connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        networkInfo = connectivityManager.getActiveNetworkInfo();
        isConnected = networkInfo != null && networkInfo.isConnectedOrConnecting();
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        permissionRequestResult = this.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION");
    }

}
