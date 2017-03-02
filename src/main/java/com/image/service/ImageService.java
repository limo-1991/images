package com.image.service;


import com.image.dao.ImageDao;
import com.image.entity.Image;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("imageService")
public class ImageService {

    @Resource(name = "imageDao")
    private ImageDao dao;

    public void save(Image image) throws Exception {
        dao.save(image);
    }

    public List<Image> getAll()throws Exception{
        return dao.getAll();
    }

    public void delete(long id) throws Exception{
        dao.delete(id);
    }


}
