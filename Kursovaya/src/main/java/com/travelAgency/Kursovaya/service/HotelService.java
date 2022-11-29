package com.travelAgency.Kursovaya.service;

import com.travelAgency.Kursovaya.entity.Hotel;
import com.travelAgency.Kursovaya.entity.Room;
import com.travelAgency.Kursovaya.repository.HotelRepository;
import com.travelAgency.Kursovaya.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    @Autowired
    HotelRepository hotelRepository;
    @Autowired
    RoomRepository roomRepository;

    public List<Hotel> getAllHotel(){
        return  hotelRepository.findAll();
    }

    public List<Room> addNewRoom(int count, String hotelName){
        Hotel hotel = hotelRepository.findByName(hotelName);
        for(int i=0; i<count; i++){
            roomRepository.save(new Room(hotel,i,false));
        }
        return roomRepository.findAll();
    }

    public void createNewHotel(String name, String addres){
        hotelRepository.save(new Hotel(name,addres));
    }
    public void deleteByHotelId(String idString){
        hotelRepository.deleteById(Long.parseLong(idString));
    }
    public void deleteByRoomId(String idString){
        roomRepository.deleteById(Long.parseLong(idString));
    }

    public void denide(String idRoom){};
    public void acsept(String idRoom){};

    public void rent(String idRoom){};
}
