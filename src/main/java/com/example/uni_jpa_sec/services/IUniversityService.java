package com.example.uni_jpa_sec.services;

import com.example.uni_jpa_sec.dtos.ApiResponse;
import com.example.uni_jpa_sec.dtos.UniversityDto;

public interface IUniversityService {
    ApiResponse add(UniversityDto universityDto) throws NoSuchFieldException;
    ApiResponse delete(Long Id);
    ApiResponse deleteAll();
    ApiResponse searchByName(String universityName);
    ApiResponse geById(Long Id);

    ApiResponse getAll();

    ApiResponse updateName(Long id, String newName);

    ApiResponse update(Long id, UniversityDto university);
}
