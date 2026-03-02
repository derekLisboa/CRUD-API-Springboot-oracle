package java.com.derek.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.com.derek.entity.Singers;
import java.com.derek.repository.SingersRepository;

public class SingersServiceImpl implements SingersService{

    @Autowired
    private SingersRepository singersRepository;

    @Override
    @Transactional
    public Integer saveSingers(Singers singers) {
        return singersRepository.save(singers).getPosition();
    }

    @Override
    @Transactional
    public void update(Singers singers) {
        singersRepository.save(singers);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        singersRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Singers getOneSinger(Integer id) {
        return singersRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public boolean isAvailable(Integer id) {
        return singersRepository.existsById(id);
    }
}
