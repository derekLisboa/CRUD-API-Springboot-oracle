package java.com.derek.service;

import java.com.derek.entity.Singers;

public interface SingersService {
    public Integer saveSingers(Singers singers);
    public void update(Singers singers);
    public void delete(Integer id);
    public Singers getOneSinger(Integer id);
    public boolean isAvailable(Integer id);

}
