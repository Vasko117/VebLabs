package mk.ukim.finki.vb.repository;

import mk.ukim.finki.vb.bootstrap.DataHolder;
import mk.ukim.finki.vb.model.Author;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class AuthorRepository {
    public List<Author> findall(){
        return DataHolder.authors;
    }
    public Author save(Author k){
        if(k==null || k.getFullname().getName()==null || k.getFullname().getName().isEmpty()){
            return null;
        }
        DataHolder.authors.removeIf(r->r.getFullname().getName().equals(k.getFullname().getName()));
        DataHolder.authors.add(k);
        return k;
    }
    public Optional<Author> findById(Long id){
        return DataHolder.authors.stream().filter(r->r.getId().equals(id)).findFirst();
    }
    public List<Author> search(String text){
        return DataHolder.authors.stream().filter(r->r.getFullname().getName().contains(text) || r.getFullname().getSurname().contains(text)).collect(Collectors.toList());
    }
    public void delete(String name)
    {
        if(name==null)
        {
            return;
        }
        DataHolder.authors.removeIf(r->r.getFullname().getName().equals(name));
    }
}
