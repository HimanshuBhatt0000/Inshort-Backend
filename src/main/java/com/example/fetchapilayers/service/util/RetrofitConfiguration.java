package com.example.fetchapilayers.service.util;

import ch.qos.logback.core.joran.util.beans.BeanDescriptionFactory;
import com.example.fetchapilayers.retrofitCallService.EconomicTimesCall;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

@Configuration
public class RetrofitConfiguration {

        @Bean
        public EconomicTimesCall economicTimesCall() {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .build();

            return new Retrofit.Builder()
                    .baseUrl("http://localhost:9082")
                    .client(client) // Add OkHttpClient with logging interceptor
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .build()
                    .create(EconomicTimesCall.class);
        }
}
