package com.sc.rai.raischeduler.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class RESTUtil {

    private static Logger log = LoggerFactory.getLogger(RESTUtil.class);

    @SuppressWarnings("rawtypes")
    public static ResponseEntity postData(String host, Object object, Class c) {

        ResponseEntity status = restServiceExchange(
                host,
                HttpMethod.POST,
                new HttpEntity<>(object, null),
                c);
        return status;
    }

    @SuppressWarnings("rawtypes")
    public static ResponseEntity postData(String user,String pass,String host, Object object, Class c) {
        log.debug("Create wallet host : "+host+user+pass);
        ResponseEntity status = restServiceExchange(
                host,
                HttpMethod.POST,
                new HttpEntity<>(object, RequestUtil.getPreFormattedRequestWithUserPassword(user,pass).getHeaders()),
                c);
        return status;
    }

    @SuppressWarnings("rawtypes")
    public static HttpStatus updateData(String user,String pass,String host, Object object, Class c) {
        log.debug("Create wallet host : "+host);
        HttpStatus status = restServiceExchange(
                host,
                HttpMethod.PUT,
                new HttpEntity<>(object, RequestUtil.getPreFormattedRequestWithUserPassword(user,pass).getHeaders()),
                String.class).getStatusCode();
        return status;
    }

    @SuppressWarnings("rawtypes")
    public static HttpStatus deleteData(String user,String pass,String host, Object object, Class c) {
        log.debug("Create wallet host : "+host);
        HttpStatus status = restServiceExchange(
                host,
                HttpMethod.DELETE,
                RequestUtil.getPreFormattedRequestWithUserPassword(user,pass),
                c,
                object).getStatusCode();
        return status;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static ResponseEntity restServiceExchange(String host, HttpMethod httpMethod, HttpEntity request, Class c, Object... varargs) {
        if (httpMethod.equals(HttpMethod.PUT) || httpMethod.equals(HttpMethod.DELETE)) {
            c = null;
        }
        return new RestTemplate().exchange(host, httpMethod, request, c, varargs);
    }

}
