package java.com.derek.controller;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import java.com.derek.entity.Singers;
import java.com.derek.service.SingersService;
import java.util.List;

@RestController
@RequestMapping("/rest/api/Singers")
public class SingersController {

    @Autowired
    private SingersService singersService;

    @PostMapping(value = "/save")
    public ResponseEntity<String> save(@RequestBody Singers singers){

        ResponseEntity<String> responseEntity = null;
        try {
            Integer integer = singersService.saveSingers(singers);
            responseEntity = new ResponseEntity<String>("Singer '" + integer + "' created", HttpStatus.OK);
        }catch(Exception e){
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        }
        return responseEntity;
    }

    @PutMapping(value = "/update")
    public ResponseEntity<String> update(@RequestBody Singers singers){

        ResponseEntity<String> responseEntity = null;
        boolean availabe = singersService.isAvailable(singers.getPosition());
        if(availabe){
            singersService.update(singers);
            responseEntity = new ResponseEntity<String>("updated successfully", HttpStatus.OK);
        }else{
            responseEntity = new ResponseEntity<String>("Record '"+singers.getPosition()+"' not found", HttpStatus.BAD_REQUEST);
        }

        return responseEntity;
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id){
        ResponseEntity responseEntity = null;

        boolean availableSinger = singersService.isAvailable(id);
        if(availableSinger){
            singersService.delete(id);
            responseEntity = new ResponseEntity<String>("Deleted"+id+"successfully", HttpStatus.OK);
        }else{
            responseEntity = new ResponseEntity<String>(id+"Not Exist", HttpStatus.OK);
        }

        return responseEntity;
    }

    @GetMapping(value = "/getSingleSinger")
    public ResponseEntity<String> getSingleSingerById(@PathVariable Integer id){

        ResponseEntity responseEntity = null;
        if(singersService.isAvailable(id)){
            Singers oneSinger = singersService.getOneSinger(id);
            responseEntity = new ResponseEntity<Singers>(oneSinger, HttpStatus.OK);
        }else{
            return new ResponseEntity("Record not found", HttpStatus.OK);
        }

        return responseEntity;
    }

    @GetMapping(value = "/getASinger")
    public ResponseEntity<String> getAllSingers(@PathVariable Integer id){

        ResponseEntity responseEntity = null;
        List<Singers> allSingers = singersService.getAllSingers();

        if(allSingers ==null || allSingers.isEmpty()){
            String message = "No Data Found";
            responseEntity = new ResponseEntity<String>(message, HttpStatus.OK);
        }else{
            responseEntity = new ResponseEntity<List<Singers>>(allSingers, HttpStatus.OK);
        }

        return responseEntity;
    }
}
