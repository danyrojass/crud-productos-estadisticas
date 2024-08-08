package py.com.danyrs.crud_productos.estadisticas.service.impl;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import py.com.danyrs.crud_productos.estadisticas.service.StatisticsService;

@Service
public class StatisticsServiceImpl implements StatisticsService{
    
    private final AtomicInteger productCount = new AtomicInteger();

    @Async
    public void incrementProductCount() {
        productCount.incrementAndGet();
    }

    public int getProductCount() {
        return productCount.get();
    }
}
