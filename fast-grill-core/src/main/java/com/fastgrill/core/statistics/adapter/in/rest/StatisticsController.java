package com.fastgrill.core.statistics.adapter.in.rest;

import com.fastgrill.core.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/v1/shorten-url")
public class StatisticsController {

}
