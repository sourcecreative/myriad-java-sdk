package io.sourcecreative.myriad.client.module;

import java.io.IOException;

import io.reactivex.Observable;
import io.sourcecreative.myriad.client.api.APIError;
import lombok.NonNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RemoteCall<T> {
	private Call<T> call;
	
	private RemoteCall(Call<T> call) {
		this.call = call;
	}
	
	public static <T> RemoteCall<T> of(Call<T> call) {
		if (call == null)
			throw new IllegalArgumentException();
		return new RemoteCall<T>(call);
	}
		
	public T send() {
		APIError error;
		try {
			Response<T> response = call.execute();
			return response.body();
		} catch(IOException e) {
			error = APIError.builder().code(502).key("network.error")
					.message("Network Connection Error")
					.details(e.getMessage())
					.build();

		} catch(RuntimeException re) {
			if (re instanceof APIError)
				error = (APIError)re;
			else
				error = APIError.builder().code(500).key("server.error.unknown")
					.message(re.getMessage()).build();	
		}
		throw error;
	}
	
	public void sendAsyn(@NonNull Callback<T> callback) {
		call.enqueue(callback);		
	}
	
	public Observable<T> sendAsync() {
		return Observable.fromCallable(() -> RemoteCall.this.send());
	}
}
