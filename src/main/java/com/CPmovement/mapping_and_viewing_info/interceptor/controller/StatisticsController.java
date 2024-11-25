package com.CPmovement.mapping_and_viewing_info.interceptor.controller;

import com.CPmovement.mapping_and_viewing_info.interceptor.ApiStatisticsInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatisticsController {

    private final ApiStatisticsInterceptor interceptor;
    private Logger logger = LoggerFactory.getLogger(StatisticsController.class);
    public StatisticsController(ApiStatisticsInterceptor interceptor) {
        this.interceptor = interceptor;
    }


    @GetMapping("/stats")
    public String getStatistics() {
        String result = String.format("Total Requests: %d, Average Handling Time (ns): %.2f",
                interceptor.getTotalRequests(),
                interceptor.getAverageHandlingTime());
        logger.info(result);
        return result;
    }
}