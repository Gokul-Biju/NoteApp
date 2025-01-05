package com.example.note_app_backend.Controller;

import com.example.note_app_backend.Model.DataModel;
import com.example.note_app_backend.Services.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/noteapp")
@RestController
@CrossOrigin(origins = "http://localhost")
public class DataController {

    @Autowired
    DataService service;

    @PostMapping("/createdata")
    public ResponseEntity<DataModel> adddata(@RequestBody DataModel model)
    {
        try{
            service.addData(model);
            return new ResponseEntity<>(model,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/getdata")
    public ResponseEntity<List<DataModel>> getdata(){
        try{
            return new ResponseEntity<>(service.getData(),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    @PutMapping("/updatedata")
    public ResponseEntity<DataModel> updatedata(@RequestBody DataModel model){

        try{
            service.updateData(model);
            return new ResponseEntity<>(model,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }

    }

    @DeleteMapping("/data/{id}")
    public void deletedata(@PathVariable String id)
    {
        try{
            service.deleteData(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
