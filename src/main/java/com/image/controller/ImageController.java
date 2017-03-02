package com.image.controller;

import com.image.entity.Image;
import com.image.service.ImageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Controller
public class ImageController {

    @Resource(name = "imageService")
    private ImageService service;

    @RequestMapping(value = "/image")
    public String show(Model model) throws Exception {
        List<Image> imageList = service.getAll();


        ArrayList<Image> randomList = new ArrayList<>(imageList.size());
        do {
            int randomIndex = Math.abs(new Random().nextInt(imageList.size()));
            randomList.add(imageList.remove(randomIndex));
        } while (imageList.size() > 0);

        ArrayList<Image> images = new ArrayList<>();

        if (randomList.size() > 8) {
            for (int i = 0; i < 8; i++) {
                images.add(randomList.get(i));
            }
            model.addAttribute("images", images);
        }
        return "image";
    }

    @RequestMapping(value = "/controller")
    public String upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, ModelMap model) throws Exception {

        if (file != null) {
            String path = request.getServletContext().getRealPath("/image");
            String fileName = file.getOriginalFilename();
            System.out.println(path);
            String suffix = fileName.substring(fileName.lastIndexOf("."), fileName.length());
            fileName = new Date().getTime() + suffix;
            File targetFile = new File(path, fileName);

            try {
                file.transferTo(targetFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
            String fileUrl = "/image/" + fileName;
            model.addAttribute("fileUrl", fileUrl);

            Image image = new Image();
            image.setUri(fileUrl);

            try {
                service.save(image);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        List<Image> imageList = service.getAll();
        model.addAttribute("images", imageList);
        return "controller";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable long id) throws Exception {
        service.delete(id);
        return "redirect:/controller";
    }


}
