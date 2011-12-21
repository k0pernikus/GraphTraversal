/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package graphtraversal;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author it0-kretph
 */
class Room {
    public boolean isVisited;
    public ArrayList<Room> seesRooms;
    public String name;
    public Room visitedFrom;
    
    Room(String name) {
         this.name = name;
         this.visitedFrom = null;
         this.isVisited = false;
         this.seesRooms = new ArrayList<Room>();
    }

    public void conectToRoom(Room room) {
        seesRooms.add(room);
    }

    public void conectToRoom(Room room1, Room room2) {
         seesRooms.add(room1);
         seesRooms.add(room2);
    }

    public void conectToRoom(Room room1, Room room2, Room room3) {
        seesRooms.add(room1);
        seesRooms.add(room2);
        seesRooms.add(room3);
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    public Room getVisitableRoomOrNull(){
        for (Room room : seesRooms){
            if (room.isVisited == false) {
                return room;
            }
        }

        return null;
    }

    public void printVisibleRooms() {
        Iterator iterator = seesRooms.listIterator();
        while (iterator.hasNext()){
            Room thatRoom = (Room) iterator.next();
            System.out.println(thatRoom.getName() + thatRoom.isVisited);
        }
    }
}