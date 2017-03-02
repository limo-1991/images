package test.com.image.entity;

import com.image.entity.Image;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * Image Tester.
 *
 * @author <Authors name>
 * @version 1.0
 */
public class ImageTest {

    @Before
    public void before() throws Exception {
    }

    @Test
    public void test() {
        Image image = new Image();
        System.out.println(image.getDate());
    }

    @After
    public void after() throws Exception {
    }


} 
