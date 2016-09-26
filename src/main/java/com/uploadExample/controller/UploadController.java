package com.uploadExample.controller;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uploadExample.model.AppUser;
import com.uploadExample.service.UserService;

import net.coobird.thumbnailator.Thumbnails;

@Controller
@RequestMapping("/")
public class UploadController {

	static final Logger logger = LoggerFactory.getLogger(UploadController.class);
	@Autowired
	private HttpServletRequest request;

	@Autowired
	UserService userService;
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
    public String list(Model model){
		
		model.addAttribute("users", userService.findAll());
		return "list";
	}
	
	@RequestMapping(value="/user/{username}/edit", method = RequestMethod.GET)
	public String displayEditPage(Model model, @PathVariable("username") String username){
		AppUser user = userService.findByUsername(username);
		model.addAttribute("user", user);
		return "editUser";
	}
	
	@RequestMapping(value="/user/{username}/edit", method = RequestMethod.POST)
	public String editUser(@Valid AppUser appUser, BindingResult result, Model model, 
			@PathVariable("username") String username, RedirectAttributes redirectAttributes){
		if (result.hasErrors()){
			return "editUsers";
		}
		userService.save(appUser);
		redirectAttributes.addFlashAttribute("user", appUser);
		return "redirect:/user/" + appUser.getUsername() + "/edit";
	}
	
	@RequestMapping(value="/upload", method = RequestMethod.GET)
	public String uploadPage(Model model){
		return "upload";
	}

	/**
	 * Process the file, rename the file and save to the location
	 * @param file
	 * @param filename
	 * @return the view of page
	 */
	@RequestMapping(value="upload", method = RequestMethod.POST)
	public String handleUpload(@RequestParam("imageFile") MultipartFile file, 
			@RequestParam("filename") String filename, Model model, 
			RedirectAttributes redirectAttributes){
		String realPathtoUploads;
		try{
			if (!file.isEmpty()) {
				String uploadsDir = "/static/images/";
				String openshiftProperty = System.getenv("OPENSHIFT_DATA_DIR");
				logger.info("The openshift to Upload is " + openshiftProperty);
				if (openshiftProperty != null){
					realPathtoUploads = openshiftProperty.substring(0, openshiftProperty.length() - 1)
							+ uploadsDir;
				}
				else{
					realPathtoUploads = request.getServletContext().getRealPath(uploadsDir);
				}
				logger.info("The real Path to Upload is " + realPathtoUploads);
				if(! new File(realPathtoUploads).exists())
				{
					if ( !new File(realPathtoUploads).mkdir()){
						logger.error("create folder failed");
						throw new Exception("Create folder failed");
					}
				}
				BufferedImage bufferedImage =
						Thumbnails.of(file.getInputStream())
						.forceSize(200, 200)
						.allowOverwrite(true)
						.outputFormat("png")
						.asBufferedImage();
				File imageDestination = new File(realPathtoUploads + filename + ".png");
				ImageIO.write(bufferedImage, "png", imageDestination);
			} 
			else{
				redirectAttributes.addFlashAttribute("errorMsg", "File is Empty");
				return "redirect:/upload?success=false";
			}
		}catch(Exception e){
			redirectAttributes.addFlashAttribute("errorMsg", e.getMessage());
			return "redirect:/upload?success=false";
		}
		return "redirect:/display/" + filename;
	}

	@RequestMapping(value="/display/test1", method = RequestMethod.GET)
	public String displayDefault(Model model){
		model.addAttribute("filename", "images");
		return "display";
	}
	@RequestMapping(value="/display/{filename}", method = RequestMethod.GET)
	public String display(Model model, @PathVariable String filename){
		model.addAttribute("filename", filename);
		return "display";
	}
}
