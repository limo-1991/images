package com.image.dao;

import com.image.TestSupport;
import com.image.entity.Image;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;

/**
 * ImageDao Tester.
 *
 * @author <Authors name>
 * @version 1.0
 */
public class ImageDaoTest extends TestSupport{

    ImageDao dao;
    @Before
    public void before() throws Exception {
        dao = (ImageDao) context.getBean("imageDao");
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: save(Image image)
     */
    @Test
    public void testSave() throws Exception {
        Image image = new Image();
        image.setUri("123456");
        dao.save(image);
        System.out.println(image.getId());
        System.out.println(image.getUri());
    }

    @Test
    public void test2() throws Exception {
        List<Image> imageList = dao.getAll();

        for (Image image:imageList){
            System.out.println(image);
        }

    }


} 
