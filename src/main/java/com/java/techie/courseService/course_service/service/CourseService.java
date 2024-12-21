package com.java.techie.courseService.course_service.service;

import com.java.techie.courseService.course_service.dto.CountDto;
import com.java.techie.courseService.course_service.dto.Course;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CourseService {
    List<Course> courseDao=new ArrayList<>();
    public Course onboardNewCourse(Course course) {
        course.setCourseId(new Random().nextInt(1121));
        courseDao.add(course);
        return course;
    }

    public List<Course> viewAllCourses() {
        return courseDao;
    }

    public Course findByCourseId(Integer courseId) {
        return courseDao.stream().filter(course -> courseId==course.getCourseId()).findFirst().orElse(null);
    }

    public void deleteCourse(int courseId) {
        Course course1=courseDao.stream().filter(course -> course.getCourseId()==courseId).findFirst().orElse(null);
        courseDao.remove(course1);
    }

    public Course updateCourse(int courseId, Course course) {
        Course course1=courseDao.stream().filter(c -> c.getCourseId()==courseId).findFirst().orElse(null);
        courseDao.set(courseDao.indexOf(course1),course);
        return course;
    }

    public List<CountDto> countByType() {

      //  List<CountDto> list=new ArrayList<>();

//        countDto.setCourseType("Live");
//        countDto.setCount((int) courseDao.stream().filter(course -> course.getCourseType().equalsIgnoreCase("Live")).count());
       // return Collections.singletonList(countDto);

     //   List<Course> l1=list.stream().filter(type->courseDao.stream().anyMatch(course->course.getCourseType().equalsIgnoreCase(type))).collect(Collectors.toList());
//        int countOfLive= (int) courseDao.stream().filter(course -> course.getCourseType().equalsIgnoreCase("Live")).count();
//        CountDto countDto=new CountDto();
//        countDto.setCourseType("Live");
//        countDto.setCount(countOfLive);
//        list.add(countDto);
//
//        int countOfRecorded= (int) courseDao.stream().filter(course -> course.getCourseType().equalsIgnoreCase("Recorded")).count();
//        CountDto countDto2=new CountDto();
//        countDto2.setCourseType("Recorded");
//        countDto2.setCount(countOfRecorded);
//        list.add(countDto2);
//
//        Map<String,Long> typeCounts=courseDao.stream().collect(Collectors.groupingBy(course -> course.getCourseType(),Collectors.counting()));
//
//        return  list;
        List<CountDto> countDtos=courseDao.stream().collect(Collectors.groupingBy(course -> course.getCourseType(),Collectors.counting()))
                                        .entrySet().stream()
                .map(entry->new CountDto(entry.getKey(), Math.toIntExact(entry.getValue()))).collect(Collectors.toList());
        return countDtos;

    }
}
