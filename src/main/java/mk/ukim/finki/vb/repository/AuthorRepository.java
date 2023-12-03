package mk.ukim.finki.vb.repository;

import mk.ukim.finki.vb.bootstrap.DataHolder;
import mk.ukim.finki.vb.model.Author;
import mk.ukim.finki.vb.model.Kategorija;
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
        if(k==null || k.getName()==null || k.getName().isEmpty()){
            return null;
        }
        DataHolder.authors.removeIf(r->r.getName().equals(k.getName()));
        DataHolder.authors.add(k);
        return k;
    }
    public Optional<Author> findById(Long id){
        return DataHolder.authors.stream().filter(r->r.getId().equals(id)).findFirst();
    }
    public List<Author> search(String text){
        return DataHolder.authors.stream().filter(r->r.getName().contains(text) || r.getSurname().contains(text)).collect(Collectors.toList());
    }
    public void delete(String name)
    {
        if(name==null)
        {
            return;
        }
        DataHolder.authors.removeIf(r->r.getName().equals(name));
    }
}
