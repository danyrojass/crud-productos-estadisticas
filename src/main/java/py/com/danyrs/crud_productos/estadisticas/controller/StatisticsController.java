package py.com.danyrs.crud_productos.estadisticas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import py.com.danyrs.crud_productos.estadisticas.service.StatisticsService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/statistics")
public class StatisticsController {

    private final StatisticsService statisticsService;

    @GetMapping("/product-count")
    public int getProductCount() {
        return statisticsService.getProductCount();
    }
}