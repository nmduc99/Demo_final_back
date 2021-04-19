package com.demo.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.demo.entity.Course;
import com.demo.service.CourseService;

@RestController
@CrossOrigin("http://localhost:3000")
public class CourseController {

	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/courses")
	public List<Course> retrieveAllCourses()
	{
		return courseService.getAll();
	}
	
	@GetMapping("/courses/{id}")
	public Course retrieveCourse(@PathVariable long id) {
		Optional<Course> course = courseService.findById(id);
		return course.get();
	}
	
	@DeleteMapping("/courses/{id}")
	public void deleteCourse(@PathVariable long id) {
		courseService.deleteById(id);
	}
	
	@PostMapping("/courses")
	public ResponseEntity<Object> createCourse(@RequestBody Course course) {
		Course savedCourse = courseService.save(course);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedCourse.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/courses/{id}")
	public ResponseEntity<Object> updateCourse(@RequestBody Course course, @PathVariable long id) {

		Optional<Course> courseOptional = courseService.findById(id);

		if (!courseOptional.isPresent())
			return ResponseEntity.notFound().build();

		course.setId(id);
		
		courseService.save(course);

		return ResponseEntity.noContent().build();
	}
}