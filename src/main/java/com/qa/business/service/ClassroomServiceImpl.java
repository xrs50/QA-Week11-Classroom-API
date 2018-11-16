package com.qa.business.service;

import com.qa.persistence.repository.ClassroomRepository;
import com.qa.util.JSONUtility;

import javax.inject.Inject;
import javax.transaction.Transactional;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

@Transactional(SUPPORTS)
public class ClassroomServiceImpl implements ClassroomService{

    @Inject
    ClassroomRepository classroomRepository;

    @Override
    public String getAllClassrooms() {
        return classroomRepository.getAllClassrooms();
    }

    @Transactional(REQUIRED)
    @Override
    public String addClassroom(String classroom) {
        return classroomRepository.createClassroom(classroom);
    }

    @Transactional(REQUIRED)
    @Override
    public String updateClassroom(int id, String classroomToUpdate) {
        return classroomRepository.updateClassroom(id, classroomToUpdate);
    }

    @Transactional(REQUIRED)
    @Override
    public String deleteClassroom(int id) {
        return classroomRepository.deleteClassroom(id);
    }
}
