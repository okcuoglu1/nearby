package com.codexist.nearby.controller;

import com.codexist.nearby.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PlaceController {

    private final PlaceService placeService;

}
