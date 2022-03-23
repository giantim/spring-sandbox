package practice.adapter;

import feign.FeignException;
import feign.Response;
import feign.RetryableException;
import feign.codec.ErrorDecoder;

import static java.lang.String.format;

public class FeignErrorDecoder implements ErrorDecoder {

    protected FeignErrorDecoder() {
    }

    @Override
    public Exception decode(String methodKey, Response response) {
        final FeignException exception = FeignException.errorStatus(methodKey, response);
        if (exception instanceof FeignException.BadGateway
                || exception instanceof FeignException.ServiceUnavailable
                || exception instanceof FeignException.GatewayTimeout) {
            return new RetryableException(
                    exception.status(),
                    format("%s executing %s %s", response, response.request().httpMethod(), response.request().url()),
                    exception.request().httpMethod(),
                    exception,
                    null,
                    exception.request());
        }

        return exception;
    }
}
