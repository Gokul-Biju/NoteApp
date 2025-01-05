package com.example.note_app_backend.Repository;

import com.example.note_app_backend.Model.DataModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRespository extends JpaRepository<DataModel,String> {
}
