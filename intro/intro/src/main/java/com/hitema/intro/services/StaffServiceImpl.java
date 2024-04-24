package com.hitema.intro.services;

import com.hitema.intro.repositories.StaffRepository;
import org.springframework.stereotype.Service;


@Service
public class StaffServiceImpl implements StaffService{
    private StaffRepository repository;

    public StaffServiceImpl(StaffRepository repository) {
        this.repository = repository;
    }

    @Override
    public byte[] getPicture(Long id) {
        return read(id).getPicture();
    }

    @Override
    public Staff read(Long id) {
        return repository.findById(id).orElse(null);
    }
}
