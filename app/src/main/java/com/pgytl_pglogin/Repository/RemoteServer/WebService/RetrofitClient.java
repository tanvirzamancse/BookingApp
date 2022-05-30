package com.pgytl_pglogin.Repository.RemoteServer.WebService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class RetrofitClient {
    private static final String BASE_URL = "https://ytl.apodigi.com/api/";
    private static final String PG_BASE_URL = "https://ytl.apodigi.com/api/Users/";
    private static final String Contact_BASE_URL = "https://ytl.apodigi.com/api/Users/";
    private static final String Point_BASE_URL = "https://ytl.apodigi.com/api/Users/";
    private static final String Payment_BASE_URL = "https://ytl.apodigi.com/api/Users/";
    private static final String Holiday_BASE_URL = "https://ytl.apodigi.com/api/Users/";
    private static final String Booking_BASE_URL = "https://ytl.apodigi.com/api/";
    private static final String ImageView_BASE_URL = "https://ytl.apodigi.com/api/";
    private static final String YearlyAMC_BASE_URL = "https://ytl.apodigi.com/api/Users/";
    private static final String PointDetails_BASE_URL = "https://ytl.apodigi.com/api/Users/";
    private static Retrofit retrofit;
    private static Retrofit PGretrofit;
    private static Retrofit Contactretrofit;
    private static Retrofit Pointretrofit;
    private static Retrofit Paymentretrofit;
    private static Retrofit Holidayretrofit;
    private static Retrofit Bookingretrofit;
    private static Retrofit ImageViewretrofit;
    private static Retrofit YearlyAMC;
    private static Retrofit PointDetails;

    public static Retrofit getYearlyAMC(){
        if (YearlyAMC == null){
            YearlyAMC = new Retrofit.Builder()
                    .baseUrl(YearlyAMC_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return YearlyAMC;
    }
    public static Retrofit getPointDetails(){
        if (PointDetails == null){
            PointDetails = new Retrofit.Builder()
                    .baseUrl(PointDetails_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return PointDetails;
    }
    public static Retrofit getRetrofit(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
    public static Retrofit getImageViewRetrofit(){

        if (ImageViewretrofit == null){
            ImageViewretrofit = new Retrofit.Builder()
                    .baseUrl(ImageView_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return ImageViewretrofit;
    }
    public static Retrofit getPGRetrofit(){
        if (PGretrofit == null){
            PGretrofit = new Retrofit.Builder()
                    .baseUrl(PG_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return PGretrofit;
    }
    public static Retrofit getContactRetrofit(){
        if (Contactretrofit == null){
            Contactretrofit = new Retrofit.Builder()
                    .baseUrl(Contact_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return Contactretrofit;
    }
    public static Retrofit getPointRetrofit(){
        if (Pointretrofit == null){
            Pointretrofit = new Retrofit.Builder()
                    .baseUrl(Point_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return Pointretrofit;
    }
    public static Retrofit getPaymentretrofit(){
        if (Paymentretrofit == null){
            Paymentretrofit = new Retrofit.Builder()
                    .baseUrl(Payment_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return Paymentretrofit;
    }
    public static Retrofit getHolidayretrofit(){
        if (Holidayretrofit == null){
            Holidayretrofit = new Retrofit.Builder()
                    .baseUrl(Holiday_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return Holidayretrofit;
    }
    public static Retrofit getBookingretrofit(){
        if (Bookingretrofit == null){
            Bookingretrofit = new Retrofit.Builder()
                    .baseUrl(Booking_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return Bookingretrofit;
    }
}
