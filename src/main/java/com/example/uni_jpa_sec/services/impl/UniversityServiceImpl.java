package com.example.uni_jpa_sec.services.impl;

import com.example.uni_jpa_sec.apiUtils.NoSuchElementFoundException;
import com.example.uni_jpa_sec.dtos.ApiResponse;
import com.example.uni_jpa_sec.dtos.UniversityDto;
import com.example.uni_jpa_sec.models.BaseEntity;
import com.example.uni_jpa_sec.models.University;
import com.example.uni_jpa_sec.repositories.UniversityRepository;
import com.example.uni_jpa_sec.services.IUniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UniversityServiceImpl implements IUniversityService {

    private final UniversityRepository universityRepository ;

    @Autowired
    public UniversityServiceImpl(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }


    @Override
    public ApiResponse add(UniversityDto universityDto)  {
        if (universityDto.getName() == null) { //&& universityDto.getAddress() == null
           // return new ApiResponse("error", "uni is empty");
            throw new NoSuchElementFoundException();
        }

        University university = new University(universityDto);

        University insertedUniversity = universityRepository.save(university);
        return new ApiResponse("university", insertedUniversity);
    }

    @Override
    public ApiResponse delete(Long Id) {
        System.out.println("del id = " + Id);

        University changStatusToDeleteUniversity = universityRepository.findById(Id).orElse(null);
        if (changStatusToDeleteUniversity != null){
            changStatusToDeleteUniversity.setRecordState(BaseEntity.RecordState.DELETED);

        University insertedUniversity = universityRepository.save(changStatusToDeleteUniversity);
        return new ApiResponse("university", insertedUniversity);
        }
        return new ApiResponse("denied", "Can not perform delete action on this Id");
    }

    @Override
    public ApiResponse deleteAll() {
        return null;
    }

    @Override
    public ApiResponse searchByName(String universityName) {
        return null;
    }

    @Override
    public ApiResponse geById(Long Id) {
        University university = universityRepository.findById(Id).orElse(null);

        if (university != null) {
            return new ApiResponse("university", university);
        }
        return new ApiResponse("university", "Id is not valid!");
    }

    @Override
    public ApiResponse getAll() {
        return new ApiResponse("universities", universityRepository.findAll());
    }

    @Override
    public ApiResponse updateName(Long id, String newName) {
        return null;
    }

    @Override
    public ApiResponse update(Long id, UniversityDto university) {
        if (university.getName()==null) { // university.getAddress()==null &&
            throw new NoSuchElementFoundException();
        }

       // University universityToUpdated = universityRepository.getOne(id);
        University universityToUpdated = universityRepository.findById(id).orElse(null);
        if (universityToUpdated != null && universityToUpdated.getRecordState() != BaseEntity.RecordState.DELETED){
            universityToUpdated.setName(university.getName());
            universityToUpdated.setAddress(university.getAddress());

            if (university.getAddress() != null){
                universityToUpdated.setRecordState(BaseEntity.RecordState.ACTIVE);
            }
            else{
                universityToUpdated.setRecordState(BaseEntity.RecordState.DRAFT);
            }
            University insertedUniversity = universityRepository.save(universityToUpdated);
            return new ApiResponse("university", insertedUniversity);
        }

        return new ApiResponse("denied", "Can not perform updated action on this record");
    }
}
