package io.sourcecreative.myriad.client.module;

import java.io.IOException;

import io.sourcecreative.myriad.client.api.APIError;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public final class RemoteCalls<T> {
	public static <T> T send(Call<T> call) {
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
	
	public static <T> void sendAsyn(Call<T> call, Callback<T> cb) {
		call.enqueue(cb);
	}

}
