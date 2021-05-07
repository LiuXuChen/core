package com.jetco.core.behavioral.strategy;

import com.jetco.sand.core.bean.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 出行控制器类
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-02-27
 */
@RestController
public class TravelController {

    @Resource
    private TravelService travelService;

    @RequestMapping("/api/travel/getTravelType")
    public Result<String> getTravelType(@RequestBody RequestParam requestParam) {
        return travelService.getTravelType(requestParam);
    }
}
