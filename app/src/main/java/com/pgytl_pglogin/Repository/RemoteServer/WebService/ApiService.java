package com.pgytl_pglogin.Repository.RemoteServer.WebService;
import com.pgytl_pglogin.Model.Booking.BookingResponse;
import com.pgytl_pglogin.Model.Contact.ContactRequest;
import com.pgytl_pglogin.Model.Contact.ContactResponse;
import com.pgytl_pglogin.Model.Holiday.HolidayRequest;
import com.pgytl_pglogin.Model.Holiday.HolidayResponse;
import com.pgytl_pglogin.Model.Login.LoginRequest;
import com.pgytl_pglogin.Model.Login.LoginResponse;
import com.pgytl_pglogin.Model.PG_Info.PGRequest;
import com.pgytl_pglogin.Model.PG_Info.PGResponse;
import com.pgytl_pglogin.Model.Payment.PaymentRequest;
import com.pgytl_pglogin.Model.Payment.PaymentResponse;
import com.pgytl_pglogin.Model.Point.PointRequest;
import com.pgytl_pglogin.Model.Point.PointResponse;
import com.pgytl_pglogin.Model.PointDetails.PointDetailsRequest;
import com.pgytl_pglogin.Model.PointDetails.PointDetailsResponse;
import com.pgytl_pglogin.Model.ViewImage.ImageRequest;
import com.pgytl_pglogin.Model.ViewImage.ImageResponse;
import com.pgytl_pglogin.Model.YearlyAMC.YearlyAMCRequest;
import com.pgytl_pglogin.Model.YearlyAMC.YearlyAMCResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface  ApiService {
    //Pointdetails Api
    @POST("point-details-Total_Point_details.php")
    Call<PointDetailsResponse> getPointDetailsResponse(
            @Body PointDetailsRequest pointDetailsRequest
    );

    //YearlyAMC Api
    @POST("point-details-YearlyAMC.php")
    Call<YearlyAMCResponse> getYearlyAMCResponse(
            @Body YearlyAMCRequest yearlyAMCRequest
    );

    //Login Api
    @POST("authentication_user/Login.php")
    Call<LoginResponse> getLoginResponse(
            @Body LoginRequest loginRequest
            );
   //PG Api
    @POST("single-pg-info-read.php")
    Call<PGResponse >getPGResponse(
           @Body PGRequest pgRequest
    );
    //Contact Api
    @POST("single-contact-info.php")
    Call<ContactResponse>getContactResponse(
            @Body ContactRequest contactRequest
    );


 //Point Api
    @POST("single-point-details-main.php")
    Call<PointResponse>getPointResponse(
            @Body PointRequest pointRequest
    );

    //Payment Api
    @POST("single-Payment-Details.php")
    Call<PaymentResponse>getPymentResponse(
            @Body PaymentRequest paymentRequest
    );
    //Holiday Api
    @POST("Single-HOLIDAY-DETAILS.php")
    Call<HolidayResponse>getHolidayResponse(
            @Body HolidayRequest holidayRequest
    );
    //Booking Api
    @GET("product/read.php")
    Call <BookingResponse>getBookingResponse(
    );
    //ImageView Api
    @POST("image-upload/view.php")
    Call <ImageResponse>getImageViewResponse(
            @Body ImageRequest imageRequest
    );

}
