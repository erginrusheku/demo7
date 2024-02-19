package group.demo7.controller;

import group.demo7.service.RegionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class RegionsController {

    @Autowired
    private RegionsService regionsService;
}
