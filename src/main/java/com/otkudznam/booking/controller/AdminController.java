package com.otkudznam.booking.controller;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.otkudznam.booking.auth.TokenResponse;
import com.otkudznam.booking.model.Agent;
import com.otkudznam.booking.model.Category;
import com.otkudznam.booking.model.Comment;
import com.otkudznam.booking.model.Favour;
import com.otkudznam.booking.model.LodgingType;
import com.otkudznam.booking.model.User;
import com.otkudznam.booking.service.AgentService;
import com.otkudznam.booking.service.CategoryService;
import com.otkudznam.booking.service.CommentService;
import com.otkudznam.booking.service.FavourService;
import com.otkudznam.booking.service.LodgingTypeService;
import com.otkudznam.booking.service.UserService;
import com.otkudznam.booking.util.DateUtil;


@RestController
public class AdminController {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AgentService agentService;
	
	@Autowired
	private LodgingTypeService lodgingTypeService;
	
	@Autowired
	private FavourService favourService;
	
	@Autowired
	private CommentService commentService;
	
	@RequestMapping(value="/getUsers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> getUsers() {

		List<User> categories = userService.findByRole("USER");
		return new ResponseEntity<List<User>>(categories, HttpStatus.OK);
	}
	
	@RequestMapping(value="/getAgents", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Agent>> getAgents() {

		List<Agent> agents = agentService.findAll();
		return new ResponseEntity<List<Agent>>(agents, HttpStatus.OK);
	}
	
	@RequestMapping(value="/getCategories", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Category>> getCinemas() {

		List<Category> categories = categoryService.findAll();
		return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
	}
	
	@RequestMapping(value="/getLodgingTypes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LodgingType>> getLodgingTypes() {

		List<LodgingType> categories = lodgingTypeService.findAll();
		return new ResponseEntity<List<LodgingType>>(categories, HttpStatus.OK);
	}
	
	@RequestMapping(value="/getFavours", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Favour>> getFavours() {

		List<Favour> categories = favourService.findAll();
		return new ResponseEntity<List<Favour>>(categories, HttpStatus.OK);
	}
	
	@RequestMapping(value="/getDisapproveComments", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Comment>> getDisapproveComments() {

		List<Comment> comments = commentService.findByApproved(false);
		return new ResponseEntity<List<Comment>>(comments, HttpStatus.OK);
	}
	
	 @RequestMapping(value = "/loginAdmin", method = RequestMethod.POST)
	    public TokenResponse loginAdmin(@RequestBody User login) throws ServletException {

	        String jwtToken = "";

	        if (login.getEmail() == null || login.getPassword() == null) {
	            throw new ServletException("Please fill in username and password");
	        }

	        String email = login.getEmail();
	        String password = login.getPassword();

	        User user = userService.findByEmail(email);

	        if (user == null) {
	            throw new ServletException("User email not found.");
	        }
	        
	        if(!user.getRole().equals("ADMIN")){
	            throw new ServletException("User is not admin.");
	        }
	        
	        String pwd = user.getPassword();

	        if (!password.equals(pwd)) {
	            throw new ServletException("Invalid login. Please check your name and password.");
	        }

	        Date expirationDate = DateUtil.getDateFromNow(DateUtil.MONTH_IN_SECONDS);
	        jwtToken = Jwts.builder().setSubject(email).claim("roles", "user").setIssuedAt(new Date()).setExpiration(expirationDate)
	                .signWith(SignatureAlgorithm.HS256, "secretkey").compact();

	        return new TokenResponse(jwtToken, DateUtil.MONTH_IN_SECONDS);
	    }
	
	@RequestMapping(value="/registerAgent", method = RequestMethod.POST)
    private ResponseEntity registerAgent(@RequestBody Agent agent) {
		
		//System.out.println(agent.getPlace());
        agentService.saveOrUpdate(agent);
        return new ResponseEntity(agent, HttpStatus.OK);
    }
	
	@RequestMapping(value="/updateCategory", method = RequestMethod.POST)
    private ResponseEntity updateCategory(@RequestBody Category category) {
		
		for(Category cat: categoryService.findAll()) {
			if(cat.getCategoryName().equals(category.getCategoryName())) {
				return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
        categoryService.saveOrUpdate(category);
        return new ResponseEntity(category, HttpStatus.OK);
    }
	
	@RequestMapping(value="/deleteCategory", method = RequestMethod.POST)
    private ResponseEntity deleteCategory(@RequestBody Category category) {
		
        categoryService.delete(category);
        return new ResponseEntity(category, HttpStatus.OK);
    }
	
	@RequestMapping(value="/updateLodgingType", method = RequestMethod.POST)
    private ResponseEntity updateLodgingType(@RequestBody LodgingType type) {
		
		for(LodgingType t: lodgingTypeService.findAll()) {
			if(t.getTypeName().equals(type.getTypeName())) {
				return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		lodgingTypeService.saveOrUpdate(type);
        return new ResponseEntity(type, HttpStatus.OK);
    }
	
	@RequestMapping(value="/deleteLodgingType", method = RequestMethod.POST)
    private ResponseEntity deleteLodgingType(@RequestBody LodgingType type) {
		
		lodgingTypeService.delete(type);
        return new ResponseEntity(type, HttpStatus.OK);
    }
	
	@RequestMapping(value="/updateFavour", method = RequestMethod.POST)
    private ResponseEntity updateFavour(@RequestBody Favour favour) {
		
		for(Favour t: favourService.findAll()) {
			if(t.getName().equals(favour.getName())) {
				return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		favourService.saveOrUpdate(favour);
        return new ResponseEntity(favour, HttpStatus.OK);
    }
	
	@RequestMapping(value="/deleteFavour", method = RequestMethod.POST)
    private ResponseEntity deleteFavour(@RequestBody Favour favour) {
		
		favourService.delete(favour);
        return new ResponseEntity(favour, HttpStatus.OK);
    }
	
	@RequestMapping(value="/deleteUser", method = RequestMethod.POST)
    private ResponseEntity deleteUser(@RequestBody User user) {
		
		userService.delete(user);
        return new ResponseEntity(user, HttpStatus.OK);
    }
	
	@RequestMapping(value="/changeActivity", method = RequestMethod.POST)
    private ResponseEntity changeActivity(@RequestBody User user) {
		
		User userChange = new User();
		userChange = userService.findByEmail(user.getEmail());
		if(userChange.isActivity()){
			userChange.setActivity(false);
		}else{
			userChange.setActivity(true);
		}
		userService.saveOrUpdate(userChange);
        return new ResponseEntity(userChange, HttpStatus.OK);
    }
	
	@RequestMapping(value="/approveComment", method = RequestMethod.POST)
    private ResponseEntity approveComment(@RequestBody Comment comment) {
		
	//	Comment commentChange = new Comment();
		Optional<Comment> commentChange = commentService.findById(comment.getId());
		commentChange.get().setApproved(true);
		commentService.saveOrUpdate(commentChange.get());
        return new ResponseEntity(commentChange.get(), HttpStatus.OK);
    }
}
