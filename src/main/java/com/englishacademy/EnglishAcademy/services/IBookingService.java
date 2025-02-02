package com.englishacademy.EnglishAcademy.services;

import com.englishacademy.EnglishAcademy.dtos.booking.BookingDTO;
import com.englishacademy.EnglishAcademy.dtos.booking.BookingWaiting;
import com.englishacademy.EnglishAcademy.entities.Student;
import com.englishacademy.EnglishAcademy.entities.Tutor;
import com.englishacademy.EnglishAcademy.entities.User;
import com.englishacademy.EnglishAcademy.models.booking.CreateBooking;

import java.util.List;

public interface IBookingService {

    List<BookingDTO> findAll();
    void save(CreateBooking createBookingList, Student student);

    List<BookingDTO> findAllByTutor(Tutor tutor);

    List<BookingDTO> findAllByStudent(Student student);

    BookingWaiting findAllWaitingByTutor(User user);
}
