package com.CPmovement.mapping_and_viewing_info.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class ApiStatisticsInterceptor implements HandlerInterceptor {

    private long totalRequests = 0;
    private long totalRequestTime = 0;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        request.setAttribute("startTime", System.nanoTime());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        if ("/stats".equals(request.getRequestURI())) {
            return;  // Skip this request from statistics
        }
        long startTime = (Long) request.getAttribute("startTime");
        long requestTime = System.nanoTime() - startTime;

        synchronized (this) {
            totalRequests++;
            totalRequestTime += requestTime;
        }
    }
    public synchronized long getTotalRequests() {
        return totalRequests;
    }

    public synchronized double getAverageHandlingTime() {
        return totalRequests > 0 ? (double) totalRequestTime / totalRequests : 0.0;
    }
}