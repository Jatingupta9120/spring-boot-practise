package com.spring_video_stream.redis_video.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_video_stream.redis_video.entities.Notes;
import com.spring_video_stream.redis_video.service.NotesService;


@RestController
@RequestMapping("/api/v1/notes")
public class NotesController {

    @Autowired
    private NotesService notesService;

    //create
    @PostMapping    
    public ResponseEntity<Notes> createNote(@RequestBody Notes note){
        return ResponseEntity.status(HttpStatus.CREATED).body(notesService.createNotes(note));
    }
    
    //update

    @PutMapping("/{id}")
    public ResponseEntity<Notes>updateNotes(@RequestBody Notes note ,@PathVariable String id){
        return ResponseEntity.status(HttpStatus.CREATED).body(notesService.updateNotesById(note, id));
    }

    //delete

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotesById(@PathVariable String id) {
        boolean isDeleted = notesService.deleteNotesById(id);
        
        if (isDeleted) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); 
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    

    //getAllNotes
    @GetMapping
    public ResponseEntity<List<Notes>>getAllNotes(){
        return ResponseEntity.status(HttpStatus.OK).body(notesService.getALLNotes());
    }

    //getNotesById
    @GetMapping("/{id}")
    public ResponseEntity<Notes> getSingleNote(@PathVariable String id) {
        Notes note = notesService.getNotesById(id);
        
        if (note != null) {
            return ResponseEntity.status(HttpStatus.OK).body(note); // 200 OK
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404 Not Found
        }
    }



}
