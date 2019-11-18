package net.plang.DYAccount.common.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import net.plang.DYAccount.common.util.FileUploader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ImgFileController extends AbstractController {
    @Override
    public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("jsonView");

        // Multipart Contnet 인지 확인
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (!isMultipart) {
            modelAndView.addObject("errorCode", -1);
            modelAndView.addObject("errorMsg", "정상적인 경로로 접근해주세요.");

            return null;
        }

        try {
            // Create a factory for disk-based file items
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();

            // Create a new file upload handler
            ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);

            String empCode = null;
            String imagePath = null;


            List<FileItem> fileItemList = servletFileUpload.parseRequest(request);

            for (FileItem fileItem : fileItemList) {
                if (!fileItem.isFormField()) {
                    String fileName = fileItem.getName();

                    if ((fileName != null) && (fileItem.getSize() > 0)) {
                        imagePath = FileUploader.doFileUpload(fileItem, empCode);
                    }
                }
            }
            modelAndView.addObject("url", imagePath);
            modelAndView.addObject("errorCode", 0);
            modelAndView.addObject("errorMsg", "이미지 저장 성공");
        } catch (FileUploadException e) {
            modelAndView.addObject("errorCode", -1);
            modelAndView.addObject("errorMsg", "파일이 서버로 업로드되지 못했습니다.");
        } catch (IOException e) {
            modelAndView.addObject("errorCode", 0);
            modelAndView.addObject("errorMsg", "파일이 서버에 저장되지 못했습니다.");
        }

        return modelAndView;
    }
}
