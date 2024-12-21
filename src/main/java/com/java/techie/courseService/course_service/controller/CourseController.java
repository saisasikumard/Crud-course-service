package com.java.techie.courseService.course_service.controller;

import com.java.techie.courseService.course_service.dto.Course;
import com.java.techie.courseService.course_service.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseController {

    private CourseService courseService;

    public CourseController(CourseService courseService)
    {
        this.courseService = courseService;
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public ResponseEntity<?> addCourse(@RequestBody Course course) {
        Course newCourse = courseService.onboardNewCourse(course);
        return new ResponseEntity<>(newCourse, HttpStatus.CREATED);//201
    }

    @GetMapping
    public ResponseEntity<?> findALlCourse(){
        return new ResponseEntity<>(courseService.viewAllCourses(), HttpStatus.OK);
    }

    @GetMapping("/search/path/{courseId}")
    public ResponseEntity<?> findCourse(@PathVariable Integer courseId){
        return new ResponseEntity<>(courseService.findByCourseId(courseId),HttpStatus.OK);
    }

    @GetMapping("/search/request")
    public ResponseEntity<?> findCourseUsingRequestParam(@RequestParam(required = false) Integer courseId){
        return new ResponseEntity<>(courseService.findByCourseId(courseId),HttpStatus.OK);
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<?> deleteCourse(@PathVariable int courseId){
        courseService.deleteCourse(courseId);
        return new ResponseEntity<>("", HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{courseId}")
    public ResponseEntity<?> updateCourse(@PathVariable int courseId, @RequestBody Course course){
        return new ResponseEntity<>(courseService.updateCourse(courseId, course), HttpStatus.OK);
    }

    @GetMapping("/countByType")
    public ResponseEntity<?> countbyType(){
        return new ResponseEntity<>(courseService.countByType(),HttpStatus.ACCEPTED);
    }


}
