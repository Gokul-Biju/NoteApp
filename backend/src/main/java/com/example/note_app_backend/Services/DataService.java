package com.example.note_app_backend.Services;

import com.example.note_app_backend.Model.DataModel;
import com.example.note_app_backend.Repository.DataRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService {

    @Autowired
    DataRespository repo;
    public void addData(DataModel model)
    {
        repo.save(model);
    }

    public List<DataModel> getData() {
        return repo.findAll();
    }

    public void updateData(DataModel model) {
        repo.save(model);
    }

    public void deleteData(String id) {
        repo.deleteById(id);
    }
}
