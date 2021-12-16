package com.cs348.cbnb.controller;

import com.cs348.cbnb.model.*;
import com.cs348.cbnb.repository.DormRepository;
import com.cs348.cbnb.repository.GuestRepository;
import com.cs348.cbnb.repository.RoomRepository;
import com.cs348.cbnb.repository.UniversityRepository;
import com.cs348.cbnb.service.BookingService;
import net.bytebuddy.implementation.bind.annotation.Argument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Controller
public class BookingController {

    @Autowired
    UniversityRepository universityRepository;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    DormRepository dormRepository;

    @Autowired
    GuestRepository guestRepository;

    @Autowired
    BookingService bookingService;

    @GetMapping("/")
    public String getIndex() {
        return "index";
    }

    @GetMapping("/details")
    public String getDetails(Model model) {
        Details details = new Details();
        model.addAttribute(details);
        return "details";
    }

    @GetMapping("/listings")
    public String getListings(Model model,  @ModelAttribute("information") Details details) {
        List<Dorm> dorms = null;
        String college = details.getUniversity();
        String date = details.getDate();
        String sort = details.getSort();
        System.out.println(college);
        System.out.println(date);
        System.out.println(sort);
        System.out.println();

        LocalDate locDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("MM/dd/yyyy"));

        if (sort == null) {
            dorms = dormRepository.getDorms(college);
        } else if (sort.equals("dname")) {
            dorms = dormRepository.sortByDormName(college);
        } else if (sort.equals("dtype")) {
            dorms = dormRepository.sortByDormType(college);
        } else if (sort.equals("tguests")) {
            dorms = dormRepository.sortByTotalGuests(college);
        } else if (sort.equals("ravail")) {
            dorms = dormRepository.sortByRoomsAvailable(college);
        } else if (sort.equals("all")) {
            dorms = dormRepository.sortByAll(college);
        }

        List<Dorm> availDorms = new ArrayList<>();
        for (Dorm d : dorms) {
            int numSpots = dormRepository.numSpots(locDate, d.getName());
            System.out.println(numSpots);
            d.setRoomsAvail(numSpots);
            if (numSpots > 0)
                availDorms.add(d);
        }

        Dorm dorm = new Dorm();
        model.addAttribute("details", details);
        model.addAttribute("dorm", dorm);
        model.addAttribute("dorms", availDorms);
        model.addAttribute("date", date);
        model.addAttribute("dormName", dorm.getName());
        return "report";
    }

    @GetMapping("/bookRoom")
    public String listRooms(Model model, @ModelAttribute("dormName") String dormName, @ModelAttribute("date") String date) {
        System.out.println(dormName);
        System.out.println(date);
        List<Room> rooms = roomRepository.findRoomsByDormId(dormName);
        System.out.println(rooms.toString());
        model.addAttribute("rooms", rooms);
        model.addAttribute("dormName", dormName);

        return "bookRoom";
    }

    @GetMapping("/book")
    public String getBooking(Model model, @ModelAttribute("dormName") String dormName, @ModelAttribute("date") String date, @ModelAttribute("roomNum") Long roomNum) {
        System.out.println("dorm: " + dormName);
        System.out.println(date);
        System.out.println(roomNum);
        Dorm dorm = dormRepository.findByName(dormName);
        System.out.println(dorm.toString());
        BookingInfo bookingInfo = new BookingInfo();
        model.addAttribute("dorm", dorm);
        model.addAttribute("date", date);
        model.addAttribute("bookingInfo", bookingInfo);
        model.addAttribute("guestName", "");
        model.addAttribute("guestEmail", "");
        model.addAttribute("rooNum", roomNum);
        return "book";
    }

    @PostMapping("/book")
    public String makeBooking(Model model, @ModelAttribute("dormName") String dormName, @ModelAttribute("bookingInfo") BookingInfo bookingInfo, @ModelAttribute("date") String date, @ModelAttribute("roomNum") String roomNum) {
        System.out.println("in book post");
        System.out.println(dormName);
        System.out.println(bookingInfo.toString());
        System.out.println(date);
        System.out.println(roomNum);
        Dorm dorm = dormRepository.findByName(dormName);

        System.out.println(dorm.toString());
        String roomID = dorm.getName() + " " + roomNum;
        String bookingId = bookingInfo.getGuestEmail() + " " + roomID;

        Guest g = new Guest(bookingInfo.getGuestEmail(), bookingInfo.getGuestName());
        System.out.println(g.getGuestID());

        guestRepository.save(g);
        Booking b = new Booking(g.getGuestID(), roomID, dorm.getName(), LocalDate.parse(date, DateTimeFormatter.ofPattern("MM/dd/yyyy")), 1);
        bookingService.createBooking(b);

        return "index";
    }

    @GetMapping("/create")
    public String getListBooking(Model model) {
        Information information = new Information();
        model.addAttribute(information);
        return "create";
    }

    @PostMapping("/create")
    public String listBooking(@ModelAttribute("information") Information information) {
        System.out.println("received");
        System.out.println(information.toString());
        University u = new University(information.getUniversity(), information.getCity(), information.getState(), "US", 1, Integer.parseInt(information.getCapacity()));
        Dorm d = new Dorm(information.getDorm(), information.getAddress(), u.getName(), Integer.parseInt(information.getCapacity()), 1, information.getRoomType());
        Room r = new Room(Long.parseLong(information.getRoom()), d.getName(), LocalDate.parse(information.getStartDate(), DateTimeFormatter.ofPattern("MM/dd/yyyy")), LocalDate.parse(information.getEndDate(), DateTimeFormatter.ofPattern("MM/dd/yyyy")), LocalDate.parse(information.getEndDate(), DateTimeFormatter.ofPattern("MM/dd/yyyy")).plusDays(1), Integer.parseInt(information.getCapacity()));
        System.out.println(information.toString());
        System.out.println(u.toString());
        System.out.println(d.toString());
        System.out.println(r.toString());
        System.out.println(r.getRoomId());
        universityRepository.save(u);
        dormRepository.save(d);
        roomRepository.save(r);

        return "index";
    }

}
