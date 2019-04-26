package io.sourcecreative.myriad.client.module;

import java.io.IOException;

import io.reactivex.Observable;
import io.sourcecreative.myriad.client.api.APIError;
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
			error = new APIError(408, "Network Connection Error");

		} catch(RuntimeException re) {
			if (re instanceof APIError)
				error = (APIError)re;
			else
				error = new APIError(re);	
		}
		throw error;
	}
	
	public void sendAsyn(Callback<T> callback) {
		call.enqueue(callback);		
	}
	
	public Observable<T> sendAsync() {
		return Observable.fromCallable(() -> RemoteCall.this.send());
	}
}
