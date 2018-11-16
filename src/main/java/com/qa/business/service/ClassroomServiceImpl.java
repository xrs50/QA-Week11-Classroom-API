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

    @Override
    public String getAllTrainees() {
        return classroomRepository.getAllTrainees();
    }

    @Transactional(REQUIRED)
    @Override
    public String addTrainee(String trainee) {
        return classroomRepository.createTrainee(trainee);
    }

    @Transactional(REQUIRED)
    @Override
    public String updateTrainee(int id, String traineeToUpdate) {
        return classroomRepository.updateTrainee(id, traineeToUpdate);
    }

    @Transactional(REQUIRED)
    @Override
    public String deleteTrainee(int id) {
        return classroomRepository.deleteTrainee(id);
    }

    public ClassroomRepository getClassroomRepository() {
        return classroomRepository;
    }

    public void setClassroomRepository(ClassroomRepository classroomRepository) {
        this.classroomRepository = classroomRepository;
    }
}
