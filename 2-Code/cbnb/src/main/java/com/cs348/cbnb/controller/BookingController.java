package com.cs348.cbnb.controller;

import com.cs348.cbnb.model.Dorm;
import com.cs348.cbnb.model.Information;
import com.cs348.cbnb.model.Room;
import com.cs348.cbnb.model.University;
import com.cs348.cbnb.repository.DormRepository;
import com.cs348.cbnb.repository.RoomRepository;
import com.cs348.cbnb.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
public class BookingController {

    private Long univId = 1L;
    private Long dormId = 1L;
    private Long roomId = 1L;

    @Autowired
    UniversityRepository universityRepository;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    DormRepository dormRepository;

    @GetMapping("/")
    public String getIndex() {
        return "index";
    }

    @GetMapping("/create")
    public String getListBooking(Model model) {
        Information information = new Information();
        model.addAttribute(information);
        return "create";
    }

    @PostMapping("/create")
    public void addBooking(@ModelAttribute("information") Information information) {
        System.out.println("received");
        System.out.println(information.toString());
        University u = new University(univId++, information.getUniversity(), information.getCity(), information.getState(), "US", 1, Integer.parseInt(information.getCapacity()));
        Dorm d = new Dorm(dormId++, information.getDorm(), information.getAddress(), u.getId(), Integer.parseInt(information.getCapacity()), 1, information.getRoomType());
        Room r = new Room(roomId++, d.getId(), LocalDate.parse(information.getStartDate(), DateTimeFormatter.ofPattern("MM/dd/yyyy")), LocalDate.parse(information.getEndDate(), DateTimeFormatter.ofPattern("MM/dd/yyyy")), LocalDate.now(), Integer.parseInt(information.getCapacity()));
        System.out.println(information.toString());
        System.out.println(u.toString());
        System.out.println(d.toString());
        System.out.println(r.toString());
        universityRepository.save(u);
        dormRepository.save(d);
        roomRepository.save(r);
    }


}
