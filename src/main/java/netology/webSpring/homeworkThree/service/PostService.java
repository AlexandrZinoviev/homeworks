package netology.webSpring.homeworkThree.service;

import netology.webSpring.homeworkThree.exception.NotFoundException;
import netology.webSpring.homeworkThree.model.Post;
import netology.webSpring.homeworkThree.repository.PostRepository;

import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class PostService {
    private final PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public List<Post> all() {
        return repository.all();
    }

    public Post getById(long id) {
        return repository.getById(id).orElseThrow(NotFoundException::new);
    }

    public Post save(Post post) {
        return repository.save(post);
    }

    public void removeById(long id) {
        repository.removeById(id);
    }
}
