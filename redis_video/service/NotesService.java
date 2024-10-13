    package com.spring_video_stream.redis_video.service;

    import java.util.List;
    import java.util.Optional;
    import java.util.UUID;

    import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

    import com.spring_video_stream.redis_video.entities.Notes;
    import com.spring_video_stream.redis_video.repository.NotesRepository;

    @Service
    public class NotesService {

        @Autowired
        private NotesRepository notesRepository;

        //create
        @CachePut(value="notes",key = "#note.id")
        public Notes createNotes(Notes note){
            note.setId(UUID.randomUUID().toString());
            return notesRepository.save(note);
        }
        //get

        public List<Notes> getALLNotes(){
            return notesRepository.findAll();
        }

        //getById
        @Cacheable(value = "notes",key="#myId")
        public Notes getNotesById(String myId){
            return notesRepository.findById(myId).orElse(null);
        }

        //delete
        @CacheEvict(value="notes",key = "#myId")
        public boolean deleteNotesById(String myId) {
            Notes note = notesRepository.findById(myId).orElse(null);
            if (note != null) {
                notesRepository.delete(note);
                return true;
            }
            return false;
        }
        
        //update
        public Notes updateNotesById(Notes notes,String myid){
            Notes note1=notesRepository.findById(myid).orElse(null);
            note1.setTitle(note1.getTitle());
            note1.setContent(note1.getContent());

            Notes saved=notesRepository.save(note1);
            return saved;

        }

    }
