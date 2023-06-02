package com.example.uni_jpa_sec.controllers;

import com.example.uni_jpa_sec.dtos.ApiResponse;
import com.example.uni_jpa_sec.dtos.UniversityDto;
import com.example.uni_jpa_sec.services.IUniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/universities")
public class UniversityController {

    private final IUniversityService universityService;

    @Autowired
    public UniversityController(IUniversityService universityService) {
        this.universityService = universityService;
    }


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ApiResponse getUniversities(){
        System.out.println("hiiiiiiiiiiii");
        return this.universityService.getAll();
    }

//    @PostMapping("/add")
//    public ApiResponse addUniversity(@RequestBody UniversityDto universityDto)  {
//        return this.universityService.add(universityDto);
//    }

    @GetMapping("{Id}")
    public ApiResponse getUniversityById(@PathVariable("Id") Long Id){
        System.out.println(Id);
        return this.universityService.geById(Id); ///
    }


    @PostMapping("/add")
    public ApiResponse addUniversity(@RequestBody UniversityDto universityDto) throws RuntimeException, NoSuchFieldException {
        return this.universityService.add(universityDto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{Id}")
    public ApiResponse updateUniversity(@PathVariable("Id") Long Id, @RequestBody UniversityDto universityDto) throws RuntimeException, NoSuchFieldException {
        System.out.println("updated ID "+ Id);
        return this.universityService.update(Id, universityDto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{Id}")
    public ApiResponse deleteUniversity(@PathVariable("Id") Long Id){
        return this.universityService.delete(Id);
    }

}
