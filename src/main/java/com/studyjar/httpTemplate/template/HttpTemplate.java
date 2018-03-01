package com.studyjar.httpTemplate.template;

import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.web.client.*;

import java.net.URI;
import java.util.Collections;

/**
 * Created by mj on 2018/1/3.
 *
 */
public class HttpTemplate extends RestTemplate{

    public static final int MAX_ATTEMPTS = 3;
    public static final long BACK_OFF_PERIOD = 500;

    private String mesApiHost;

    private int mesApiPort;

    private String mesApiHttpSchemeHierarchical;

    // retry template
    private final RetryTemplate retryTemplate = new RetryTemplate();

    public HttpTemplate(ClientHttpRequestFactory clientHttpRequestFactory,
                        String mesApiHost,
                        int mesApiPort) {
        super(clientHttpRequestFactory);
        this.mesApiHost = mesApiHost;
        this.mesApiPort = mesApiPort;
        this.mesApiHttpSchemeHierarchical = "http://" + this.mesApiHost + ":" + this.mesApiPort;

        // retry policy
        SimpleRetryPolicy policy = new SimpleRetryPolicy(MAX_ATTEMPTS,
                Collections.<Class<? extends Throwable>, Boolean>singletonMap(ResourceAccessException.class, true));
        FixedBackOffPolicy fixedBackOffPolicy = new FixedBackOffPolicy();
        fixedBackOffPolicy.setBackOffPeriod(BACK_OFF_PERIOD);
        retryTemplate.setRetryPolicy(policy);
        retryTemplate.setBackOffPolicy(fixedBackOffPolicy);
    }

    public String getMesApiHttpSchemeHierarchical() {
        return mesApiHttpSchemeHierarchical;
    }

    @Override
    protected <T> T doExecute(URI url, HttpMethod method, RequestCallback requestCallback,
                              ResponseExtractor<T> responseExtractor) throws RestClientException {
        return retryTemplate.execute(
                context -> HttpTemplate.super.doExecute(url, method, requestCallback, responseExtractor));
    }


}
