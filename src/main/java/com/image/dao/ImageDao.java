package com.image.dao;


import com.image.entity.Image;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("imageDao")
public class ImageDao extends DaoSupport{

    public void save(Image image) throws Exception {
        super.save("ImageMapper.save",image);
    }

    public List<Image> getAll() throws Exception {

       return (List<Image>) super.findForList("ImageMapper.getAll",null);
    }

    public void delete(long id)throws Exception{
        super.delete("ImageMapper.delete",id);
    }

}
