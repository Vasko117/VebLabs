package mk.ukim.finki.vb.service.imp;

import mk.ukim.finki.vb.model.Author;
import mk.ukim.finki.vb.repository.AuthorRepository;
import mk.ukim.finki.vb.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImp implements AuthorService {
    private final AuthorRepository authrepo;

    public AuthorServiceImp(AuthorRepository authrepo) {
        this.authrepo = authrepo;
    }
    @Override
    public List<Author> listAuthors(){
        return authrepo.findall();
    };
    @Override
    public Author findById(Long id){
         Optional<Author> authorot= authrepo.findById(id);
         Author deauthor;
         if(authorot.isPresent())
         {
              deauthor=authorot.get();
              return deauthor;
         }
         else {
             return null;
         }
    };
}
