package com.qa.business.service;

public interface ClassroomService {
    String getAllClassrooms();
    String addClassroom(String classroom);
    String updateClassroom(int id, String classroomToUpdate);
    String deleteClassroom(int id);
}
