package group.demo7.controller;

import group.demo7.service.LocationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class LocationsController {

    @Autowired
    private LocationsService locationsService;
}
