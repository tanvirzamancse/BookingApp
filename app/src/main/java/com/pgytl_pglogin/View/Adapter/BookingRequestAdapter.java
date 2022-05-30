package com.pgytl_pglogin.View.Adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.pgytl_pglogin.Model.Booking.BookingResult;
import com.pgytl_pglogin.R;
import java.util.List;
public class BookingRequestAdapter extends RecyclerView.Adapter<BookingRequestAdapter.ViewHolder> {
    private Context context;
    List<BookingResult> list;
    public BookingRequestAdapter(Context context, List<BookingResult> list) {
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public BookingRequestAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View itemView = layoutInflater.inflate(R.layout.booking_reques_rowt,parent,false);
        return new ViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull BookingRequestAdapter.ViewHolder holder, int position) {
       BookingResult bookingResult=list.get(position);
       holder.name.setText(bookingResult.getName());
       holder.pg_id.setText(bookingResult.getPgId());
       holder.destination.setText(bookingResult.getDestination());
       holder.date.setText(bookingResult.getDate());
       holder.email.setText(bookingResult.getEmail());
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,pg_id,destination,date,email;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            pg_id = itemView.findViewById(R.id.pg_id);
            destination = itemView.findViewById(R.id.destination);
            date = itemView.findViewById(R.id.date);
            email = itemView.findViewById(R.id.email);
        }
    }
}
